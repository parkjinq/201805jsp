package calculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		int mulResult = param1 * param2;
		
		HttpSession session = request.getSession();
		int sumResult = (int) session.getAttribute("sumResult");
		
		session.setAttribute("mulResult", mulResult * sumResult);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/mulResult.jsp");
		rd.forward(request, response);
	}

}
