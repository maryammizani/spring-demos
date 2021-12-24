package com.demo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		
		// Simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Return a fortune
		return "Heavy Traffic";
	}

	public String getFortune(boolean iEnableException) {
		// For testing purpose: Simulate an exception
		if(iEnableException) {
			throw new RuntimeException("Major Accident!");
		}
		return getFortune();
	}
}
