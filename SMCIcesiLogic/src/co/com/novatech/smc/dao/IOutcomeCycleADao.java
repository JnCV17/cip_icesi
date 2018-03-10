package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.OutcomeCycleA;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IOutcomeCycleADao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public OutcomeCycleA persistOutcomeCycleA(OutcomeCycleA outcomeCycleA);

	/**
	 * @generated DT_ID=none
	 */
	// public OutcomeCycleA mergeOutcomeCycleA(OutcomeCycleA outcomeCycleA);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeOutcomeCycleA(OutcomeCycleA outcomeCycleA);

	/**
	 * @generated DT_ID=none
	 */
	public List<OutcomeCycleA> getOutcomeCycleAFindAll();

	/**
	 * 
	 */
	public OutcomeCycleA getOutcomeCycleAFindById(Long idOutcomeCycleA);

	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo);

	public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome);

}
