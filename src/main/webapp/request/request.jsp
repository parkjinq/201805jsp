<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request.jsp</title>
</head>
<body>
	<form action="/requestServlet" method="post">
		사용자 아이디 : <input type="text" name="userId"> 
		<br />
		사용자 이름 : <input type="text" name="name">
		<input type="submit" value="전송">
	</form>

</body>
</html>