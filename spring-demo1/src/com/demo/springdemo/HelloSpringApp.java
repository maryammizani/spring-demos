package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext lContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach lCoach = lContext.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(lCoach.getDailyWorkout());
		System.out.println(lCoach.getDailyFortune());
		
		// close the context
		lContext.close();

	}

}
