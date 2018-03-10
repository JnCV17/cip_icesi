package co.com.novatech.smc.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.novatech.smc.logic.PlanLogic;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.PlanSmc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "PlanDao", mappedName = "SMCIcesi-SMCIcesiLogic-PlanDao")
public class PlanDao implements IPlanDao {

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
	public PlanDao() {
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
	@Override
	public PlanSmc persistPlan(PlanSmc plan) {
		em.persist(plan);
		return plan;
	}

	/**
	 * @generated DT_ID=none
	 */
	@Override
	public PlanSmc mergePlan(PlanSmc plan) {
		return em.merge(plan);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removePlan(PlanSmc plan) {
		plan = em.find(PlanSmc.class, plan.getIdPlan());
		em.remove(plan);
	}

	/**
	 * @generated DT_ID=none
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PlanSmc> getPlanFindAll() {
		return em.createQuery("SELECT p FROM PlanSmc p").getResultList();
	}

	@Override
	public List<PlanSmc> findByDateOfCreation(Date dateOfCreation) {
		Query consulta = em.createQuery("Select plan From PlanSmc plan Where plan.creationDate=:date");
		consulta.setParameter("date", dateOfCreation);
		return consulta.getResultList();
	}

	@Override
	public PlanSmc findPlanByOutcome(long idOutcome) {
		Query consulta = em
				.createQuery("Select plan From PlanSmc plan Where plan.outcomeCycleA.idOutcoCycle=:idOutcome");
		consulta.setParameter("idOutcome", idOutcome);
		return (PlanSmc) consulta.getSingleResult();
	}

	@Override
	public List<MainCycle> findByMainCycle(MainCycle cycle) {

		return null;
	}

	@Override
	public List<MainCycle> findBySubCycle(MainCycle subcycle) {

		return null;
	}

	@Override
	public PlanSmc findByid(long idPlan) {
		return em.find(PlanSmc.class, idPlan);
	}

	@Override
	public List<PlanSmc> findPlanStateApproved() {
		// TODO Auto-generated method stub
		Query consulta = em
				.createQuery("Select plan From PlanSmc plan Where plan.stateSmc.idState=:state");
		consulta.setParameter("state", PlanLogic.APPROVED);
		return consulta.getResultList();
	}

}
