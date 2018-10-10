package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserService implements IUserService{

	IUserDao dao = new UserDao();
	
	@Override
	public List<UserVO> selectUserAll() {
		List<UserVO> list = dao.selectUserAll();
		return list;
	}

	@Override
	public UserVO selectUser(String userId) {
		UserVO userVO = dao.selectUser(userId);
		return userVO;
	}

	@Override
	public UserVO selectUserByVo(UserVO userVOInfo) {
		UserVO userVO = dao.selectUserByVo(userVOInfo);
		return userVO;
	}

	@Override
	public List<UserVO> selectUserPageList(PageVO pageVO) {
		List<UserVO> list = dao.selectUserPageList(pageVO);
		return list;
	}

}
