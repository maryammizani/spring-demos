package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext lContext = 
				new ClassPathXmlApplicationContext("beanLifeCycle-ApplicationContext.xml");
		
		// retrieve bean from spring container
		Coach lCoach =  lContext.getBean("myCoach", Coach.class);		
		System.out.println(lCoach.getDailyWorkout());
		lContext.close();
	}
}
