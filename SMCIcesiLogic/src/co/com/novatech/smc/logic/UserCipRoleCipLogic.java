package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IUserCipRolCipDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

@Stateless
public class UserCipRoleCipLogic implements IUserCipRoleCipLogic {

	@EJB
	private IUserCipRolCipDao userCipRoleCipDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws Exception {
		if (userCipRoleCip == null) {

			throw new ZMessManager().new NullEntityExcepcion("userCipRoleCip");
		}

		UserCipRoleCip entity = userCipRoleCipDao.findByIdUserCipRoleCip(userCipRoleCip.getIdUserCipRole());

		if (entity != null) {

			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		if (userCipRoleCip.getRoleCip() == null) {

			throw new ZMessManager().new NullEntityExcepcion("RoleCip");
		}

		if (userCipRoleCip.getUserCip() == null) {

			throw new ZMessManager().new NullEntityExcepcion("UserCip");
		}
		userCipRoleCipDao.persistUserCipRoleCip(userCipRoleCip);
	}

	@TransactionAttribute
	public UserCipRoleCip findByIdUserCipRoleCip(long userCipRoleCipId) throws Exception {

		return userCipRoleCipDao.findByIdUserCipRoleCip(userCipRoleCipId);
	}

	@TransactionAttribute
	public List<UserCipRoleCip> findAllUserCipRoleCip() {
		return userCipRoleCipDao.getUserCipRoleCipFindAll();
	}

	public List<UserCip> findUserByRole(long idRole) {
		return userCipRoleCipDao.findUserByRole(idRole);
	}

	public List<RoleCip> findRoleByUser(long id) {
		return userCipRoleCipDao.findRoleByUser(id);
	}

	public List<UserCipRoleCip> findByUserAndRole(long idUser, long idRole) {

		return userCipRoleCipDao.findByUserAndRole(idUser, idRole);
	}

	@Override
	public void removeUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		userCipRoleCipDao.removeUserCipRoleCip(userCipRoleCip);

	}

}
