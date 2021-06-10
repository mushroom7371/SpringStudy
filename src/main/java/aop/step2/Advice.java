package aop.step2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

//횡단적 관심사가 분리된 코드
public class Advice {
	
	@Autowired
	Tizen db;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
	
	//before advice type
	public void beforeLog() {
		System.out.println("log : " + sdf.format(new Date()));
		db.run();	//joinPoint, pointCut
	}
	//after advice type
	public void afterLog() {
		db.run();	//joinPoint, pointCut
		System.out.println("log : " + sdf.format(new Date()));
		}

	//around advice type
	public void aroundLog() {
		System.out.println("log : " + sdf.format(new Date()));
		db.run();	//joinPoint, pointCut
		System.out.println("log : " + sdf.format(new Date()));
	}
}
