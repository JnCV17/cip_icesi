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

import co.com.novatech.smc.modelo.Alert;
import co.com.novatech.smc.modelo.EvideFile;
import co.com.novatech.smc.modelo.Outcome;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "EvideFileDao", mappedName = "SMCIcesi-SMCIcesiLogic-EvideFileDao")
public class EvideFileDao implements IEvideFileDao {

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
	public EvideFileDao() {
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
	public EvideFile persistEvideFile(EvideFile evideFile) {
		em.persist(evideFile);
		return evideFile;
	}

	/**
	 * @generated DT_ID=none
	 */
	public EvideFile mergeEvideFile(EvideFile evideFile) {
		return em.merge(evideFile);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeEvideFile(EvideFile evideFile) {
		evideFile = em.find(EvideFile.class, evideFile.getIdFile());
		em.remove(evideFile);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<EvideFile> getEvideFileFindAll() {
		return em.createNamedQuery("EvideFile.findAll").getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc) {

		Query o = em.createQuery("SELECT e FROM EvideFile e where e.asSrc.idAsSrc =:idAsSrc");

		o.setParameter("idAsSrc", idAsSrc);

		return o.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public EvideFile getEvideFileById(long evideFileId){
//		Query o = em.createQuery(
//				"SELECT e FROM EvideFile e WHERE e.idFile =:evideFileId");
//		o.setParameter("evideFileId", evideFileId);
//
//		return (EvideFile) o.getSingleResult();
		
		return em.find(EvideFile.class, evideFileId);
	}
	

}
