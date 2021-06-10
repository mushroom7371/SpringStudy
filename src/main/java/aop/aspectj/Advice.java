package aop.aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice	{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");

	public Object before(JoinPoint point){
		
		System.out.println(sdf.format(new Date()));
		
		return null;
	}
	
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		System.out.println(sdf.format(new Date()));
		point.proceed();
		System.out.println(sdf.format(new Date()));
		
		return null;
	}

}
