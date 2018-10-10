package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.model.PageVO;

@WebServlet("/userAllList")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final int PAGE_SIZE = 10;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전체 사용자 조회
		IUserService service = new UserService();
		
		int page = 1;
		
		PageVO pageVO = new PageVO(page, PAGE_SIZE);
		
		List<UserVO> userList = service.selectUserAll();
		List<UserVO> userListPage = service.selectUserPageList(pageVO);
		
		/*
		 조회된 사용자 정보를 userAllList.jsp를 통해 화면처리
			- session : 해당 사용자만 접근이 가능(사용자의 전용 공간)
				> 참조 빈도가 높은 데이터
				> 너무 많은 데이터를 저장할 경우 과부하(OOM : Out Of Memory) 유발 가능
				
			- application : 모든 사용자가 접근 가능(서버당 1개만 생성) 
				> 보통 설정과 관련된 값을 저장
				
			- request : 해당 요청의 응답이 끝날 때까지
		*/
		
		//application
//		getServletContext().setAttribute("userList", userList);
		
		//session
//		HttpSession session = request.getSession();
//		session.setAttribute("userList", userList);
		
		//request
		request.setAttribute("userList", userList);
		request.setAttribute("userListPage", userListPage);
		request.setAttribute("pagination", pageVO);
		
		//화면 위임 2가지 방법(새로고침을 생각해보자)
		//1. dispatch : 조회만 했을 경우, 보통/일반적으로 사용
		//2. sendRidirect : 서버에 데이터가 변경되었을 때
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
