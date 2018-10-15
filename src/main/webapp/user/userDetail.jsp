<%@page import="kr.or.ddit.util.model.PageVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<style type="text/css">
	.kyuseung {
		width: 200px;
		height: 200px;
	}
</style>

<%@ include file="/common/basicLib.jsp"%>

	<%
		UserVO userVo = (UserVO)request.getAttribute("userVO");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
	%>
<script type="text/javascript">
	$(document).ready(function() {

		var ev = "click";
		
		$(".updateClick").on(ev, function() {
			console.log("document.ready");
			$("#uu").submit();
		});
	});
</script>

</head>

<form id="uu" action="/userUpdate" method="get">
	<input type="hidden" id="userId" name="userId" value="<%=userVo.getUserId() %>">
</form>

<body>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" action="/userPageList" method="get">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
						<%if(userVo.getProfile() != null){
							%>
							<img src="<%=userVo.getProfile() %>" class="kyuseung"/>
							<%
						} else {
							%>
							<img src="/profile/no_image.jpg" class="kyuseung"/>
							<%
						}
							%>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
								<label class="control-label" id="userId" ><%=userVo.getUserId() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label" ><%=userVo.getName() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=userVo.getAddr1() %></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=userVo.getAddr2() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=userVo.getZipcd() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=formatter.format(userVo.getBirth()) %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=userVo.getEmail() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
								<label class="control-label" ><%=userVo.getTel() %></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="page" value="1">
							<input type="hidden" name="pageSize" value="10">
							<input type="button" class="btn btn-default updateClick" value="정보수정" >
							<button type="submit" class="btn btn-default">목록보기</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>

