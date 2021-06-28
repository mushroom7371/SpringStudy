package reserve;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.BoardAttVo;
import board.BoardFileUploadController;
import board.BoardVo;
import board.Page;
import mybatis.MybaFactory;

public class ReserveDao {
SqlSession sqlSession;
	
	public ReserveDao() {
		try {
			sqlSession = MybaFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("sqlSession 생성시 오류 발생");
			}else {
				System.out.println("정상적으로 sqlSession이 생성됨.");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public MyReserveVo select(MyReserveVo vo){
		MyReserveVo vo2 = null;
		
		try {
			
			vo2 = sqlSession.selectOne("reserve_search", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return vo2;
	}
	
	public String insert(MyReserveVo vo) {
		String msg = "OK";
		int r = 0;

		try {
			r = sqlSession.insert("reserve.reserve_myinsert", vo);
			System.out.println("vo size : " + r);
			if(r>0) {
					sqlSession.commit();
				}else {
					throw new Exception();
				}
		}catch(Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();

		}

		return msg;
	}
}


















