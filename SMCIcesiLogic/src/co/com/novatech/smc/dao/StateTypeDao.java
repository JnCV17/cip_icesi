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

import co.com.novatech.smc.modelo.StateType;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "SessionBeanStateType", mappedName = "SMCIcesiLogic-SessionBeanStateType")
public class StateTypeDao implements IStateTypeDao {

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
	public StateTypeDao() {
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
	public StateType persistStateType(StateType stateType) {
		em.persist(stateType);
		return stateType;
	}

	/**
	 * @generated DT_ID=none
	 */
	public StateType mergeStateType(StateType stateType) {
		return em.merge(stateType);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeStateType(StateType stateType) {
		stateType = em.find(StateType.class, stateType.getIdStateType());
		em.remove(stateType);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<StateType> getStateTypeFindAll() {
		return em.createNamedQuery("StateType.findAll").getResultList();
	}

	 
	public StateType findById(long id) {

		return em.find(StateType.class, id);
	}

}
