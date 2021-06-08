package di.step2;
//DI 약간 구현, 외부환경 변화에 따라 내부환경도 변화해야 한다.
public class DiStep2Main {
	Tizen t;
	public void run(Tizen t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		Tizen t = new Tizen();
		DiStep2Main main = new DiStep2Main();
		main.run(t);
	}
}
