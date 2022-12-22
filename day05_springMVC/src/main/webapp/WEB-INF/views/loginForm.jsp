<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
<style>
	.msg{
		text-align:center;
		font-size:14px;
		color:red;
	}
</style>

</head>
<body>
<!-- 
	쿠키 : 이름, 값의 쌍으로 이루어진 정보, 아스키문자로 이루어짐
		  서버에서 생성 후 응답시 전송, 브라우저에 저장되어 관리, 유효기간이 지나면 삭제
		  브라우저에 의해서 저장된 쿠키는 서버에 요청시마다 쿠키를 실어서 전송한다.
		 
		  서버는 쿠기를 이용해서 클라이언트를 구분한다.
	
	// 서버
	쿠키 생성 : Cookie cookie = new Cookie("id", "test"); new Cookie(이름, 값)
	유효기간 설정 : cookie.setMaxAge(60*60*24) => 하루
	쿠키 응답 : response.addCookie(cookie); // client에 전송
	
	전송 방법 : 응답메시지에 Set-Cookie: id=test; 유효기간; 형태로 전달(응답헤더에 포함)
	
	쿠키값 얻어오기 : Cookie[] cookies = request.getCookies();
				for(Cookie cookie: cookies){
					String cName = cookie.getName(); // 쿠키이름
					String cVal = cookie.getValue(); // 쿠키값
				}
				
	쿠키 삭제 : 
			cookie.setMaxAge(0);				
				
	// 클라이언트는 요청시마다 쿠키전송
	전송 방법 : 요청메시지에 Cookie:id=test(요청헤더 포함)     
	
	 	 
		
 -->


<div class="container w-50 mt-5 p-5 shadow">
	<form action="<c:url value="/login/login"/>" method="post" onsubmit="return inputChk(this)"> 
		<h4>로그인</h4>				
			
		<div id="msg" class="msg my-4">${URLDecoder.decode(param.msg, "utf-8")}</div>
					
		<input class="form-control mb-2" type="text" id="id" name="id" value="${cookie.id.value}" placeholder="아이디" autofocus>		
		<input class="form-control mb-2" type="text" name="pw" placeholder="비밀번호">
		<!-- checkbox의 기본 value값은 on -->
		<label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}/>아이디 기억하기</label>
		
		<div class="text-center mt-3">
			<button class="btn btn-primary">로그인</button>	
			<!-- <input class="btn btn-primary" value="가입"> -->
		</div>
	</form>
</div>
<script>
	function inputChk(obj){
		var msg ="";
		
		if(obj.id.value.length<3){
			setMsg("id를 입력하세요!!", obj.id);
			return false;
		}
		
		if(obj.pw.value.length<3){
			setMsg("비밀번호를 입력하세요!!", obj.pw);
			return false;
		}
		
		return true;
	}

	
	// 메세지, 태그를 받아서 처리하는 함수
	function setMsg(msg, element){ 
		document.getElementById("msg").innerHTML = `<i class="fa fa-info-circle">${'${msg}'}</i>`;
		
		if(element){
			element.select(); // 잘못된 입력값을 바로 선택해서 수정가능하도록 하는 메소드
		}
	}
</script>
</body>
</html>