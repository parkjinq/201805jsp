package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class PagrEtcTest {

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	* Method : pageNaviCalTest
	* 작성자 : jin
	* 변경이력 :
	* Method 설명 : 페이지 네비게이션 계산 테스트
	 */
	@Test
	public void pageNaviCalTest() {
		/***Given***/
		int totalUserCnt = 105;
		int pageSize = 10;

		/***When***/
		//천장함수, 바닥함수
//		int naviSize = (totalUserCnt / pageSize) + 1;
		int naviSize = (int) (Math.ceil(((double)totalUserCnt / pageSize)));
		
		/***Then***/
		assertEquals(11, naviSize);
	}

}
