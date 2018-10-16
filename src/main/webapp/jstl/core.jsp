<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="kr.or.ddit.util.model.PageVO"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core.jsp</title>
</head>
<body>
<%--core tag prefix : c --%>
<%--jstl 태그 사용법 : <prefix:태그명> --%>
	<h2>core set</h2>

	<%--pageContext.setAttribute("attribute", "cSetValue"); --%>
	<c:set var="attribute" value="cSetValue" scope="request"/>
	
	el : ${attribute} <br />
	pagrContext : <%=pageContext.getAttribute("attribute") %>	<br />
	request : <%=request.getAttribute("attribute") %>	

	<hr>

	<h2>core remove</h2>
	<c:remove var="attribute"/>
	el : ${attribute} <br />
	
	<hr>
	<h2>core if : 단일 비교</h2>
	<%--if(){} else{} --%>
	<c:set var="code" value="01"/>
	
	<%--code가 "01"이면 if 안쪽코드가 실행 --%>
	<c:if test="${code == '01'}"> <%--공백조심 공백조심 --%>
		if 안쪽
	</c:if>
	
	<hr>
	<h2>core choose : 실질적인 if 구문</h2>
	<c:choose>
		<c:when test="${code == '01'}">공일</c:when>
		<c:when test="${code == '02'}">공이</c:when>
		<c:when test="${code == '03'}">공삼</c:when>
		<c:otherwise>else</c:otherwise>
	</c:choose>
	
	<hr>
	<h2>core foreach : 반복문</h2>
	<%--사용자 리스트 1페이지 조회 --%>
	<%
		IUserService service = new UserService();
		Map<String, Object> resultMap = service.selectUserPageList(new PageVO(1,10));
		request.setAttribute("userList", resultMap.get("userList"));

	%>
	<%-- <c:set var="user" value="userList" --%>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>생일</th>
		</tr>
	<c:forEach items="${userList}" var="user">
		<tr class="userClick">
			<td>${user.rnum}</td>
			<td>${user.userId}</td>
			<td>${user.name}</td>
			<td>${user.birth}</td>
		</tr>
	</c:forEach>
	</table>
	
	<hr>
	<h2>core foreach index loop</h2>
	<c:forEach begin="0" end="10" var="i" step="3">
		${i}&nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<hr>
	<h2>core foreach index loop</h2>
	
	<%
		Map<String, String> strMap = new HashMap<String, String>();
		strMap.put("ranger1", "brown");
		strMap.put("ranger2", "sally");
		strMap.put("ranger3", "cony");
		strMap.put("ranger4", "james");
		
		request.setAttribute("strMap", strMap);
	%>
	
	<c:forEach items="${strMap}" var="map">
		${map.key} : ${map.value} <br />
	</c:forEach>
	
	<hr>
	<h2>core foreach index loop</h2>
	<% request.setAttribute("lineRangers", "brown,cony,sally,james,jesica"); %>
	<c:forTokens items="${lineRangers}" delims="," var="i">
		${i}&nbsp;
	</c:forTokens>
	
</body>
</html>



































