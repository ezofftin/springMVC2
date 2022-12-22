package ez.web.day05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScoreMVC3 {
	
	// 예외처리
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		//e.printStackTrace();
		return "scoreErr"; // scoreErr.jsp
	}
	
	// @RequestParam :기본형 매개변수, String 매개변수 앞에
	// @ModelAttribute : 참조형 매개변수 앞에 붙이거나 반환타입 앞에 붙여서 사용
	// 자동으로 Model에 저장을 해줌
	
	// ("myScore") 키값을 생략하면 자동으로 참조형 매개변수 타입의 첫글자를 
	// 소문자로 변경하여 키값으로 활용한다.
	
	@RequestMapping("/scoreMVC3") // 메소드에 매핑
//	public String aaa(@ModelAttribute("myScore") MyScore myScore, Model model){	// 아래 두라인과 동일
//	public String aaa(@ModelAttribute MyScore myScore, Model model){ // @ModelAttribute 참조형 매개변수 앞에서생략가능	
	public String aaa(MyScore myScore, Model model){	
		
		// 작업 처리		
//		String strAvg = getAvg(myScore);
//		model.addAttribute("myScore", myScore);	
//		model.addAttribute("strAvg", strAvg);	
		
		 return "scoreMVC";
	}

	// 반환되는 값을 "strAvg"키값으로 model에 저장을 의미
	private @ModelAttribute("strAvg") String getAvg(MyScore myScore) {
		double avg = myScore.getTotal() / 3.0;
		String strAvg = String.format("%.2f", avg);
		return strAvg;
	}
}
