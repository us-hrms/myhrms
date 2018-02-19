package com.hrms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExceptionInterceptor {

    @Pointcut("execution(public * com.hrms.service.impl..*.*(..))")
    public void myMethod(){};
    
    /*@Before("myMethod()")
    public void before() {
        System.out.println("method staet");
    } 
    @After("myMethod()")
    public void after() {
        System.out.println("method after");
    } 
    @AfterReturning("execution(public * com.oumyye.dao..*.*(..))")
    public void AfterReturning() {
        System.out.println("method AfterReturning");
    } 
    @AfterThrowing("execution(public * com.oumyye.dao..*.*(..))")
    public void AfterThrowing() {
        System.out.println("method AfterThrowing");
    } */
    
    @Around("myMethod()")
    public Object around(ProceedingJoinPoint pjp){
    	try {
			return pjp.proceed();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
