package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Menu;

@Remote
public interface IMenuLogic {

	/**
	 * Metodo que guarda un menú
	 * 
	 * @param entity,
	 *            menú que se va a guardar
	 * @throws Exception
	 * 
	 */
	// public void saveMenu(Menu entity) throws Exception;

	/**
	 * Metodo que actualiza un menú
	 * 
	 * @param entity,
	 *            menú que se va a actualizar
	 * @throws Exception
	 * 
	 */
	// public void updateMenu(Menu entity) throws Exception;

	/**
	 * Metodo que elimina un menú
	 * 
	 * @param entity,
	 *            menú que se va a eliminar
	 * @throws Exception
	 * 
	 */
	// public void deleteMenu(Menu entity) throws Exception;

	/**
	 * Metodo que realiza la busqueda de un menú
	 * 
	 * @param idMenu,
	 *            el id del menú a buscar
	 * @return El menú buscado
	 * @throws Exception
	 */
	public Menu findByIidMenu(Long idMenu) throws Exception;

	/**
	 * Metodo que realiza la busqueda de todos los menú
	 * 
	 * @return Una lista con todos los menú
	 * @throws Exception
	 */
	public List<Menu> findAllMenus() throws Exception;

}
