<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timezone.jsp</title>
</head>
<body>
	<c:set var="now" value="<%=new Date() %>"></c:set>
	
	<fmt:timeZone value="">
	format date : <fmt:formatDate value="${now}" type="both"/><br />
	</fmt:timeZone>
	<fmt:timeZone value="Asia/Bangkok">
	format date(Asia/Bangkok) : <fmt:formatDate value="${now}" type="both"/><br />
	</fmt:timeZone>
	
	<br />
	<fmt:setTimeZone value="Brazil/West" var="brazil"/>
	brazil : <fmt:formatDate value="${now}" timeZone="${brazil}" type="both"/>
</body>
</html>