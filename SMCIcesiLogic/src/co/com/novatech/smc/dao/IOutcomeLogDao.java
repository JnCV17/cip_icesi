package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.OutcomeLog;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IOutcomeLogDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public OutcomeLog persistOutcomeLog(OutcomeLog outcomeLog);

	/**
	 * @generated DT_ID=none
	 */
	// public OutcomeLog mergeOutcomeLog(OutcomeLog outcomeLog);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeOutcomeLog(OutcomeLog outcomeLog);

	/**
	 * @generated DT_ID=none
	 */
	public List<OutcomeLog> getOutcomeLogFindAll();

}
