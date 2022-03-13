package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import java.util.List;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

  private Logger logger = Logger.getLogger(getClass().getName());

  @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    String method = proceedingJoinPoint.getSignature().toShortString();
    logger.info("\n Executing Around on method: " + method);

    long begin = System.currentTimeMillis();

    Object result = proceedingJoinPoint.proceed();

    long end = System.currentTimeMillis();

    long duration = end - begin;

    logger.info("\n=====> Duration " + duration / 1000.0 + " seconds");

    return result;
  }

  @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
    String method = joinPoint.getSignature().toShortString();
    logger.info("\n Executing @After (finally) on method: " + method);
  }

  @AfterThrowing(
      pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "exc")
  public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
    String method = joinPoint.getSignature().toShortString();
    logger.info("\n Executing AfterThrowing on method: " + method);

    logger.info("\n========> The exception is: " + exc);
  }

  @AfterReturning(
      pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

    // print method with method we are advising on
    String method = joinPoint.getSignature().toShortString();
    logger.info("\n Executing AfterReturning on method: " + method);

    logger.info("\n========> result is: " + result);

    // convert the account names to upper case !!! BAD PRACTICE TO MODIFY THE DATA USING Aspect
    convertAccountToUpperCase(result);

    logger.info("\n========> result is: " + result);
  }

  private void convertAccountToUpperCase(List<Account> result) {
    for (Account account : result) {
      String nameUpper = account.getName().toUpperCase();
      account.setName(nameUpper);
    }
  }

  @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    logger.info("\n=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

    logger.info("Method: " + methodSignature);

    // display method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object arg : args) {
      logger.info(arg.toString());
      if (arg instanceof Account) {
        // dowcast and print Account specific stuff
        Account account = (Account) arg;
        logger.info("account name: " + account.getName());
        logger.info("account level: " + account.getLevel());
      }
    }
  }
}
