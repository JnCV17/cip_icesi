package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.UserAsSrc;

@Remote
public interface IUserAsrcLogic {
	/**
	 * M�todo que permite guardar un Usuario que hace la recolecci�n
	 * 
	 * @param UserAsrc,
	 *            UserAsSrc que se desea guardar
	 * @throws ZMessManager,
	 *             si el UserAsSrc que entra como par�metro es nulo; si el id
	 *             del UserAsSrc que entra como par�metro es vac�o; si el
	 *             UserAsSrc ya existe; si el c�digo del UserAsSrc es nulo,
	 *             vac�o o excede el tama�o permitido.
	 * 
	 */
	public void saveUserAsrc(UserAsSrc UserAsrc) throws ZMessManager;

	/**
	 * M�todo que permite buscar un UserAsSrc dado un id pasado por par�metro.
	 * 
	 * @param id,
	 *            identificador del UserAsSrc a buscar
	 * @return UserAsSrc, un UserAsSrc que corresponde al id pasado por
	 *         par�metro
	 * @throws ZMessManager,
	 *             si el id es vac�o.
	 */
	public UserAsSrc findByIdUserAsrc(long id) throws ZMessManager;

	/**
	 * M�todo que permite recuperar todos los UserAsSrc que se tienen
	 * almacenados
	 * 
	 * @return List<UserAsSrc>, una lista con todos los UserAsSrc que se
	 *         encuentran almacenados
	 */
	public List<UserAsSrc> findAllUserAsrc();

	public void updateUserAsrc(UserAsSrc userAsrc);

}
