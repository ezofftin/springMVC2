package ez.web.day05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Resource {
	
	@RequestMapping("/srp")
	public void main(HttpServletRequest request, HttpServletResponse response) 
			throws IOException{
		String myNum = request.getParameter("myNum");
		int com = (int)(Math.random()*3)+1;
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("My : <img src='img/"+myNum+".png' width='200px'/>");
		out.println("|||| VS ||||");
		out.println("<img src='img/"+com+".png' width='200px'/> : Computer");
		out.println("</body>");
		out.println("<html>");
	}
}
