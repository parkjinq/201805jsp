<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>

<!-- 
	jstl 사용하기 위한 절차
	1. dependency 추가
	2. jsp파일에서 지시자 추가 (taglib : profix, uri)
	3. prefix를 이용하여 jstl 태그 사용
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_import.jsp</title>
</head>
<body>	
	<h2>timesTables</h2>
	<c:import url="timesTables.jsp">
		<c:param name="number" value="5"/>
	</c:import>

	<h2>naver search</h2>
	<c:import url="https://search.naver.com/search.naver">
		<c:param name="query" value="구글 홈 미니"/>
	</c:import>
</body>
</html>