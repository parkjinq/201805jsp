<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTables.jsp</title>
</head>
<body>
			core_import.jsp 변수 param = <%=request.getParameter("number") %>
	<h2>스크립틀릿</h2>
<table border="1">
		<%
		
			for (int i = 2; i <= 9; i++) {
		%>
		<tr>
			<%
				for (int j = 1; j <= 9; j++) {
			%>
			<td><%=i%> X <%=j%> = <%=i * j%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
	
	<hr>
	<h2>jstl</h2>
	<table border="1">
		<c:forEach begin="2" end="${param.number}" var="i">
			<tr>
				<c:forEach begin="1" end="9" var="j">
					<td>${i} X ${j} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>