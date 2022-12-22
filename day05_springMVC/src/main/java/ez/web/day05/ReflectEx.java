package ez.web.day05;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReflectEx {
	public static void main(String[] args) throws Exception{
		// ScoreMain 객체 생성
		Class clazz=Class.forName("ez.web.myapp.ScoreMain");
		Object obj = clazz.newInstance();
		
		// ScoreMain의 모든 메소드의 정보를 가져오기
		Method[] methodArr=clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String mName = m.getName(); // 메소드의 이름
			Parameter[] paramArr =m.getParameters(); // 메소드의 매개변수 목록
			Class returnType =m.getReturnType(); // 메소드의 반환타입
			
			
//			(HttpServletRequest request, HttpServletResponse response) 출력하기위해
			// StringJoiner 를 사용				//구분자, 접두어, 접미어
			StringJoiner paramList =new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName =param.getName(); // 파라미터 이름
				Class paramType =param.getType(); // 파라미터 타입
				
				paramList.add(paramType.getName() + " "+ paramName);
			}
			
			// 반환타입 메서드명(파라미터타입 파라미터명,...)형식으로 출력
			System.out.printf("%s %s%s", returnType.getName(), mName, paramList);
			// arg0, arg1으로 출력되는 이유는 컴파일된 클래스파일에서는 컴파일시점에 매개변수명을 저장하지 않으면
			// 매개변수명을 가져올 수 없다.
			// 컴파일 시점에 매개변수명을 저장하는 방법 : javac -parameters옵션을 줌 <-- Reflection API를 이용하면 가능
			// 이옵션은 java 8부터 지원
			
			//void aaa(javax.servlet.http.HttpServletRequest arg0, 
			//           javax.servlet.http.HttpServletResponse arg1)
			
			 
		}
		
		
		
	}
}
