package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IStateDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.StateSmc;

@Stateless
public class StateLogic implements IStateLogic {

	@EJB
	private IStateDao stateDao;

	@TransactionAttribute
	public StateSmc findById(long id) throws ZMessManager {
		StateSmc state = null;

		if (id == 0) {
			throw new ZMessManager().new EmptyFieldException("id State");
		}

		state = stateDao.findById(id);

		return state;
	}

	@TransactionAttribute
	public List<StateSmc> findAllState() throws ZMessManager {

		return stateDao.getStateFindAll();

	}

}
