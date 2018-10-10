<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scopeResult.jsp</title>
</head>
<body>
<!-- 		//request 영역 -->
		requestScope : <%=request.getAttribute("requestScope") %><br />
		
<!-- 		//session 영역 -->
<%-- 		<% HttpSession session = request.getSession(); %> --%>
		sessionScope : <%=session.getAttribute("sessionScope") %><br />
		
<!-- 		//application 영역 -->
<%-- 		<% ServletContext application = getServletContext(); %> --%>
		applicationScope : <%=application.getAttribute("applicationScope") %><br />
</body>
</html>