package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

  // Define a private field
  private FortuneService fortuneService;

  // Define a construction for dependency injection
  public BaseballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
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
