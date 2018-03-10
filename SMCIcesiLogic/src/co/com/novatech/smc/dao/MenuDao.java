package co.com.novatech.smc.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.novatech.smc.modelo.Menu;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "MenuDao", mappedName = "SMCIcesi-SMCIcesiLogic-MenuDao")
public class MenuDao implements IMenuDao {

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName = "SMCIcesiLogic")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public MenuDao() {
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public Menu persistMenu(Menu menu) {
		em.persist(menu);
		return menu;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Menu mergeMenu(Menu menu) {
		return em.merge(menu);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeMenu(Menu menu) {
		menu = em.find(Menu.class, menu.getIdMenu());
		em.remove(menu);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Menu> getMenuFindAll() {
		return em.createNamedQuery("Menu.findAll").getResultList();
	}

	 
	public Menu findByIdMenu(Long idMenu) {
		return em.find(Menu.class, idMenu);
	}

}
