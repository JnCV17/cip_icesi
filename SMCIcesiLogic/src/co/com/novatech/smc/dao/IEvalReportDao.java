package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvalReport;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IEvalReportDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public EvalReport persistEvalReport(EvalReport evalReport);

	/**
	 * @generated DT_ID=none
	 */
	public EvalReport mergeEvalReport(EvalReport evalReport);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeEvalReport(EvalReport evalReport);

	/**
	 * @generated DT_ID=none
	 */
	public List<EvalReport> getEvalReportFindAll();

	public EvalReport findByIdEvalReport(long idEvalReport);

}
