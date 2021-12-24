package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.demo.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// Read Spring config Java class
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		TrafficFortuneService  lTrafficFortuneService  = lContext.getBean("trafficFortuneService", TrafficFortuneService .class);
				
		System.out.println("\n---------------- Main Program: " );
		System.out.println("Calling getFortune:" );
		String lData = lTrafficFortuneService.getFortune();
		System.out.println("\nFortune is: " + lData );
		// Close the context
		lContext.close();
	}

}
