package com.telusko.springmvcboot;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution (public *  com.telusko.springmvcboot.AlienController.getAliens())")
	public void logBefore() 
	{
		LOGGER.info("getAliens method called from LoggingAspect!");
	}
	
	@AfterReturning("execution (public *  com.telusko.springmvcboot.AlienController.getAliens())")     //When execution of method is success
	public void logAfter() 
	{
		LOGGER.info("getAliens method Executed !");
	}
	
	@AfterThrowing("execution (public *  com.telusko.springmvcboot.AlienController.getAliens())")     //When execution of method is not success
	public void logException() 
	{
		LOGGER.info("Issue !");
	}
	
	

}
