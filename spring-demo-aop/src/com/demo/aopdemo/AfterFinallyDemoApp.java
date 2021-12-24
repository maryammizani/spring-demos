package com.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDAO;
import com.demo.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// Read Spring config Java class
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO lAccountDAO = lContext.getBean("accountDAO", AccountDAO.class);
				
		List<Account> lAccounts = null;
		
		try {
			// Add a boolean flag to simulate exceptions
			boolean lEnableException = true;
			lAccountDAO.findAccounts(lEnableException);			
		}
		catch (Exception exc) {
			System.out.println("\n\n---------------- Main Program Exception: " + exc );
		}
		
		System.out.println("\n\n---------------- Main Program: " );
		System.out.println(lAccounts );
		System.out.println("\n" );
		// Close the context
		lContext.close();
	}

}
