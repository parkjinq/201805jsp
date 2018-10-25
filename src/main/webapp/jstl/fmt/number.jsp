<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>number.jsp</title>
</head>
<body>

	<c:set var="number" value="9999999" scope="request"/>
	<c:set var="percent" value="0.123" scope="request"/>

	<h2>기본 로케일</h2>
	
	<fmt:formatNumber value="${number}" /><br />
	<fmt:formatNumber value="${number}" type="currency"/><br />
	<fmt:formatNumber value="${percent}" type="percent"/><br />
	
	<h2>일어 로케일</h2>
	
	<fmt:setLocale value="ja_jp"/>
	<fmt:formatNumber value="${number}" /><br />
	<fmt:formatNumber value="${number}" type="currency"/><br />
	<fmt:formatNumber value="${percent}" type="percent"/><br />
	
	<h2>영어 로케일</h2>
	
	<fmt:setLocale value="en_us"/>
	<fmt:formatNumber value="${number}" /><br />
	<fmt:formatNumber value="${number}" type="currency"/><br />
	<fmt:formatNumber value="${percent}" type="percent"/><br />
	
	<h2>독어 로케일</h2>
	
	<fmt:setLocale value="de_de"/>
	<fmt:formatNumber value="${number}" /><br />
	<fmt:formatNumber value="${number}" type="currency"/><br />
	<fmt:formatNumber value="${percent}" type="percent"/><br />
	
	<h2>스트링 넘버 포맷(독어)</h2>
	<c:set var="parseNumber" value="1.000,99" scope="request"/>
	<fmt:parseNumber value="${parseNumber}"/>	
	
	
</body>
</html>












