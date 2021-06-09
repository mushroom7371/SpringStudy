package di.board;

import java.util.List;

public interface Dao {
	
	public int insert();
	
	public List<Object> search();
	
	public int update();
	
	public int delete();
	
}
