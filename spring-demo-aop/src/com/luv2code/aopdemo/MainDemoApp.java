package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read spring config class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from, spring container
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    // call business method
    accountDAO.addAccount();

    // close context
    context.close();
  }
}
