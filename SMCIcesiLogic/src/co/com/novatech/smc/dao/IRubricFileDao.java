package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RubricFile;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IRubricFileDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public RubricFile persistRubricFile(RubricFile rubricFile);

	/**
	 * @generated DT_ID=none
	 */
	public RubricFile mergeRubricFile(RubricFile rubricFile);

	/**
	 * @generated DT_ID=none
	 */
	public void removeRubricFile(RubricFile rubricFile);

	/**
	 * @generated DT_ID=none
	 */
	public List<RubricFile> getRubricFileFindAll();

	public RubricFile findByIdRubric(long idRubric);

}
