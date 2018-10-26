package kr.or.ddit.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3.FilterServlet doget");
		
//		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
		request.getRequestDispatcher("/filter/requestCount.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//characterEncoding 설정을 filter로 이관(코드 중복 제거)
//		request.setCharacterEncoding("utf-8");
		
		//userNm파라미터 받기
		String userNm = request.getParameter("userNm");
		
		//request 속성으로 저장
		request.setAttribute("userNm", userNm);
		
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
		
	}

}
