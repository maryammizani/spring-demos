package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext lContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// get the bean from spring container
		Coach lCoach = lContext.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(lCoach.getDailyWorkout());
		System.out.println(lCoach.getDailyFortune());
		
		// close the context
		lContext.close();

	}
}
