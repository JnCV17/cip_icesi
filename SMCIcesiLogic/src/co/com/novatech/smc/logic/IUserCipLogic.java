package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;

@Remote
public interface IUserCipLogic {

	/**
	 * Buscar usuario por id
	 * 
	 * @param idUser,
	 *            el Id del usuario
	 * @return el usuario
	 */
	public UserCip findByIdUser(long idUser);

	/**
	 * Generar la lista de usuarios
	 * 
	 * @return la lista de todos los usuarios del sistema.
	 */
	public List<UserCip> findAllUser();

	/**
	 * Validar el ingreso al sistema de un usuario
	 * 
	 * @param username,
	 *            el nombre de usuario de un Usuario.
	 * 
	 * @param password,
	 *            el password de un Usuario.
	 * @return el usuario validado.
	 * @throws Exception
	 */
	public UserCip validateUser(String username, String password) throws Exception;

	public List<UserCip> findAllMentorUser();

	/**
	 * 
	 * @param idDir
	 *            id usuario
	 * @return retorna los programas del cual un usuario es director
	 */
	public List<ProgramSmc> getFindProgramByDirector(long idDir);

}
