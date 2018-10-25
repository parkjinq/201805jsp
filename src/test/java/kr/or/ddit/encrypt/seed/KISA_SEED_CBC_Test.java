package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class KISA_SEED_CBC_Test {

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	* Method : EncryptTest
	* 작성자 : jin
	* 변경이력 :
	* Method 설명 : seed encrypt 체스트
	 */
	@Test
	public void encryptTest() {
		/***Given***/
		String password = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(password);
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(password, decrypt);
	}

}
