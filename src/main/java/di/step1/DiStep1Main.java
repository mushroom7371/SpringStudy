package di.step1;
//DI없이 바로 작성 하였기에 의존성이 떨어진다
public class DiStep1Main {
	public void run() {
		Oracle db = new Oracle();
	}
	
	public static void main(String[] args) {
		DiStep1Main main = new DiStep1Main();
		main.run();
	}
	
}
