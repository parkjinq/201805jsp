<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scope.jsp</title>
</head>
<body>

	scope.jsp	> 	ScopeServlet.java		> 	scopeResult.jsp(dispatch)
	(값을 전송)	> 	(각 영역에 속성을 저장)		> 	(각 영역에 저장된 값을 확인)
	
	<form action="/ScopeServlet" method="post">
		<input type="text" name="pageScope" value="page"><br />
		<input type="text" name="requestScope" value="reauest"><br />
		<input type="text" name="sessionScope" value="session"><br />
		<input type="text" name="applicationScope" value="application"><br />
		<input type="submit" value="전송">
	</form>
	
</body>
</html>