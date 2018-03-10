package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MenuRole;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IMenuRoleDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public MenuRole persistMenuRole(MenuRole menuRole);

	/**
	 * @generated DT_ID=none
	 */
	// public MenuRole mergeMenuRole(MenuRole menuRole);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeMenuRole(MenuRole menuRole);

	/**
	 * @generated DT_ID=none
	 */
	public List<MenuRole> getMenuRoleFindAll();

	/**
	 * Retorna el MenuRole con el id pasado por parametro
	 */
	public MenuRole findMenuRoleById(long idMenuRole);
}
