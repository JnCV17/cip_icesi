package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IStateTypeDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.StateType;

@Stateless
public class StateTypeLogic implements IStateTypeLogic {

	@EJB
	private IStateTypeDao stateTypeDao;

	@TransactionAttribute
	public StateType findByIdStateType(long id) throws ZMessManager {
		StateType stateType = null;

		if (id == 0) {
			throw new ZMessManager().new EmptyFieldException("Id state type");
		}

		stateType = stateTypeDao.findById(id);
		return null;
	}

	@TransactionAttribute
	public List<StateType> findAllStateType() {

		return stateTypeDao.getStateTypeFindAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveStateType(StateType stateType) {
		if (stateType == null) {
			throw new ZMessManager().new NullEntityExcepcion("State type");
		}

		if (stateTypeDao.findById(stateType.getIdStateType()) != null) {
			throw new ZMessManager().new FindingException("State type");
		}

		if (stateType.getStateTypeName() == null || stateType.getStateTypeName().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("State type name");
		}

		stateTypeDao.persistStateType(stateType);

	}

}
