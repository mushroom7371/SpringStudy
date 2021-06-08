package di.step4;

public class DiStep4Main {
	// 1000만원짜리 코드 오픈을 안해도 assembler 에서 변경하면 됨
	DB db;
	public void abc(DB db) {
		this.db = db;
		this.db.run();
	}
	//메서드에 DB 인터페이스를 구현한 참조변수를 받으면 db에 저장되고, run()메서드가 실행된다.
	public static void main(String[] args) {
		Assembler ass = new Assembler();
		DiStep4Main m = new DiStep4Main();
		
		m.abc(ass.getDb());
		//Assembler 객체의 getDb()메서드로 생성된 객체를 리턴받고 이를 abc()메서드에 매개변수로 넣어준다.
		
	}
}
