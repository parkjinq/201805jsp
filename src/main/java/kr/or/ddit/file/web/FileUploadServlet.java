package kr.or.ddit.file.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1024*5 ,maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//fileUpload.jsp 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/fileupload/fileUpload.jap").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 text 파라미터 : request.getParameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		
		request.setCharacterEncoding("utf-8");
		
		
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");
		
		Part profilePart = request.getPart("profile");
		
		String contentDisposition = profilePart.getHeader("Content-disposition");
		String[] fileNameList  = contentDisposition.split(";");
		String condition = "filename=\"";
		for(String str : fileNameList){
			if(str.contains(condition)){
				//샘 방식
				int beginIndex = str.lastIndexOf(condition)+condition.length();
				int endIndex = str.lastIndexOf("\"");
				profile = str.substring(beginIndex, endIndex);
				//내 방식
//				profile = str.substring(condition.length()+1, str.length()-1);
			}
		}
		
		//파일쓰기
		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + profile);
		profilePart.delete();//파일이 크면 일부만 받고 남은 부분을 임시영역에 저장하는데, 이때 임시영역을 지우는 역할

		System.out.println("profilePart(Header) : " + profilePart.getHeader("Content-disposition"));
		System.out.println("profilePart(Type) : " + profilePart.getContentType());
		System.out.println("userId : " + userId + "\nprofile : " + profile);
	}

}
