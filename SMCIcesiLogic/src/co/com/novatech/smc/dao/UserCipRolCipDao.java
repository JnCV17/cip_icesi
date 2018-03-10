package co.com.novatech.smc.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "UserCipRolCipDao", mappedName = "SMCIcesi-SMCIcesiLogic-UserCipRolCipDao")
public class UserCipRolCipDao implements IUserCipRolCipDao {

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName = "SMCIcesiLogic")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public UserCipRolCipDao() {
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public UserCipRoleCip persistUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		em.persist(userCipRoleCip);
		return userCipRoleCip;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public UserCipRoleCip mergeUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		return em.merge(userCipRoleCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		userCipRoleCip = em.find(UserCipRoleCip.class, userCipRoleCip.getIdUserCipRole());
		em.remove(userCipRoleCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UserCipRoleCip> getUserCipRoleCipFindAll() {
		return em.createQuery("SELECT u FROM UserCipRoleCip u").getResultList();
	}

	 
	public UserCipRoleCip findByIdUserCipRoleCip(long idUserCipRoleCip) {
		return em.find(UserCipRoleCip.class, idUserCipRoleCip);
	}

	 
	public List<RoleCip> findRoleByUser(long id) {

		Query o = em.createQuery("SELECT rol.roleCip FROM UserCipRoleCip rol WHERE rol.userCip.idUser =:id");

		o.setParameter("id", id);

		return o.getResultList();

	}

	 
	public List<UserCip> findUserByRole(long idRole) {

		Query o = em.createQuery("SELECT rol.userCip FROM UserCipRoleCip rol WHERE rol.roleCip.idRole =:id");

		o.setParameter("id", idRole);

		return o.getResultList();

	}

	 
	public List<UserCipRoleCip> findByUserAndRole(long idUser, long idRole) {

		Query o = em.createQuery(
				"SELECT userCipRoleCip FROM UserCipRoleCip userCipRoleCip WHERE userCipRoleCip.roleCip.idRole =:idRole AND userCipRoleCip.userCip.idUser =:idUser");

		o.setParameter("idRole", idRole);
		o.setParameter("idUser", idUser);
		return o.getResultList();
	}

}
