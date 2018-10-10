package kr.or.ddit.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVO;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//parameter userId, name
		String userId = req.getParameter("userId");
		String name = req.getParameter("name");
		
		resp.setCharacterEncoding("utf-8");

		//request 정보에 값을 저장
		UserVO userVO = getUser(userId);
		req.setAttribute("userVO", userVO); //key value 형태와 비슷, parameter : 사용자의 값을 받는 것/ Attribute: 개발자가 값을 저장을 하는 것
		
		HttpSession session = req.getSession();
		session.setAttribute("userVO", userVO);
		
		//dispatch
		RequestDispatcher rd = req.getRequestDispatcher("/request/requestResult.jsp");
		rd.forward(req, resp);//받은 정보요청을 재사용하겠다.
		
		
		//redirect
//		resp.sendRedirect("requestServlet");//request객체가 바뀌어서 null이 뜬다
		
	}
	
	public UserVO getUser(String userId) {
		
		//userId 매개변수를 이용하여 사용자 정보를 DB에서 조회
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setName("브라운");
		userVO.setBirth(new Date());
		
		return userVO;
	}
}
