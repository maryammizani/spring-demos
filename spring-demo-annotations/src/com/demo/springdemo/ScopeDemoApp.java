package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp {

	public static void main(String[] args) {

		// load spring config file
		ClassPathXmlApplicationContext lContext = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach lCoach = lContext.getBean("tennisCoach", Coach.class);
		Coach lAlphaCoach = lContext.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean lResult = (lCoach == lAlphaCoach);
		System.out.println("Pointing to the same obj: " + lResult);
		System.out.println("Memory location for the coach: " + lCoach);
		System.out.println("Memory location for the alphaCoach: " + lAlphaCoach);
		
		// close the context
		lContext.close();
	}

}
