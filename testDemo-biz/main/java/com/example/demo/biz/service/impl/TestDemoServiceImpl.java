package com.example.demo.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.api.dto.UserInfoDto;
import com.example.demo.api.exception.BusinessException;
import com.example.demo.biz.dao.UserInfoRepository;
import com.example.demo.biz.dao.entity.UserInfoEntity;
import com.example.demo.biz.service.TestDemoService;
import com.example.demo.biz.utils.RedisUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TestDemoServiceImpl implements TestDemoService {
  private static final Logger logger = LogManager.getLogger("TestDemoServiceImplLog");
  @Autowired UserInfoRepository userInfoRepository;
  @Autowired RedisUtil redisUtil;
  @Autowired RabbitTemplate rabbitTemplate;

  /** 查询用户信息 */
  @Override
  public UserInfoDto queryUserInfo(String uuid) {
    if (StringUtils.isBlank(uuid)) {
      throw new BusinessException("uuid不能为空!");
    }

    UserInfoDto userInfoDto = new UserInfoDto();
    UserInfoEntity userInfoEntity = null;
    // 先查缓存，缓存没有再查DB
    String userInfoEntityStr = redisUtil.get(uuid);
    if (StringUtils.isNotBlank(userInfoEntityStr)) {
      userInfoEntity =
          JSON.parseObject(
              userInfoEntityStr, UserInfoEntity.class); // 将存在Redis缓存中的字符串类型数据进行JSON反序列化,转成java对象
    } else {
      userInfoEntity =
          Optional.ofNullable(userInfoRepository.findByUuid(uuid)).orElseGet(UserInfoEntity::new);
      // 数据查询之后先存进缓存
      redisUtil.set(userInfoEntity.getUuid(), JSON.toJSONString(userInfoEntity), 5);
    }

    if (null != userInfoEntity) {
      // 组装返回前端的对象
      BeanUtils.copyProperties(userInfoEntity, userInfoDto);
    }
    return userInfoDto;
  }

  /** 分页查询用户信息 */
  @Override
  public PageImpl<UserInfoDto> pageQueryUserInfoByUserName(
      String userName, int pageNumber, int pageSize) {
    if (StringUtils.isBlank(userName)) {
      throw new BusinessException("用户姓名不能为空!");
    }

    List<UserInfoDto> userInfoDtoList = new ArrayList<>();

    Sort sort = Sort.by(Sort.Direction.ASC, "userCode");
    // 注:前端传入的pageNumber是从0页开始
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
    Page<UserInfoEntity> page = userInfoRepository.findByUserName(userName, pageRequest);
    Optional.ofNullable(page.getContent())
        .orElseGet(ArrayList::new)
        .forEach(
            (UserInfoEntity userInfoEntity) -> {
              UserInfoDto userInfoDto = new UserInfoDto();
              userInfoDto.setUuid(userInfoEntity.getUuid());
              userInfoDto.setUserCode(userInfoEntity.getUserCode());
              userInfoDto.setUserName(userInfoEntity.getUserName());
              userInfoDto.setIdentifyType(userInfoEntity.getIdentifyType());
              userInfoDto.setIdentifyNumber(userInfoEntity.getIdentifyNumber());
              userInfoDto.setMobile(userInfoEntity.getMobile());
              userInfoDto.setEmail(userInfoEntity.getEmail());
              userInfoDto.setPassword(userInfoEntity.getPassword());
              userInfoDtoList.add(userInfoDto);
            });

    return new PageImpl<>(userInfoDtoList, page.getPageable(), page.getTotalElements());
  }

  /** 保存用户信息 */
  @Override
  public String saveUserInfo(UserInfoDto userInfoDto) {
    if (ObjectUtils.isEmpty(userInfoDto)) {
      return "用户保存信息不能为空!!!";
    }
    UserInfoEntity userInfoEntity = new UserInfoEntity();
    BeanUtils.copyProperties(userInfoDto, userInfoEntity);
    if (StringUtils.isBlank(userInfoEntity.getUuid())) { // 如果uuid不为空则视为数据更新，否则为新增保存
      userInfoEntity.setUuid(UUID.randomUUID().toString());
    }

    logger.info("新保存的用户数据为:" + JSON.toJSONString(userInfoEntity));
    Object object = userInfoRepository.save(userInfoEntity);

    // 将数据发送到mq消息队列中：
    rabbitTemplate.convertAndSend(
        "testDemoExchange", "test-demo-key-A", JSON.toJSONString(userInfoEntity));
    return "用户数据保存成功";
  }

  /** 创建一个rabbitMQ消费者 */
  @RabbitListener(queues = "testDemo")
  public void rabbitMQReceiver(String message) {
    if (StringUtils.isBlank(message)) {
      return;
    }
    System.out.println("获取到的消息队列中的数据为：message:" + message);
  }
}
