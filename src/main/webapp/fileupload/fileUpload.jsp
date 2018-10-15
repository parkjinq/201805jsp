<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileUpload.jsp</title>
</head>
<body>
	
	<!-- 파일전송은 post만 가능 -->
	<!-- get 	/fileUpload : fileUpload.jsp 요청
		 post 	/fileUpload : form전송 처리	
	 -->
	<form action="/fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="userId" value="brown"><br />
		<!-- 파일 유출의 문제가 있기 때문에 value 불가 -->
		<input type="file" name="profile"><br />
		<input type="submit" value="전송">
		
		<%=application.getRealPath("/profile") %>
	</form>

</body>
</html>