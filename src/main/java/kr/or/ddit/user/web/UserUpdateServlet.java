package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5 ,maxRequestSize=1024*1024*5*5)
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUserService userService = new UserService();
		
		UserVO userVO = (UserVO)userService.selectUser(request.getParameter("userId"));
		request.setAttribute("userVO", userVO);
		request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUserService userService = new UserService();
		
		UserVO userVO = new UserVO();
		userVO.setUserId(request.getParameter("userId"));
		userVO.setPass(request.getParameter("pass"));
		userVO.setName(request.getParameter("name"));
		userVO.setZipcd(request.getParameter("zipcd"));
		userVO.setAddr1(request.getParameter("addr1"));
		userVO.setAddr2(request.getParameter("addr2"));
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			userVO.setBirth(formatter.parse(request.getParameter("birth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userVO.setEmail(request.getParameter("email"));
		userVO.setTel(request.getParameter("tel"));
		
		Part profilePart = request.getPart("profile");
		System.out.println("profilePart" + profilePart);
		//수정후 파일 저장
		String contentDisposition = profilePart.getHeader("Content-disposition");
		String profile = StringUtil.stringUtil(contentDisposition);
		String path = getServletContext().getRealPath("/profile");
		System.out.println("profile" + profile);
		if(!(profile.equals(""))){
			profilePart.write(path + File.separator + profile);
			profilePart.delete();
			userVO.setProfile("profile/" + profile);
			
			String aa = request.getParameter("existingProfile");
			aa = aa.split("/")[1];
			String pathpath = path + File.separator + aa;
//			pathpath.replaceAll("/", "\\");
			
//			File file = new File(path + File.separator + request.getParameter("existingProfile"));
			File file = new File(pathpath);
			if(file.exists()){ //파일존재여부
				if(file.isDirectory()){
					
					File[] files = file.listFiles();
	                 
	                for( int i=0; i<files.length; i++){
	                    if( files[i].delete() ){
	                        System.out.println(files[i].getName()+" 삭제성공");
	                    }else{
	                        System.out.println(files[i].getName()+" 삭제실패");
	                    }
	                }
				}
				if(file.delete()){
					System.out.println("기존 file 삭제 완료");
				} else {
					System.out.println("기존 file 삭제 실패");
				}
			} else {
				System.out.println("기존 file이 존재하지 않음");
			}
		} else {
			profile = request.getParameter("existingProfile");
			userVO.setProfile(profile);
		}
		
		int updateCnt = userService.updateUser(userVO);
		System.out.println("updateCnt" + updateCnt);
		//수정전 파일 삭제
		
		response.sendRedirect("/userDetail?userId=" + userVO.getUserId());
	}

}
