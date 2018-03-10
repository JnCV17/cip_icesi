package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.StateSmc;

@Remote
public interface IStateLogic {

	/**
	 * Método que busca un estado dado el id del estado que se pasa por
	 * parametro.
	 * 
	 * @param id,
	 *            identificador del estado
	 * @return State, estado identificado con el id pasado por parametro
	 * @throws Exception
	 */
	public StateSmc findById(long id) throws ZMessManager;

	/**
	 * Método que retorna una lista de todos los estados que se encuentren
	 * almacenados en la base de datos
	 * 
	 * @return List<State>, lista con los estados encontrados
	 */
	public List<StateSmc> findAllState();

}
