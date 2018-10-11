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
<style type="text/css">
	.userClick {
		cursor : pointer;
	}
</style>
<script>
// 	function userDetail(userId) {
// // 		location.href = "/userDetail?userId=" + userId.id;
// 		location.href = "/userDetail?userId=" + userId;
// 	}
	$(document).ready(function() {
		console.log("document.ready");
		
		//tr에 select (class="userClick")
// 		$(".userClick").click(function() {
// 		});
		
		var ev = "click"
		
		$(".userClick").on(ev, function() {
			console.log("document.ready");
			var userId = $(this).children()[1].innerText;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
	});
	
</script>

</head>

<form id="frm" action="/userDetail" method="get">
	<input type="hidden" id="userId" name="userId">
</form>

<body>
	<%
		@SuppressWarnings("unchecked")
		List<UserVO> userListPage = (List<UserVO>) request.getAttribute("userListPage");
		PageVO pagination = (PageVO)request.getAttribute("pagination");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
	%>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						userPageList.jsp
						<h2 class="sub-header">사용자 페이징 리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>아이디</th>
									<th>이름</th>
									<th>생년월일</th>
								</tr>
								<%
									for (UserVO user : userListPage) {
								%>
<%-- 								<tr id="<%=user.getUserId()%>" onclick="javascript:userDetail(<%=user.getUserId()%>)"> --%>
<%-- 								<tr onclick="javascript:userDetail('<%=user.getUserId()%>')"> --%>
								<tr class="userClick">
									<td><%=user.getRnum()%></td>
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
								<li><a href="/userPageList?page=1&pageSize=10" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<li><a href="/userPageList?page=1&pageSize=10"><<</a></li>
								<%
									PageVO currentPage = (PageVO)request.getAttribute("pagination");
									
									int userAllNum = 0;					//페이지네이션 마지막 숫자(제일 큰수)
									int startIndex = 0; 				//페이지네이션 시작넘버 1~5 > 1, 6~10 > 6
									int endIndex = 0;					//5단위 끝자리 1~5 > 5, 6~10 > 10
									int pagingNum = 0;					//상황에 맞게 startIndex를 이용하여 페이지 이동 버튼 값을 할당
									
									//가장 마지막 페이지 구하는 조건문
// 									userAllNum = userList.size()%10 != 0 ? userList.size() / 10 + 1 : userList.size() / 10;
									userAllNum = (Integer)request.getAttribute("pageCnt");
									
									//페이징 5개씩 나눌때 시작페이지와 끝페이지번호 정하는 조건문
									if(userAllNum != 0){
										for(int i = 0; i <= (currentPage.getPage()-1)/5; i++){
											startIndex = (5*i)+1;
											endIndex = startIndex + 4;
										}
										//페이징에서 필요한 길이(5개중 2개만 필요하면 반복문이 딱 2번만 돌도록 값을 넣어주는 부분)
										if(endIndex > userAllNum){
											endIndex = userAllNum;
										}
									} else {
										//반환된 리스트가 없을 경우
										startIndex = 1;
										endIndex = 1;
									}
									%>
								<li><a href="/userPageList?page=<%=pagingNum = startIndex == 1 ? 1 : startIndex-5%>&pageSize=10"><</a></li>
								<%
									for (int i = startIndex; i <= endIndex; i++) {
								%>
								<li><a href="/userPageList?page=<%=i%>&pageSize=10"><%=i%></a></li>
								<%
									}
								%>
								<li><a href="/userPageList?page=<%=pagingNum = startIndex + 5 > userAllNum ? startIndex : startIndex + 5 %>&pageSize=10">></a></li>
								<li><a href="/userPageList?page=<%=userAllNum%>&pageSize=10">>></a></li>
								<li><a href="/userPageList?page=<%=userAllNum%>&pageSize=10"" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>