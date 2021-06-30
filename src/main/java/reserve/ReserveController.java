package reserve;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

@RestController
public class ReserveController {
	@Autowired
	ReserveDao dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	int size;
	
	
    //인증키 생성
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }

	// mailSending 코드
	@RequestMapping(value = "mailSender.reserve", method = {RequestMethod.POST})
	public String mailSender( HttpServletRequest req, HttpServletResponse resp) {
	    JsonObject json = new JsonObject();
		String chkNum = getKey(6);
		String authKey = "인증 번호는 " + chkNum + " 입니다.";

		String setfrom = "wnsghk6670@gmail.com";
		String tomail = req.getParameter("tomail"); // 받는 사람 이메일
		String title = "백신예약 인증번호 안내입니다."; // 제목
		//String content = request.getParameter("content"); // 내용
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(authKey); // 메일 내용

			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		 json.addProperty("chkNum", chkNum);
		 json.addProperty("tomail", tomail);
		 System.out.println(json.get("chkNum"));
		 System.out.println(json.get("tomail"));
		 String result = json.toString();
		 System.out.println(result);
		 
		 return result;
		
	}
	
	@RequestMapping(value="/doReserve.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doReserve() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("doReserve");

		return mv;
	}
	
	@RequestMapping(value="/my.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView me() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myReserve");

		return mv;
	}
	
	@RequestMapping(value="/other.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView other() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("otherReserve");

		return mv;
	}
	
	@RequestMapping(value="sc.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView sc() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reserveSearchAndCancle");

		return mv;
	}
	
	@RequestMapping(value="/insert.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView register(MyReserveVo vo, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
//		JsonObject json = new JsonObject();
//		
//		String myPhone = req.getParameter("myPhone");
		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("Controller.register....");
			
			dao.insert(vo);
			
			mv.setViewName("reserveSearchAndCancle");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
//		json.addProperty("myPhone", myPhone);
		return mv;
	}
	
	@RequestMapping(value="/otherInsert.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView registerO(OtherReserveVo vo, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		System.out.println("tettxtsate : " + vo.getMyPhone());
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("Controller.registerR....");
			
			dao.insertO(vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		mv.setViewName("reserveSearchAndCancle");
		return mv;
	}
	
	@RequestMapping(value="/search.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView search(MyReserveVo vo, OtherReserveVo v) {
		ModelAndView mv = new ModelAndView();

		System.out.println("Controller.search............");
		
		MyReserveVo vo2 = dao.select(vo);
		OtherReserveVo v2 = dao.otherSelect(v);

		if(v2.getOtherName().equals("")) {
			v2.setOtherName(vo2.getMyName());
			v2.setOtherJumin(vo2.getMyJumin());
		}
		
		String phone = vo2.getMyPhone();
		
		mv.addObject("list", vo2);
		mv.addObject("list2", v2);
		mv.addObject("phone",phone);
		mv.setViewName("reserveSearch");
		
		return mv;
	}
	
	@RequestMapping(value="canclePage.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView canclePage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reserveCancle");

		return mv;
	}
	
	@RequestMapping(value="/cancle.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView cancle(MyReserveVo v) {
		ModelAndView mv = new ModelAndView();
		
		MyReserveVo vo = dao.select(v);		
		dao.delete(vo);
		
		mv.setViewName("reserveSearchAndCancle");
		
		return mv;
	}
}
















