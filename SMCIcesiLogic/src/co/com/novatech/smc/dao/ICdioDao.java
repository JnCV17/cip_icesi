package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Cdio;

/**
 * @generated DT_ID=none
 */
@Remote
public interface ICdioDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public Cdio persistCdio(Cdio cdio);

	/**
	 * @generated DT_ID=none
	 */
	// public Cdio mergeCdio(Cdio cdio);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeCdio(Cdio cdio);

	/**
	 * @generated DT_ID=none
	 */
	public List<Cdio> getCdioFindAll();

	public Cdio findByIdCdio(long idCdio);

}
