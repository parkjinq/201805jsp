package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("1.Filter - 전처리");
		
		//다른 적용할 필터가있으면 다른 필터로 요청을 넘기고
		//더이상 적용할 필터가 없으면 원래 요청에 대한 servlet/jsp로 요청을 이관
		chain.doFilter(request, response); // > 서블릿 처리하고 후처리로 내려간다.
		
		System.out.println("5.Filter - 후처리");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
