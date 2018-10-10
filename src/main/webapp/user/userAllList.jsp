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

<%@ include file="/common/basicLib.jsp"%>

</head>

<body>
	<%
		List<UserVO> userList = (List<UserVO>) request.getAttribute("userList");
		List<UserVO> userListPage = (List<UserVO>) request.getAttribute("userListPage");
		PageVO pagination = (PageVO)request.getAttribute("pagination");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		int count = userList.size();
	%>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
				userAllList.jsp
						<h2 class="sub-header">사용자 리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>번호</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생년월일</th>
								</tr>
								<%
									for (UserVO user : userListPage) {
								%>
								<tr>
									<td><%=count--%></td>
									<td><%=user.getUserId()%></td>
									<td><%=user.getName()%></td>
									<td><%=formatter.format(user.getBirth())%></td>
								</tr>

								<%
									}
								%>

							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
										<li><a href="#" ><</a></li>
								<%
									int pageSize = pagination.getPageSize();
									int pageNum = pagination.getPage();
									int paginationNum = 10;

									for (int i = pageNum; i < pageNum + paginationNum; i++) {
								%>
										<li><a href="/userAllList" ><%=i%></a></li>
								<%
									}
								%>
										<li><a href="#" >></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
