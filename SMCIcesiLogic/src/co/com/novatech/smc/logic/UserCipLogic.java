package co.com.novatech.smc.logic;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.sun.jersey.core.util.Base64;

import co.com.novatech.smc.dao.IRoleCIPDao;
import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.dao.IUserCipRolCipDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

@Stateless
public class UserCipLogic implements IUserCipLogic {

	@EJB
	private IUserCipDao userCipDao;

	@EJB
	private IUserCipRolCipDao userCipRoleCip;
	@EJB
	private IRoleCIPDao roleCIPDao;

	private SecretKey key;

	private Cipher cipher;

	@TransactionAttribute
	public UserCip findByIdUser(long idUser) {

		return userCipDao.findByIdUserCip(idUser);
	}

	@TransactionAttribute
	public List<UserCip> findAllUser() {
		return userCipDao.getUserCipFindAll();
	}

	@TransactionAttribute
	public List<UserCip> findAllMentorUser() {
		List<UserCip> users = findAllUser();
		List<UserCip> profesores = new ArrayList<UserCip>();

		for (UserCip userCip : users) {

			List<UserCipRoleCip> roles = null;
			for (UserCipRoleCip userCipRoleCip : roles) {
				if (userCipRoleCip.getRoleCip().getIdRole() == 4L) {
					profesores.add(userCip);
				}
			}
		}
		return profesores;
	}

	public String encrypt(String unencryptedString) {
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

	public String decrypt(String encryptedString) {
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

	private UserCip findByUsername(String username) throws Exception {
		try {
			List<UserCip> lista = userCipDao.findByUsername(username);
			if (lista == null || lista.size() != 1) {
				throw new Exception("Nombre de usuario o contraseña inválidos");
			}
			return lista.get(0);
		} catch (Exception e) {
			throw e;
		}
	}

	public UserCip validateUser(String username, String password) throws Exception {
		if (username.trim().equals("") || password.trim().equals("")) {
			throw new ZMessManager("Password or username must not be blank spaces");
		}
		UserCip userCip = findByUsername(username);
		if (userCip == null) {
			throw new Exception("There is no user in the system with that username");
		}

		StateSmc stateSmc = userCip.getStateSmc();
		if (stateSmc.getStateName().equals("INACTIVO")) {
			throw new ZMessManager("User is inactive");
		}

		if (!userCip.getPasswordUser().equals(password)) {
			throw new Exception("Incorrect password! Try again");
		}

		return userCip;
	}

	public List<ProgramSmc> getFindProgramByDirector(long idDir) {

		return userCipDao.getFindProgramByDirector(idDir);
	}

}
