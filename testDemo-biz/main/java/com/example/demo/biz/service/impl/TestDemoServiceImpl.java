package com.example.demo.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.api.dto.UserInfoDto;
import com.example.demo.biz.dao.UserInfoRepository;
import com.example.demo.biz.dao.entity.UserInfoEntity;
import com.example.demo.biz.service.TestDemoService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TestDemoServiceImpl implements TestDemoService {
  private static final Logger logger = LogManager.getLogger("TestDemoServiceImplLog");
  @Autowired UserInfoRepository userInfoRepository;

  /** 查询用户信息 */
  @Override
  public UserInfoDto queryUserInfo(String uuid) {
    if (StringUtils.isBlank(uuid)) {
      return null;
    }

    UserInfoDto userInfoDto = new UserInfoDto();
    UserInfoEntity userInfoEntity =
        Optional.ofNullable(userInfoRepository.findByUuid(uuid)).orElseGet(UserInfoEntity::new);
    userInfoDto.setUuid(userInfoEntity.getUuid());
    userInfoDto.setUserCode(userInfoEntity.getUserCode());
    userInfoDto.setUserName(userInfoEntity.getUserName());
    userInfoDto.setMobile(userInfoEntity.getMobile());
    userInfoDto.setIdentifyType(userInfoEntity.getIdentifyType());
    userInfoDto.setIdentifyNumber(userInfoEntity.getIdentifyNumber());
    userInfoDto.setEmail(userInfoEntity.getEmail());
    return userInfoDto;
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
    return "用户数据保存成功";
  }
}
