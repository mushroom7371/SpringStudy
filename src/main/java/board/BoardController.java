package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	//기존 servlet 사용과의 차이점을 확인하기
	@Autowired
	BoardDao dao;
	
	@Autowired
	BoardFileUploadController fileUpload;
	
	List<BoardAttVo> attList;
	
	@RequestMapping(value="/search.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView search(Page page) { //hello 매개변수로 HttpServletRequest, HttpServletResponse 를 쓸 수 있다. 필요에 따라 쓴다.
		ModelAndView mv = new ModelAndView();
		
		System.out.println("BoardController.search............");

		List<BoardVo> list = dao.select(page);
		
		//Model : model.addAttribute("msg", "Hi...spring !!")
		mv.addObject("list", list);
		mv.addObject("page", page);
		mv.setViewName("search");
		return mv;
	}
	
	@RequestMapping(value="/register.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView register(Page page) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("page", page);
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="/fup.brd", method= RequestMethod.POST)
	public void  upload(HttpServletRequest req, HttpServletResponse resp){
		attList = fileUpload.upload(req);
		System.out.println(attList.size());
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			pw.print("ok...");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/registerR.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView registerR(BoardVo vo, Page page, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
	
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("Controller.registerR");
			
			vo.setAttList(attList);
			dao.insert(vo);
			
			mv = search(page);

		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping(value="/view.brd", method= {RequestMethod.POST})
	public ModelAndView view(BoardVo v, Page p) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = dao.view(v.getSerial());
		
		mv.addObject("vo", vo);
		mv.addObject("page", p);
		mv.setViewName("view");	
		
		return mv;
	}
	
	@RequestMapping(value="/modify.brd", method= {RequestMethod.POST})
	public ModelAndView modify(BoardVo v, Page p) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = dao.view(v.getSerial());
		
		mv.addObject("vo", vo);
		mv.addObject("page", p);
		mv.setViewName("modify");
			return mv;
	}
	
	@RequestMapping(value="/modifyR.brd", method= {RequestMethod.POST})
	public ModelAndView modifyR(BoardVo v, Page p, @RequestParam(value="delFile", required=false) List<String> delFile) {
		ModelAndView mv = new ModelAndView();
		List<BoardAttVo> delList = new ArrayList<BoardAttVo>();
		
		if(delFile != null) {
			for(String ori : delFile) {
				BoardAttVo attVo = new BoardAttVo();
				attVo.setSysAtt(ori);
				delList.add(attVo);
				v.setDelList(delList);
			}
		}
		
		v.setAttList(attList);
		
		dao.update(v);
		
		mv = search(p);
		mv.setViewName("search");
		
			return mv;
	}
	
	@RequestMapping(value="/delete.brd", method= {RequestMethod.GET})
	public ModelAndView delete(BoardVo v, Page p) {
		ModelAndView mv = new ModelAndView();
		
		dao.delete(v);
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("list", list);
		mv.addObject("page", p);
		mv.setViewName("search");
		return mv;
	}
	
	@RequestMapping(value="/repl.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView repl(Page page) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("page", page);
		mv.setViewName("repl");
		return mv;
	}
	
	@RequestMapping(value="/replR.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView replR(BoardVo vo, Page page) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Controller.replR");
			
		vo.setAttList(attList);
		dao.repl(vo);
			
		mv = search(page);
		mv.setViewName("search");
		return mv;
	}
	
}
















