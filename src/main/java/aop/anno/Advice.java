package aop.anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advice	{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");

	@Before("execution(* insert(..)) || execution(* update(..))")
	public Object before(JoinPoint point){
		
		System.out.println(sdf.format(new Date()));
		
		return null;
	}
	
	@Around("execution(* delete(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		System.out.println(sdf.format(new Date()));
		point.proceed();
		System.out.println(sdf.format(new Date()));
		
		return null;
	}

}
