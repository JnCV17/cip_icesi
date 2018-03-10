package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioCourseMtx;

/**
 * @generated DT_ID=none
 */
@Remote
public interface ICdioCourseMtxDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioCourseMtx persistCdioCourseMtx(CdioCourseMtx cdioCourseMtx);

	/**
	 * @generated DT_ID=none
	 */
	// public CdioCourseMtx mergeCdioCourseMtx(CdioCourseMtx cdioCourseMtx);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx);

	/**
	 * @generated DT_ID=none
	 */
	public List<CdioCourseMtx> getCdioCourseMtxFindAll();

	public CdioCourseMtx findByIdCDIOCourseMtx(long id);

	public List<CdioCourseMtx> findByCdio(long idCdio);

}
