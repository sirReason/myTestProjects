package com.aop.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//表明当前类是一个切面类
public class LogUtil {

    /**
     * 用于配置当前方法是一个前置通知
     */
    @Before("execution(* com.aop.service.impl.*.saveUser(..))")
    public void printLog() {
        System.out.println("执行打印日志的功能");
    }
}