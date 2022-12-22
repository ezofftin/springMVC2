package ez.web.day05;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, boolean rememberId, HttpServletResponse response) throws Exception {
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		System.out.println("rememberId : "+rememberId);
		
		// id와 pw를 확인(DB에 있는지) 
		if(!memberChk(id, pw)) {
			// DB와 일치하지 않으면 출력할 메세지
			String msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다!!", "utf-8");
			
			return "redirect:/login/login?msg="+msg; 
		}
		
		
		// id와 pw가 일치하면
		if(rememberId) { // 아이디 기억하기가 체크되어 있는 경우 쿠키 생성
			// 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			// 쿠키 응답하기 : 응답헤더에 설정해서 쿠키를 브라우저에게 전달
			response.addCookie(cookie);
		}else { // 아이디 기억하기가 체크가 안되어 있을 경우
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // 쿠키의 유효기간을 0으로 설정해서 
			
			// 브라우저에게 전송하기, 브라우저에서 쿠키를 받으면 쿠키는 바로 삭제됨
			response.addCookie(cookie);
		}
		
		return "redirect:/"; // 로그인 성공시 홈으로 이동
	}

	private boolean memberChk(String id, String pw) {		
		// DB아이디: test, DB비번: 1234 가정
		return "test".equals(id) && "1234".equals(pw);
	}	
}
