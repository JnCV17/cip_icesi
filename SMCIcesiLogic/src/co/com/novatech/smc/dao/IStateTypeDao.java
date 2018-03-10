package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.StateType;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IStateTypeDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public StateType persistStateType(StateType stateType);

	/**
	 * @generated DT_ID=none
	 */
	// public StateType mergeStateType(StateType stateType);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeStateType(StateType stateType);

	/**
	 * @generated DT_ID=none
	 */
	public List<StateType> getStateTypeFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public StateType findById(long id);
}
