package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService mFortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getmEmail() {
		return email;
	}

	public String getmTeam() {
		return team;
	}

	public SwimCoach(FortuneService iFortuneService) {
		mFortuneService = iFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters";
	}

	@Override
	public String getDailyFortune() {
		return mFortuneService.getFortune();
	}

}
