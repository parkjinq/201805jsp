<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scope.jsp</title>
</head>
<body>
	<%-- el scope 확인 예제 --%>
	<%--
	page(pageContext) : jsp페이지 에서만 유효한 속성
	request : 요청이 끝날때 까지 유효한 속성
	session : session이 만료되기 전까지 유효한 속성
	(세션 만료 : 서버종료, tomcat설정에 따라, session.invalidate(), 사용자가 server timeout을 요청하지 않을때)
	application : was에 하나 존재(서버 종료전까진 유효한 속성)
 --%>
	<%
		pageContext.setAttribute("attribute", "pageContextAttribute");
		request.setAttribute("attribute", "requestAttribute");
		session.setAttribute("attribute", "sessionAttribute");
		application.setAttribute("attribute", "applicationAttribute");
	%>

	pageContext :
	<%=pageContext.getAttribute("attribute")%>
	<br /> request :
	<%=request.getAttribute("attribute")%>
	<br /> session :
	<%=session.getAttribute("attribute")%>
	<br /> application :
	<%=application.getAttribute("attribute")%>
	<br />

	<hr>
	<h3>el</h3>
	<h5>속성명은 되도록이면 다르게 하는것이 좋다. 속성명이 같으면 scope가 좁은 것이 나온다</h5>
	el attribute : ${applicationScope.attribute}
	<br />
	el attribute : ${attribute}
	<br />

</body>
</html>