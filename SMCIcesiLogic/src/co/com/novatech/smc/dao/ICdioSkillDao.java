package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioSkill;

/**
 * @generated DT_ID=none
 */
@Remote
public interface ICdioSkillDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioSkill persistCdioSkill(CdioSkill cdioSkill);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioSkill mergeCdioSkill(CdioSkill cdioSkill);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeCdioSkill(CdioSkill cdioSkill);

	/**
	 * @generated DT_ID=none
	 */
	public List<CdioSkill> getCdioSkillFindAll();

	public CdioSkill findByIdCdioSkill(long idCdioSkill);

	public List<CdioSkill> findAllCdioSkillByPi(long idPi);

	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2);

}
