package com.luv2code.springdemo;

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

  //define a default constructor
  public TennisCoach() {
    System.out.println(">> TennisCoach: inside default constructor");
  }

  // define my init method
  @PostConstruct
  public void doMyStartupStuff() {
    System.out.println(">> TennisCoach: inside of doMyStartupStuff: ");
  }

  @PreDestroy
  public void doMyDestroyStuff() {
    System.out.println(">> TennisCoach: inside of doMyDestroyStuff: ");
  }


  // define my destroy method

  // define a setter method
//  @Autowired
//  public void doSomeCrazyStuff(FortuneService fortuneService) {
//    System.out.println(">> TennisCoach: inside setFortuneService() method");
//    this.fortuneService = fortuneService;
//  }

//  @Autowired
//  public TennisCoach(FortuneService fortuneService) {
//    this.fortuneService = fortuneService;
//  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
