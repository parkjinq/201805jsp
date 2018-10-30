package kr.or.ddit.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/fileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userid = request.getParameter("userid");
		
		IUserService service = new UserService();
			
		UserVO userVO =  service.selectUser(userid);
		
		File f = new File(userVO.getProfile());
		FileInputStream fis = new FileInputStream(f);
		
		byte[] buffer = new byte[512];
		int len = 0;
		
		ServletOutputStream sos = response.getOutputStream();//response에 쓰면 된다.
		
		//파일 읽기 
		while ((len = fis.read(buffer)) != -1) {
			//파일 쓰기(response에 쓰면 된다.)
			sos.write(buffer, 0, len);
		}
			sos.flush();
			sos.close();
			fis.close();
	}


}
