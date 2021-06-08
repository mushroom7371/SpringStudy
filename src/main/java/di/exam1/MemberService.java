package di.exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MemberService {
	
	public MemberService() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/exam1/member.xml");
		
		Member rM = ac.getBean("rM", RegisterMember.class);
		Member gM = (GuestMember)ac.getBean("gM");
		
		rM.insert(1);
		gM.delete(1);
		
	}
	

	public static void main(String[] args) {
		new MemberService();
	}
}
