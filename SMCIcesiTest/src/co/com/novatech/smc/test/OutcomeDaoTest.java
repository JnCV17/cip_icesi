package co.com.novatech.smc.test;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IOutcomeDao;
import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

//@ApplicationException(rollback = false)
public class OutcomeDaoTest {

	private static IOutcomeDao outcomeDaoRemote;
	private static IUserCipDao userRemote;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			outcomeDaoRemote = (IOutcomeDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IOUTCOMEDAO);

			userRemote = (IUserCipDao) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.IUSERDAO);
		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aModificarOutcome() {
		try {

			Outcome outcome = outcomeDaoRemote.findbyid(28);
			UserCip user = userRemote.findByIdUserCip(9);

			// System.out.println("Lider de outcome actual" +
			// outcome.getUserCip().getNameUser() + "prueba modificar");
//
//			outcome.setCriterion(outcome.getCriterion());
//			outcome.setDescription(outcome.getDescription());
//			outcome.setProgramSmc(outcome.getProgramSmc());
//			outcome.setShortDescription(outcome.getShortDescription());
//			outcome.setStateSmc(outcome.getStateSmc());
//			outcome.setIdStOutcome(outcome.getIdStOutcome());

			outcome.setUserCip(user);
			 outcomeDaoRemote.mergeOutcome(outcome);

			System.out.println("Lider de outcome actual" + outcome.getUserCip().getNameUser() + "prueba modificar");

		} catch (EJBException e) {
			e.printStackTrace();
		}

	}

	// @Test
	// public void bconsultarOutcome() throws Exception {
	//
	// Outcome outcome= outcomeDaoRemote.findbyid(13);
	//
	// System.out.println(outcome.getShortDescription() + "prueba consultar");
	//
	//
	//
	// }
	//
	// @Test
	// public void findAllOutcome() throws Exception {
	//
	// List<Outcome> all= outcomeDaoRemote.getOutcomeFindAll();
	//
	// for (int i = 0; i < all.size(); i++) {
	// System.out.println(all.get(i).getShortDescription() );
	// }
	// }
	
	@Test
	public void findOutcomeByUser() throws Exception {
	
	//List<Outcome> all=  ( outcomeDaoRemote).findOutcomeByUserAndProgram(6, "IND");	
		
//	for (Outcome outcome : all) {
//		System.out.println(outcome.getCriterion());
//	}

	
	}

}
