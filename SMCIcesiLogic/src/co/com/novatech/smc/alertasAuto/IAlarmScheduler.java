package co.com.novatech.smc.alertasAuto;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IAlarmScheduler {

	/**
	 * Método que permite inicializar el timer al momento de montar el servidor
	 * dandole una hora y un intervalo de ejecución.
	 */
	public void startUpTimer();

	/**
	 * Método que elimina todos los timers que se encuentren activos en el
	 * servidor al momento de montar el servidor.
	 */
	public void shutDownTimer();
	
	/**
	 * Método que valida la primera fecha de recolección de los planes de Assessment
	 * que se encuentren en estado "Approved" para cambiar a estado "in process"
	 */
	
}
