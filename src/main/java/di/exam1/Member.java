package di.exam1;

import java.util.List;

public interface Member {
	//회원정보 CRUD 추상 메서드들
	public int insert(Object o);
	public List<Object> select(Object o);
	public int update(Object o);
	public int delete(Object o);
	
}
