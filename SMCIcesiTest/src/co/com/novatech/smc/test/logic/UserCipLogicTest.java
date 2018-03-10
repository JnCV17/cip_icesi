package co.com.novatech.smc.test.logic;

import static org.junit.Assert.assertNotNull;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class UserCipLogicTest {

	private static IUserCipLogic usuarioDaoRemote;
	// private static final Logger log =
	// LoggerFactory.getLogger(UsuarioLogicaTest.class);

	private static IUserCipLogic usuarioDaoLogic;
	// private static final Logger log =
	// LoggerFactory.getLogger(UsuarioLogicaTest.class);

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			usuarioDaoLogic = (IUserCipLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IUSERCIPLOGIC);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	// @Test
	// public void bconsultarUsuario() throws Exception {
	// try {
	//
	//
	// for (int i = 6; i < 10; i++) {
	// System.out.println(usuarioDaoRemote.findByIdUser(i + 20).getNameUser() +
	// " prueba 1");
	//
	// for (int i = 6; i < 10; i++) {
	// System.out.println(usuarioDaoLogic.findByIdUser(i + 20).getNameUser() + "
	// prueba 1");
	//
	// }
	//
	// } catch (EJBException e) {
	// e.printStackTrace();
	//
	// }
	//
	// }

	// @Test
	// public void findAllUsers() throws Exception {
	//
	// try {
	// List<UserCip> all = usuarioDaoRemote.findAllUser();
	// System.out.println(all==null);
	// System.out.println(all.size());
	//
	// for (int i = 6; i < 20; i++) {
	// System.out.println(all.get(i).getNameUser() + " prueba 2");
	// }
	//
	// } catch (EJBException e) {
	//
	// }
	//
	//
	// //Revisar,
	// }

	// @Test
	// public void findAllMentorsUsers() throws Exception {
	//
	// try {
	// List<UserCip> all = usuarioDaoRemote.findAllMentorUser();
	//
	// for (int i = 6; i < 20; i++) {
	// System.out.println(all.get(i).getNameUser() +
	// "------------------------------");
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	//
	//
	// List<UserCip> all = usuarioDaoLogic.findAllUser();
	//
	// for (int i = 6; i < 20; i++) {
	// System.out.println(all.get(i).getNameUser() + " prueba 2");
	//
	// }
	//
	// }
	// }

	@Test
	public void validarUsuario() throws Exception {

		UserCip user = usuarioDaoLogic.findByIdUser(6);
		System.out.println(user.getIdentification());
		System.out.println(user.getPasswordUser());

		assertNotNull(usuarioDaoLogic.validateUser(user.getIdentification(), user.getPasswordUser()));

	}

}
