package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDAO;
import com.demo.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read Spring config Java class
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO lAccountDAO = lContext.getBean("accountDAO", AccountDAO.class);
				
		// Call the business method
		lAccountDAO.addAccount();
		
		// Get the membership bean from spring container
		MembershipDAO lMembershipDAO = lContext.getBean("membershipDAO", MembershipDAO.class);
						
		// Call the business method
		lMembershipDAO.addAccount();
		
		// Close the context
		lContext.close();
	}

}
