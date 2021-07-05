
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurePW {

	public String encode(String password) {
	BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
	String securePw = ec.encode(password);
	System.out.println("password 암호화 :"+securePw);
	return securePw;
	}
	
	
	public Boolean matche(String a, String b) {
		BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
		Boolean result = ec.matches(a, b);
		if(result == true) {
			System.out.println("일치함");
		}else {
			System.out.println("불일치");
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SecurePW pw = new SecurePW();
		
		String a = "911119-1111111";
		
		
		pw.encode(a);
		pw.matche(a, "$2a$10$OGsA.aZI4RHDnmp475Zkl.uBU6Y8PLw2ylS3Ob7XOba/UaCa.24W.");
	}
		
}
