/*
 * Class: CMSC203 
 * Instructor: Professor Thai
 * Description: Make Caesar and Bellaso Ciphers
 * Due: 3/25/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Daniel Truong
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Crypto_JUnit_GFA_Test {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
		assertTrue(CryptoManager.stringInBounds("HELLO WORLD"));
		assertTrue(CryptoManager.stringInBounds("IFMMP!XPSME"));
	}
}
