package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Alert;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IAlertDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public Alert persistAlert(Alert alert);

	/**
	 * @generated DT_ID=none
	 */
	public Alert mergeAlert(Alert alert);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeAlert(Alert alert);

	/**
	 * @generated DT_ID=none
	 */
	public List<Alert> getAlertFindAll();

	public Alert findByIdAlert(long IdALert);
}
