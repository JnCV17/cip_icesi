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

import co.com.novatech.smc.modelo.ComplSrc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "ComplSrcDao", mappedName = "SMCIcesi-SMCIcesiLogic-ComplSrcDao")
public class ComplSrcDao implements IComplSrcDao {

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
	public ComplSrcDao() {
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
	public ComplSrc persistComplSrc(ComplSrc complSrc) {
		em.persist(complSrc);
		return complSrc;
	}

	/**
	 * @generated DT_ID=none
	 */
	public ComplSrc mergeComplSrc(ComplSrc complSrc) {
		return em.merge(complSrc);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeComplSrc(ComplSrc complSrc) {
		complSrc = em.find(ComplSrc.class, complSrc.getIdComplSrc());
		em.remove(complSrc);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComplSrc> getComplSrcFindAll() {
		return em.createNamedQuery("ComplSrc.findAll").getResultList();
	}

	
	public ComplSrc findById(long idComplSrc){
		
		return em.find(ComplSrc.class, idComplSrc);
	}
	
}
