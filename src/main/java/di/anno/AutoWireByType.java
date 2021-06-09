package di.anno;

//동일한 타입을 가지고 있는 bean을 주입
//업무용으로 실행되는 코드
public class AutoWireByType {
	Tizen tizen;
	
	public void setTizen(Tizen tizen) {
		this.tizen = tizen;
	}

	public void output() {
		tizen.run();
	}
}
