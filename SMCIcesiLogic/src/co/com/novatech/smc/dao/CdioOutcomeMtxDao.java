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

import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "CdioOutcomeMtxDao", mappedName = "SMCIcesi-SMCIcesiLogic-CdioOutcomeMtxDao")
public class CdioOutcomeMtxDao implements ICdioOutcomeMtxDao {

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
	public CdioOutcomeMtxDao() {
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

	public CdioOutcomeMtx persistCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		em.persist(cdioOutcomeMtx);
		return cdioOutcomeMtx;
	}

	/**
	 * @generated DT_ID=none
	 */

	public CdioOutcomeMtx mergeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		return em.merge(cdioOutcomeMtx);
	}

	/**
	 * @generated DT_ID=none
	 */

	public void removeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {

		cdioOutcomeMtx = em.find(CdioOutcomeMtx.class, cdioOutcomeMtx.getOutcome());
		em.remove(cdioOutcomeMtx);
	}

	/**
	 * @generated DT_ID=none
	 */

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CdioOutcomeMtx> getCdioOutcomeMtxFindAll() {
		return em.createNamedQuery("CdioOutcomeMtx.findAll").getResultList();
	}

	 
	public CdioOutcomeMtx findByIdCdioOutcomeMtx(long idCdioOutcomeMtx) {

		return em.find(CdioOutcomeMtx.class, idCdioOutcomeMtx);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd) {
		Query query = em
				.createQuery("SELECT cdioS.cdioSkill FROM CdioOutcomeMtx cdioS WHERE cdioS.outcome.idStOutcome=:idStd");
		query.setParameter("idStd", idStd);
		return query.getResultList();
	}

}
