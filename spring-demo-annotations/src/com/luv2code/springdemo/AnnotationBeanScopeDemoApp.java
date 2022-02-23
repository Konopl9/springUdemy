package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

  public static void main(String[] args) {

    // load spring config file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach coach = context.getBean("tennisCoach", Coach.class);
    Coach coach1 = context.getBean("tennisCoach", Coach.class);

    // check if they are the same
    boolean result = (coach == coach1);

    // print out the results
    System.out.println("\nPointing to the same object: " + result);

    System.out.println("\nMemory location for coach: " + coach);

    System.out.println("\nMemory location for coach1: " + coach1 + "\n");

    // context close
    context.close();
  }
}
