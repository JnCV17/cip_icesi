package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Course;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IAsSrcDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public AsSrc persistAsSrc(AsSrc asSrc);

	/**
	 * @generated DT_ID=none
	 */
	public AsSrc mergeAsSrc(AsSrc asSrc);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeAsSrc(AsSrc asSrc);

	/**
	 * @generated DT_ID=none
	 */
	public List<AsSrc> getAsSrcFindAll();

	public AsSrc findByIdAssessmentSource(long idAsSrc);

	public List<AsSrc> findAllAsSrc(long idPi);

	public List<Course> findAllAsSrcDistinct(long idPi);

}
