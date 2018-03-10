package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.UserAsSrc;

@Remote
public interface IUserAsrcLogic {
	/**
	 * Método que permite guardar un Usuario que hace la recolección
	 * 
	 * @param UserAsrc,
	 *            UserAsSrc que se desea guardar
	 * @throws ZMessManager,
	 *             si el UserAsSrc que entra como parámetro es nulo; si el id
	 *             del UserAsSrc que entra como parámetro es vacío; si el
	 *             UserAsSrc ya existe; si el código del UserAsSrc es nulo,
	 *             vacío o excede el tamaño permitido.
	 * 
	 */
	public void saveUserAsrc(UserAsSrc UserAsrc) throws ZMessManager;

	/**
	 * Método que permite buscar un UserAsSrc dado un id pasado por parámetro.
	 * 
	 * @param id,
	 *            identificador del UserAsSrc a buscar
	 * @return UserAsSrc, un UserAsSrc que corresponde al id pasado por
	 *         parámetro
	 * @throws ZMessManager,
	 *             si el id es vacío.
	 */
	public UserAsSrc findByIdUserAsrc(long id) throws ZMessManager;

	/**
	 * Método que permite recuperar todos los UserAsSrc que se tienen
	 * almacenados
	 * 
	 * @return List<UserAsSrc>, una lista con todos los UserAsSrc que se
	 *         encuentran almacenados
	 */
	public List<UserAsSrc> findAllUserAsrc();

	public void updateUserAsrc(UserAsSrc userAsrc);

}
