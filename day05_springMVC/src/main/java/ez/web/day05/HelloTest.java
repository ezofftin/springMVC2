package ez.web.day05;

import java.lang.reflect.Method;

public class HelloTest {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.helloPrint();
		
		// java.lang.reflect 패키지에 Reflection API가 제공
		// Reflection API는 클래스의 필드, 메소드, 생성자, 접근제어자등의 정보를
		// 얻어올 수 있는 강력한 기능을 제공
		
		// Class 클래스의 forName("클래스명")을 이용하여 해당 클래스의 정보를 갖는
		// Class 객체를 얻어올 수 있다.
		Class clazz= Class.forName("ez.web.myapp.Hello");
		
		// clazz가 갖고 있는 Hello클래스의 정보를 이용해서 Hello객체를 생성
		Hello hello = (Hello)clazz.newInstance();
		
		// helloPrint메소드를 얻어옴 
		Method helloPrint = clazz.getDeclaredMethod("helloPrint");
		
		// helloPrint 메소드의 접근이 가능하도록 설정(private도 접근이 가능하게됨)
		helloPrint.setAccessible(true);
		
		// hello객체의 helloPrint메소드를 호출 invoke(객체)
		helloPrint.invoke(hello);
	}
}
