package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IUserCipRolCipDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public UserCipRoleCip persistUserCipRoleCip(UserCipRoleCip userCipRoleCip);

	/**
	 * @generated DT_ID=none
	 */
	// public UserCipRoleCip mergeUserCipRoleCip(UserCipRoleCip userCipRoleCip);

	/**
	 * @generated DT_ID=none
	 */
	public void removeUserCipRoleCip(UserCipRoleCip userCipRoleCip);

	/**
	 * @generated DT_ID=none
	 */
	public List<UserCipRoleCip> getUserCipRoleCipFindAll();

	public UserCipRoleCip findByIdUserCipRoleCip(long idUserCipRoleCip);

	public List<RoleCip> findRoleByUser(long idUserCipRoleCip);

	public List<UserCip> findUserByRole(long idRole);

	public List<UserCipRoleCip> findByUserAndRole(long idUser, long idRole);
}
