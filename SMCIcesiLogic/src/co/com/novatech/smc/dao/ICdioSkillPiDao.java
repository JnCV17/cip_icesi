package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioSkillPi;

/**
 * @generated DT_ID=none
 */
@Remote
public interface ICdioSkillPiDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public CdioSkillPi persistCdioSkillPi(CdioSkillPi cdioSkillPi);

	/**
	 * @generated DT_ID=none /
	 */
	// public CdioSkillPi mergeCdioSkillPi(CdioSkillPi cdioSkillPi);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeCdioSkillPi(CdioSkillPi cdioSkillPi);

	/**
	 * @generated DT_ID=none
	 */
	public List<CdioSkillPi> getCdioSkillPiFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public CdioSkillPi findByIdCdioSkillPi(long CdioSkillPi);

}
