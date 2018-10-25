<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="java.lang.Integer" required="false"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
	스트립틀릿으로도 선언/초기화
	변수에 접근이 가능하다.
 --%>

<%-- length 속성이 없을 경우 length 기본값 20으로 표현 --%>

<c:set var="length" value="${length eq null ? 20 : length}"></c:set>

<font color="${color}"> 
	<c:forEach var="i" begin="1" end="${length}">
		<c:out value="="></c:out>
	</c:forEach> 
	logging 
	<c:forEach var="i" begin="1" end="${length}">
		<c:out value="="></c:out>
	</c:forEach>
</font>























