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

import co.com.novatech.smc.modelo.MainCycle;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "MainCycleDao", mappedName = "SMCIcesi-SMCIcesiLogic-MainCycleDao")
public class MainCycleDao implements IMainCycleDao {

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
	public MainCycleDao() {
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
	 
	public MainCycle persistMainCycle(MainCycle mainCycle) {
		em.persist(mainCycle);
		return mainCycle;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public MainCycle mergeMainCycle(MainCycle mainCycle) {
		return em.merge(mainCycle);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeMainCycle(MainCycle mainCycle) {
		mainCycle = em.find(MainCycle.class, mainCycle.getIdCycle());
		em.remove(mainCycle);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<MainCycle> getMainCycleFindAll() {
		return em.createNamedQuery("MainCycle.findAll").getResultList();
	}

	 
	public MainCycle findById(long idCycle) {

		return em.find(MainCycle.class, idCycle);
	}

}