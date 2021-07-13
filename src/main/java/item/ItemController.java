package item;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
	SqlSession sql = mybatis.MybaFactory.getFactory().openSession();
	
	@RequestMapping(value="/search.item", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView search(ItemVo vo) {
		ModelAndView mv = new ModelAndView();
		
		List<ItemVo> list = null;
		
		list = sql.selectList("item.search", vo);
		
		mv.addObject("list", list);
		mv.setViewName("item");
		
		return mv;
	}
	
	@RequestMapping(value="/update.item", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView update(ItemVo vo) {
		ModelAndView mv = new ModelAndView();
		
		sql.update("item.update", vo);
		sql.commit();
		
		mv.setViewName("item");
		
		return mv;
	}
	
	@RequestMapping(value="/delete.item", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView delete(ItemVo vo) {
		ModelAndView mv = new ModelAndView();
		
		sql.delete("item.delete", vo);
		sql.commit();
		
		mv.setViewName("item");
		
		return mv;
	}
}
