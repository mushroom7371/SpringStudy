package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/fup.brd", method=RequestMethod.POST)
	public void  upload(HttpServletRequest req){
		attList = fileUpload.upload(req);
		System.out.println(attList.size());
	}
	
	@RequestMapping(value="/registerR.brd", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView register(BoardVo vo, Page page) {
		ModelAndView mv = new ModelAndView();
		
		dao.insert(vo);
		
		mv.addObject("page", page);
		mv.setViewName("search");
		return mv;
	}
	
	@RequestMapping(value="/board/view.brd", method= {RequestMethod.POST})
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
	
	@RequestMapping(value="/delete.brd", method= {RequestMethod.POST})
	public ModelAndView delete(BoardVo v, Page p) {
		ModelAndView mv = new ModelAndView();
		
		dao.delete(v);
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("list", list);
		mv.addObject("page", p);
		mv.setViewName("search");
		return mv;
	}
	
}
















