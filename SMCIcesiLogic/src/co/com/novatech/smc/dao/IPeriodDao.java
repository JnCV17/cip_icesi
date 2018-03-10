package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Period;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IPeriodDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public Period persistPeriod(Period period);

	/**
	 * @generated DT_ID=none
	 */
	// public Period mergePeriod(Period period);

	/**
	 * @generated DT_ID=none
	 */
	// public void removePeriod(Period period);

	/**
	 * @generated DT_ID=none
	 */
	public List<Period> getPeriodFindAll();

	public Period findByIdPeriod(long idPeriod);

}
