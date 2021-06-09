package di.exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MemberService {
	
	public MemberService() {
		/* 기존 member.xml 파일을 사용하여 빈을 다루는 방법
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/di/exam1/member.xml");
		
		Member rM = ac.getBean("rM", RegisterMember.class);
		//object 타입으로 잡았기 때문에 .class 로 RegisterMember 타입으로 해주는것
		Member gM = (GuestMember)ac.getBean("gM");
		//마찬가지로 GuestMember 타입으로 형변환하여 타입을 맞춰줌
		*/
		
		//MemberConfig.java를 이용하여 빈을 가져오는 방법
		ApplicationContext ac = new AnnotationConfigApplicationContext(MemberConfig.class);
		Member rM = ac.getBean("rMember", RegisterMember.class);
		Member gM = (GuestMember)ac.getBean("gMember");	
		
		rM.insert(1);
		gM.delete(1);
		
	}
	

	public static void main(String[] args) {
		new MemberService();
	}
}
