package aop.step3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//횡단적 관심사가 분리된 코드
public class Advice implements MethodInterceptor {	//메서드가 실행되기 전에 쓱 가로챈다
	
	@Autowired
	@Qualifier("ti")
	Tizen db;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		beforeLog();
		invocation.proceed(); //DB.run()을 실행하게 됨.
		afterLog();
		
		return null;
	}
	
	//before advice type
	public void beforeLog() {
		System.out.println("log1 : " + sdf.format(new Date()));
	}
	//after advice type
	public void afterLog() {
		System.out.println("log2 : " + sdf.format(new Date()));
		}

	//around advice type
	public void aroundLog() {
		System.out.println("log : " + sdf.format(new Date()));
		db.run();	//joinPoint, pointCut
		System.out.println("log : " + sdf.format(new Date()));
	}

}
