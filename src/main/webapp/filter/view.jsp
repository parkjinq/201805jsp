<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view.jsp</title>
</head>
<body>
	
	userNm : ${userNm}
	<br />
	view.jsp
	<%-- post --%>
	<form action="/filterServlet" method="post">
		<input type="text" name="userNm" value="브라운"><br />
		<button type="submit">전송</button>
	</form>
	
</body>
</html>