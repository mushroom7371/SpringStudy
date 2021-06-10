package aop.exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/aop/exam1/assembler.xml");
		
		Dao dao = ac.getBean("proxy", Dao.class);
		
		dao.insert();
		dao.search();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
