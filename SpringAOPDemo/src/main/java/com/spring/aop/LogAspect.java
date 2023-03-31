package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	public LogAspect() {
		//System.out.println("Log Aspect contructor");
	}
	// logger in java
	// before -> advice where u provide pointcut expression
//	@Before("execution(* com.spring.aop.EmpService.setName(String))")
//	public void beforeAdvice(JoinPoint jp)
//	{
//		System.out.println("\n************************\n");
//		System.out.println("Before advice applied "+jp.getTarget());
//		System.out.println(jp.getSignature().getName());
//		System.out.println("\n************************\n");
//	}
//	@After("execution(* com.spring.aop.EmpService.setName(String))"
//			+ " && args(name)")
//	public void afterAdvice(JoinPoint jp, String name)
//	{
//		System.out.println("\n************************\n");
//		System.out.println("After advice applied "+jp.getTarget());
//		System.out.println(jp.getSignature().getName());
//		System.out.println(name);
//		System.out.println("\n************************\n");
//	}
	@After("execution(* com.spring.aop.*.*(..)) && args(obj) ")
	public void afterAnotherAdvice(JoinPoint jp, Object obj)
	{
		System.out.println("\n************************\n");
		System.out.println("After Another advice applied "+jp.getTarget());
		System.out.println(jp.getSignature().getName());
		System.out.println(obj);
		System.out.println("\n************************\n");
	}
}
