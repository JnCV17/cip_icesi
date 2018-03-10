package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioSkill;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;

@Remote
public interface IPlanLogic {

	/**
	 * Método que guarda un Plan de Assessment
	 * 
	 * @param plan
	 *            Plan que se va a agregar
	 * @throws Exception
	 * 
	 *             Si el plan es nulo, si el plan ya existe, Si la fecha de
	 *             creación es null, si el periodo asociado es null, si el ciclo
	 *             asociado es null, si el outcome asociado es nulo, si el
	 *             estado es nulo, si el usuario creador del Plan es nulo
	 * 
	 */
	public void savePlan(PlanSmc plan) throws Exception;

	/**
	 * Método que actualiza un Plan de Assessment
	 * 
	 * @param plan
	 *            Plan que se va a actualizar
	 * 
	 * @throws Exception
	 *             Si el plan es nulo, Si la fecha de creación es null, si el
	 *             periodo asociado es null, si el ciclo asociado es null, si el
	 *             si el outcome asociado es nulo, si el estado es nulo, si el
	 *             usuario creador del Plan es nulo
	 */
	public void updatePlan(PlanSmc plan) throws Exception;

	/**
	 * Método que retorna una lista con todos los planes de Assessment en el
	 * sistema
	 * 
	 * @return una lista de todos lo planes
	 */
	public List<PlanSmc> findAll();

	/**
	 * Método que se encarga de buscar un Plan de Assessment
	 * 
	 * @param id
	 *            id el plan de Assessment
	 * 
	 * @return
	 */
	public PlanSmc findByid(long id);

	/**
	 * Método que busca todos los planes de Assessment que se crearon en una
	 * fecha
	 * 
	 * @param dateOfCreation
	 *            Fecha en la que se crearon los planes de Assessment
	 * @return Una lista de planes que fueron creados en esa fecha
	 */
	public List<PlanSmc> findByDateOfCreation(Date dateOfCreation);

	/**
	 * Método para crear un nuevo Plan de assessment a partir de otro
	 * 
	 * @param plan,
	 *            el plan a partir del cual se creara el nuevo plan
	 * @param user,
	 *            el creador del paln
	 * @throws Exception,
	 *             en caso de que no se pueda crear el plan.
	 */
	public void createPlanFromAnother(PlanSmc plan, UserCip user, StateSmc state, BigDecimal period, OutcomeCycleA out,
			Date fecha) throws Exception;

	/**
	 * Método que busca todos los planes de Assessment que pertenecen a un ciclo
	 * 
	 * @param cycle
	 *            Ciclo al cual pertenecen los Planes de Assessment
	 * @return Una lista de planes que fueron creados en ese ciclo
	 */

	/**
	 * Metodo que valida que un plan tenga una rubrica para descargar
	 * 
	 * @param plan
	 *            , plan que se va a buscar para saber si tiene una rubrica
	 *            asociada
	 * @throws Exception,
	 *             si el plan asociado no tiene una rubrica, si el plan es null
	 */

	public void validarDescarga(PlanSmc plan) throws Exception;

	/**
	 * 
	 * @param plan
	 * @throws Exception
	 */

	public void validarCarga(PlanSmc plan) throws Exception;

	/**
	 * Busca un Plan por su outcome
	 * 
	 * @param idOutcome,
	 *            el outcome por el que se desea buscar
	 * @return el plan asociado a ese outcome
	 */
	public PlanSmc findPlanByOutcome(long idOutcome);

	/**
	 * Modifica un plan de assessment (cuando se le agrega un PI)
	 * 
	 * @param idAssessmenPlan,
	 *            el id del plan por el que se desea buscar
	 * 
	 */
	public void modifyAssessmentPlan(long idAssessmentPlan, PiSmc pi, CdioSkill competenciaCdio, Course cursoFuente,
			Method metodoAs, Date recoleccion, String frecuencia, UserCip profesor, Date evaluacion) throws Exception;

	public void validarCargaEvidencia(PlanSmc plan) throws Exception;

	/**
	 * Metodo para filtrar un conjunto de planes de assesment dado, por el
	 * programa pasado por parametro
	 * 
	 * @param planes
	 *            listado de planes de assessment que seran filtrado, debe ser
	 *            diferente de null y no puede estar vacio
	 * @param programa
	 *            objeto programa por el cual se realizara el filtro, debe ser
	 *            diferente de null y existir dentro del sistema
	 * @return listado de planes de assessment filtrado segun el criterio dado
	 *         por parametro
	 */
	public List<PlanSmc> filtrarPlanesPorPrograma(List<PlanSmc> planes, ProgramSmc programa);

	/**
	 * 
	 * Metodo para filtrar un conjunto de planes de assesment dado, por el
	 * outcome pasado por parametro
	 * 
	 * @param planes
	 *            listado de planes de assessment que seran filtrado, debe ser
	 *            diferente de null y no puede estar vacio
	 * @param outcome
	 *            objeto outcome por el cual se realizara el filtro, debe ser
	 *            diferente de null y existir dentro del sistema
	 * @return listado de planes de assessment filtrado segun el criterio dado
	 *         por parametro
	 */
	public List<PlanSmc> filtrarPlanesPorOutcome(List<PlanSmc> planes, Outcome outcome);

	/**
	 * Método para cambiar el estado de un Plan de Assessment
	 * 
	 * @param plan,
	 *            el plan al cuál se le cambiara el estado
	 * 
	 * @throws Exception,
	 *             si el plan de assessment es null
	 */
	public void cambiarEstadoPlanAssessment(PlanSmc plan, StateSmc estado, UserCip user) throws Exception;

}
