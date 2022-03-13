package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundWithLoggerDemoApp {

  private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

  public static void main(String[] args) {

    // read spring config class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from, spring container
    TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

    logger.info("\nMain program: AroundDemoApp");

    logger.info("Calling getFortune");

    String data = trafficFortuneService.getFortune();

    logger.info("\nMy fortune is: " + data);

    logger.info("Finished");
    // close context
    context.close();
  }
}
