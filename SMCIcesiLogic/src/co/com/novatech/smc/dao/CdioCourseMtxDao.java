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

import co.com.novatech.smc.modelo.CdioCourseMtx;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "CdioCourseMtxDao", mappedName = "SMCIcesi-SMCIcesiLogic-CdioCourseMtxDao")
public class CdioCourseMtxDao implements ICdioCourseMtxDao {

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
	public CdioCourseMtxDao() {
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

	public CdioCourseMtx persistCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		em.persist(cdioCourseMtx);
		return cdioCourseMtx;
	}

	/**
	 * @generated DT_ID=none
	 */

	public CdioCourseMtx mergeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		return em.merge(cdioCourseMtx);
	}

	/**
	 * @generated DT_ID=none
	 */

	public void removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {

		cdioCourseMtx = em.find(CdioCourseMtx.class, cdioCourseMtx.getCourse());
		em.remove(cdioCourseMtx);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CdioCourseMtx> getCdioCourseMtxFindAll() {
		return em.createNamedQuery("CdioCourseMtx.findAll").getResultList();
	}

	 
	public CdioCourseMtx findByIdCDIOCourseMtx(long cdioCourseMtx) {

		return em.find(CdioCourseMtx.class, cdioCourseMtx);
	}

	public List<CdioCourseMtx> findByCdio(long idCdioskill) {
		System.out.println("CdioCourseMtx");
		Query consulta = em
				.createQuery("Select distinct cour From CdioCourseMtx cour Where cour.cdioSkill.idCdioSkill=:id");
		consulta.setParameter("id", idCdioskill);
		System.out.println("CdioCourseMtx Finish");
		return consulta.getResultList();
	}

}
