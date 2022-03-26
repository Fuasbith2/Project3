
public class test {
	public static void main(String args[])
	{
	/*	String s = CryptoManager.encryptBellaso("TESTING", "CIPHER_IS_LONGER_THAN_\n"+ "THE_PLAIN_TEXT\n"+ "");
		System.out.println(s);
		System.out.println(CryptoManager.decryptBellaso(s, "CIPHER_IS_LONGER_THAN_\n"
				+ "THE_PLAIN_TEXT\n"
				+ ""));
		*/
		String str4 = "bac";
		System.out.println("Caesar cipher of \""+str4+"\" should return \"UFTUJOH\":   "+ CryptoManager.encryptCaesar(str4, 1));
	}

}
