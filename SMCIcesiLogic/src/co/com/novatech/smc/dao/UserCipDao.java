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

import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "UserCipDao", mappedName = "SMCIcesi-SMCIcesiLogic-UserCipDao")
public class UserCipDao implements IUserCipDao {

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
	public UserCipDao() {
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
	 
	public UserCip persistUserCip(UserCip userCip) {
		em.persist(userCip);
		return userCip;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public UserCip mergeUserCip(UserCip userCip) {
		return em.merge(userCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeUserCip(UserCip userCip) {
		userCip = em.find(UserCip.class, userCip.getIdUser());
		em.remove(userCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UserCip> getUserCipFindAll() {
		return em.createNamedQuery("UserCip.findAll").getResultList();
	}

	 
	public UserCip findByIdUserCip(long idUser) {

		return em.find(UserCip.class, idUser);

	}

	 
	public List<UserCip> findByUsername(String username) {
		Query consul = em.createQuery("SELECT usr FROM UserCip usr WHERE usr.identification=:usrname");
		consul.setParameter("usrname", username);
		// List<UserCip> result = consul.getResultList();
		// System.out.println(result.size());
		return consul.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProgramSmc> getFindProgramByDirector(long idDir) {

		Query o = em.createQuery("SELECT p FROM ProgramSmc p where p.userCip.idUser =:id");

		o.setParameter("id", idDir);

		return o.getResultList();

	}
}
