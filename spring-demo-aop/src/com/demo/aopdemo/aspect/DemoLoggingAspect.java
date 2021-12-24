package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
		
//	@Before("execution(public void add*())")
//	@Before("execution(* add*(..))")
//	@Before("execution(* com.demo.aopdemo.dao.*.*(..))")
	@Before("com.demo.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() { 		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
	
}
