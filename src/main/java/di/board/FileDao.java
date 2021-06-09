package di.board;

import java.util.List;

public class FileDao implements Dao {
	
	public FileDao() {
		System.out.println("FileDao 객체가 생성됨");
	}
	
	public int insert() {
		int r = 0;
		System.out.println("자료실에서 자료가 작성되었습니다.");
		
		return r;
	}
	
	public List<Object> search(){
		List<Object> list = null;
		System.out.println("자료실에서 자료가 조회되었습니다.");
		
		return list;
	}
	
	public int update() {
		int r = 0;
		System.out.println("자료실에서 자료가 수정되었습니다.");
		
		return r;
	}
	public int delete() {
		int r = 0;
		System.out.println("자료실에서 자료가 삭제되었습니다.");
		
		return r;
	}
	
}
