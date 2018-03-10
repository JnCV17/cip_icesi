package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RoleCip;

@Remote
public interface IRoleCipLogic {

	/**
	 * findByIdRoleCip busca un rol por id
	 * 
	 * @param idRole,
	 *            el id del rol a buscar
	 * @return el role
	 */
	public RoleCip findByIdRoleCip(long idRole);

	/**
	 * findAllRole, busca todos los roles
	 * 
	 * @return la lista de los roles
	 */
	public List<RoleCip> findAllRole();
}
