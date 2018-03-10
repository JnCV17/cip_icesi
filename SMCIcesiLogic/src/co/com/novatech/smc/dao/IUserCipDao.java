package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IUserCipDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public UserCip persistUserCip(UserCip userCip);

	/**
	 * @generated DT_ID=none
	 */
	// public UserCip mergeUserCip(UserCip userCip);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeUserCip(UserCip userCip);

	/**
	 * @generated DT_ID=none
	 */
	public UserCip findByIdUserCip(long idUser);

	/**
	 * @generated DT_ID=none
	 */
	public List<UserCip> getUserCipFindAll();

	public List<UserCip> findByUsername(String username);

	/**
	 * 
	 * @param idDir
	 *            id usuario
	 * @return retorna los programas del cual un usuario es director
	 */

	public List<ProgramSmc> getFindProgramByDirector(long idDir);

}
