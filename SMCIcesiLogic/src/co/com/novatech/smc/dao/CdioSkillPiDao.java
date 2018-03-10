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

import co.com.novatech.smc.modelo.CdioSkillPi;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "CdioSkillPiDao", mappedName = "SMCIcesi-SMCIcesiLogic-CdioSkillPiDao")
public class CdioSkillPiDao implements ICdioSkillPiDao {

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
	public CdioSkillPiDao() {
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
	public CdioSkillPi persistCdioSkillPi(CdioSkillPi cdioSkillPi) {
		em.persist(cdioSkillPi);
		return cdioSkillPi;
	}

	/**
	 * @generated DT_ID=none
	 */
	public CdioSkillPi mergeCdioSkillPi(CdioSkillPi cdioSkillPi) {
		return em.merge(cdioSkillPi);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeCdioSkillPi(CdioSkillPi cdioSkillPi) {
		cdioSkillPi = em.find(CdioSkillPi.class, cdioSkillPi.getPCdioSkillPi());
		em.remove(cdioSkillPi);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CdioSkillPi> getCdioSkillPiFindAll() {
		return em.createNamedQuery("CdioSkillPi.findAll").getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CdioSkillPi findByIdCdioSkillPi(long CdioSkillPi) {
		return em.find(CdioSkillPi.class, CdioSkillPi);

	}

}
