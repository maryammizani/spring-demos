package com.demo.springdemo;

public class TrackCoach implements Coach {

	// define a private field for the dependency
	private FortuneService mFortuneService;			

	public TrackCoach() {
	}
	
	public TrackCoach(FortuneService mFortuneService) {
		super();
		this.mFortuneService = mFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " +  mFortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}
	
}
