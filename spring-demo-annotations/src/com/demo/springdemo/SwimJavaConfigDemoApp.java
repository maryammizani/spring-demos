package com.demo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring Java config file
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach lCoach = lContext.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(lCoach.getDailyWorkout());
		System.out.println(lCoach.getDailyFortune());
		
		System.out.println(lCoach.getmEmail());
		System.out.println(lCoach.getmTeam());
		
		// close the context
		lContext.close();

	}
}
