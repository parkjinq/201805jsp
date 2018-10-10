package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	
	private String userId = "brown";
	private IUserService service;
	
	//				JUNIT 실행주기
	//@BeforeClass 어노테이션이 적용된 메소드 실행(최초 1회)
	//@Before 어노테이션이 적용된 메서드 실행(테스트 메서드 실행전 실행)
	//@Test
	//@After 어노테이션이 적용된 메서드 실행(테스트 메서드 실행후 실행)
	//@AfterClass 어노테이션이 적용된 메서드 실행(최초 1회)

	// @BeforeClass 
	// > @Before > @Test > @After 
	// > @Before > @Test > @After 
	// > @Before > @Test > @After 
	// > @AfterClass
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("─────────────────────────");
		System.out.println("	@BeforeClass");
		System.out.println("─────────────────────────");
	}
	
	@Before
	public void before(){
		System.out.println("─────────────────────────");
		System.out.println("	@Before");
		System.out.println("─────────────────────────");
		
		service = new UserService();
	}
	
	@After
	public void after(){
		System.out.println("─────────────────────────");
		System.out.println("	@After");
		System.out.println("─────────────────────────");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("─────────────────────────");
		System.out.println("	@AfterClass");
		System.out.println("─────────────────────────");
	}
	
	@Test
	public void selectUserAllTest() {

		/*** Given : 주어진 상황 ***/
		List<UserVO> userList = null;
		
		/*** When : 어떤 동작 수행(메소드 호출) ***/

		userList = service.selectUserAll();
		System.out.println("- selectUserAllTest()");
		System.out.println(userList);

		/*** Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(5, userList.size());
	}

	@Test
	public void selectUserTest() {
		
		/*** Given ***/
		UserVO user = null;
		
		/*** When ***/
		user = service.selectUser(userId);
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
		UserVO user =null;
		
		UserVO userVo = new UserVO();
		userVo.setUserId(userId);

		/*** When ***/
		user = service.selectUserByVo(userVo);
		System.out.println("\n- selectUserByVoTest()");
		System.out.println(user);

		/*** Then ***/
		assertEquals("브라운", user.getName());
		assertEquals("brown", user.getUserId());
		assertNotEquals("샐리", user.getName());
		assertNotNull(user);
	}
}
