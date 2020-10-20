package com.vjsb.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//@Before("execution(public void add*())")
	
	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create  pointcut for setter methods
	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");
	}
	
}
