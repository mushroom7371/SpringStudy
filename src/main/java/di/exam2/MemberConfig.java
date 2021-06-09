package di.exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// exam1안에 있는 member.xml 파일 대체 어노테이션을 이용한 bean 설정
@Configuration
public class MemberConfig {
	
	@Bean
	public Member rMember() {	//메서드명이 xml 파일의 id 역할을 한다.
		return new RegisterMember();
	}
	
	@Bean
	public Member gMember() {
		return new GuestMember();
	}
}
