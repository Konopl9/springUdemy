package com.luv2code.springdemo;

public class TrackCoach implements Coach {

  private FortuneService fortuneService;

  public TrackCoach() {

  }

  public TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just do IT" + fortuneService.getFortune();
  }

  // add an init method
  public void doMyStartupStaff() {
    System.out.println("TrackCoach: inside method doMyStartupStaff");
  }

  // add destroy method
  public void doMyCleanupStaff() {
    System.out.println("TrackCoach: inside method doMyCleanupStaff");
  }
}
