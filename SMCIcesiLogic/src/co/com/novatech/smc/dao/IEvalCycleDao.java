package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvalCycle;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IEvalCycleDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public EvalCycle persistEvalCycle(EvalCycle evalCycle);

	/**
	 * @generated DT_ID=none
	 */
	// public EvalCycle mergeEvalCycle(EvalCycle evalCycle);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeEvalCycle(EvalCycle evalCycle);

	/**
	 * @generated DT_ID=none
	 */
	public List<EvalCycle> getEvalCycleFindAll();

	public EvalCycle findByIdEvalCycle(long idEvalCycle);

	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan);

	public List<EvalCycle> findIdEvalByIdCycle(long idCycle);

}
