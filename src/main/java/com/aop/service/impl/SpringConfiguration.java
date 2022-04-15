package com.aop.service.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.service")
@EnableAspectJAutoProxy(exposeProxy = true)//开启spring注解aop配置的支持
public class SpringConfiguration {
}