package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

  public static void main(String[] args) {
    // read spring configuration java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SportConfig.class);
    // ge bean from spring container
    SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
    // call a method on the bean
    System.out.println(coach.getDailyWorkout()); 
    // call method to get the daily fortune
    System.out.println(coach.getDailyFortune());
    // call our new methods
    System.out.println(coach.getEmail());
    System.out.println(coach.getTeam());
    // clean context
    context.close();
  }

}
