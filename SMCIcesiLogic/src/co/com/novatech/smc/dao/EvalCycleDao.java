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

import co.com.novatech.smc.modelo.EvalCycle;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "EvalCycleDao", mappedName = "SMCIcesi-SMCIcesiLogic-EvalCycleDao")
public class EvalCycleDao implements IEvalCycleDao {

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
	public EvalCycleDao() {
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
	public EvalCycle persistEvalCycle(EvalCycle evalCycle) {
		em.persist(evalCycle);
		return evalCycle;
	}

	/**
	 * @generated DT_ID=none
	 */
	public EvalCycle mergeEvalCycle(EvalCycle evalCycle) {
		return em.merge(evalCycle);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeEvalCycle(EvalCycle evalCycle) {

		evalCycle = em.find(EvalCycle.class, evalCycle.getIdEvalCycle());
		em.remove(evalCycle);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<EvalCycle> getEvalCycleFindAll() {
		return em.createNamedQuery("EvalCycle.findAll").getResultList();
	}

	@Override
	public EvalCycle findByIdEvalCycle(long idEvalCycle) {
		return em.find(EvalCycle.class, idEvalCycle);
	}

	@Override
	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan) {
		Query consulta = em.createQuery("Select eval From EvalCycle eval Where eval.planSmc.idPlan=:idPLan");
		consulta.setParameter("idPLan", idPLan);
		return (EvalCycle) consulta.getSingleResult();
	}

	@Override
	public List<EvalCycle> findIdEvalByIdCycle(long idCycle) {
		Query consulta = em.createQuery("Select eval From EvalCycle eval Where eval.mainCycle.idCycle=:idCycle");
		consulta.setParameter("idCycle", idCycle);
		return consulta.getResultList();
	}

}
