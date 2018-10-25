<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logging.jsp</title>
</head>
<body>

	<h2>loggingTag</h2>
	1 ~ 10출력<br />
	<tags:loggingTag></tags:loggingTag>
	<c:forEach begin="1" end="10" var="i">
		${i}<br />
	</c:forEach>
	<tags:loggingTag></tags:loggingTag>
	
	<h2>colorLoggingTag</h2>
	<tags:colorLogging length="10" color="powderblue"></tags:colorLogging>
	<br />
	<c:forEach begin="1" end="10" var="i">
		${i}<br />
	</c:forEach>
	<tags:colorLogging color="tomato"></tags:colorLogging>
	
	<br />
	<tags:code code="P201"></tags:code>
	

</body>
</html>