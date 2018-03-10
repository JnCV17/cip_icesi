package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Menu;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IMenuDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public Menu persistMenu(Menu menu);

	/**
	 * @generated DT_ID=none
	 */
	// public Menu mergeMenu(Menu menu);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeMenu(Menu menu);

	/**
	 * @generated DT_ID=none
	 */
	public List<Menu> getMenuFindAll();

	public Menu findByIdMenu(Long idMenu);

}
