package com.example.demo.biz.validation;

import com.example.demo.biz.utils.RedisUtil;
import com.example.demo.biz.validation.annotation.ClearAndReloadCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @className: ClearAndReloadCacheAspect
 * @author: 吴吉
 * @description: 延时双删切面
 * @date: 2024/2/1 15:14
 * @version: 1.0
 */
@Aspect
@Component
public class ClearAndReloadCacheAspect {
  private final RedisUtil redisUtil;

  public ClearAndReloadCacheAspect(RedisUtil redisUtil) {
    this.redisUtil = redisUtil;
  }

    /** 切入点:基于注解实现的切入点 加上该注解的都是Aop切面的切入点 */
  @Pointcut("@annotation(com.example.demo.biz.validation.annotation.ClearAndReloadCache)")
  public void pointCut() {}

  @Around("pointCut()")
  public Object clearAndReloadCacheMethod(ProceedingJoinPoint proceedingJoinPoint) {
    System.out.println("******切面方法开始执行 start******");

    Signature signature = proceedingJoinPoint.getSignature();

    MethodSignature methodSignature = (MethodSignature) signature;

    Method targetMethod = methodSignature.getMethod();

    ClearAndReloadCache clearAndReloadCache =
        targetMethod.getAnnotation(ClearAndReloadCache.class); // 通过反射得到自定义注解的方法对象

    String key = clearAndReloadCache.key(); // 获取自定义注解的方法对象的参数key
    int delayMillisSecond = clearAndReloadCache.delayMillisSecond(); // 获取延时时间
    redisUtil.delete(key); // 第一次删除缓存

    Object result = null;
    try {
      // 手动调用目标方法
      result = proceedingJoinPoint.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }

    // 开一个线程，延迟1s第二次删除缓存（延迟时间可根据实际需要而定）
    // 在线程中延迟删除  同时将业务代码的结果返回 这样不影响业务代码的执行
    new Thread(
            () -> {
              try {
                Thread.sleep(delayMillisSecond);
                redisUtil.delete(key);
                System.out.println("-----------1秒钟后，在线程中延迟删除完毕 -----------");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();

    return result;
  }
}
