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
	
	// Create pointcuts for getter methods
	@Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// Create pointcuts for setter methods
	@Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
	private void  setter() {}
	
	// Create pointcuts: include package ... exclude getter/setter
		
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
//	@Before("execution(public void add*())")
//	@Before("execution(* add*(..))")
//	@Before("execution(* com.demo.aopdemo.dao.*.*(..))")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() { 		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() { 		
		System.out.println("\n======>>> Performing Api Analytics");
	}
}
