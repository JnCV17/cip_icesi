package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MenuRole;

@Remote
public interface IMenuRoleLogic {

	/**
	 * Metodo que guarda un menú
	 * 
	 * @param entity,
	 *            menú que se va a guardar
	 * @throws Exception
	 * 
	 */
	// public void saveMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que actualiza un menú
	 * 
	 * @param entity,
	 *            menú que se va a actualizar
	 * @throws Exception
	 * 
	 */
	// public void updateMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que elimina un menú
	 * 
	 * @param entity,
	 *            menú que se va a eliminar
	 * @throws Exception
	 * 
	 */
	// public void deleteMenuRole(MenuRole entity) throws Exception;

	/**
	 * Metodo que realiza la busqueda de un menú
	 * 
	 * @param idMenu,
	 *            el id del menú a buscar
	 * @return El menú buscado
	 * @throws Exception
	 */
	public MenuRole findByIidMenuRole(Long idMenu);

	/**
	 * Metodo que realiza la busqueda de todos los menú
	 * 
	 * @return Una lista con todos los menú
	 * @throws Exception
	 */
	public List<MenuRole> findAllMenuRole();

}
