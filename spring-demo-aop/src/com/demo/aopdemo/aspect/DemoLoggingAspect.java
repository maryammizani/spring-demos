package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	// This is where we add all of our related advices for logging
	
	// Let's start with an @Before advice
	
	@Before("execution(public void com.demo.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() { // method name can be anything
		
		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}
}
