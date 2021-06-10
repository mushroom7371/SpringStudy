package aop.exam1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class Advice implements MethodInterceptor{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("클래스 명은 : " + invocation.getThis().getClass().getSimpleName());
		beforeLog();
		invocation.proceed(); //Dao 메서드를 실행하게 됨.
		
		return null;
	}
	
	//before advice type
	public void beforeLog() {
		System.out.println("실행 시간은 : " + sdf.format(new Date()));
	}
}
