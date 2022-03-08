package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read spring config class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from, spring container
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    // get membership ben
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

    // call business method
    Account account = new Account();
    accountDAO.addAccount(account, false);
    membershipDAO.addAccount();
    membershipDAO.goToSleep();

    System.out.println("\n let's do it againt");

    // call the accountdao getter/setter methods
    accountDAO.setName("Test");
    accountDAO.setServiceCode("TestService");
    String name = accountDAO.getName();
    String code = accountDAO.getServiceCode();

    // call business method
    accountDAO.addAccount(account, true);
    accountDAO.doWork();

    // close context
    context.close();
  }
}
