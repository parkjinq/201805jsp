<%@ tag import="java.sql.DriverManager"%>
<%@ tag import="java.sql.ResultSet"%>
<%@ tag import="java.sql.Statement"%>
<%@ tag import="java.sql.Connection"%>
<%@ tag import="java.sql.SQLException"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

code : ${code}
<br />
<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.203.50:1521:xe";
		String user = "jin";
		String pw = "java";
		conn = DriverManager.getConnection(url, user, pw);
		
		stmt = conn.createStatement();
		
		String sql = "select *	from prod where prod_lgu = '" + code + "'";
		
		System.out.println("SQL >> " + sql); //오류 발생시 확인 방법 : 출력된거 복사해서 developer에서 실행
		
		rs = stmt.executeQuery(sql);
		
		out.write("<select>");
		while (rs.next()) {
			out.write("<option value='" + rs.getString("prod_id") + ">" + rs.getString("prod_name") + "</option>");
		}
		out.write("</select>");
		%>
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








