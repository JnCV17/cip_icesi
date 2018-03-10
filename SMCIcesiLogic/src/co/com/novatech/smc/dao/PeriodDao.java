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

import co.com.novatech.smc.modelo.Period;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "PeriodDao", mappedName = "SMCIcesi-SMCIcesiLogic-PeriodDao")
public class PeriodDao implements IPeriodDao {

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
	public PeriodDao() {
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
	public Period persistPeriod(Period period) {
		em.persist(period);
		return period;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Period mergePeriod(Period period) {
		return em.merge(period);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removePeriod(Period period) {
		period = em.find(Period.class, period.getIdPeriod());
		em.remove(period);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Period> getPeriodFindAll() {
		return em.createNamedQuery("Period.findAll").getResultList();
	}

	 
	public Period findByIdPeriod(long idPeriod) {

		return em.find(Period.class, idPeriod);
	}

}
