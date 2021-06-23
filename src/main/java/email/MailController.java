package email;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailController {

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
		@RequestMapping(value = "mailSender.email", method = {RequestMethod.POST})
		public String mailSender(HttpServletRequest request) {
			
			String authKey = getKey(6);

			String setfrom = "wnsghk6670@gmail.com";
			String tomail = request.getParameter("tomail"); // 받는 사람 이메일
			String title = request.getParameter("title"); // 제목
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
				System.out.println(e);
			}

			return "email";
		}
	}
