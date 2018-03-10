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

import co.com.novatech.smc.modelo.MenuRole;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "MenuRoleDao", mappedName = "SMCIcesi-SMCIcesiLogic-MenuRoleDao")
public class MenuRoleDao implements IMenuRoleDao {

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
	public MenuRoleDao() {
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
	 
	public MenuRole persistMenuRole(MenuRole menuRole) {
		em.persist(menuRole);
		return menuRole;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public MenuRole mergeMenuRole(MenuRole menuRole) {
		return em.merge(menuRole);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeMenuRole(MenuRole menuRole) {
		menuRole = em.find(MenuRole.class, menuRole.getIdMenuRol());
		em.remove(menuRole);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<MenuRole> getMenuRoleFindAll() {
		return em.createNamedQuery("MenuRole.findAll").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public MenuRole findMenuRoleById(long idMenuRole) {
		return em.find(MenuRole.class, idMenuRole);

	}

}
