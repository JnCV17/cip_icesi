package co.com.novatech.smc.test.logic;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IOutcomeDao;
import co.com.novatech.smc.logic.IAssignOutcomeLogic;
import co.com.novatech.smc.logic.IRoleCipLogic;
import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.logic.IUserCipRoleCipLogic;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class AssignOutcomeLogicTest {

	private static IAssignOutcomeLogic assignOutcomeLogic;
	private static IOutcomeDao outcomeLogic;
	private static IRoleCipLogic roleCipLogic;
	private static IUserCipLogic userCipLogic;
	private static IUserCipRoleCipLogic userCipRole;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			assignOutcomeLogic = (IAssignOutcomeLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IASSIGNOUTCOMELOGIC);
			outcomeLogic = (IOutcomeDao) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.IOUTCOMEDAO);
			roleCipLogic = (IRoleCipLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IROLECIPLOGIC);
			userCipLogic = (IUserCipLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IUSERCIPLOGIC);

			userCipRole = (IUserCipRoleCipLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IUSERCIPROLELOGIC);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aDesasignarOutcome() throws Exception {

		try {
			Outcome out = outcomeLogic.findbyid(25);
			System.out.println(out.getDescription());

			assignOutcomeLogic.unassignOutcome(out);
			System.out.println("despues de desasignar" + out.getUserCip());
			// assertNull(out.getUserCip());
		} catch (EJBException e) {

			e.printStackTrace();
		}

	}

	// @Test
	// public void prueba() {
	// Outcome out = outcomeLogic.findbyid(23);
	// try {
	// List<UserCipRoleCip> user = userCipRole.findAllUserCipRoleCip();
	// System.out.println(user == null);
	//
	// for (UserCipRoleCip userCipRoleCip : user) {
	// System.out.println(userCipRoleCip.getRoleCip().getName());
	// }
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	//
	// // List<Outcome> roles =
	// // outcomeLogic.findOutcomeByUser(out.getUserCip().getIdUser());
	// //
	// // System.out.println(roles.get(0).getUserCip().getIdentification());
	// // System.out.println(roles == null);
	// // System.out.println(roles.size());
	//
	// }

	@Test
	public void aAsignarOutcome() throws Exception {
		try {
			Outcome out = outcomeLogic.findbyid(4L);
			UserCip user = userCipLogic.findByIdUser(6L);

			assignOutcomeLogic.toAssignOutcome(out, user);

			// asserNottNull(out.getUserCip());
		} catch (EJBException e) {
			e.printStackTrace();
		}

	}

}
