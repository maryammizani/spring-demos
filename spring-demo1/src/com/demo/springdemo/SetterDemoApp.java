package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext lContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve bean from container
		CricketCoach lCoach = lContext.getBean("myCricketCoach", CricketCoach.class);
		
		// call method on the bean
		System.out.println(lCoach.getDailyWorkout());
		System.out.println(lCoach.getDailyFortune());
		
		System.out.println(lCoach.getEmailAddress());
		System.out.println(lCoach.getTeam());
		
		// close the context
		lContext.close();

	}
}
