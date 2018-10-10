<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestResult.jsp</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	requestResult.jsp
	<h2>parameter</h2>
	userId : <%=request.getParameter("userId") %>
	<br />
	name : <%=request.getParameter("name") %>
	
<%-- 	<% UserVO userVO = (UserVO)request.getAttribute("userVO");%> --%>
	<%
		UserVO userVO = (UserVO)session.getAttribute("userVO");
	%>
	<h2>attribute</h2>
	userId : <%=userVO.getUserId() %>
	<br /> 
	name : <%=userVO.getName() %>
	<br /> 
	birth : <%=userVO.getBirth() %>
	
</body>
</html>