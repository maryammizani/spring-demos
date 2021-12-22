package com.demo.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	/*
	 * @Autowired public TennisCoach(FortuneService iFortuneService) {
	 * fortuneService = iFortuneService; }
	 */
	public TennisCoach() {
		System.out.println(">> Tennis Coach: Inside default constructor");
	}
	
	// Define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> Tennis Coach: inside of doMyStartupStuff()");
	}
	
	// Define destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> Tennis Coach: inside of doMyCleanupStuff()");
	}
	
	// Define a Setter method
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService iFortuneService) {
	 * System.out.println(">> Tennis Coach: Inside doSomeCrazyStuff()");
	 * fortuneService = iFortuneService; }
	 */
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand vollley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
