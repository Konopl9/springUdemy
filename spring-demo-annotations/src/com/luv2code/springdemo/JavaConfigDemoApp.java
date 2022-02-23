package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

  public static void main(String[] args) {
    // read spring configuration java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SportConfig.class);
    // ge bean from spring container
    Coach coach = context.getBean("tennisCoach", Coach.class);
    // call a method on the bean
    System.out.println(coach.getDailyWorkout()); 
    // call method to get the daily fortune
    System.out.println(coach.getDailyFortune());
    // clean context
    context.close();
  }

}
