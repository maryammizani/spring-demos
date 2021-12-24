package com.demo.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.aopdemo.Account;
import com.demo.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
		
	private Logger mLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	// Add a new advice for @Around on the findAccounts method
	@Around("execution(* com.demo.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint iProceedingJoinPoint) throws Throwable{
		String lMethodSignature = iProceedingJoinPoint.getSignature().toShortString();
		mLogger.info("Method: " + lMethodSignature);
		mLogger.info("\n======>>> Executing @Around on Method: " + lMethodSignature);
		
		long lBegin = System.currentTimeMillis();
		Object lResult = iProceedingJoinPoint.proceed();
		long lEnd = System.currentTimeMillis();
		long lDuration = lEnd- lBegin;
		mLogger.info("\n======>>> Duration: " + lDuration/1000.0 + " seconds");
		return lResult;
	} 
		
	// Add a new advice for @After on the findAccounts method
	@After("execution(* com.demo.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint iJoinPoint) {
		String lMethodSignature = iJoinPoint.getSignature().toShortString();
		mLogger.info("Method: " + lMethodSignature);
		mLogger.info("\n======>>> Executing @AfterFinally on Method: " + lMethodSignature);
	} 	
		
	// Add a new advice for @AfterThrowing on the findAccounts method
	@AfterThrowing(pointcut="execution(* com.demo.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc")
	public void afterThrwoingFindAccountsAdvice(JoinPoint iJoinPoint, Throwable exc) {
		String lMethodSignature = iJoinPoint.getSignature().toShortString();
		mLogger.info("Method: " + lMethodSignature);
		mLogger.info("\n======>>> Executing @AfterThrowing on Method: " + lMethodSignature);
		mLogger.info("\n======>>> Exception is: " + exc);
	} 	
	
	// Add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.demo.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint iJoinPoint, List<Account> result) {
		String lMethodSignature = iJoinPoint.getSignature().toShortString();
		mLogger.info("Method: " + lMethodSignature);
		mLogger.info("\n======>>> Executing @AfterReturning on Method: " + lMethodSignature);
		mLogger.info("\n======>>> result is: " + result);
		
		// Post process data and modify it
		convertAccountNamesToUpperCase(result);
		mLogger.info("\n======>>> result is: " + result);
	} 		
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account lAccount: result) {
			String lName = lAccount.getName().toUpperCase();
			lAccount.setName(lName);
		}			
	}

//	@Before("execution(public void add*())")
//	@Before("execution(* add*(..))")
//	@Before("execution(* com.demo.aopdemo.dao.*.*(..))")
	@Before("com.demo.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint iJoinPoint) { 		
		mLogger.info("\n======>>> Executing @Before advice on addAccount()");
		
		// Display the method signature
		MethodSignature lMethodSignature = (MethodSignature)iJoinPoint.getSignature();
		mLogger.info("Method: " + lMethodSignature);
		
		// Display the method arguments
		Object[] lArgs = iJoinPoint.getArgs();
		for(Object lArg: lArgs) {
			mLogger.info((String) lArg);
			if(lArg instanceof Account) {
				// Downcast and print Account specific stuff
				Account lAccount = (Account)lArg;
				mLogger.info("Account name: " + lAccount.getName());
				mLogger.info("Account code: " + lAccount.getLevel());
			}
		}			
	}
	
}
