package member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	SqlSession sql = mybatis.MybaFactory.getFactory().openSession();
	
	@RequestMapping(value="/search.test", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView search(MemberVo vo) {
		ModelAndView mv = new ModelAndView();

		List<MemberVo> list = null;
		
		try {
			list = sql.selectList("member.search", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		mv.addObject("list", list);
		mv.setViewName("member");
		
		return mv;	
	}
}
