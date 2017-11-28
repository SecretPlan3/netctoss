package org.project.netctoss.aspects;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


import org.springframework.stereotype.Component;
//@Component
//@Aspect
public class RunLogsMag {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	//@AfterReturning(pointcut="execution(* com.easy.service.serviceimpl.UserServiceImpl.*(..))",returning="retVal")
	public void runLog(JoinPoint jp,Object retVal) {
		System.out.println("aopok");
		Object obj=jp.getTarget();
		Class<?> c=obj.getClass();
		
		String message=c.getName()+"------------"+jp.getSignature().getName()+"-----------return="+retVal.toString();
		System.out.println(message);
		log.info(message);
		
	}
	//@AfterThrowing(pointcut="execution(* com.easy.service.serviceimpl.UserServiceImpl.*(..))",throwing="exception")
	public void runLog2(JoinPoint jp,Object exception) {
		System.out.println("aopno");
		Object obj=jp.getTarget();
		Class<?> c=obj.getClass();
		Exception e=(Exception) exception;
		log.debug(c.getName()+"------------"+jp.getSignature().getName(), e);
		
	}
	
	//@AfterReturning(pointcut="execution(* com.easy.controller.UserController.*(..))",returning="retVal")
	public void runLogcon(JoinPoint jp,Object retVal) {
		System.out.println("aopok");
		Object obj=jp.getTarget();
		Class<?> c=obj.getClass();
		
		String message=c.getName()+"------------"+jp.getSignature().getName()+"-----------return="+retVal.toString();
		System.out.println(message);
		log.info(message);
		
	}
	//@AfterThrowing(pointcut="execution(* com.easy.controller.UserController.*(..))",throwing="exception")
	public void runLogcon2(JoinPoint jp,Object exception) {
		System.out.println("aopno");
		Object obj=jp.getTarget();
		Class<?> c=obj.getClass();
		Exception e=(Exception) exception;
		log.debug(c.getName()+"------------"+jp.getSignature().getName(), e);
		
	}
	
	
}
