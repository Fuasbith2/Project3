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

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; // 64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for(int i=0; i < plainText.length(); i++)
		{
			if(plainText.charAt(i)<LOWER_BOUND || plainText.charAt(i)>UPPER_BOUND) // checks if the character is within Range
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		int newKey = key;
		String newString = "";
		while(newKey>UPPER_BOUND) // if the key is too big subtract it by 64 until its within Range
		{
			newKey -= RANGE;
		}
		
		for(int i=0; i<plainText.length(); i++)
		{
			int revisedKey = newKey;
			char replace;
			if(plainText.charAt(i) + newKey>UPPER_BOUND)
			{
				revisedKey = (newKey - (UPPER_BOUND - plainText.charAt(i))) + 31;
				replace = (char) revisedKey;
			}
			else
			{
			replace = (char) (plainText.charAt(i) + revisedKey);
			}
			newString += replace;
		}
		return newString;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) { 
		String newString = "";
		String newBellaso = bellasoStr;
		
		if(bellasoStr.length()<plainText.length())    // lengthens bellaso string to same length as plainText by repeating itself
		{
			int x = bellasoStr.length();
			for(int i = 0; ; i++)
			{
			    if (x == i)
			    	i = 0;
			    if (plainText.length() == newBellaso.length())
			        break;
			      newBellaso +=(bellasoStr.charAt(i));
			 }
		}
		
		for(int i=0; i < plainText.length(); i++) // does the encrypting
		{
			int p = plainText.charAt(i);
			int b = newBellaso.charAt(i);
			char replace = (char) (p + b);
			while(replace > UPPER_BOUND)
			{
				replace -= RANGE;
			}
			newString += replace;
		}
		
		return newString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		int newKey = key;
		String newString = "";
		while(newKey>UPPER_BOUND)
		{
			newKey -= RANGE;
		}
		
		for(int i=0; i<encryptedText.length(); i++)
		{
			int revisedKey = newKey;
			char replace;
			if(encryptedText.charAt(i) - newKey<LOWER_BOUND)
			{
				revisedKey = 96 - (newKey - (encryptedText.charAt(i) - LOWER_BOUND));
				replace = (char) revisedKey;
			}
			else
			{
			replace = (char) (encryptedText.charAt(i) - revisedKey);
			}
			newString += replace;
		}
		return newString;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String newString = "";
		String newBellaso = bellasoStr;
		
		if(bellasoStr.length()<encryptedText.length())    // lengthens bellaso string to same length as plainText by repeating itself
		{
			int x = bellasoStr.length();
			for(int i = 0; ; i++)
			{
			    if (x == i)
			    	i = 0;
			    if (encryptedText.length() == newBellaso.length())
			        break;
			      newBellaso +=(bellasoStr.charAt(i));
			 }
		}
		
		for(int i=0; i < encryptedText.length(); i++) // does the decrypting
		{
			int originalChar = ((encryptedText.charAt(i) + RANGE) - newBellaso.charAt(i));
			newString += (char)originalChar;
		}
		
		return newString;
	}
}
