package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IPiLogic {

	/**
	 * Método que permite guardar un PI
	 * 
	 * @param pi,
	 *            PI que se desea guardar
	 * @throws ZMessManager,
	 *             si el PI que entra como parámetro es nulo; si el id del PI
	 *             que entra como parámetro es vacío; si el PI ya existe; si el
	 *             código del PI es nulo, vacío o excede el tamaño permitido; si
	 *             la descripción del PI es nulo, vacío o excede el tamaño
	 *             permitido; si el plan asociado al PI es nulo.
	 */
	public void savePi(PiSmc pi) throws ZMessManager;

	/**
	 * Método que permite buscar un PI dado un id pasado por parámetro.
	 * 
	 * @param id,
	 *            identificador del PI a buscar
	 * @return PI, un PI que corresponde al id pasado por parámetro
	 * @throws ZMessManager,
	 *             si el id es vacío.
	 */
	public PiSmc findByIdPi(long id) throws ZMessManager;

	/**
	 * Método que permite buscar un PI dado un plan pasado por parámetro.
	 * 
	 * @param plan,
	 *            plan asociado al PI
	 * @return PI, un PI que corresponde al Plan pasado por parámetro
	 * @throws ZMessManager,
	 *             si el plan pasado por parámetro es nulo; si el plan no exste.
	 */
	public PiSmc findByPlanPi(PlanSmc plan) throws ZMessManager;

	/**
	 * Método que permite recuperar todos los PI que se tienen almacenados
	 * 
	 * @return List<Pi>, una lista con todos los Pi que se encuentran
	 *         almacenados
	 */
	public List<PiSmc> findAllPi();

	public List<PiSmc> findAllPisByPlan(long idPlan);

	public void updatePi(PiSmc piSmc);
}
