<%@ page import = "java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dbcpConnection.jsp</title>
</head>
<body>
	<%
		//db connection pooling, dbcp2껄로
		BasicDataSource bd = new BasicDataSource();
		//기본적인 DB접속 설정
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bd.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bd.setUsername("jin");
		bd.setPassword("java");
		
		//db connection 초기화 사이즈
		bd.setInitialSize(10);
		
		Connection conn = bd.getConnection();
		
		//시간측정 : 시작시간
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 30; i++){
			conn = bd.getConnection();
			out.println("schema : " + conn.getSchema() + "<br />");
			conn.close();
		}
		
		//시간측정 : 종료시간
		long endTime = System.currentTimeMillis();
		out.println("conn 걸린 시간 : " + ((double)(endTime - startTime)/1000) + "sec");
		
		bd.close();
	%>
</body>
</html>