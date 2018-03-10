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

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Course;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "AsSrcDao", mappedName = "SMCIcesi-SMCIcesiLogic-AsSrcDao")
public class AsSrcDao implements IAsSrcDao {

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
	public AsSrcDao() {
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

	public AsSrc persistAsSrc(AsSrc asSrc) {
		em.persist(asSrc);
		return asSrc;
	}

	/**
	 * @generated DT_ID=none
	 */

	public AsSrc mergeAsSrc(AsSrc asSrc) {
		return em.merge(asSrc);
	}

	/**
	 * @generated DT_ID=none
	 */

	public void removeAsSrc(AsSrc asSrc) {

		asSrc = em.find(AsSrc.class, asSrc.getIdAsSrc());
		em.remove(asSrc);
	}

	/**
	 * @generated DT_ID=none
	 */

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AsSrc> getAsSrcFindAll() {
		return em.createNamedQuery("AsSrc.findAll").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public AsSrc findByIdAssessmentSource(long idAsSrc) {

		return em.find(AsSrc.class, idAsSrc);

	}

	public List<AsSrc> findAllAsSrc(long idPi) {

		Query query = em.createQuery("SELECT a FROM AsSrc a WHERE a.piSmc.idPi=:idPi");
		query.setParameter("idPi", idPi);
		return query.getResultList();

	}

	public List<Course> findAllAsSrcDistinct(long idPi) {

		Query query = em.createQuery("SELECT DISTINCT (a.course) FROM AsSrc a WHERE a.piSmc.idPi=:idPi");
		query.setParameter("idPi", idPi);

		return query.getResultList();

	}

}
