<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>date.jsp</title>
</head>
<body>
	
	<c:set var="date" value="<%=new Date() %>" scope="request"/>
	
	<h2>DATE</h2>
	<c:out value="${date}"/>
	
	<h2>FORMAT DATE</h2>
	<fmt:formatDate value="${date}"/><br />
	
	<h2>FORMAT DATE(pattern)</h2>
	<fmt:formatDate value="${date}" pattern="yy-MM-dd"/>
	
	<h2>FORMAT DATE(type)</h2>
	date : <fmt:formatDate value="${date}" type="date"/><br />
	time : <fmt:formatDate value="${date}" type="time"/>
	
	<h2>FORMAT DATE(dateStyle)</h2>
	full : <fmt:formatDate value="${date}" dateStyle="full"/><br />
	medium : <fmt:formatDate value="${date}" dateStyle="medium"/><br />
	short : <fmt:formatDate value="${date}" dateStyle="short"/>
	
	<h2>FORMAT DATE(parsDate)</h2>
	<c:set var="parseDate" value="2018-10-25"/>
	parseDate: <fmt:parseDate var="dt" value="${parseDate}" pattern="yyyy-MM-dd"/><br />
	<c:out value="${dt}"></c:out> 
		
</body>
</html>