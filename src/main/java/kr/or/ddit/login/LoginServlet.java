package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class LoginServlet extends HttpServlet{
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	private static final long serialVersionUID = 1L;
	
	private IUserService service;
	
	public LoginServlet () {
		service = new UserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.사용자 아이디, 비밀번호를 request객테에서 받아온다
		//2.db에서 조회해온 아이디, 비밀번호를 체크한다
		//3-1.일치할경우, main.jsp로 이동
		//3-2.불일치할 경우, login.jsp로 이동
		
		//1.
		String userId = req.getParameter("user_id");
		String password = req.getParameter("user_pw");
		String rememberMe = req.getParameter("remember-me");

		//아이디 기억
		if(rememberMe == null){
//			Cookie cookie = new Cookie("remember", "N");
//			Cookie useridCookie = new Cookie("userId", userId);
//			cookie.setMaxAge(60*60*24);
//			cookie.setMaxAge(-1); //음수로 하면 쿠키가 유효화 되며 사라짐
//			resp.addCookie(cookie);
//			resp.addCookie(useridCookie);
			
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("userId")){
					cookie.setMaxAge(0); // 0 : 바로삭제, -1 : 브라우저 재시작시 쿠키삭제 반영
					resp.addCookie(cookie);
				} else if(cookie.getName().equals("remember")){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
				System.out.println(cookie.getName());
			}
		} else {
			//response 객체에 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie useridCookie = new Cookie("userId", userId);
			resp.addCookie(cookie);
			resp.addCookie(useridCookie);
		}
		
		//2. > db대신 상수로 대체
		
		//1.사용자가 전송한 userId 파라미터로 사용자 정보조회
		//2. db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교
		//3. session에 사용자 정보 설정(as-is : 임의의 userVO등록
		//						  to-be : db에서 조회한 userVO)
		//pom.xml에서 orcale dependency scope 삭제
		UserVO loginInfo = new UserVO();
		loginInfo.setUserId(userId);
		String encryptPass = KISA_SHA256.encrypt(password);
		loginInfo.setPass(password);
//		loginInfo.setPass(encryptPass);
		
		UserVO userVO = service.selectUserByVo(loginInfo);
//		userVO.authPass(encryptPass);
		if(userVO != null){
			HttpSession session = req.getSession();
			
			session.setAttribute("S_userVO", userVO);
			
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
			
			System.out.println("------------------------------------");
			
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("login/login.jsp");
		}
		
//		if(USERID.equals(userId) && USERPW.equals(password)){
//		//3-1.
//			//redirect(꼭그런건 아닌데 DB에 변경이 있을 경우 사용)
////			resp.sendRedirect("main.jsp?user_id=" + userId + "&user_pw=" + password);
//			
//			//18.10.05
//			//1.session에 사용자 정보 설정
//			userVO.setUserId(userId);
//			userVO.setName("브라운");
//			userVO.setBirth(new Date());
//			
//			HttpSession session = req.getSession();
//			
//			session.setAttribute("userVO", userVO);
//			session.setAttribute("name", userVO.getName());
//			
//			//2.main.jsp
//			//body영역에 이름[별명]
//			
//			
//			
//			//dispatch(꼭그런건 아닌데 기본)
//			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
//			rd.forward(req, resp);//받은 정보요청을 재사용하겠다.
//		} else {
//		//3-2.
//			resp.sendRedirect("login/login.jsp");
//		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
		String[] userIds = req.getParameterValues("user_id");
		for(String userId : userIds){
			pw.println("		userId : " + userId + "<br>");
		}
		
		pw.println("		password : " + req.getParameter("user_pw") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");
	}
}







