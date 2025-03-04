package com.example.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    @Before("execution(* com.example.demo.Controlllers.Controller.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(">>> LoggingAspect: Executing before method : " + joinPoint.getSignature().getName());


    }
}