package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Outcome;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IOutcomeDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public Outcome persistOutcome(Outcome outcome);

	/**
	 * @generated DT_ID=none
	 */
	public Outcome mergeOutcome(Outcome outcome);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeOutcome(Outcome outcome);

	/**
	 * @generated DT_ID=none
	 */
	public List<Outcome> getOutcomeFindAll();

	public Outcome findbyid(long idOutcome);

	public List<Outcome> findOutcomesByProgram(String idProgram);

	public List<Outcome> findOutcomeByUser(long idUser);

	public Outcome findOutcomeCycleByidOutcome(String criterio, String programa);

	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram);

}
