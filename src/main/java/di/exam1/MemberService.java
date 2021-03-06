package di.exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MemberService {
	
	public MemberService() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/exam1/member.xml");
		
		Member rM = ac.getBean("rM", RegisterMember.class);
		//object 타입으로 잡았기 때문에 .class 로 RegisterMember 타입으로 해주는것
		Member gM = (GuestMember)ac.getBean("gM");
		//마찬가지로 GuestMember 타입으로 형변환하여 타입을 맞춰줌
		
		rM.insert(1);
		gM.delete(1);
		
	}
	

	public static void main(String[] args) {
		new MemberService();
	}
}
