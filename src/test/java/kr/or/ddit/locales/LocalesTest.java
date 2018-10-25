package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.After;
import org.junit.Test;

public class LocalesTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void localesTest() {
		/***Given***/
		

		/***When***/
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale l : locales){
			System.out.println(l);
		}
		/***Then***/

		
		assertEquals("", "");
	}

}
