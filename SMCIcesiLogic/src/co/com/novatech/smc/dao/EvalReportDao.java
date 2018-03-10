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

import co.com.novatech.smc.modelo.EvalReport;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "EvalReportDao", mappedName = "SMCIcesi-SMCIcesiLogic-EvalReportDao")
public class EvalReportDao implements IEvalReportDao {

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
	public EvalReportDao() {
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
	public EvalReport persistEvalReport(EvalReport evalReport) {
		em.persist(evalReport);
		return evalReport;
	}

	/**
	 * @generated DT_ID=none
	 */
	public EvalReport mergeEvalReport(EvalReport evalReport) {
		return em.merge(evalReport);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeEvalReport(EvalReport evalReport) {
		evalReport = em.find(EvalReport.class, evalReport.getIdEvalReport());
		em.remove(evalReport);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<EvalReport> getEvalReportFindAll() {
		return em.createNamedQuery("EvalReport.findAll").getResultList();
	}

	@Override
	public EvalReport findByIdEvalReport(long idEvalReport) {

		return em.find(EvalReport.class, idEvalReport);
	}

}
