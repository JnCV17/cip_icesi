package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MenuRole;

@Remote
public interface IMenuRoleLogic {

	/**
	 * Metodo que guarda un men�
	 * 
	 * @param entity,
	 *            men� que se va a guardar
	 * @throws Exception
	 * 
	 */
	// public void saveMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que actualiza un men�
	 * 
	 * @param entity,
	 *            men� que se va a actualizar
	 * @throws Exception
	 * 
	 */
	// public void updateMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que elimina un men�
	 * 
	 * @param entity,
	 *            men� que se va a eliminar
	 * @throws Exception
	 * 
	 */
	// public void deleteMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que realiza la busqueda de un men�
	 * 
	 * @param idMenu,
	 *            el id del men� a buscar
	 * @return El men� buscado
	 * @throws Exception
	 */
	public MenuRole findByIidMenuRole(Long idMenu);

	/**
	 * Metodo que realiza la busqueda de todos los men�
	 * 
	 * @return Una lista con todos los men�
	 * @throws Exception
	 */
	public List<MenuRole> findAllMenuRole();

}
