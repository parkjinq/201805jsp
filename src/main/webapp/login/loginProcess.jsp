<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProcess.jsp</title>
</head>
<body>
	<%-- login.jsp에서 전송한 파라미터 : user_id, user_pw --%>
	<%-- request parameter 관련 메서드
		1. getParameter(String name) --%>
	<br />User ID : <%=request.getParameter("user_id") %>
	
	
	<h3>getParameterValues</h3>
	<br />getParameterValues : <%=request.getParameterValues("user_id") %>
	<%
		String[] user_ids = request.getParameterValues("user_id");

		for (String s : user_ids) {
	%>
	<br /><%=s%>
	<%
		}
	%>
	<h3>getParameterMap</h3>
	<br />getParameterMap :
	<%=request.getParameterMap()%>
	<%
		Map<String, String[]> user_idMap = request.getParameterMap();
		for (String s : user_idMap.get("user_id")) {
	%>
	<br />s =
	<%=s%>
	<%
		}
	%>
	<%=user_idMap.get("user_pw")%>
	<h3>getParameterNames</h3>
	<%
		Enumeration enumId = request.getParameterNames();

		while (enumId.hasMoreElements()) {
			String parameterName = (String)enumId.nextElement();
	%>
	<%=parameterName%>
	<%
		}
	%>
	<br />User PW : <%=request.getParameter("user_pw") %>
</body>
</html>