package com.springAOP.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * LoggingAspect is an Aspect class used to add logging behavior before, after, and around
 * specific methods in the OrderService class.
 *
 * Author: Jaisai Sarkate
 * Time: September 9, 2024
 * Objective: To provide logging functionality and measure execution time of methods in the service layer.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * @Before advice for cancelOrder and updateOrder methods.
     *
     * Objective: Log information before the execution of cancelOrder and updateOrder methods.
     *
     * @param joinPoint Provides access to the method information being intercepted.
     */
    @Before("execution(* com.springAOP.service.OrderService.cancelOrder(..)) || execution(* com.springAOP.service.OrderService.updateOrder(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        System.out.println("INFO: Before executing method: " + joinPoint.getSignature().getName());
    }

    /**
     * @After advice for cancelOrder and updateOrder methods.
     *
     * Objective: Log information after the execution of cancelOrder and updateOrder methods.
     *
     * @param joinPoint Provides access to the method information being intercepted.
     */
    @After("execution(* com.springAOP.service.OrderService.cancelOrder(..)) || execution(* com.springAOP.service.OrderService.updateOrder(..))")
    public void logAfterAllMethods(JoinPoint joinPoint) {
        System.out.println("INFO: After executing method: " + joinPoint.getSignature().getName());
    }

    /**
     * @Around advice for processOrder method.
     *
     * Objective: Measure the execution time of the processOrder method and log the start and end of the method.
     *
     * @param joinPoint Provides access to the method information and the ability to control its execution.
     * @return The result of the processOrder method.
     * @throws Throwable Allows exceptions thrown by the method to propagate.
     */
    @Around("execution(* com.springAOP.service.OrderService.processOrder(..))")
    public Object logAroundProcessOrder(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        // Log before method execution and record the start time
        System.out.println("INFO: Starting method: " + methodName);
        long startTime = System.currentTimeMillis();

        // Execute the method
        Object result = joinPoint.proceed();
        Thread.sleep(1000);  // Simulate a delay for the sake of example

        // Log after method execution and record the end time
        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000; // Time taken in seconds
        System.out.println("INFO: Method " + methodName + " executed in " + timeTaken + " seconds");

        return result;
    }
}
