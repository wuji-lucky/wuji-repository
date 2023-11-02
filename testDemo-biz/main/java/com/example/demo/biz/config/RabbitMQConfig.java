package com.example.demo.biz.config;

import com.example.demo.biz.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @className: RabbitMQConfig
 * @author: 吴吉
 * @description: rabbitMQ的配置类
 * @date: 2023/10/31 14:32
 * @version: 1.0
 */
@Configuration
public class RabbitMQConfig {
  @Value("${spring.rabbitmq.host}")
  private String host;

  @Value("${spring.rabbitmq.port}")
  private Integer port;

  @Value("${spring.rabbitmq.username}")
  private String userName;

  @Value("${spring.rabbitmq.password}")
  private String passWord;

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
    cachingConnectionFactory.setHost(host);
    cachingConnectionFactory.setPort(port);
    cachingConnectionFactory.setUsername(userName);
    cachingConnectionFactory.setPassword(passWord);
    return cachingConnectionFactory;
  }

  @Bean
  public RabbitAdmin rabbitAdmin(
      ConnectionFactory connectionFactory) { // RabbitAdmin对象用于在RabbitMQ服务器上声明队列、交换机和绑定关系
    return new RabbitAdmin(connectionFactory);
  }

  /**
   * 根据交换机类型创建交换机对象
   *
   * @param
   * @return Exchange
   */
  private Exchange createExchange(QueueEnum queueEnum) {
    if ("direct".equalsIgnoreCase(queueEnum.getExchangeType())) { // 直连模式
      return new DirectExchange(queueEnum.getExchangeName());
    } else if ("fanout".equalsIgnoreCase(queueEnum.getExchangeType())) { // 订阅模式
      return new FanoutExchange(queueEnum.getExchangeName());
    } else if ("topic".equalsIgnoreCase(queueEnum.getExchangeType())) { // 主题模式
      return new TopicExchange(queueEnum.getExchangeName());
    }
    // 默认使用直连模式
    return new DirectExchange(queueEnum.getExchangeName());
  }

  /** 初始化队列,交换机以及其绑定关系 */
  @PostConstruct
  public void initQueueAndBind() {
    RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());

    QueueEnum[] queueEnums = QueueEnum.values();
    for (int i = 0; i < queueEnums.length; i++) {
      // 初始化队列
      Queue queue = new Queue(queueEnums[i].getQueueName(), true, false, false);
      rabbitAdmin.declareQueue(queue);

      // 初始化交换机
      Exchange exchange = createExchange(queueEnums[i]);
      rabbitAdmin.declareExchange(exchange);

      // 初始化队列与交换机的绑定关系
      Binding binding =
          BindingBuilder.bind(queue)
              .to(exchange)
              .with(queueEnums[i].getRoutingKey())
              .noargs(); // noargs方法是用于声明 Exchange 不需要任何额外参数，也就是使用默认的参数进行创建
      rabbitAdmin.declareBinding(binding);
    }
  }

  /**
   * 创建了一个RabbitTemplate对象，用于发送消息到RabbitMQ服务器
   *
   * @param connectionFactory
   * @return
   */
  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    return rabbitTemplate;
  }
}
