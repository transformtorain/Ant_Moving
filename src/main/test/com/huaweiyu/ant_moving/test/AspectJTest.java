package com.huaweiyu.ant_moving.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//注解1
@Aspect
public class AspectJTest {
	
	//注解2 设置切入的目标方法，即执行哪些方法会生效
	@Pointcut("execution(* *.test(..))")
	public void test(){
		
	}
	
	//前置通知
	@Before("test()")
	public void beforeTest(){
		System.out.println("before");
	}
	
	//后置通知
	@After("test()")
	public void afterTest(){
		System.out.println("after");
	}
	
	//环绕通知
	@Around("test()")
	public Object arountTest(ProceedingJoinPoint p){
		System.out.println("before1");
		Object o = null;
		try {
			o = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after1");
		return o;
	}

}
