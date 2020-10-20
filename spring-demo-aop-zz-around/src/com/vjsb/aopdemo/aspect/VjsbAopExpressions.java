package com.vjsb.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class VjsbAopExpressions {

	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create  pointcut for setter methods
	@Pointcut("execution(* com.vjsb.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
