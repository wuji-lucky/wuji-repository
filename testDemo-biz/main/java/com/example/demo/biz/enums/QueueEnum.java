package com.example.demo.biz.enums;

/**
 * @className: QueueEnum
 * @author: 吴吉
 * @description: 消息队列枚举类-如果想更加灵活配置，可以将相关配置放在数据库中
 * @date: 2023/10/31 14:14
 * @version: 1.0
 */
public enum QueueEnum {
  QUEUE1("testDemo", "testDemoExchange", "test-demo-key-A", "direct", "/"); // 定义第一个队列

  private String queueName;
  private String exchangeName;
  private String routingKey;
  private String exchangeType;
  private String virtualHost;

  QueueEnum(
      String queueName,
      String exchangeName,
      String routingKey,
      String exchangeType,
      String virtualHost) {
    this.queueName = queueName;
    this.exchangeName = exchangeName;
    this.routingKey = routingKey;
    this.exchangeType = exchangeType;
    this.virtualHost = virtualHost;
  }

  public String getQueueName() {
    return queueName;
  }

  public String getExchangeName() {
    return exchangeName;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public String getExchangeType() {
    return exchangeType;
  }

  public String getVirtualHost() {
    return virtualHost;
  }
}
