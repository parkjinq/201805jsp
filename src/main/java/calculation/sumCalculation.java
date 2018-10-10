package calculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존 view 요청 get: localhost:8081/jsp/sumInput.jsp
		//변경 view 요청 get: localhost:8081/sumCalculation
		//sumInput.jsp forward
		//요청은 jsp가 아니라 서블릿이 받는게 맞다
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumInput.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sumResult = 0;
		
		sumResult = new CalculationLogic().sumBetweenTwoNumbers(start, end);
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sumResult);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(request, response);
		
	}



}
