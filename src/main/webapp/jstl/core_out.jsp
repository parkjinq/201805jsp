<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_out.jsp</title>
</head>
<body>
	<%	request.setAttribute("userID", "cony");
		request.setAttribute("password", "conypass");
	%>
	userID : <c:out value="${userID}"/>
	<br />
	password : <c:out value="${password}"/>
	<br />
	name : <c:out value="${user}" default="brownDefault"/>
</body>
</html>