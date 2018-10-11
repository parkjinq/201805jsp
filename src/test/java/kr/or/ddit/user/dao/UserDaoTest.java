package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private String userId = "brown";
	private String pass = "brownpass";
	private IUserDao userDao;
	
	@Before
	public void before(){
		System.out.println("─────────────────────────");
		System.out.println("	@Before");
		System.out.println("─────────────────────────");
		userDao = new UserDao();
	}
	
	@Test
	public void selectUserAllTest() {

		/*** Given : 주어진 상황 ***/
		List<UserVO> userList;
		
		/*** When : 어떤 동작 수행(메소드 호출) ***/

		userList = userDao.selectUserAll();
		
		System.out.println("- selectUserAllTest()");
		System.out.println(userList);

		/*** Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(105, userList.size());
	}

	@Test
	public void selectUserTest() {
		/*** Given ***/
		UserVO user;
		
		/*** When ***/
		user = userDao.selectUser(userId);
		
		System.out.println("\n- selectUserTest()");
		System.out.println(user);

		/*** Then ***/
		assertEquals("브라운", user.getName());
		assertEquals("brown", user.getUserId());
		assertNotEquals("샐리", user.getName());
		assertNotNull(user);
	}

	@Test
	public void selectUserByVoTest() {
		/*** Given ***/
		UserVO userVo = new UserVO();
		userVo.setUserId(userId);
		userVo.setPass(pass);
		UserVO user;
		
		/*** When ***/
		user = userDao.selectUserByVo(userVo);
		
		System.out.println("\n- selectUserByVoTest()");
		System.out.println(user);

		/*** Then ***/
		assertEquals("브라운", user.getName());
		assertEquals("brown", user.getUserId());
		assertNotEquals("샐리", user.getName());
		assertNotNull(user);
	}
	
	@Test
	public void selectUserPageList() {
		/*** Given ***/
		PageVO pageVO = new PageVO(5, 10);
		List<UserVO> userList;
		
		/*** When ***/
		userList = userDao.selectUserPageList(pageVO);
		
		System.out.println("\n- selectUserPageList()");
		System.out.println(userList);
		
		/*** Then ***/
		assertEquals(10, userList.size());
	}
	
	@Test
	public void getUserCnt() {
		/*** Given ***/
		int userCnt;
		
		/*** When ***/
		userCnt = userDao.getUserCnt();
		
		System.out.println("\n- getUserCnt()");
		System.out.println(userCnt);
		
		/*** Then ***/
		assertEquals(105, userCnt);
	}
}
