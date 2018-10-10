package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements IUserDao{

	public List<UserVO> selectUserAll() {

		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		return session.selectList("user.selectUserAll");
	}

	public UserVO selectUser(String userId) {

		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		return session.selectOne("user.selectUser", userId);
	}

	public UserVO selectUserByVo(UserVO userVO) {

		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		return session.selectOne("user.selectUserByVo", userVO);
	}

	@Override
	public List<UserVO> selectUserPageList(PageVO pageVO) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		return session.selectList("user.selectUserPageList", pageVO);
	}

}
