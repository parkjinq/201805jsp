<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial.jsp</title>
</head>
<body>

	<%!//factorial method 선언
	public String msg() {
		return "Factorial Test";
	}%>
	<%!public int factorial(int val) {
		int result = 1;
		for (int i = 1; i <= val; i++) {
			result *= i;
		}
		return result;
	}%>

	<%=msg()%>
	<%
		for (int i = 0; i <= 8; i++) {
	%>
	<br />factorial(<%=i%>) =
	<%=factorial(i)%>
	<%
		}
	%>
	<%--factorial method 호출 (loop를 통해 factorial 8까지 호출)--%>
</body>
</html>