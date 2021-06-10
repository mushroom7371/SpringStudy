package aop.aspectj;

import java.util.List;

public class BoardDao implements Dao {
	public BoardDao() {
		System.out.println("BoardDao 객체가 생성됨");
	}
	
	@Override
	public String insert() {
		System.out.println("게시판에서 글이 작성됨");
		return null;
	}

	@Override
	public List<Object> search() {
		List<Object> list = null;
		System.out.println("게시판에서 글이 조회됨");
		return list;
	}

	@Override
	public String update() {
		System.out.println("게시판에서 글이 수정됨");
		return null;
	}

	@Override
	public String delete() {
		System.out.println("게시판에서 글이 삭제됨");
		return null;
	}
	
}
