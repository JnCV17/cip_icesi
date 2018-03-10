package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;

/**
 * @generated DT_ID=none
 */
@Remote
public interface ICdioOutcomeMtxDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioOutcomeMtx persistCdioOutcomeMtx(CdioOutcomeMtx
	// cdioOutcomeMtx);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioOutcomeMtx mergeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx);

	/**
	 * @generated DT_ID=none
	 */
	public List<CdioOutcomeMtx> getCdioOutcomeMtxFindAll();

	public CdioOutcomeMtx findByIdCdioOutcomeMtx(long idCdioOutcomeMtx);

	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd);

}
