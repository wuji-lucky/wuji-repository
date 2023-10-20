package com.example.demo.biz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfoEntity {
  /** 主键uuid */
  @Id
  @Column(name = "uuid")
  private String uuid;

  /** 人员代码 */
  @Column(name = "userCode")
  private String userCode;

  /** 人员名称 */
  @Column(name = "userName")
  private String userName;

  /** 手机号 */
  @Column(name = "mobile")
  private String mobile;

  /** 证件类型 */
  @Column(name = "identifyType")
  private String identifyType;

  /** 证件号码 */
  @Column(name = "identifyNumber")
  private String identifyNumber;

  /** 电子邮件地址 */
  @Column(name = "email")
  private String email;

  /** 登录密码 */
  @Column(name = "password")
  private String password;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getIdentifyType() {
    return identifyType;
  }

  public void setIdentifyType(String identifyType) {
    this.identifyType = identifyType;
  }

  public String getIdentifyNumber() {
    return identifyNumber;
  }

  public void setIdentifyNumber(String identifyNumber) {
    this.identifyNumber = identifyNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
