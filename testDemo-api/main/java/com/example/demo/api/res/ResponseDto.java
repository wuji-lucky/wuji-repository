package com.example.demo.api.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className: ResponseDto
 * @author: 吴吉
 * @description: 接口反参统一包装类
 * @date: 2024/1/29 11:16
 * @version: 1.0
 */
@ApiModel(value = "接口响应结果")
@Data
@Accessors(chain = true)
public class ResponseDto<T> {
  @ApiModelProperty(value = "是否成功标志位:true-成功,false-失败", required = true)
  private boolean success;

  @ApiModelProperty(value = "响应代码", example = "成功-200,失败-999")
  private int rtnCode;

  @ApiModelProperty(value = "响应信息", example = "成功/失败")
  private String rtnMsg;

  @ApiModelProperty(value = "反参对象")
  private T result;

  /**
   * @description: 成功
   * @author: wuji
   * @date: 2024/1/29 15:23
   * @param: 成功的入参
   * @return: 成功的反参
   */
  public static <T> ResponseDto<T> success(T result) {
    return new ResponseDto<T>()
        .setSuccess(true)
        .setRtnCode(Type.SUCCESS.value)
        .setRtnMsg("成功")
        .setResult(result);
  }

  /**
   * @description: 成功
   * @author: wuji
   * @date: 2024/1/29 17:02
   * @param: 成功的入参
   * @return: 成功的反参
   */
  public static <T> ResponseDto<T> of(boolean success, String rtnMsg, T result) {
    return new ResponseDto<T>().setSuccess(success).setRtnMsg(rtnMsg).setResult(result);
  }

  /**
   * @description: 成功
   * @author: wuji
   * @date: 2024/1/29 17:02
   * @param: 成功的入参
   * @return: 成功的反参
   */
  public static <T> ResponseDto<T> of(boolean success, Type type, String rtnMsg, T result) {
    return new ResponseDto<T>()
        .setSuccess(success)
        .setRtnCode(type.getValue())
        .setRtnMsg(rtnMsg)
        .setResult(result);
  }

  /**
   * @description: 失败-失败返回失败信息
   * @author: wuji
   * @date: 2024/1/29 16:46
   * @param: 失败的入参
   * @return: 失败的反参
   */
  public static ResponseDto<?> fail(String rtnMsg) {
    return fail(rtnMsg, Type.ERROR);
  }

  /**
   * @description: 失败-失败返回失败信息
   * @author: wuji
   * @date: 2024/1/29 16:46
   * @param: 失败的入参
   * @return: 失败的反参
   */
  public static ResponseDto<?> fail(String rtnMsg, Type type) {
    return new ResponseDto<>().setSuccess(false).setRtnCode(type.getValue()).setRtnMsg(rtnMsg);
  }

  /**
   * @description: 失败
   * @author: wuji
   * @date: 2024/1/29 17:19
   * @param: 失败的入参
   * @return: 失败的反参
   */
  public static <T> ResponseDto<T> fail(int rtnCode, String rtnMsg) {
    return new ResponseDto<T>().setSuccess(false).setRtnCode(rtnCode).setRtnMsg(rtnMsg);
  }

  /** 反参状态类型 */
  public enum Type {
    /** 成功 */
    SUCCESS(200),

    /** 错误 */
    ERROR(500),

    /** 警告 */
    WARNING(301),

    /** 未登录 */
    UNLOGGING(401),

    /** 未授权 */
    UNAUTHORIZED(403),

    /** token失效 */
    TOKEN_INVALID(600),

    /** 参数错误 */
    PARAM_INVALID(10001),

    /** 未查询 */
    NO_QUERY(10010),

    /** 无数据 */
    NO_DATA(10011),

    /** 查询失败 */
    QUERY_FAIL(10012),

    /** 查询中 */
    IN_QUERY_PROGRESS(10013),

    /** 数据已存在 */
    DATA_EXIST(10014);

    private final int value;

    public int getValue() {
      return value;
    }

    Type(int value) {
      this.value = value;
    }

    // 根据rtnCode循环匹配
    public static Type of(Object obj) {
      if (null == obj) {
        return null;
      }

      try {
        int rtnCode = Integer.parseInt(obj.toString());
        for (Type type : Type.values()) {
          if (type.value == rtnCode) {
            return type;
          }
        }
      } catch (Exception e) {
        // just ignore
      }
      return null;
    }
  }
}
