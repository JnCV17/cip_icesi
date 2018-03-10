package co.com.novatech.smc.test.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

import com.sun.jersey.core.util.Base64;

import co.com.novatech.smc.dao.IUserCipDao;

public class EncryptHelper {

	PrintWriter out;

	private static IUserCipDao userCip;

	static {

		userCip = (IUserCipDao) LookUpClass.lookUp(userCip, InfoLookUp.IUSERDAO);
	}

	private SecretKey key;

	private Cipher cipher;

	@Test
	public void changeAllPasswords() throws IOException {
		// initWritter();
		// out.write("#ID\t\t\t\t\tNAME\t\t\t\t\t\t\tPASSWORD\n");
		// for (int i = 300; i < 301; i++) {
		// UserCip usr = userCip.findByIdUserCip(i);
		// String name = new StringTokenizer(usr.getNameUser()).nextToken();
		// String generatedPass = generatePassword(name);
		// System.out.println(usr.getIdentification() + "\t\t" +
		// usr.getNameUser() + "\t\t" + generatedPass + "\n");
		// out.write(usr.getIdentification() + "\t\t" + usr.getNameUser() +
		// "\t\t" + generatedPass + "\n");
		// System.out.println(generatedPass);
		// usr.setPasswordUser(encrypt(generatedPass));
		// userCip.mergeUserCip(usr);

		// usr = userCip.findByIdUserCip(6);
		// System.out.println(usr.getPasswordUser());
		// System.out.println("Decrypted: " +
		// decrypt(usr.getPasswordUser()));
		// }
		// out.flush();
		// out.close();
	}

	private String generatePassword(String name) {
		SecureRandom sr = new SecureRandom();
		int digi1 = sr.nextInt(10);
		int digi2 = sr.nextInt(10);
		int digi3 = sr.nextInt(10);
		int digi4 = sr.nextInt(10);

		String cad = name + "" + digi1 + "" + digi2 + "" + digi3 + "" + digi4;
		return cad;
	}

	private void initWritter() throws IOException {
		out = new PrintWriter(new BufferedWriter(new FileWriter(new File("passwords_smc.txt"))));
	}

	private String encrypt(String unencryptedString) {
		String encryptedString = null;
		try {
			initEncryptionVars();
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes("UTF-8");
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encode(encryptedText));
		} catch (Exception e) {
			System.out.println("Cause: " + e.getMessage() + ", in: " + e.getClass());
		}
		return encryptedString;
	}

	private String decrypt(String encryptedString) {
		String decryptedText = null;
		try {
			initEncryptionVars();
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedText = Base64.decode(encryptedString);
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedText;
	}

	private void initEncryptionVars() throws Exception {
		String myEncryptionKey = "novatechsmcicesi";
		String encAlgotihm = "AES";
		key = new SecretKeySpec(myEncryptionKey.getBytes(), encAlgotihm);
		cipher = Cipher.getInstance(encAlgotihm);
	}
}
