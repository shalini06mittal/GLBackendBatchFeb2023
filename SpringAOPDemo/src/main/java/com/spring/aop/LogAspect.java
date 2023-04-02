package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	// setName(String) => ..
	// getName()
	@Before("execution(* com.spring.aop.EmpService.setName(..))")
	public void beforeAdvice(JoinPoint jp)
	{
		System.out.println("\n************************\n");
		System.out.println("Before advice applied "+jp.getTarget());
		System.out.println(jp.getSignature().getName());
		System.out.println("\n************************\n");
	}
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
//	@After("execution(* com.spring.aop.*.*(..)) && args(obj) ")
//	public void afterAnotherAdvice(JoinPoint jp, Object obj)
//	{
//		System.out.println("\n************************\n");
//		System.out.println("After Another advice applied "+jp.getTarget());
//		System.out.println(jp.getSignature().getName());
//		System.out.println(obj);
//		System.out.println("\n************************\n");
//	}
//	@AfterReturning(pointcut= "execution(* com.spring.aop.*.*(..))",
//			returning="obj")
//	public void afterReturningAdvice(JoinPoint jp, Object obj)
//	{
//		System.out.println("\n************************\n");
//		System.out.println("After Returning advice applied "+jp.getTarget());
//		System.out.println(jp.getSignature().getName());
//		System.out.println(obj);
//		System.out.println("\n************************\n");
//	}
//	@AfterThrowing(pointcut="execution(* com.spring.aop.*.*(..))",
//			throwing = "ex")
//	public void afterThrowingAdvice(JoinPoint jp, Exception ex)
//	{
//		System.out.println("\n************************\n");
//		System.out.println("After Throwing exception advice applied "+jp.getTarget());
//		System.out.println(jp.getSignature().getName());
//		System.out.println(ex.getMessage());
//		System.out.println("\n************************\n");
//	}
	
//	@Around("execution(* com.spring.aop.*.*(..))")
//	public String aroundAdvice(ProceedingJoinPoint pjp )
//	{
//		String data = null;
//		System.out.println("\n******** that is checking the cache****************\n");
//		System.out.println("Around advice applied before calling teh actual method"+pjp.getTarget());
//		System.out.println(pjp.getSignature().getName());
//		System.out.println("\n************************\n");
//		// proceed will proceed calling the actual method
//		try {
//		 data =(String) pjp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return data.toUpperCase();
//	}
	
	
}
