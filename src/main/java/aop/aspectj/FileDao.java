package aop.aspectj;

import java.util.List;

public class FileDao implements Dao {
	public FileDao() {
		System.out.println("FileDao 객체가 생성됨");
	}
	
	@Override
	public String insert() {
		System.out.println("자료실에서 자료가 작성됨");
		return null;
	}

	@Override
	public List<Object> search() {
		List<Object> list = null;
		System.out.println("자료실에서 자료가 조회됨");
		return list;
	}

	@Override
	public String update() {
		System.out.println("자료실에서 자료가 수정됨");
		return null;
	}

	@Override
	public String delete() {
		int r = 1;
		System.out.println("자료실에서 자료가 삭제됨");
		return null;
	}
	
	

}
