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

import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "PiDao", mappedName = "SMCIcesi-SMCIcesiLogic-PiDao")
public class PiDao implements IPiDao {

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
	public PiDao() {
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
	 
	public PiSmc persistPi(PiSmc pi) {
		em.persist(pi);
		return pi;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public PiSmc mergePi(PiSmc pi) {
		return em.merge(pi);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removePi(PiSmc pi) {
		pi = em.find(PiSmc.class, pi.getIdPi());
		em.remove(pi);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PiSmc> getPiFindAll() {
		return em.createNamedQuery("Pi.findAll").getResultList();
	}

	 
	public PiSmc findById(Long id) {
		return em.find(PiSmc.class, id);
	}

	 
	public PiSmc findByPlan(PlanSmc plan) {
		long idPlan = plan.getIdPlan();
		Query query = em.createQuery("SELECT p FROM Pi p WHERE p.plan.idPlan=:idPlan");
		query.setParameter("idPlan", idPlan);
		return (PiSmc) query.getSingleResult();
	}

	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PiSmc> findAllPisByPlan(long idPlan) {

		Query query = em.createQuery("SELECT p FROM PiSmc p WHERE p.planSmc.idPlan=:idPlan");
		query.setParameter("idPlan", idPlan);
		return query.getResultList();
	}

}
