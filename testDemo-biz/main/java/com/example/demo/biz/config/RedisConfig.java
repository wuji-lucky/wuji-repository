package com.example.demo.biz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
/*
 * @Configuration用于定义配置类，可替换xml配置文件。
 * 被注解的类内部包含一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描
 * 并用于构建并定义Bean，初始化Spring容器
 * */
public class RedisConfig {

  @Bean
  /*
   *Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后将这个Bean对象交给Spring去管理。
   *产生这个Bean对象的方法Spring只会调用一次，随后Spring将会把这个Bean对象放入自己的IOC容器中。
   * */
  public RedisTemplate<String, Object> createRedisTemplate(
      RedisConnectionFactory redisConnectionFactory) {

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    // 使用stringRedisSerializer来序列化和反序列化redis的key值和value值
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());
    // 配置连接工厂
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate;
  }
}
