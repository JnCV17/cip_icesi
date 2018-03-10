package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ComplSrc;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IComplSrcDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public ComplSrc persistComplSrc(ComplSrc complSrc);

	/**
	 * @generated DT_ID=none
	 */
	// public ComplSrc mergeComplSrc(ComplSrc complSrc);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeComplSrc(ComplSrc complSrc);

	/**
	 * @generated DT_ID=none
	 */
	public List<ComplSrc> getComplSrcFindAll();

	public ComplSrc findById(long idComplSrc);

}
