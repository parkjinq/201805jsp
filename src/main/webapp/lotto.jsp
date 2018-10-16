<%@page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<Integer, String> std = null;
		
		int random = (int)(Math.random()*19)+1;
		
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.203.50:1521:xe";
		String user = "jin";
		String pw = "java";
		conn = DriverManager.getConnection(url, user, pw);
		
		stmt = conn.createStatement();
		
		String sql = "select *	from jspstudent";
		
		System.out.println("SQL >> " + sql); //오류 발생시 확인 방법 : 출력된거 복사해서 developer에서 실행
		
		rs = stmt.executeQuery(sql);
		
		std = new HashMap<Integer, String>();
		
		while (rs.next()) {
			std.put(rs.getInt("no"), rs.getString("name"));
		}
		%>
	<canvas id="myCanvas" width="200" height="200" ></canvas>
	<script type="text/javascript">
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		var ctx2 = canvas.getContext("2d");
		var ctx3 = canvas.getContext("2d");
		
		ctx2.beginPath();
		ctx2.arc(100,100,100,0,2*Math.PI);
		ctx2.stroke();
		
		ctx3.fillStyle = "tomato";
		ctx3.font = "30px Arial";
		ctx3.fillText("응 너야~ㅋ",28,55);
		ctx3.fillText("나와~^오^",35,165);
		
		ctx.font = "50px Arial";
		ctx.fillStyle = "red";
		ctx.fillText("<%=std.get(random) %>",25,115);
		   
	</script>
	<%
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	%>
</body>
</html>