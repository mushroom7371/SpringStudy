package board;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class BoardDao {
	SqlSession sqlSession;
	
	public BoardDao() {
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
	
	public List<BoardVo> select(Page page){
		List<BoardVo> list = null;
		
		try {
			int totList = sqlSession.selectOne("board.totList", page.getFindStr());
			page.setTotList(totList);
			page.compute();
			
			list = sqlSession.selectList("board.search", page);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	// board, boardAtt 저장
	// 오류 : 첨부 파일 삭제
	public String insert(BoardVo vo) {
		String msg = "OK";
		int r = 0;
		int chkCnt = 0;
		try {
			int serial = sqlSession.selectOne("board.brd_getSerial");
			vo.setSerial(serial);
			r = sqlSession.insert("board.brd_insert", vo);
			if(r>0) {
				chkCnt = 0; //첨부파일의 수만큼 실행된 쿼리의 수
				for(BoardAttVo v : vo.getAttList()) {
					v.setpSerial(serial);
					chkCnt += sqlSession.insert("board.brdAtt_insert", v);
				}
				if(chkCnt == vo.getAttList().size()) {
					sqlSession.commit();
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			msg = ex.toString();
			System.out.println("r=" + r);
			System.out.println("chkCnt=" + chkCnt);
			ex.printStackTrace();
			sqlSession.rollback();
			
			for(BoardAttVo delVo : vo.getAttList()) {
				File f = new File(BoardFileUploadController.saveDir + delVo.getSysAtt());
				if(f.exists()) f.delete();
			}
		}

		return msg;
	}
	
	// board, boardAtt 저장
	// 정상 : boardAtt에서 삭제 파일 정보 삭제, 삭제파일 삭제
	// 오류 : 첨부파일 삭제
	public String update(BoardVo vo) {
		
		String msg = "OK";
		int r=0;
		int chkCnt = 0;
		try {
			r = sqlSession.update("board.brd_update", vo);

			if(r<1) throw new Exception();
			chkCnt = 0;
			for(BoardAttVo v : vo.getAttList()) {
				v.setpSerial(vo.getSerial());
				chkCnt += sqlSession.insert("board.brdAtt_insert", v);
			}
			if(chkCnt == vo.getAttList().size()) {
				for(BoardAttVo delVo : vo.getDelList()) {
					
					sqlSession.delete("board.brdAtt_delete2", delVo.getSysAtt() );
					File f = new File(BoardFileUploadController.saveDir +  delVo.getSysAtt());
					if(f.exists()) f.delete();
				}
				sqlSession.commit();
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			System.out.println("r=" + r);
			System.out.println("chkCnt=" + chkCnt);
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
			for(BoardAttVo delVo : vo.getAttList()) {
				File f = new File(BoardFileUploadController.saveDir + delVo.getSysAtt());
				if(f.exists()) f.delete();
			}

		}

		return msg;
		
		
	}
	
	public String repl(BoardVo vo) {
		String msg = "OK";
		int r = 0;
		int chkCnt = 0;
		try {
			int serial = sqlSession.selectOne("board.brd_getSerial");
			vo.setpSerial(vo.getSerial());
			vo.setSerial(serial);
			r = sqlSession.insert("board.brd_repl", vo);
			if(r>0) {
				chkCnt = 0; //첨부파일의 수만큼 실행된 쿼리의 수
				for(BoardAttVo v : vo.getAttList()) {
					v.setpSerial(serial);
					chkCnt += sqlSession.insert("board.brdAtt_insert", v);
				}
				if(chkCnt == vo.getAttList().size()) {
					sqlSession.commit();
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			msg = ex.toString();
			System.out.println("r=" + r);
			System.out.println("chkCnt=" + chkCnt);
			ex.printStackTrace();
			sqlSession.rollback();
			
			for(BoardAttVo delVo : vo.getAttList()) {
				File f = new File(BoardFileUploadController.saveDir + delVo.getSysAtt());
				if(f.exists()) f.delete();
			}
		}

		return msg;
	}
	
	public BoardVo view(int serial) {
		BoardVo vo = new BoardVo();
		
		try {
			sqlSession.update("board.brd_hitUp", serial);
			sqlSession.commit();
			
			vo = sqlSession.selectOne("board.brd_view", serial);
			List<BoardAttVo> attList = sqlSession.selectList("board.brdAtt_view", serial);
			
			vo.setAttList(attList);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		

		return vo;
	}
	
	// 첨부파일 가져오기
	// board 삭제 -> boardAtt 삭제 -> 파일 삭제
	public String delete(BoardVo vo) {
		String msg = "OK";
		List<BoardAttVo> delList = null;
		try {
			delList = sqlSession.selectList("board.brd_att_list", vo.getSerial());
			
			int r = sqlSession.delete("board.brd_delete", vo);
			if(r>0) {
				r = sqlSession.delete("board.brdAtt_delete", vo.getSerial());
				if(vo.getAttList().size() ==0 || r == vo.getAttList().size()) {
					sqlSession.commit();
					for(BoardAttVo v : delList) {
						File f = new File(BoardFileUploadController.saveDir + v.getSysAtt());
						if(f.exists()) f.delete();
					}
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();				
			}
		}catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
			msg = ex.toString();
		}
		return msg;
	}
	
	
	public static void main(String[] args) {
		new BoardDao();
	}
}


















