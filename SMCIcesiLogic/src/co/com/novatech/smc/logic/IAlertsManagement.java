package co.com.novatech.smc.logic;

import java.util.Date;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.PlanSmc;

@Remote
public interface IAlertsManagement {

	/**
	 * Método que envía un correo de alerta cuando a un usuario se le es
	 * asignado un outcome.
	 * 
	 * @param idUsuario,
	 *            identificación del usuario.
	 * @param idProgram,
	 *            identificación del programa
	 * @param idStOutcome,
	 *            identificación del outcome.
	 * @param idUser,
	 *            identificacion del usuario
	 */
	public void envioCorreoAsignacionOutcome(long idUsuario, String idProgram, long idStOutcome, long idUser);

	/**
	 * Método que envía un correo recordatorio cuando un plan de assessment es
	 * cambiado de estado.
	 * 
	 * @param idPlan,
	 *            identificación del plan de assessement.
	 * @param idProgram,
	 *            identificación del programa al que pertenece el plan de
	 *            assessment.
	 */
	public void envioCorreoCambioEstadoPlanAsesssment(long idPlan, String idProgram);

	/**
	 * Método que envía un correo recordatorio cuando un plan de assessment
	 * tiene cerca la fecha de recolección de evidencias.
	 * 
	 * @param planSmc,
	 *            identidicador del plan de assessment.
	 * @param idProgram,
	 *            identificación del programa al que pertenece el plan de
	 *            assessment.
	 */
	public void envioCorreoFechaRecoleccionEvidencias(AsSrc fuente, String idProgram);

	/**
	 * Método que envía un correo recordatorio 3 semanas antes de que llegue la
	 * fecha de evaluación del plan de assessment.
	 * 
	 * @param planSmc,
	 *            Plan de asssessment que dentro de 3 semanas será sometido a
	 *            evaluación.
	 */
	public void envioCorreoFechaEvaluacion(PlanSmc planSmc);

	/**
	 * Método que envía un correo de alerta cuando un outcome es desasignado a
	 * un usuario
	 * 
	 * @param idProgram,
	 *            identificación del programa.
	 * @param idStOutcome,
	 *            identificación del outcome.
	 * @param idUser,
	 *            identificación del usuario
	 */
	public void envioCorreoDesasignacionOutcome(String idProgram, long idStOutcome, long idUser);

	/**
	 * Método que verifica que alertas de tipo carga de evidencias deben ser
	 * enviadas si la fecha de envío de la alerta coincide con la actual.
	 */
	public void envioCorreoEvidencias();

	/**
	 * Método que verfica que alertas de tipo fecha de evalución deben ser
	 * enviadas si la fecha de envío de la alerta coincide con la actual.
	 */
	public void envioCorreoEvaluacion();

	/**
	 * Método que permite calcular la fecha de envío de una alerta dada las
	 * semanas de anticipación del evento que se va a tratar
	 * 
	 * @param fecha,
	 *            fecha del evento que se esta tratanto
	 * @param semanas,
	 *            semanas de anticipación del evento de las que serán enviadas
	 *            las alertas
	 * @return Date, fecha del envío del correo.
	 */

	// Reportes de evaluacion

	/**
	 * Método que envía un correo recordatorio cuando un Reporte de evalcuacion
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
