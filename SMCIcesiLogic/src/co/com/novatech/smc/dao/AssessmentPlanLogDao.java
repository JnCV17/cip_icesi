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

import co.com.novatech.smc.modelo.AssessmentPlanLog;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "AssessmentPlanLogDao", mappedName = "SMCIcesi-SMCIcesiLogic-AssessmentPlanLogDao")
public class AssessmentPlanLogDao implements IAssessmentPlanLogDao {
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
	public AssessmentPlanLogDao() {
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
	public AssessmentPlanLog persistAssessmentPlanLog(AssessmentPlanLog assessmentPlanLog) {
		em.persist(assessmentPlanLog);
		return assessmentPlanLog;
	}

	/**
	 * @generated DT_ID=none
	 */
	public AssessmentPlanLog mergeAssessmentPlanLog(AssessmentPlanLog assessmentPlanLog) {
		return em.merge(assessmentPlanLog);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeAssessmentPlanLog(AssessmentPlanLog assessmentPlanLog) {
		assessmentPlanLog = em.find(AssessmentPlanLog.class, assessmentPlanLog.getIdAssessmentPlanLog());
		em.remove(assessmentPlanLog);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AssessmentPlanLog> getAssessmentPlanLogFindAll() {
		return em.createNamedQuery("AssessmentPlanLog.findAll").getResultList();
	}

	public AssessmentPlanLog findByid(long idAssessmentPlanLog) {

		return em.find(AssessmentPlanLog.class, idAssessmentPlanLog);
	}

}
