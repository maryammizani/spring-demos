package com.demo.springdemo;

public class BaseballCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService mFortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService iFortuneService) {
		mFortuneService = iFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use mFortuneService to get a fortune
		return mFortuneService.getFortune();
	}
}
