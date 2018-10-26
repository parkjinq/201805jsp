<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/common/basicLib.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestCount.jsp</title>
</head>
<body>

			<c:forEach items="${countMap}" var="count">
				<label>${count.key} : ${count.value}</label><br />
			</c:forEach>
			
</body>
</html>