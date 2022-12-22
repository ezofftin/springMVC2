<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나의 성적</h1>
<p>국어 : ${myScore.kor}</p>
<p>영어 : ${myScore.eng}</p>
<p>수학 : ${myScore.mat}</p>

<%-- <p>총점 : ${total}</p> --%>
<p>총점 : ${myScore.total}</p>
<p>평균 : ${strAvg}</p>
</body>
</html>
