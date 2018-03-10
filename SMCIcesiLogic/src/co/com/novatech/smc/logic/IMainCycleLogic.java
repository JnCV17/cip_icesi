package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IMainCycleLogic {

	/**
	 * Buscar un ciclo por su Id
	 * 
	 * @param idCycle
	 * @return
	 */

	public MainCycle findByIdMainCycle(long idCycle);

	/**
	 * Buscar todos los ciclos existentes
	 * 
	 * @return
	 */
	public List<MainCycle> findAllMainCycles();

	/**
	 * 
	 * @param idCycle
	 * @return
	 */
	public MainCycle findByIdCycle(long idCycle);

	/**
	 * 
	 * @param idCycle
	 * @return
	 */
	public List<MainCycle> findAllSubCyclesByMainCycle(long idMainCycle);

	/**
	 * 
	 * @return
	 */
	public List<MainCycle> findAllSubCycles();

	/**
	 * Consultar un ciclo por su Id
	 * 
	 * @param idCiclo
	 * @return
	 */
	public MainCycle MaincycleConsult(Long idCiclo);

	/**
	 * Consultar los subciclos de para un ciclo
	 * 
	 * @param mainCycle
	 * @return
	 */

	public List<MainCycle> SubcycleConsult(MainCycle mainCycle);

	/**
	 * Validar si es un ciclo o subciclo
	 * 
	 * @param mainCycle
	 * @return
	 */

	public boolean CycleValidate(MainCycle mainCycle);

	/**
	 * Consulta los planes para una lista de subciclos dados
	 * 
	 * @param subCycles
	 * @return
	 */

	public List<PlanSmc> PlanConsult(List<MainCycle> subCycles);

	/**
	 * Consulta los Ciclos de un programa
	 * 
	 * @param idProgram
	 * @return
	 */
	public List<MainCycle> CycleForProgram(String idProgram);

}
