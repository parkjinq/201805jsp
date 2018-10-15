package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

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
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//사용자 등록화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userForm.jsp로 위임
		request.getRequestDispatcher("user/userForm.jsp").forward(request, response);
	}

	//사용자 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기
		//userId, name, pass, addr1, addr2, zipcd, birth, email, tel
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");	//type
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String zipcd = request.getParameter("zipcd");
		
		Part profilePart = request.getPart("profile");
		System.out.println(profilePart);
		
		String contentDisposition = profilePart.getHeader("Content-disposition");
		String profile = StringUtil.stringUtil(contentDisposition);
		
		//파일쓰기
		//url정보를 실제 파일경로로 변경
		String path = getServletContext().getRealPath("/profile");
		//File.separator : \(운영체제 영향을 받지 않고 '\' 가능)
		profilePart.write(path + File.separator + profile);
//		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\workspace\\jsp\\src\\main\\webapp\\profile\\" + profile);
		profilePart.delete();
		
		System.out.println(userId + " / " + name + " / " + " / " + pass + " / " + addr1 + " / " + addr2 + " / " + birth + " / " + email + " / " + tel + " / " + zipcd);
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setName(name);
		userVO.setPass(pass);
		userVO.setAddr1(addr1);
		userVO.setAddr2(addr2);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVO.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userVO.setEmail(email);
		userVO.setTel(tel);
		userVO.setZipcd(zipcd);
		userVO.setProfile("profile/" + profile);
		
		//사용자 등록 서비스 호출
		IUserService userService = new UserService();
		int insertCnt = userService.insertUser(userVO);
		
		//사용자 리스트로 이동(redirect : 서버상태가 변경되므로 사용자가 새로고침을 통해 재용청시 중복  등록되는 현상을 막는다)
		response.sendRedirect("/userPageList?page=1&pageSize=10");
	}

}
