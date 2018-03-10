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

import co.com.novatech.smc.modelo.CdioSkill;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "CdioSkillDao", mappedName = "SMCIcesi-SMCIcesiLogic-CdioSkillDao")
public class CdioSkillDao implements ICdioSkillDao {

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
	public CdioSkillDao() {
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
	public CdioSkill persistCdioSkill(CdioSkill cdioSkill) {
		em.persist(cdioSkill);
		return cdioSkill;
	}

	/**
	 * @generated DT_ID=none
	 */
	public CdioSkill mergeCdioSkill(CdioSkill cdioSkill) {
		return em.merge(cdioSkill);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeCdioSkill(CdioSkill cdioSkill) {
		cdioSkill = em.find(CdioSkill.class, cdioSkill.getIdCdioSkill());
		em.remove(cdioSkill);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CdioSkill> getCdioSkillFindAll() {
		return em.createNamedQuery("CdioSkill.findAll").getResultList();
	}

	 
	public CdioSkill findByIdCdioSkill(long idCdioSkill) {
		return em.find(CdioSkill.class, idCdioSkill);

	}

	 
	public List<CdioSkill> findAllCdioSkillByPi(long idPi) {

		Query query = em.createQuery("SELECT cdioS FROM CdioSkill cdioS WHERE cdioS.piSmc.idPi=:idPi");
		query.setParameter("idPi", idPi);
		return query.getResultList();
	}

	 
	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2) {
		Query query = em
				.createQuery("SELECT cdioS FROM CdioSkill cdioS WHERE cdioS.cdioSkill.idCdioSkill=:idCdioSkillLevel2");
		query.setParameter("idCdioSkillLevel2", idCdioSkillLevel2);
		return query.getResultList();
	}

}
