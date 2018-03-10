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

import co.com.novatech.smc.modelo.RoleCip;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "RoleCIPDao", mappedName = "SMCIcesi-SMCIcesiLogic-RoleCIPDao")
public class RoleCIPDao implements IRoleCIPDao {

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
	public RoleCIPDao() {
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
	public RoleCip persistRoleCip(RoleCip roleCip) {
		em.persist(roleCip);
		return roleCip;
	}

	/**
	 * @generated DT_ID=none
	 */
	public RoleCip mergeRoleCip(RoleCip roleCip) {
		return em.merge(roleCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeRoleCip(RoleCip roleCip) {
		roleCip = em.find(RoleCip.class, roleCip.getIdRole());
		em.remove(roleCip);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<RoleCip> getRoleCipFindAll() {
		return em.createNamedQuery("RoleCip.findAll").getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public RoleCip findByIdRoleCip(long idRole) {
		return em.find(RoleCip.class, idRole);
	}

}
