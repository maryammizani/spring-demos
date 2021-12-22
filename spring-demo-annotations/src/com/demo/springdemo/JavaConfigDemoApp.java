package com.demo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring Java config file
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach lCoach = lContext.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(lCoach.getDailyWorkout());
		System.out.println(lCoach.getDailyFortune());
		
		// close the context
		lContext.close();

	}
}
