package di.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/anno/assembler.xml");
		
		AutoWireByName abn = ac.getBean("byName", AutoWireByName.class);
		abn.output();
		
		AutoWireByType abt = ac.getBean("byType", AutoWireByType.class);
		abt.output();
		
		AutoWireByAnno aba = ac.getBean("byAnno", AutoWireByAnno.class);
		aba.output();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
