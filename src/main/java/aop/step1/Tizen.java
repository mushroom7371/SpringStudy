package aop.step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tizen implements DB {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		
	public Tizen() {
		System.out.println("Tizen database가 실행됨.");
	}

	@Override
	public void run() {
		System.out.println("log : " + sdf.format(new Date()));
		System.out.println("Tizen에서 회원정보가 수정됨");
		
	}
}
