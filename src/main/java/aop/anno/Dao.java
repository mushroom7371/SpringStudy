package aop.anno;

import java.util.List;

public interface Dao {
	
	public String insert();
	
	public List<Object> search();
	
	public String update();
	
	public String delete();
}
