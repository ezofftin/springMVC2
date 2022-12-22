package ez.web.day05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 요청에 응답하는 컨트롤러로 등록(서버에서 동작하는 객체로 등록) 
public class ScoreMain {
	
	@RequestMapping("/score") // 메소드에 매핑
//	public static void main(String[] args) {
	public static void aaa(HttpServletRequest request, HttpServletResponse response) 
			throws IOException{
//		String kor = args[0];
//		String eng = args[1];
//		String mat = args[2];
		
		// 파라미터 수집
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("mat");
		
		int kScore = Integer.parseInt(kor);
		int eScore = Integer.parseInt(eng);
		int mScore = Integer.parseInt(mat);
		
		// 작업 처리
		int total = kScore + eScore + mScore;
		double avg = total / 3.0;
		
		String strAvg = String.format("%.2f", avg);
		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		System.out.println("총점 : " + total);
//		System.out.println("평균 : " + strAvg);		
		
		// 출력
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("총점 : " + total + "점");
		out.println("평균 : " + strAvg + "점");
		out.println("</body>");
		out.println("<html>");
	}
}
