package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Test;

public class UserDaoTest {

	private String userId = "brown";

	@Test
	
	public void selectUserAllTest() {

		/*** Given : 주어진 상황 ***/
		IUserDao userDao = new UserDao();
		/*** When : 어떤 동작 수행(메소드 호출) ***/

		List<UserVO> userList = userDao.selectUserAll();
		System.out.println("- selectUserAllTest()");
		System.out.println(userList);

		/*** Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(5, userList.size());
	}

	@Test
	public void selectUserTest() {
		/*** Given ***/
		IUserDao userDao = new UserDao();

		/*** When ***/
		UserVO user = userDao.selectUser(userId);
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
		IUserDao userDao = new UserDao();
		UserVO userVo = new UserVO();
		userVo.setUserId(userId);

		/*** When ***/
		UserVO user = userDao.selectUserByVo(userVo);
		System.out.println("\n- selectUserByVoTest()");
		System.out.println(user);

		/*** Then ***/
		assertEquals("브라운", user.getName());
		assertEquals("brown", user.getUserId());
		assertNotEquals("샐리", user.getName());
		assertNotNull(user);
	}
}
