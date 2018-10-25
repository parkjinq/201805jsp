package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.After;
import org.junit.Test;

public class TimeZoneTest {

	@Test
	public void timeZoneTest() {
		
		/***Given***/
		

		/***When***/
		String[] timeZone = TimeZone.getAvailableIDs();
		
		for(String str : timeZone){
			System.out.println(str);
		}
		
		/***Then***/

		
		assertEquals("", "");
	}

}
