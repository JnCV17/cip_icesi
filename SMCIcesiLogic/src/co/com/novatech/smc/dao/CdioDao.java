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

import co.com.novatech.smc.modelo.Cdio;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "CdioDao", mappedName = "SMCIcesi-SMCIcesiLogic-CdioDao")
public class CdioDao implements ICdioDao {

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
	public CdioDao() {
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
	public Cdio persistCdio(Cdio cdio) {
		em.persist(cdio);
		return cdio;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Cdio mergeCdio(Cdio cdio) {
		return em.merge(cdio);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeCdio(Cdio cdio) {
		cdio = em.find(Cdio.class, cdio.getIdCdio());
		em.remove(cdio);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Cdio> getCdioFindAll() {
		return em.createNamedQuery("Cdio.findAll").getResultList();
	}

	 
	public Cdio findByIdCdio(long idCdio) {

		return em.find(Cdio.class, idCdio);
	}

}
