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

/**
 * @generated DT_ID=none
 */
@Stateless(name = "AlertDao", mappedName = "SMCIcesi-SMCIcesiLogic-AlertDao")
public class AlertDao implements IAlertDao {

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
	public AlertDao() {
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
	public Alert persistAlert(Alert alert) {
		em.persist(alert);
		return alert;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Alert mergeAlert(Alert alert) {
		return em.merge(alert);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeAlert(Alert alert) {
		alert = em.find(Alert.class, alert.getIdAlert());
		em.remove(alert);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Alert> getAlertFindAll() {
		return em.createNamedQuery("Alert.findAll").getResultList();
	}

	 
	public Alert findByIdAlert(long IdALert) {

		return em.find(Alert.class, IdALert);
	}

}
