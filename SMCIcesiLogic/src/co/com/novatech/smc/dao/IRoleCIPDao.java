package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RoleCip;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IRoleCIPDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public RoleCip persistRoleCip(RoleCip roleCip);

	/**
	 * @generated DT_ID=none
	 */
	// public RoleCip mergeRoleCip(RoleCip roleCip);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeRoleCip(RoleCip roleCip);

	/**
	 * @generated DT_ID=none
	 */
	public List<RoleCip> getRoleCipFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public RoleCip findByIdRoleCip(long idRole);

}
