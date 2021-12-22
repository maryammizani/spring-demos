package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext lContext = 
				new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");
		
		// retrieve bean from spring container
		Coach lCoach =  lContext.getBean("myCoach", Coach.class);
		Coach lAlphaCoach =  lContext.getBean("myCoach", Coach.class);

		System.out.println("lCoach: " + lCoach.getDailyFortune());
		
		// check if they are the same bean
		boolean lResult = (lCoach == lAlphaCoach);
		System.out.println("Same obj: " + lResult);
		System.out.println("Memory location for Coach: " + lCoach);
		System.out.println("Memory location for alphCoach: " + lAlphaCoach);
		lContext.close();
	}
}
