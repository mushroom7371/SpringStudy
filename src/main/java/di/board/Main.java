package di.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	
	public Main() {
		
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/board/config.xml");
		
		BoardService bs = ac.getBean("byType", BoardService.class);
		bs.output();
	
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
}
		