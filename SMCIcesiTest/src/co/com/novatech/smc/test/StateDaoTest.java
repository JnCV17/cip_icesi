package co.com.novatech.smc.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IStateDao;
import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class StateDaoTest {

	private static IStateDao stateDao;
	


	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			stateDao = (IStateDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.ISTATEDAO);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}


	@Test
	public void consultarDao() throws Exception {
		try {


			for (int i = 3; i < 10; i++) {
				System.out.println(stateDao.findById(i).getStateName() + " prueba 1");
			}

		} catch (EJBException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void findAllUsers() throws Exception {

		List<StateSmc> all = stateDao.getStateFindAll(); 

		for (int i = 0; i < all.size(); i++) {
			System.out.println(all.get(i).getStateName());
		}


	}

}
