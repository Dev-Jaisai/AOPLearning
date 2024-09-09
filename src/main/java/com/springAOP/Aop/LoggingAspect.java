package com.springAOP.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // @Before advice for all methods in OrderService class
    @Before("execution(* com.springAOP.service.OrderService.cancelOrder(..)) || execution(* com.springAOP.service.OrderService.updateOrder(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        System.out.println("INFO: Before executing method: " + joinPoint.getSignature().getName());
    }

    // @After advice for all methods in OrderService class
    @After("execution(* com.springAOP.service.OrderService.cancelOrder(..)) || execution(* com.springAOP.service.OrderService.updateOrder(..))")
    public void logAfterAllMethods(JoinPoint joinPoint) {
        System.out.println("INFO: After executing method: " + joinPoint.getSignature().getName());
    }

    // @Around advice specifically for processOrder method to log execution time
    @Around("execution(* com.springAOP.service.OrderService.processOrder(..))")
    public Object logAroundProcessOrder(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        // Log before method execution and record the start time
        System.out.println("INFO: Starting method: " + methodName);
        long startTime = System.currentTimeMillis();

        // Execute the methessod
        Object result = joinPoint.proceed();
        Thread.sleep(1000);
        // Log after method execution and record the end time
        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000; // Time taken in seconds
        System.out.println("INFO: Method " + methodName + " executed in " + timeTaken + " seconds");

        return result;
    }
}
