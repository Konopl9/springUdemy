package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

  public String addAccount() {
    System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

    return "";
  }

  public void goToSleep() {
    System.out.println(getClass() + ": going to sleep");
  }
}
