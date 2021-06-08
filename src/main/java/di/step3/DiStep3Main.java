package di.step3;

public class DiStep3Main {
//	Oracle o;
//	
//	public DiStep3Main(Oracle o) {
//		Oracle o = new Oarcle();	X
//		this.o = o;
//	}
	
	//DB 변경시 1000만원짜리 코드를 오픈하기 힘들다
	DB db;
	public DiStep3Main(DB db) {//생성자를 통한 주입
		this.db = db;
		db.run();
	}
	
	public void abc(DB db) {//메서드를 통한 주입
		this.db = db;
	}
		
	public static void main(String[] args) {
		Tizen o = new Tizen();
		DiStep3Main m = new DiStep3Main(o);

	}
}
