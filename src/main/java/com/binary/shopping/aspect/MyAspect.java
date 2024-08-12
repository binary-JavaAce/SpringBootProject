package com.binary.shopping.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.binary.shopping.entity.Customer;

@Component
@Aspect
public class MyAspect {

	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
//	@Before("execution(* com.binary.shopping.controller.*.*())")
//	public void printBefore(JoinPoint joinPoint) {
//		System.out.println("Method execution started" + joinPoint.getSignature());
//	}
//
//	@After("execution(* com.binary.shopping.service.impl*.*())")
//	public void printAfter(JoinPoint joinPoint) {
//		System.out.println("Method execution ended" + joinPoint.getSignature());
//	}
//
//	@AfterReturning("execution(* com.binary.shopping.controller.*.*(..))")
//	public void printAround() {
//		System.out.println("Method execution ended");
//	}


	@Pointcut("execution(* com.binary.shopping.controller.*.*(..)) ")
	private void saveCustomer() {
	}

	@Around("saveCustomer()")
    public Object beforeAdvice(ProceedingJoinPoint pjp) throws Throwable
	{
        // Print statements
        System.out.println("Around method:" + pjp.getSignature());
        System.out.println("Before calling joint point service method");
        
        Object[] args = pjp.getArgs();

        // Assuming the first argument is the object you want to pass/manipulate
        if (args.length > 0 && args[0] instanceof Customer) {
            Customer cust = (Customer) args[0];
        logger.info("Arguments : First Name :  {} , Last Name {}" + cust.getFirstName(), cust.getFirstName());
        }
        Object c = pjp.proceed();
 
        // Print statement
        logger.info("After calling joint point service method ");
	    return c;
	    
	}
}
