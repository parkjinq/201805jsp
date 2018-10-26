package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCounterFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("reqCountFilter - 전처리");
		
		String uri = ((HttpServletRequest)request).getRequestURI();	//요청 uri 값
		System.out.println("RequestCountFilter/uri : " + uri);
		int count = 0; 	//맵의 value값(접속횟수)
		Map<String, Integer> countMap = null;
		
		//접속이 처음이 아니라면 기존의 맵을 사용한다.
		if(request.getServletContext().getAttribute("countMap") == null){
			countMap = new HashMap<String, Integer>();
		} else {
			countMap = (Map<String, Integer>) request.getServletContext().getAttribute("countMap");
		}
		
		//uri 비교후 일치하면 해당 uri키의 value 중가
		if(countMap.get(uri) != null){
			count = (int) countMap.get(uri);
		} 
		countMap.put(uri, ++count);
		
		//페이지 카운트를 application에 담아준다
		request.getServletContext().setAttribute("countMap", countMap);
		
		chain.doFilter(request, response);
		
		System.out.println("reqCountFilter - 후처리");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
