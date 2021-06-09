package di.board;

import java.util.List;

public class BoardDao implements Dao {
	
	public BoardDao() {
		System.out.println("BoardDao 객체가 생성됨");
	}
	
	
	public int insert() {
		int r = 0;
		System.out.println("게시판에서 게시글이 작성되었습니다.");
		
		return r;
	}
	
	public List<Object> search(){
		List<Object> list = null;
		System.out.println("게시판에서 게시글이 조회되었습니다.");
		
		return list;
	}
	
	public int update() {
		int r = 0;
		System.out.println("게시판에서 게시글이 수정되었습니다.");
		
		return r;
	}
	public int delete() {
		int r = 0;
		System.out.println("게시판에서 게시글이 삭제되었습니다.");
		
		return r;
	}
	
	
}
