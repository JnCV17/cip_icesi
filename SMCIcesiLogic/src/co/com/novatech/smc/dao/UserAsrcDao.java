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

import co.com.novatech.smc.modelo.UserAsSrc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "IUserAsrcDao", mappedName = "SMCIcesi-SMCIcesiLogic-IUserAsrcDao")
public class UserAsrcDao implements IUserAsrcDao {

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
	public UserAsrcDao() {
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
	public UserAsSrc persistUserAsSrc(UserAsSrc userAsSrc) {
		em.persist(userAsSrc);
		return userAsSrc;
	}

	/**
	 * @generated DT_ID=none
	 */
	public UserAsSrc mergeUserAsSrc(UserAsSrc userAsSrc) {
		return em.merge(userAsSrc);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeUserAsSrc(UserAsSrc userAsSrc) {
		userAsSrc = em.find(UserAsSrc.class, userAsSrc.getIdUserAsSrc());
		em.remove(userAsSrc);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UserAsSrc> getUserAsSrcFindAll() {
		return em.createNamedQuery("UserAsSrc.findAll").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UserAsSrc findById(long idUserAsSrc) {
		return em.find(UserAsSrc.class, idUserAsSrc);
	}

}
