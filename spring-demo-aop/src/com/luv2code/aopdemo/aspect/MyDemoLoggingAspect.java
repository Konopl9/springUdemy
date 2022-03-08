package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    AOP

//    //@Before("execution(public void add*())")
//    //@Before("execution(* add*(com.luv2code.aopdemo.Account))")
//    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//    public void beforeAddAccountAdvice() {
//    System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//    }

//    AOP DECLARATION
//    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//    private void forDaoPackage() {}
//
//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//    }
//
//    @Before("forDaoPackage()")
//    public void performApiAnalytics() {
//    System.out.println("\n=====>>> Performing API analytics");
//    }
    //    AOP DECLARATION COMBO
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // create pointcut for getter method
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create pointcut for setter method
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package .. exclude getter \ setter
    @Pointcut("forDaoPackage() && !(getter() || setter()))")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
    System.out.println("\n=====>>> Performing API analytics");
    }
}
