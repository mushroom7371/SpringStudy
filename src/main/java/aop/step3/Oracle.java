package aop.step3;

public class Oracle implements DB {
		
	public Oracle() {
		System.out.println("oracle database가 실행됨.");
	}
	//생성자를 통해 객체가 생성되면 oracle이 실행 된다는 글귀를 띄움

	@Override
	public void run() {
		System.out.println("Oracle에서 회원정보가 삭제됨");
	}
	//인터페이스의 추상 메서드를 오버라이딩 하여 클래스의 내용에 맞게 출력 문구를 작성함.
}


