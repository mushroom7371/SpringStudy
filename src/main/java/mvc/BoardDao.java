package mvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class BoardDao {
	
	SqlSession sqlSession;
	
	public BoardDao() {
		try {
			sqlSession = MybaFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("SqlSession 생성중 오류 발생...");
			}else {
				System.out.println("SqlSession 정상적으로 생성 완료...");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String input(BoardVo vo) {
		String msg = "OK";
		System.out.println("BoardDao.input");
		System.out.println("mid : " + vo.getMid());
		System.out.println("phone : " + vo.getPhone());
		
		int totSize = sqlSession.selectOne("board.totList", "");
		System.out.println("totSize : " + totSize);
		
		
		return msg;
	}
	
	public List<BoardVo> search(String findStr) {
		List<BoardVo> list = null;
		list = sqlSession.selectList("board.search", findStr);
		return list;
	}
		
}
