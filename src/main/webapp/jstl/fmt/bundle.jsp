<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bundle.jsp</title>
</head>
<body>
	<h2>기본</h2>
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"/> : 
		<fmt:message key="visitor">
			<fmt:param value="brown" />
		</fmt:message>
	</fmt:bundle>
	<br />
	
	<h2>변경 로케일 : ja(일본어)</h2>
	<fmt:setLocale value="ja"/>
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello"/> : 
		<fmt:message key="visitor">
			<fmt:param value="cony"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br />
	
	<h2>setBundle</h2>
	<fmt:setLocale value="en"/>
	<fmt:setBundle basename="kr.or.ddit.resource.msg.msg" var="msg" />
	<fmt:message key="hello" bundle="${msg}" />
	<fmt:message key="visitor" bundle="${msg}">
		<fmt:param value="cony"></fmt:param>
	</fmt:message>
	
</body>
</html>