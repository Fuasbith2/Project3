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

public class CryptoManager_GFA_Test {

	public static void main(String[] args) {

		String str1 = "\"THIS TEST SHOULD SUCCEED\"";
		String str4 = "HELLO WORLD";
		String str5 = "IFMMP!XPSME";


		boolean good = CryptoManager.stringInBounds(str5);
		System.out.println(str5+" Is it in bounds? "+good);
	}
}
