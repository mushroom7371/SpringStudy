package di.anno;

//동일한 이름을 가지고 있는 bean을 주입
//업무용으로 실행되는 코드
public class AutoWireByName {
	Oracle or;
	
	public void setOr(Oracle or) {
		this.or = or;
	}

	public void output() {
		or.run();
	}
}
