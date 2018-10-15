package kr.or.ddit.etc;

import static org.junit.Assert.*;
import kr.or.ddit.util.StringUtil;

import org.junit.After;
import org.junit.Test;

public class StringUtilTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void stringUtilTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"ddit.png\"";

		/***When***/
		//logic
		String fileName = "";
		//indexOf사용
//		int index = contentDisposition.lastIndexOf("filename=\"");
//		String fileName = contentDisposition.substring(index+10, contentDisposition.length()-1);
		
		//split사용
		String[] fileNameList  = contentDisposition.split(";");
		String condition = "filename=\"";
		for(String str : fileNameList){
			if(str.contains(condition)){
				fileName = str.substring(condition.length()+1, str.length()-1);
			}
		}
		
		/***Then***/
		assertEquals("ddit.png", fileName);
	}
	
	@Test
	public void getCookie(){
		/***Given***/
		String cookieString = "remember=Y; userId=brown; etc=test";

		/***When***/
		String cookieValue = StringUtil.getCookie(cookieString, "remember");
		String cookieValue2 = StringUtil.getCookie(cookieString, "userId");
		
		/***Then***/
		assertEquals("Y", cookieValue);
		assertEquals("brown", cookieValue2);

	}

}
