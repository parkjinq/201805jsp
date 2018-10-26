package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVO;

public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter - 전처리");
		
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		UserVO userVO = (UserVO) session.getAttribute("S_userVO");
		if(userVO == null){
			req.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return;
//			resp.sendRedirect("/");
//			return;
		}
		
		chain.doFilter(request, response);
		
		System.out.println("LoginCheckFilter - 후처리");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
