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
		 System.out.println(chkNum);
		 json.addProperty("chkNum", chkNum);
		 System.out.println(json.get("chkNum"));
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
	
	@RequestMapping(value="/me.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView me() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("me");

		return mv;
	}
	
	@RequestMapping(value="/other.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView other() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("other");

		return mv;
	}
	
	@RequestMapping(value="/sc.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView sc() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("sc");
		
		return mv;
	}
	
	@RequestMapping(value="/search.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("search");
		
		return mv;
	}
	
	@RequestMapping(value="/cancle.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView cancle() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("cancle");
		
		return mv;
	}
}
















