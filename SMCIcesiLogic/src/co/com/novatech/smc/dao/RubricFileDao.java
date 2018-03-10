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

import co.com.novatech.smc.modelo.RubricFile;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "RubricFileDao", mappedName = "SMCIcesi-SMCIcesiLogic-RubricFileDao")
public class RubricFileDao implements IRubricFileDao {

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
	public RubricFileDao() {
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
	 
	public RubricFile persistRubricFile(RubricFile rubricFile) {
		em.persist(rubricFile);
		return rubricFile;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public RubricFile mergeRubricFile(RubricFile rubricFile) {
		return em.merge(rubricFile);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeRubricFile(RubricFile rubricFile) {
		rubricFile = em.find(RubricFile.class, rubricFile.getIdFile());
		em.remove(rubricFile);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<RubricFile> getRubricFileFindAll() {
		return em.createNamedQuery("RubricFile.findAll").getResultList();
	}

	 
	public RubricFile findByIdRubric(long idRubric) {
		return em.find(RubricFile.class, idRubric);
	}

}
