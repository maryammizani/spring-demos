package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
	public void beforeAddAccountAdvice(JoinPoint iJoinPoint) { 		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
		
		// Display the method signature
		MethodSignature lMethodSignature = (MethodSignature)iJoinPoint.getSignature();
		System.out.println("Method: " + lMethodSignature);
		
		// Display the method arguments
	}
	
}
