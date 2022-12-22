package ez.web.day05;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member") // URL패턴에서 공통되는 부분을 클래스에 적용가능
public class RegisterController {
	
	//@RequestMapping(value="/member/form", method= {RequestMethod.GET, RequestMethod.POST})// 아래와 동일
	//@RequestMapping("/member/form") //get, post 모두 지원됨
	
	
	// get방식만 허용
//	@GetMapping("/form") // 4.3부터 추가된 기능		
////	@RequestMapping(value="/member/form", method=RequestMethod.GET)
//	public String register() {
//		return "registerForm"; //WEB-INF/views/registerForm.jsp
//	}
	
//	@GetMapping("/save") // 4.3부터 추가된 기능		
	// post 방식만 허용
	@PostMapping("/save")
//	@RequestMapping(value="/member/save", method=RequestMethod.POST)
//	@RequestMapping("/save")
	public String save(Member member, Model model) throws Exception {
		
		// 유효성 검사 예
		if(!chkParam(member)) {
			// encoding 지원이 안되는 형식일 경우 예외 사항이 발생한다.
			String msg = URLEncoder.encode("잘못 입력하셨습니다!!! 다시 확인 요망!!", "utf-8");
			
			model.addAttribute("msg", msg); // redirect url에는 model 적용이 안되나
			return "redirect:/member/form"; // 스프링이 자동으로 적용해줌.
			
//			return "redirect:/member/form?msg="+msg; // 재요청
		}
		
		return "registerInfo";
	}

	private boolean chkParam(Member member) {
//		return false; 
		return true; // 유효성검사 성공적으로 이루어졌을 때를 의미 
	}
}
