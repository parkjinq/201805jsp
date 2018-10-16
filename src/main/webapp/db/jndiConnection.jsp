<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page import = "java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jndiConnection.jsp</title>
</head>
<body>
	<%
		//jndi connection, javax naming껄로
		Context initialContext = new InitialContext();
		//앞부분은 거의 고정, 뒤에가 다름, 자원에 대해 리턴해주는 녀석
		DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracleDB");
		
		Connection conn = null;
		
		//시간측정 : 시작시간
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 30; i++){
			conn = ds.getConnection();
			out.println("schema : " + conn.getSchema() + "<br />");
			conn.close();
		}
		
		//시간측정 : 종료시간
		long endTime = System.currentTimeMillis();
		out.println("conn 걸린 시간 : " + ((double)(endTime - startTime)/1000) + "sec");
	%>
</body>
</html>