package di.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiStep5Main {
	
	public DiStep5Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/step5/assembler.xml");
		
		DB db = (DB)ac.getBean("db");	//assembler.xml의 bean id 와 동일
		db.run();
		
	}
	
	public static void main(String[] args) {
		new DiStep5Main();
	}
}
