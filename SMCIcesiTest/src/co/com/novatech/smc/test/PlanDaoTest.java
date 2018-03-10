package co.com.novatech.smc.test;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IPlanDao;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class PlanDaoTest {

	private static IPlanDao planDaoRemote;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			planDaoRemote = (IPlanDao) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.IPLANDAO);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void bconsultarPlan() throws Exception {

		PlanSmc plan = planDaoRemote.findByid(1);

		System.out.println(plan.getIdPlan() + plan.getUserCip().getNameUser());

	}

	@Test
	public void findAllPlanes() throws Exception {

		try {

			List<PlanSmc> all = planDaoRemote.getPlanFindAll();

			for (int i = 0; i < all.size(); i++) {
				System.out.println(
						all.get(i).getIdPlan() + " " + "Usuario:" + " " + all.get(i).getUserCip().getNameUser());
			}

		} catch (EJBException e) {

			e.printStackTrace();
		}

	}

}
