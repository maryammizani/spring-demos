package com.demo.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.demo.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	// Logger is also used by Spring Framework
	private static Logger sLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// Read Spring config Java class
		AnnotationConfigApplicationContext lContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		TrafficFortuneService  lTrafficFortuneService  = lContext.getBean("trafficFortuneService", TrafficFortuneService .class);
				
		sLogger.info("\n---------------- Main Program: " );
		sLogger.info("Calling getFortune:" );
		String lData = lTrafficFortuneService.getFortune();
		sLogger.info("\nFortune is: " + lData );
		lContext.close();
	}

}
