package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.StateSmc;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IStateDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public StateSmc persistState(StateSmc state);

	/**
	 * @generated DT_ID=none
	 */
	// public StateSmc mergeState(StateSmc state);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeState(StateSmc state);

	/**
	 * @generated DT_ID=none
	 */
	public List<StateSmc> getStateFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public StateSmc findById(long id);

}
