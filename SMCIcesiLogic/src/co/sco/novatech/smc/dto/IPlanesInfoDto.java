package co.sco.novatech.smc.dto;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ProgramSmc;

@Remote
public interface IPlanesInfoDto {
	/**
	 * Metodo que carga la informaci�n a mostrar de los planes
	 * 
	 * @param programa
	 * @param ciclo
	 * @param subciclo
	 * @return retorna una lista de objetos PlanesInfo
	 * 
	 *         Este metodo carga la informaci�n a mostrar segun los criterios de
	 *         aceptaci�n para un plan. La informaci�n de los planes se carga de
	 *         acuerdo a los filtros que recibe el metodo.
	 */

	public List<PlanesInfoDto> cargaInformacionPlanes(ProgramSmc programa, MainCycle ciclo, MainCycle subciclo);

}
