package com.bree.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect//声明切片
@Component//加入容器
public class TimeAspect {

    @Around("execution(* com.bree.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        long startTime = new Date().getTime();
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is:"+ arg);
        }
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时："+ (new Date().getTime()-startTime));
        System.out.println("time aspect end");

        return object;
    }

}
