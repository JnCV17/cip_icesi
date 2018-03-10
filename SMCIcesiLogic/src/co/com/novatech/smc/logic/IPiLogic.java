package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IPiLogic {

	/**
	 * M�todo que permite guardar un PI
	 * 
	 * @param pi,
	 *            PI que se desea guardar
	 * @throws ZMessManager,
	 *             si el PI que entra como par�metro es nulo; si el id del PI
	 *             que entra como par�metro es vac�o; si el PI ya existe; si el
	 *             c�digo del PI es nulo, vac�o o excede el tama�o permitido; si
	 *             la descripci�n del PI es nulo, vac�o o excede el tama�o
	 *             permitido; si el plan asociado al PI es nulo.
	 */
	public void savePi(PiSmc pi) throws ZMessManager;

	/**
	 * M�todo que permite buscar un PI dado un id pasado por par�metro.
	 * 
	 * @param id,
	 *            identificador del PI a buscar
	 * @return PI, un PI que corresponde al id pasado por par�metro
	 * @throws ZMessManager,
	 *             si el id es vac�o.
	 */
	public PiSmc findByIdPi(long id) throws ZMessManager;

	/**
	 * M�todo que permite buscar un PI dado un plan pasado por par�metro.
	 * 
	 * @param plan,
	 *            plan asociado al PI
	 * @return PI, un PI que corresponde al Plan pasado por par�metro
	 * @throws ZMessManager,
	 *             si el plan pasado por par�metro es nulo; si el plan no exste.
	 */
	public PiSmc findByPlanPi(PlanSmc plan) throws ZMessManager;

	/**
	 * M�todo que permite recuperar todos los PI que se tienen almacenados
	 * 
	 * @return List<Pi>, una lista con todos los Pi que se encuentran
	 *         almacenados
	 */
	public List<PiSmc> findAllPi();

	public List<PiSmc> findAllPisByPlan(long idPlan);

	public void updatePi(PiSmc piSmc);
}
