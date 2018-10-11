package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

@WebServlet(urlPatterns={"/userAllList", "/userPageList", "/userDetail"})
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IUserService service = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 uri로 로직 분기
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet " + uri);
		
		if(uri.equals("/userAllList")){
			//uri = userAllList
			userAllList(request, response);
		} else if(uri.equals("/userPageList")) {
			userPageList(request, response);
		} else if(uri.equals("/userDetail")){
			userDetail(request, response);
		}
		
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
		
		
	}

	private void userDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		//사용자 아이디가 파라미터로 넘어온다.
//		HttpSession session = request.getSession();
//		
//		//사용자 아이디에 해당하는 사용자 정보 조회
//		UserVO userVO = (UserVO)session.getAttribute("userVO");
//		
//		//jsp로 위임하기 위해 사용자 정보를 request에 저장
//		request.setAttribute("userVO", userVO);
//		
//		//사용자 상세 화면으로 위임
//		RequestDispatcher rd = request.getRequestDispatcher("user/userDetail.jsp");
//		rd.forward(request, response);
		
		UserVO userVo = service.selectUser(request.getParameter("userId"));
		
		if(userVo != null){
			request.setAttribute("userVO", userVo);
			
		RequestDispatcher rd = request.getRequestDispatcher("user/userDetail.jsp");
		rd.forward(request, response);
			
		}
	}

	/**
	 * 
	* Method : userPageList
	* 작성자 : jin
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 사용자 페이지 리스트 조회
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userPageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//필요한 정보
		// 1.전체 리스트 수
		
		System.out.println("userPageList");
		//userService 생성
		//userPageList 호출 : 메소드 인자-pageVo : pagem pageSize
		
		//페이지 사용자리스트 조회
//		int page = 1;
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap = service.selectUserPageList(pageVO);
		
		@SuppressWarnings("unchecked")
		List<UserVO> userListPage = (List<UserVO>) resultMap.get("userList");
		int pageCnt = (int) resultMap.get("pageCnt");
		
		//request
		request.setAttribute("userListPage", userListPage);
		request.setAttribute("pagination", pageVO);
		request.setAttribute("pageCnt", pageCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPageList.jsp");
		rd.forward(request, response);
	}

	/**
	 * 
	* Method : userAllList
	* 작성자 : jin
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	protected void userAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userAllList");
		
		//전체 사용자 조회
		List<UserVO> userList = service.selectUserAll();
		request.setAttribute("userList", userList);
		
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
