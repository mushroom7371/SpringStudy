package board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class BoardFileUploadController {
	
	final static String saveDir = "C:\\eclipse\\workspace\\SpringStudy\\src\\main\\webapp\\upload\\";
	
	public List<BoardAttVo> upload(HttpServletRequest req) {
		
		List<BoardAttVo> attList = null;
		
		try {
			req.setCharacterEncoding("utf-8");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
			
			String contentType = req.getContentType();
	
			if(contentType.toLowerCase().startsWith("multipart/")) {
				
				attList = new ArrayList<BoardAttVo>();
			
				Collection<Part> parts = req.getParts();
				for(Part p : parts) {
					if( p.getHeader("Content-Disposition").contains("filename=")) { // file tag
						String fileName = p.getSubmittedFileName();
						BoardAttVo attVo = new BoardAttVo();
						
						String date = sdf.format(new Date());
						
						if(p.getSize()>0) {
							p.write(saveDir + date + "-" + fileName);
							p.delete();
	
							attVo.setSysAtt(date + "-" + fileName);
							attVo.setOriAtt(fileName);
							attList.add(attVo);
						}
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return attList;
	}
	
	
}
	






