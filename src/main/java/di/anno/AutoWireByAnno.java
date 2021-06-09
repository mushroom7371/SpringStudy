package di.anno;

import org.springframework.beans.factory.annotation.Autowired;

//동일한 유형의 bean을 자동 주입
//업무용으로 실행되는 코드
public class AutoWireByAnno {
	Mysql sql;
	
	@Autowired
	public void setMysql(Mysql sql) {
		this.sql = sql;
	}

	public void output() {
		sql.run();
	}
}
