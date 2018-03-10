package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

@Remote
public interface IUserCipRoleCipLogic {

	public void saveUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws Exception;

	public UserCipRoleCip findByIdUserCipRoleCip(long userCipRoleCipId) throws Exception;

	public void removeUserCipRoleCip(UserCipRoleCip userCipRoleCip);

	public List<UserCipRoleCip> findAllUserCipRoleCip();

	public List<UserCip> findUserByRole(long idRole);

	public List<RoleCip> findRoleByUser(long id);

	public List<UserCipRoleCip> findByUserAndRole(long idUser, long idRole);
}
