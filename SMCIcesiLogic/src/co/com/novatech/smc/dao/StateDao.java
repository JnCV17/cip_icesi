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

import co.com.novatech.smc.modelo.StateSmc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "SessionBeanState", mappedName = "SMCIcesiLogic-SessionBeanState")
public class StateDao implements IStateDao {

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
	public StateDao() {
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
	public StateSmc persistState(StateSmc state) {
		em.persist(state);
		return state;
	}

	/**
	 * @generated DT_ID=none
	 */
	public StateSmc mergeState(StateSmc state) {
		return em.merge(state);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeState(StateSmc state) {
		state = em.find(StateSmc.class, state.getIdState());
		em.remove(state);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<StateSmc> getStateFindAll() {
	
		return em.createNamedQuery("StateSmc.findAll").getResultList();
	}


	 
	public StateSmc findById(long id) {
		return em.find(StateSmc.class, id);
	}

}
