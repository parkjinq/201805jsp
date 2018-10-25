package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.util.model.PageVO;

@WebServlet(urlPatterns ={"/prodPageList", "/prodDetail", "/prodList"})
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProdService service = ProdService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		if(uri.equals("/prodPageList")){
			prodPageList(request, response);
		} else if (uri.equals("/prodDetail")) {
			prodDetail(request, response);
		} else if (uri.equals("/prodList")) {
			prodList(request, response);
		}
		
	}
	
	

	private void prodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String prod_lgu = request.getParameter("prod_lgu");
		
		List<ProdVO> prodList = service.selectProdByLgu(prod_lgu);
		
		request.setAttribute("prodList", prodList);
		
		request.getRequestDispatcher("/WEB-INF/tags/code.tag").forward(request, response);
	}



	private void prodDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdVO prodVO = service.selectProd(request.getParameter("prod_id"));
		
		if(prodVO != null){
			request.setAttribute("prodVO", prodVO);
			request.getRequestDispatcher("prod/prodDetail.jsp").forward(request, response);
		}
	}



	private void prodPageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageVO pageVO = new PageVO(Integer.parseInt(request.getParameter("page")), Integer.parseInt(request.getParameter("pageSize")));

		Map<String, Object> resultMap = service.selectProdPageList(pageVO);
		
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("pdCnt", resultMap.get("pdCnt"));
		request.setAttribute("pdList", (List<ProdVO>)resultMap.get("pdList"));
		request.getRequestDispatcher("/prod/prodPageList.jsp").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
