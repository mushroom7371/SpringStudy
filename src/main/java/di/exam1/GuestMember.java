package di.exam1;

import java.util.List;

public class GuestMember implements Member {
	
	public GuestMember() {
		System.out.println("GuestMember를 구현함");
	}
	
	public int insert(Object o) {
		int r = 0;
		System.out.println("GuestMember에서 회원정보가 입력됨");
		
		return r;
	}
	public List<Object> select(Object o) {
		List<Object> list = null;
		System.out.println("GuestMember에서 회원정보가 조회됨");
		
		return list;
	}
	public int update(Object o) {
		int r = 0;
		System.out.println("GuestMember에서 회원정보가 수정됨");
		
		return r;
	}
	public int delete(Object o) {
		int r = 0;
		System.out.println("GuestMember에서 회원정보가 삭제됨");
		
		return r;
	}
}
