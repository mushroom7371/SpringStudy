package aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/aop/aspectj/assembler.xml");
		
		Dao dao = ac.getBean("fDao", Dao.class);
							//proxy가 아니라 객체를 불러온다
		
		dao.insert();
		dao.search();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
