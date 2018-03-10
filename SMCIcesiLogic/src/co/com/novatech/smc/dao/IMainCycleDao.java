package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MainCycle;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IMainCycleDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public MainCycle persistMainCycle(MainCycle mainCycle);

	/**
	 * @generated DT_ID=none
	 */
	// public MainCycle mergeMainCycle(MainCycle mainCycle);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeMainCycle(MainCycle mainCycle);

	/**
	 * @generated DT_ID=none
	 */
	public List<MainCycle> getMainCycleFindAll();

	public MainCycle findById(long idCycle);

}
