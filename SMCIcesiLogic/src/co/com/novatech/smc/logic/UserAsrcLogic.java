package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IUserAsrcDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.UserAsSrc;

@Stateless
public class UserAsrcLogic implements IUserAsrcLogic {

	@EJB
	private IUserAsrcDao userAsrcDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveUserAsrc(UserAsSrc userAsrc) throws ZMessManager {
		if (userAsrc == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc");
		}

		if (userAsrc.getUserCip() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc userCip");
		}
		if (userAsrc.getAsSrc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc AsSrc");
		}
		UserAsSrc entity = userAsrcDao.findById(userAsrc.getIdUserAsSrc());
		if (entity != null) {
			throw new ZMessManager().new FindingException("UserAsrc UserAsrc");
		}
		userAsrcDao.persistUserAsSrc(userAsrc);

	}

	@Override
	public UserAsSrc findByIdUserAsrc(long id) throws ZMessManager {

		return userAsrcDao.findById(id);
	}

	@Override
	public List<UserAsSrc> findAllUserAsrc() {
		return userAsrcDao.getUserAsSrcFindAll();
	}

	@Override
	public void updateUserAsrc(UserAsSrc userAsrc) {
		if (userAsrc == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc");
		}
		if (userAsrc.getIdUserAsSrc() == 0) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc code");
		}
		if (userAsrc.getUserCip() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc userCip");
		}
		if (userAsrc.getAsSrc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserAsrc AsSrc");
		}
		UserAsSrc entity = userAsrcDao.findById(userAsrc.getIdUserAsSrc());
		if (entity != null) {
			throw new ZMessManager().new FindingException("UserAsrc UserAsrc");
		}
		userAsrcDao.mergeUserAsSrc(userAsrc);

	}

}
