package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.UserAsSrc;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IUserAsrcDao {

	/**
	 * @generated DT_ID=none
	 */
	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public UserAsSrc persistUserAsSrc(UserAsSrc userAsSrc);

	/**
	 * @generated DT_ID=none
	 */
	public UserAsSrc mergeUserAsSrc(UserAsSrc userAsSrc);

	/**
	 * @generated DT_ID=none
	 */
	public void removeUserAsSrc(UserAsSrc userAsSrc);

	/**
	 * @generated DT_ID=none
	 */
	public List<UserAsSrc> getUserAsSrcFindAll();

	public UserAsSrc findById(long idUserAsSrc);

}
