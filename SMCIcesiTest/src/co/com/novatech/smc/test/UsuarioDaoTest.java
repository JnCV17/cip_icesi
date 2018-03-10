package co.com.novatech.smc.test;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.dao.IUserCipRolCipDao;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class UsuarioDaoTest {

	private static IUserCipDao usuarioDaoRemote;
	// private static final Logger log =
	// LoggerFactory.getLogger(UsuarioLogicaTest.class);

	private static IUserCipRolCipDao user;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			usuarioDaoRemote = (IUserCipDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IUSERDAO);

			user = (IUserCipRolCipDao) new InitialContext(pruebasUtil.getProperties()).lookup(
					"java:global/SMCIcesi/SMCIcesiLogic/UserCipRolCipDao!co.com.novatech.smc.dao.IUserCipRolCipDao");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	// conectar al usuario 5
	@Test
	public void bconsultarUsuario() throws Exception {
		try {

			for (int i = 6; i < 10; i++) {
				System.out.println(usuarioDaoRemote.findByIdUserCip(i + 20).getNameUser());
			}

		} catch (EJBException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void findAllUsers() throws Exception {

		List<UserCip> all = usuarioDaoRemote.getUserCipFindAll();

		for (int i = 6; i < 20; i++) {
			System.out.println(all.get(i).getNameUser());
		}

	}

	@Test
	public void findRolByUSer() throws Exception {

		List<UserCip> all = user.findUserByRole(4);

		for (UserCip roleCip : all) {
			System.out.println(roleCip.getNameUser());
		}
	}

}
