package ez.web.day05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScoreMVC {
	
	//********* 수집과 작업처리, 출력을 분리해서 MVC패턴으로 처리(관심사의 분리:Separation Of Concern) *************
	// SOLID의 첫번째 원칙(단일 책임의 원칙)
	
	@RequestMapping("/scoreMVC") // 메소드에 매핑	
//	public static void aaa(HttpServletRequest request, HttpServletResponse response) 
//			throws IOException{
	
	// DispatcherServlet에서 Model을 생성해서 전달 받음
	public String aaa(int kor, int eng, int mat, Model model){
	
	// Controller에서 ModelAndView를 생성해서 처리
	// ModelAndView리턴
//	public ModelAndView aaa(int kor, int eng, int mat){
		// 파라미터 수집
//		String kor = request.getParameter("kor");
//		String eng = request.getParameter("eng");
//		String mat = request.getParameter("mat");
		
//		int kScore = Integer.parseInt(kor);
//		int eScore = Integer.parseInt(eng);
//		int mScore = Integer.parseInt(mat);
		
		// Model + View
//		ModelAndView mv = new ModelAndView();
		
		// 작업 처리
//		int total = kScore + eScore + mScore;
		int total = kor + eng + mat;
		double avg = total / 3.0;
		
		String strAvg = String.format("%.2f", avg);
		model.addAttribute("total", total);
		model.addAttribute("strAvg", strAvg);
		
//		mv.addObject("total", total);
//		mv.addObject("strAvg", strAvg);
//		
//		mv.setViewName("scoreMVC");
//		
//		return mv;
		
		// 출력
//		response.setContentType("text/html; charset=utf-8");
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("총점 : " + total + "점");
//		out.println("평균 : " + strAvg + "점");
//		out.println("</body>");
//		out.println("<html>");
		
		 return "scoreMVC";
	}
}
