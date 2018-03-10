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
import co.com.novatech.smc.modelo.Method;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "MethodDao", mappedName = "SMCIcesi-SMCIcesiLogic-MethodDao")
public class MethodDao implements IMethodDao {

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
	public MethodDao() {
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
	public Method persistMethod(Method method) {
		em.persist(method);
		return method;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Method mergeMethod(Method method) {
		return em.merge(method);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeMethod(Method method) {
		method = em.find(Method.class, method.getIdAsMethod());
		em.remove(method);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Method> getMethodFindAll() {
		return em.createNamedQuery("Method.findAll").getResultList();
	}
	
	 
	public Method findById(long idMethod) {

		return em.find(Method.class, idMethod);
	}

}
