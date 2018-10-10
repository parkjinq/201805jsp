package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* BasicServlet.java
*
* @author jin
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* jin 최초 생성
*
* </pre>
*/
public class BasicServlet extends HttpServlet{
	
	//요청 http 메소드에 따라 실행되는 메소드가 달라진다.
	//get	: doGet
	//post	: doPost
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//HttpServletRequest	: 요청에 대한 정보
		//HttpServletResponse	: 응답에 대한 정보
		
		//브라우저에서 한글이 깨질 경우 콘텐츠 타입을 설정해준다
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		//date format을 이용하여 : 년-월-일 출력
		Date date = new Date(); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatDate = format.format(date);
		
//		pw.println("Hello, world");
//		pw.println(formatDate);

		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>BasicSevlet.html</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("			헬로우 월드<br />");
		pw.println("			" + formatDate);
		pw.println("		</body>");
		pw.println("</html>");
		
		
		pw.flush();
		pw.close();
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}
}


//정적 자료 : index.html > url
//동적자료 : servlet > url mapping 구성필요 : web.xml

//public class BasicServlet extends HttpServlet{
//	
//	//요청 http 메소드에 따라 실행되는 메소드가 달라진다.
//	//get	: doGet
//	//post	: doPost
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		//HttpServletRequest	: 요청에 대한 정보
//		//HttpServletResponse	: 응답에 대한 정보
//		
//		//브라우저에서 한글이 깨질 경우 콘텐츠 타입을 설정해준다
//		resp.setContentType("text/html; charset=utf-8");
//		
//		PrintWriter pw = resp.getWriter();
//		
////		//date format을 이용하여 : 년-월-일 출력
////		Date date = new Date(); 
////		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////		
////		pw.println("Hello, world");
////		pw.println(format.format(date));
//
//		pw.println("<!DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head>");
//		pw.println("<meta charset=\"UTF-8\">");
//		pw.println("<title>index.html</title>");
//		
//		pw.println("</head>");
//		pw.println("<body>");
//		pw.println("</body>");
//		
//		pw.println("<script type=\"text/javascript\">");
//		pw.println("	var date = new Date();");
//		pw.println("	document.getElementsByTagName(\"body\")[0].innerHTML = \"현재시간 : \" + date;");
//		
//		pw.println("</script>");
//		pw.println("</html>");
//		
//		pw.flush();
//		pw.close();
//		
//	}





