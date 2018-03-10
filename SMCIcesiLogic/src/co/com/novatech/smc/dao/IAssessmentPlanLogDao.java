package co.com.novatech.smc.dao;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.AssessmentPlanLog;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IAssessmentPlanLogDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public AssessmentPlanLog persistAssessmentPlanLog(AssessmentPlanLog assessmentPlanLog);

	/**
	 * @generated DT_ID=none
	 */
	// public AssessmentPlanLog mergeAssessmentPlanLog(AssessmentPlanLog
	// assessmentPlanLog);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeAssessmentPlanLog(AssessmentPlanLog assessmentPlanLog);

	/**
	 * @generated DT_ID=none
	 */
	// public List<AssessmentPlanLog> getAssessmentPlanLogFindAll();

	// public AssessmentPlanLog findByid(long idAssessmentPlanLog);
}
