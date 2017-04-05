package com.mmm.utils.logging;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	private static Long currentTimeMillis = 0l;
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("execution(* com.mmm.dao.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		currentTimeMillis = System.currentTimeMillis();
		logger.info("This method ["+methodName+"] start with args "+Arrays.asList(joinPoint.getArgs()));
	}
	/**
	 * 返回通知
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value="execution(* com.mmm.dao.*.*(..))",returning="result")
	public void afterMethod(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		logger.info("This method ["+methodName+"] end with result "+result);
		logger.info("This method ["+methodName+"] response time is "+(System.currentTimeMillis()-currentTimeMillis)+" ms");
		
	}
	
}
