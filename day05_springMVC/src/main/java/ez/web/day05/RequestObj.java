package ez.web.day05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestObj {
	
	@RequestMapping("/request")
	public static void main(HttpServletRequest request) { // HttpServletRequest : 클라이언트의 요청정보를 갖고 있는 객체
		System.out.println("request.getScheme() : " +request.getScheme()); // 프로토콜
		
		System.out.println("request.getServerName() : " +request.getServerName()); // 서버이름 
		System.out.println("request.getServerPort() : " +request.getServerPort()); // 서버포트
		System.out.println("request.getRequestURL() : " +request.getRequestURL()); // 요청URL
		System.out.println("request.getRequestURI() : " +request.getRequestURI()); // 요청URI
		
		System.out.println("----------------");
		System.out.println("request.getContextPath() : " +request.getContextPath()); // context Path
		System.out.println("request.getQueryString() : " +request.getQueryString()); // 쿼리 스트링
		
		System.out.println("----------------");
		System.out.println("request.getRemoteAddr() : " +request.getRemoteAddr()); // 원격 ip주소
		System.out.println("request.getRemoteHost() : " +request.getRemoteHost()); // 원격 호스트 또는 ip주소
		
		
		
		
		
		
		
	}
}
