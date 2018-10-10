<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<!-- 스크립트릿 <% %> : 자바 코드를 작성-->
	<%-- 표현식 (Line 16)<%= %> : 출력을 표현 --%> 
	<%
		String msg = "first jsp";
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String formatDate = format.format(date);
	%>
<body>

	session 이름[별명] : <%=session.getAttribute("name") + "[" + session.getAttribute("alias") + "]님 안녕하세요" %>
	<br />
	Hello World
	<br />
	<%=msg %>
	<br />
	<%-- yyyy-MM-dd --%>
	<%=formatDate %>
</body>
</html>