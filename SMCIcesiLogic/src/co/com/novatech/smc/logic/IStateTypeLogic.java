package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.StateType;

@Remote
public interface IStateTypeLogic {

	/**
	 * M�todo que permite encontrar un tipo de estado dado un id pasado por
	 * par�metro.
	 * 
	 * @param id,
	 *            identificador del tipo de estado que se desea buscar
	 * @return StateType, tipo de estado asociado con el identificador paasado
	 *         por par�metro.
	 * @throws ZMessManager,
	 *             si el identificador del tipo de estado no fue especificado.
	 */
	public StateType findByIdStateType(long id) throws ZMessManager;

	/**
	 * M�todo que retorna todos tipos de estado que se encuentran almacenados.
	 * 
	 * @return List<StateType>, una lista de los tipos de estados que se
	 *         encuentran almacenados.
	 */
	public List<StateType> findAllStateType();

	public void saveStateType(StateType stateType);

}
