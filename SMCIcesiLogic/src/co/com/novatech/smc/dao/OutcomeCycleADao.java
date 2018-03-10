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

import co.com.novatech.smc.modelo.OutcomeCycleA;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "OutcomeCycleADao", mappedName = "SMCIcesi-SMCIcesiLogic-OutcomeCycleADao")
public class OutcomeCycleADao implements IOutcomeCycleADao {

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
	public OutcomeCycleADao() {
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
	 
	public OutcomeCycleA persistOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		em.persist(outcomeCycleA);
		return outcomeCycleA;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public OutcomeCycleA mergeOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		return em.merge(outcomeCycleA);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeOutcomeCycleA(OutcomeCycleA outcomeCycleA) {

		outcomeCycleA = em.find(OutcomeCycleA.class, outcomeCycleA.getIdOutcoCycle());
		em.remove(outcomeCycleA);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<OutcomeCycleA> getOutcomeCycleAFindAll() {
		return em.createNamedQuery("OutcomeCycleA.findAll").getResultList();
	}

	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public OutcomeCycleA getOutcomeCycleAFindById(Long idOutcomeCycleA) {

		return em.find(OutcomeCycleA.class, idOutcomeCycleA);
	}

	 
	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo) {

		Query o = em.createQuery(
				"SELECT out FROM OutcomeCycleA out WHERE out.outcome.idStOutcome =:id AND out.mainCycle.idCycle=:id2");

		o.setParameter("id", idOutcome);
		o.setParameter("id2", idciclo);

		return (OutcomeCycleA) o.getSingleResult();

	}

	public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome) {

		Query o = em.createQuery("SELECT out.idCycle FROM OutcomeCycleA out WHERE out.outcome.idStOutcome =:id");

		o.setParameter("id", idOutcome);

		return o.getResultList();

	}

}
