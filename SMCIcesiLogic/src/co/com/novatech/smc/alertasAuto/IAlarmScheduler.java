package co.com.novatech.smc.alertasAuto;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IAlarmScheduler {

	/**
	 * M�todo que permite inicializar el timer al momento de montar el servidor
	 * dandole una hora y un intervalo de ejecuci�n.
	 */
	public void startUpTimer();

	/**
	 * M�todo que elimina todos los timers que se encuentren activos en el
	 * servidor al momento de montar el servidor.
	 */
	public void shutDownTimer();
	
	/**
	 * M�todo que valida la primera fecha de recolecci�n de los planes de Assessment
	 * que se encuentren en estado "Approved" para cambiar a estado "in process"
	 */
	
}
