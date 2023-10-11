package com.example.demo.api.dto;

import com.example.demo.api.validation.annotation.CheckMobileNo;

public class UserInfoDto {
  /** 主键uuid */
  private String uuid;

  /** 人员代码 */
  private String userCode;

  /** 人员名称 */
  private String userName;

  /** 手机号 */
  @CheckMobileNo(message = "入参中的手机号怎么不对啊???")
  private String mobile;

  /** 证件类型 */
  private String identifyType;

  /** 证件号码 */
  private String identifyNumber;

  /** 电子邮件地址 */
  private String email;

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
}
