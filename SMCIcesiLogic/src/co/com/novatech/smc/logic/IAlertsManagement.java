package co.com.novatech.smc.logic;

import java.util.Date;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IAlertsManagement {

	/**
	 * M�todo que env�a un correo de alerta cuando a un usuario se le es
	 * asignado un outcome.
	 * 
	 * @param idUsuario,
	 *            identificaci�n del usuario.
	 * @param idProgram,
	 *            identificaci�n del programa
	 * @param idStOutcome,
	 *            identificaci�n del outcome.
	 * @param idUser,
	 *            identificacion del usuario
	 */
	public void envioCorreoAsignacionOutcome(long idUsuario, String idProgram, long idStOutcome, long idUser);

	/**
	 * M�todo que env�a un correo recordatorio cuando un plan de assessment es
	 * cambiado de estado.
	 * 
	 * @param idPlan,
	 *            identificaci�n del plan de assessement.
	 * @param idProgram,
	 *            identificaci�n del programa al que pertenece el plan de
	 *            assessment.
	 */
	public void envioCorreoCambioEstadoPlanAsesssment(long idPlan, String idProgram);

	/**
	 * M�todo que env�a un correo recordatorio cuando un plan de assessment
	 * tiene cerca la fecha de recolecci�n de evidencias.
	 * 
	 * @param planSmc,
	 *            identidicador del plan de assessment.
	 * @param idProgram,
	 *            identificaci�n del programa al que pertenece el plan de
	 *            assessment.
	 */
	public void envioCorreoFechaRecoleccionEvidencias(AsSrc fuente, String idProgram);

	/**
	 * M�todo que env�a un correo recordatorio 3 semanas antes de que llegue la
	 * fecha de evaluaci�n del plan de assessment.
	 * 
	 * @param planSmc,
	 *            Plan de asssessment que dentro de 3 semanas ser� sometido a
	 *            evaluaci�n.
	 */
	public void envioCorreoFechaEvaluacion(PlanSmc planSmc);

	/**
	 * M�todo que env�a un correo de alerta cuando un outcome es desasignado a
	 * un usuario
	 * 
	 * @param idProgram,
	 *            identificaci�n del programa.
	 * @param idStOutcome,
	 *            identificaci�n del outcome.
	 * @param idUser,
	 *            identificaci�n del usuario
	 */
	public void envioCorreoDesasignacionOutcome(String idProgram, long idStOutcome, long idUser);

	/**
	 * M�todo que verifica que alertas de tipo carga de evidencias deben ser
	 * enviadas si la fecha de env�o de la alerta coincide con la actual.
	 */
	public void envioCorreoEvidencias();

	/**
	 * M�todo que verfica que alertas de tipo fecha de evaluci�n deben ser
	 * enviadas si la fecha de env�o de la alerta coincide con la actual.
	 */
	public void envioCorreoEvaluacion();

	/**
	 * M�todo que permite calcular la fecha de env�o de una alerta dada las
	 * semanas de anticipaci�n del evento que se va a tratar
	 * 
	 * @param fecha,
	 *            fecha del evento que se esta tratanto
	 * @param semanas,
	 *            semanas de anticipaci�n del evento de las que ser�n enviadas
	 *            las alertas
	 * @return Date, fecha del env�o del correo.
	 */

	// Reportes de evaluacion

	/**
	 * M�todo que env�a un correo recordatorio cuando un Reporte de evalcuacion
	 * es cambiado de estado.
	 * 
	 * @param idReporte
	 *            reporte evaluacion que cambio de estado
	 */
	// TODO meter al deployment luego
	public void envioCorreoCambioEstadoReporteDeEvaluacion(EvalReport idReporte);

	// TODO private
	public Date calculoEnvioProximoCorreo(Date fecha, int semanas);
}
