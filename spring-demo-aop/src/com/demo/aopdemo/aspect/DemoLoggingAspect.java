package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	// This is where we add all of our related advices for logging
	
	@Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
//	@Before("execution(public void add*())")
//	@Before("execution(* add*(..))")
//	@Before("execution(* com.demo.aopdemo.dao.*.*(..))")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() { 
		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() { 		
		System.out.println("\n======>>> Performing Api Analytics");
	}
}
