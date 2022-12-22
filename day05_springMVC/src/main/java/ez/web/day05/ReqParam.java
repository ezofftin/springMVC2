package ez.web.day05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @RequestParam    생략가능 : 기본형 매개변수, String 매개변수 앞에서 생략
// @ModelAttribute  생략가능 : 참조형 매개변수 앞에서 생략

@Controller
public class ReqParam {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
//		e.printStackTrace();
		return "scoreErr";
	}
	
	@RequestMapping("/requestParam")
	public String main(HttpServletRequest request) {
		String kor = request.getParameter("kor");
		
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam2")
	public String main2(@RequestParam(name="kor", required=false) String kor) {
//	public String main2(String kor) {
		//http://localhost:8088/day04/requestParam2?kor >>>> kor="" // no Error required=false이기 때문
		//http://localhost:8088/day04/requestParam2?kor= >>>>kor="" // no Error
		//http://localhost:8088/day04/requestParam2    >>>>kor=null // no Error
		
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam3")
//	public String main3(@RequestParam(name="kor", required=true) String kor) {
	public String main3(@RequestParam String kor) {
//		http://localhost:8088/day04/requestParam3 >>>> kor=null 400오류 required=true이기 때문
//		http://localhost:8088/day04/requestParam3?kor >>>> kor="" 
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	
	@RequestMapping("/requestParam4")
	public String main4(@RequestParam(required=false) String kor) {
		//http://localhost:8088/day04/requestParam2?kor >>>> kor="" // no Error required=false이기 때문
		//http://localhost:8088/day04/requestParam2?kor= >>>>kor="" // no Error
		//http://localhost:8088/day04/requestParam2    >>>>kor=null // no Error
		
		System.out.println("국어점수 : " + kor);
		return "score";
		
	}
	@RequestMapping("/requestParam5")
	public String main5(@RequestParam(required=false, defaultValue="60") String kor) {
//		http://localhost:8088/day04/requestParam5 >>>> kor=60 , defaultValue가 할당된다.
//		http://localhost:8088/day04/requestParam5?kor >>>> kor="" , defaultValue가 할당된다.
		System.out.println("국어점수 : " + kor);
		return "score";
		
	}

////////////////////////////////////////////////////////////////////	
	
	// 파라미터값이 텍스트로 넘어오기 때문에 스프링이 내부적으로 int으로 형변환을 해준다.
	@RequestMapping("/requestParam6")
	public String main6(int kor) { // required=false 생략된 형태
		// http://localhost:8088/day04/requestParam6 >>>> kor=null 500 에러: 서버 내부에러
		// http://localhost:8088/day04/requestParam6?kor >>> kor="" 400 에러: 클라이언트 잘못된 요청
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	
	// 필수 입력일 때는 예외처리를 해주자.
	@RequestMapping("/requestParam7") 
	public String main7(@RequestParam int kor) { //required = true 생략된 형태
		//http://localhost:8088/day04/requestParam7 >>> 400 에러
		//http://localhost:8088/day04/requestParam7?kor >>> 400 에러
		
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	// 필수 입력이 아닐 경우에는 defaultValue를 넣어주자!!
	@RequestMapping("/requestParam8")
	public String main8(@RequestParam(required=false, defaultValue="100") int kor) {
		// defaultValue가 없으면 null로 처리되기 때문에 int형으로 변환이 안되는 서버에러 클라이언트 에러가 아님
//		http://localhost:8088/day04/requestParam8 >>> 에러를 피할 수 있다.
		
		// 클라이언트가 빈값을 넣엏기 때문에 에러가 발생, 잘못요청을 하더라도 예외 처리가 되야 함.
//		http://localhost:8088/day04/requestParam8?kor >>> ""은 int형 변환 안됨. 400 클라이언트의 잘못된 요청
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam9")
	public String main9(@RequestParam(required=true, defaultValue="55") int kor) {
//		http://localhost:8088/day04/requestParam9 >>> kor = 55
//		http://localhost:8088/day04/requestParam9?kor >>>  kor = 55
		System.out.println("국어점수 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam10")
	public String main10(@RequestParam(name="kor", required=true, defaultValue="55") int eng) {
//	public String main10(@RequestParam(required=true, defaultValue="55") int eng) {
//		http://localhost:8088/day04/requestParam9?kor=100 >>> eng가 null이기때문에 eng = 55
//		http://localhost:8088/day04/requestParam9?kor=100 >>> name="kor"인경우에는 eng변수로 대체한다.
		System.out.println("국어점수 : " + eng); // 국어점수 : 55
		return "score";
	}
	

	
}
