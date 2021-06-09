package di.anno;

public class Mysql implements DB {
	public Mysql() {
		System.out.println("Mysql database가 실행됨.");
	}

	@Override
	public void run() {
		System.out.println("MySql에서 회원정보가 조회됨");
		
	}
}
