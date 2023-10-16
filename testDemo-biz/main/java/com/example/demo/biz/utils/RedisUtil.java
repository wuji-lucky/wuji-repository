package com.example.demo.biz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

  // RedisTemplate是Spring Data Redis提供的一个高级封装类，它允许我们通过一些方便的方法来操作Redis。
  @Autowired private RedisTemplate<String, String> redisTemplate;

  // 存储数据到Redis,并且不设置过期时间
  public void set(String key, String value) {
    // ValueOperations是RedisTemplate中的一个接口，它提供了各种对Redis中的值进行操作的方法
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    valueOperations.set(key, value);
  }

  // 存储数据到Redis,并且设置了过期时间
  public void set(String key, String value, int time) {
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    valueOperations.set(key, value, time, TimeUnit.MINUTES);
    // 注:TimeUnit是java.util.concurrent下面的一个枚举类，它提供了将给定时间转换到另一单位时间的方法,
    // 如:long b = TimeUnit.HOURS.convert(58L, TimeUnit.MINUTES);//将58分钟转换为小时
  }

  // 通过key获取value
  public String get(String key) {
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    if (redisTemplate.hasKey(key)) {
      return valueOperations.get(key);
    } else {
      return null;
    }
  }

  // 判断是否存在对应的key
  public boolean exist(String key) {
    if (this.get(key) != null) {
      return true;
    } else {
      return false;
    }
  }

  // 删除key
  public void delete(String key) {
    redisTemplate.delete(key);
  }
}
