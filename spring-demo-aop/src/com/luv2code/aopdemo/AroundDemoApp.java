package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

  public static void main(String[] args) {
    // read spring config class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from, spring container
    TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

    System.out.println("\nMain program: AroundDemoApp");

    System.out.println("Calling getFortune");

    String data = trafficFortuneService.getFortune();

    System.out.println("\nMy fortune is: " + data);

    System.out.println("Finished");
    // close context
    context.close();
  }
}
