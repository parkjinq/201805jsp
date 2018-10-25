package kr.or.ddit.encrypt.sha;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class KISA_SHA256_Test {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void encryptTest() {
		/***Given***/
		String password = "brownpass";
		String password1 = "brownpast";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(password);
		String encrypt1 = KISA_SHA256.encrypt(password1);
		System.out.println(encrypt);
		System.out.println(encrypt1);
		
		/***Then***/
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);
	}

}
