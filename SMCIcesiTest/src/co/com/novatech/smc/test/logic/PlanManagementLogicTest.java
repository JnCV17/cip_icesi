package co.com.novatech.smc.test.logic;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.logic.IOutcomeCycleALogic;
import co.com.novatech.smc.logic.IOutcomeLogic;
import co.com.novatech.smc.logic.IParameterLogic;
import co.com.novatech.smc.logic.IPeriodLogic;
import co.com.novatech.smc.logic.IPlanLogic;
import co.com.novatech.smc.logic.IProgramLogic;
import co.com.novatech.smc.logic.IStateLogic;
import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class PlanManagementLogicTest {

	private static IPlanLogic planManagementLogic;
	private static IProgramLogic programLogic;
	private static IPlanLogic planLogic;
	private static IOutcomeLogic outcomeLogic;
	private static IUserCipLogic userCipLogic;
	private static IPeriodLogic periodLogic;
	private static IStateLogic stateLogic;
	private static IOutcomeCycleALogic outcomeCycleALogic;
	private static IParameterLogic parameterLogic;
	// private static final Logger log =
	// LoggerFactory.getLogger(UsuarioLogicaTest.class);

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			planLogic = (IPlanLogic) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.IPLANLOGIC);

			// planManagementLogic = (IPlanLogic) new
			// InitialContext(pruebasUtil.getProperties())
			// .lookup(InfoLookUp.IPLANMANAGEMENTLOGIC);
			programLogic = (IProgramLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IPROGRAMLOGIC);
			outcomeLogic = (IOutcomeLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IOUTCOMELOGIC);
			userCipLogic = (IUserCipLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IUSERCIPLOGIC);
			periodLogic = (IPeriodLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IPERIODLOGIC);
			stateLogic = (IStateLogic) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.ISTATELOGIC);
			outcomeCycleALogic = (IOutcomeCycleALogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IOUTCOMECYCLEALOGIC);
			parameterLogic = (IParameterLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IPARAMETERLOGIC);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aFiltrarPlanesPorOutcome() {
		//
		// String planesEsperados = "1,12,45,";
		// String losPlanes = "";

		List<PlanSmc> allPlanes = planLogic.findAll();

		Outcome out = outcomeLogic.findbyId(1L);

		List<PlanSmc> filtro = planManagementLogic.filtrarPlanesPorOutcome(allPlanes, out);

		for (PlanSmc planSmc : filtro) {

			// losPlanes += planSmc.getIdPlan() + ",";
			System.out.println(planSmc.getIdPlan());
		}

		// assertEquals(losPlanes, planesEsperados);

	}

	@Test
	public void bFiltrarPlanesPorPrograma() {

		System.out.println(new Date());
		// String actual =
		// "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,45,46,47,48,49,50,";
		// String esperado = "";
		System.out.println("Entro");
		List<PlanSmc> allPlanes = planLogic.findAll();
		ProgramSmc program = programLogic.findProgramById("SIS");

		List<PlanSmc> filtros = planLogic.filtrarPlanesPorPrograma(allPlanes, program);

		for (PlanSmc planSmc : filtros) {

			// esperado += planSmc.getIdPlan() + ",";

			System.out.println(planSmc.getIdPlan());
		}

		// assertEquals(actual, esperado);

	}

	@Test
	public void cCrearNuevoPlan() throws Exception {

		UserCip user = userCipLogic.findByIdUser(7);
		System.out.println(user.getLogin());
		StateSmc state = stateLogic.findById(3);
		System.out.println(state.getStateName());
		OutcomeCycleA out = outcomeCycleALogic.findByIid(1);
		System.out.println(out);
		PlanSmc plan = new PlanSmc();
		plan.setCreationDate(new Date());
		plan.setPeriodIdPeriod(new BigDecimal("201110"));
		plan.setUserCip(user);
		plan.setStateSmc(state);
		plan.setOutcomeCycleA(out);
		planManagementLogic.savePlan(plan);

		assertNotNull(plan);

	}

	@Test
	public void dCrearPlanAPartirdeOtro() {

		PlanSmc plan = planLogic.findByid(14);
		UserCip user = userCipLogic.findByIdUser(5000);
		BigDecimal period = periodLogic.periodToPlan();

		System.out.println(user.getNameUser() + " Creo el Plan con id " + plan.getIdPlan() + " en el periodo "
				+ plan.getPeriodIdPeriod().toString());
		StateSmc state = stateLogic.findById(9);
		System.out.println("Su estado es: " + state.getStateName());
		ProgramSmc programa = plan.getOutcomeCycleA().getOutcome().getProgramSmc();
		Date fecha = new Date();
		long subcycle = parameterLogic.subcycleActiveByProgram(programa);
		OutcomeCycleA out = outcomeCycleALogic
				.findOutcomeCycleByidOutcome(plan.getOutcomeCycleA().getOutcome().getIdStOutcome(), subcycle);

		try {

			planLogic.createPlanFromAnother(plan, user, state, period, out, fecha);
		} catch (Exception e) {

			e.printStackTrace();
		}

		assertNotNull(plan);

	}

	@Test
	public void eCambiarEstadoPlan() {
		//
		// PlanSmc planAprobado = planLogic.findByid(50);
		// PlanSmc planBorrador = planLogic.findByid(49);
		// PlanSmc planEjecucion = planLogic.findByid(48);
		// PlanSmc planCompletado = planLogic.findByid(51);

		PlanSmc planBorrador = planLogic.findByid(50);
		PlanSmc planAprobado = planLogic.findByid(48);

		UserCip user = userCipLogic.findByIdUser(5000);

		// String nameState = planAprobado.getStateSmc().getStateName();
		// System.out.println("Estado actual: " + nameState);

		StateSmc stateBorrador = stateLogic.findById(9);
		StateSmc stateAprobado = stateLogic.findById(10);
		StateSmc stateEjecucion = stateLogic.findById(11);
		StateSmc stateCompletado = stateLogic.findById(12);

		try {
			planManagementLogic.cambiarEstadoPlanAssessment(planBorrador, stateAprobado, user);

			assertNotEquals("Los estados son iguales", planBorrador.getStateSmc().getIdState(),
					stateAprobado.getIdState());

			planManagementLogic.cambiarEstadoPlanAssessment(planBorrador, stateBorrador, user);
			assertNotEquals("Los estados son iguales", planBorrador.getStateSmc().getIdState(),
					stateBorrador.getIdState());

			planManagementLogic.cambiarEstadoPlanAssessment(planBorrador, stateEjecucion, user);
			assertNotEquals("Los estados son iguales", planAprobado.getStateSmc().getIdState(),
					stateEjecucion.getIdState());

			planManagementLogic.cambiarEstadoPlanAssessment(planBorrador, stateCompletado, user);
			assertNotEquals("Los estados son iguales", planBorrador.getStateSmc().getIdState(),
					stateCompletado.getIdState());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// @Test
		// public void dBuscarOutcomexPrograma() {
		// String proga = "Ingeniería Telemática";
		// ProgramSmc pro1 = programLogic.findProgramByName(proga);
		// try {
		// System.out.println("programa00000000000000000000000000000000000000000000000");
		// UserCip usu = userCipLogic.findByIdUser(6);
		//
		// Outcome out = outcomeLogic.findbyId(26);
		//
		// List<Outcome> listaDeOutcome = new ArrayList<Outcome>();
		//
		// listaDeOutcome.add(out);
		// usu.setOutcomes(listaDeOutcome);
		// out.setUserCip(usu);
		//
		// //
		// // List<Outcome> outcomesss = usu.getOutcomes();
		// System.out.println("programa" + pro1.getNameProgram());
		//
		// ProgramSmc pro =
		// programLogic.findProgramByName(pro1.getNameProgram());
		// List<String> outcomes = new ArrayList<String>();
		// List<Outcome> outs =
		// outcomeLogic.findOutcomesByProgram(pro.getIdProgram());
		// for (Outcome outcome : outs) {
		// System.out.println(outcome.getCriterion());
		// outcomes.add(outcome.getCriterion());
		// }
		//
		// List<Outcome> outcomesss = usu.getOutcomes();
		// List<Outcome> filtrados = new ArrayList<Outcome>();
		// for (Outcome outcome : outcomesss) {
		// if (outcomes.contains(outcome.getCriterion())) {
		// filtrados.add(outcome);
		// }
		//
		// }
		//
		// System.out.println("lider del outcome 26 es " +
		// out.getUserCip().getLastName());
		//
		// } catch (
		//
		// Exception e) {
		//
		// e.printStackTrace();
		// }
		//
		// }
	}
}
