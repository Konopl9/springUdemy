package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

  @AfterThrowing(
      pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "exc")
  public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n Executing AfterThrowing on method: " + method);

    System.out.println("\n========> The exception is: " + exc);
  }

  @AfterReturning(
      pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

    // print method with method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n Executing AfterReturning on method: " + method);

    System.out.println("\n========> result is: " + result);

    // convert the account names to upper case !!! BAD PRACTICE TO MODIFY THE DATA USING Aspect
    convertAccountToUpperCase(result);

    System.out.println("\n========> result is: " + result);
  }

  private void convertAccountToUpperCase(List<Account> result) {
    for (Account account : result) {
      String nameUpper = account.getName().toUpperCase();
      account.setName(nameUpper);
    }
  }

  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

    System.out.println("Method: " + methodSignature);

    // display method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object arg : args) {
      System.out.println(arg);
      if (arg instanceof Account) {
        // dowcast and print Account specific stuff
        Account account = (Account) arg;
        System.out.println("account name: " + account.getName());
        System.out.println("account level: " + account.getLevel());
      }
    }
  }
}
