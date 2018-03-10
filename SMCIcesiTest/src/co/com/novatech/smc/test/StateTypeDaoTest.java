package co.com.novatech.smc.test;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IStateTypeDao;
import co.com.novatech.smc.modelo.StateType;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class StateTypeDaoTest {

	private static IStateTypeDao stateDaoRemote;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			stateDaoRemote = (IStateTypeDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.ISTATETYPEDAO);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aConsultarStateType() {

		try {

			for (int i = 1; i < 5; i++) {

				System.out.println(stateDaoRemote.findById(i).getIdStateType() + " "
						+ stateDaoRemote.findById(i).getStateTypeName());
			}

		} catch (EJBException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void bConsultarTodoStateType() {

		List<StateType> all = stateDaoRemote.getStateTypeFindAll();

		try {

			System.out.println("Buscar Todo:");
			for (int i = 0; i < all.size(); i++) {

				System.out.println(all.get(i).getIdStateType() + " " + all.get(i).getStateTypeName());
			}

		} catch (Exception e) {

		}

	}
}
