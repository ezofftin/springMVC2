package ez.web.day05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class Hello {
	int i = 100;// 인스턴스 변수
	static int si = 200; // 스태틱변수
	
	// static이 없는 public void helloPrint()는 인스턴스메소드
	// 인스턴스 메소드는 객체 생성후에 호출가능한데 어떻게 호출이 가능한가?
	// 스프링이 component scan을 하면서 내부적으로 Hello 만들기 때문에
	// 호출이 가능
	
	// 스태틱, 인스턴스 변수 모두 사용가능
//	@RequestMapping("/hello") // URL과 메서드 매핑
//	public void helloPrint() { // 인스턴스 메소드
//		System.out.println("Hello Spring!!");
//		System.out.println(i);
//		System.out.println(si);
//	}
	
	// private은 외부에서 호출 불가, 하지만 스프링에서 호출이 가능하다.
	// 호출이 가능한 것은 스프링 내부에서 Reflection API를 사용하기 때문에 가능
	@RequestMapping("/hello") // URL과 메서드 매핑
	private void helloPrint() { // 인스턴스 메소드
		System.out.println("Hello Spring!!");
		System.out.println(i);
		System.out.println(si);
	}
	
	
	// 스태틱은 스태틱변수만 사용가능
	@RequestMapping("/main") // URL과 메서드 매핑
	public static void main() { // static 메소드
		System.out.println("Main Hello Spring!!");
		System.out.println(si);
//		System.out.println(i); //에러
	}
	
	
}
