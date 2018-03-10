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

import co.com.novatech.smc.modelo.OutcomeLog;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "OutcomeLogDao", mappedName = "SMCIcesi-SMCIcesiLogic-OutcomeLogDao")
public class OutcomeLogDao implements IOutcomeLogDao {

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
	public OutcomeLogDao() {
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
	public OutcomeLog persistOutcomeLog(OutcomeLog outcomeLog) {
		em.persist(outcomeLog);
		return outcomeLog;
	}

	/**
	 * @generated DT_ID=none
	 */
	public OutcomeLog mergeOutcomeLog(OutcomeLog outcomeLog) {
		return em.merge(outcomeLog);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeOutcomeLog(OutcomeLog outcomeLog) {
		outcomeLog = em.find(OutcomeLog.class, outcomeLog.getIdOutcomeLog());
		em.remove(outcomeLog);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<OutcomeLog> getOutcomeLogFindAll() {
		return em.createNamedQuery("OutcomeLog.findAll").getResultList();
	}

}
