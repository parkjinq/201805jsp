<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.3.1.min.js"></script>
<link href="/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#selectBox').on('change', function() {
			location.href = 'http://localhost:8081/jstl/fmt/selectLang.jsp?lang=' + this.value;
		})
		
		//======================================================================================
			
		$('#lang').val('${param.lang}');
		$('#lang').on('change', function() {
			$('#frm').submit();
		})
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectLang.jsp</title>
</head>
<body>

	<!-- 
		1. lang 이라고 이름 지어진 파라미터로 locale을 설정
		2. 만약 lang 파라미터가 없을 경우 ko를 기본 값으로 사용
		3. select 변경될 때 해당 언어로 페이지 요청
		4. select 현재요청된 lang파라미터 언억밧이 선택되어져 있어야함(lang 파라미터가 없을 경우 기본 값 ko)
		
		최초접속 : http://localhost:8081/jstl/fmt/selectLang.jsp
		그 이후 : select 변경하여 페이지 재요청
		
		문자표시할 경우 쿼테이션 잊지말자....
	 -->
	<c:set var="lang" value="${param.lang ne null ? param.lang : 'ko'}" />


	lang : ${lang}

	<h1>onChange</h1>
	<br />
	<select id="selectBox">
		<option value="ko" ${lang eq 'ko' ? 'selected' : ''}>한국어</option>
		<option value="en" ${lang eq 'en' ? 'selected' : ''}>English</option>
		<option value="ja" ${lang eq 'ja' ? 'selected' : ''}>日本語</option>
		<%-- 	 	<option value="ko" <c:if test="${lang eq 'ko'}">selected</c:if>>한국어</option> --%>
		<%-- 	 	<option value="en" <c:if test="${lang eq 'en'}">selected</c:if>>English</option> --%>
		<%-- 	 	<option value="ja" <c:if test="${lang eq 'ja'}">selected</c:if>>日本語</option> --%>
	</select>

	<br />
	<fmt:setLocale value="${lang}" />
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello" />
		<br />
		<fmt:message key="visitor">
			<fmt:param value="cony"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br />

	<!-- ============================================================== -->

	<h1>form(get)</h1>
	<form id="frm" action="selectLang.jsp">
		<select name="lang" id="lang">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="ja">日本語</option>
		</select>
	</form>

	<br />
	<fmt:setLocale value="${lang}" />
	<fmt:bundle basename="kr.or.ddit.resource.msg.msg">
		<fmt:message key="hello" />
		<br />
		<fmt:message key="visitor">
			<fmt:param value="cony"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br />

</body>
</html>