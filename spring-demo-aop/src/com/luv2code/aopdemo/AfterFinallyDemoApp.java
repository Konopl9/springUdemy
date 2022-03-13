package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterFinallyDemoApp {

  public static void main(String[] args) {
    // read spring config class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from, spring container
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    // get membership ben
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

    // call method to find the accounts
    List<Account> accounts = null;
    try {
      boolean tripWire = true;
      accounts = accountDAO.findAccounts(tripWire);
    } catch (Exception e) {
      System.out.println("\n\nMain program .. caught the exception " + e);
    }

    // display the accounts
    System.out.println("\n\nMain Program: AfterThrowingDemoApp");

    System.out.println(accounts);

    System.out.println("\n");

    // close context
    context.close();
  }
}
