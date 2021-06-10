package aop.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/aop/step2/assembler.xml");
		
		Advice advice = ac.getBean("advice", Advice.class);
		System.out.println("before.............");
		advice.beforeLog();
		
		System.out.println("after..............");
		advice.afterLog();
		
		System.out.println("around.............");
		advice.aroundLog();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
