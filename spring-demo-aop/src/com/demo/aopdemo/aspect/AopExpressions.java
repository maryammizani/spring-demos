package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// Create pointcuts for getter methods
	@Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// Create pointcuts for setter methods
	@Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
	public void  setter() {}
	
	// Create pointcuts: include package ... exclude getter/setter		
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
