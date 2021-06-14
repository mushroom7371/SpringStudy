package mvc;

import java.util.List;

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
	
	@RequestMapping(value="/board/input.board", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView input(BoardVo vo) { //hello 매개변수로 HttpServletRequest, HttpServletResponse 를 쓸 수 있다. 필요에 따라 쓴다.
		ModelAndView mv = new ModelAndView();
		
		System.out.println("BoardController............");
		System.out.println("mid : " + vo.getMid());
		System.out.println("phone : " + vo.getPhone());

		String msg = dao.input(vo);
		
		
		//Model : model.addAttribute("msg", "Hi...spring !!")
		mv.addObject("msg", msg);
		mv.addObject("vo", vo);
		mv.setViewName("input_result");
		return mv;
	}
	
	@RequestMapping(value="/board/search.board", method= {RequestMethod.GET, RequestMethod.POST}) //get 또는 post 쓸 때
	public ModelAndView search(String findStr) { //hello 매개변수로 HttpServletRequest, HttpServletResponse 를 쓸 수 있다. 필요에 따라 쓴다.
		ModelAndView mv = new ModelAndView();
		
		System.out.println("BoardController.search............");

		List<BoardVo> list = dao.search(findStr);
		
		//Model : model.addAttribute("msg", "Hi...spring !!")
		mv.addObject("list", list);
		mv.setViewName("search");
		return mv;
	}
	
	@RequestMapping(value="/update.board", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView update() {
		ModelAndView mv = new ModelAndView();
		
		//Model : model.addAttribute("msg", "Hi...spring !!")
		mv.addObject("msg", "Hi...spring !!!!");
		mv.setViewName("hello");
			return mv;
	}
	
}
