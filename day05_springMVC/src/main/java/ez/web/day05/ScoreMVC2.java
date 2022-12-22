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
public class ScoreMVC2 {
	
	// 예외처리
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		//e.printStackTrace();
		return "scoreErr"; // scoreErr.jsp
	}
	
	
	@RequestMapping("/scoreMVC2") // 메소드에 매핑	
	// DispatcherServlet에서 Model을 생성해서 전달 받음
	
//	public String aaa(int kor, int eng, int mat, Model model){
	
	// 스프링이 여러 개의 파라미터를 참조형 매개변수 하나로 묶어줌
	// setter를 이용해서 값 셋팅
	public String aaa(MyScore myScore, Model model){	
		
		// 작업 처리
//		int total = kor + eng + mat;
		
		String strAvg = getAvg(myScore);
		
//		model.addAttribute("total", total);
		model.addAttribute("myScore", myScore);	
		model.addAttribute("strAvg", strAvg);	
		
		 return "scoreMVC";
	}

	private String getAvg(MyScore myScore) {
		double avg = myScore.getTotal() / 3.0;
		String strAvg = String.format("%.2f", avg);
		return strAvg;
	}
}
