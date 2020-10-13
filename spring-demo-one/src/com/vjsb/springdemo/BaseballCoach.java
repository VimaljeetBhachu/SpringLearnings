package com.vjsb.springdemo;

public class BaseballCoach implements Coach {
	
	public BaseballCoach() {
		
	}
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for the dependency injection
	public BaseballCoach(FortuneService thefortuneService) {
		this.fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
