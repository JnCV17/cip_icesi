package co.com.novatech.smc.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.delegate.GenericLookup;
import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.logic.IEvideFileLogic;
import co.com.novatech.smc.logic.IPlanLogic;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class BusinessDelegateTest {
	private static IBusinessDelegate delegado;

	private static IEvideFileLogic evideFileLogic;
	private static IPlanLogic planLogic;

	static GenericLookup gl = new GenericLookup();
	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		delegado = gl.lookupDelegate();

		try {
			delegado = (IBusinessDelegate) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IBUSINESSDELEGATELOGIC);
			evideFileLogic = (IEvideFileLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IEVIDEFILELOGIC);

			planLogic = (IPlanLogic) new InitialContext(pruebasUtil.getProperties()).lookup(InfoLookUp.IPLANLOGIC);
		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aGuardarEvideFile() {
		//
		// String planesEsperados = "1,12,45,";
		// String losPlanes = "";

		// delegado.saveEvideFile(evideFile);

		// assertEquals(losPlanes, planesEsperados);

	}

	@Test
	public void bEliminarEvideFile() {
		//
		// String planesEsperados = "1,12,45,";
		// String losPlanes = "";

		// List<PlanSmc> allPlanes = planLogic.findAll();
		//
		// Outcome out = outcomeLogic.findbyId(1L);
		//
		// List<PlanSmc> filtro =
		// planManagementLogic.filtrarPlanesPorOutcome(allPlanes, out);
		//
		// for (PlanSmc planSmc : filtro) {
		//
		// // losPlanes += planSmc.getIdPlan() + ",";
		// System.out.println(planSmc.getIdPlan());
		// }

		// assertEquals(losPlanes, planesEsperados);

	}

	// @Test
	// public void pruebita() {
	//
	// // public void dBuscarOutcomexPrograma() throws Exception {
	// String proga = "Ingeniería Telemática";
	// // ProgramSmc pro = delegado.findProgramByName(proga);
	// List<Outcome> outs;
	// try {
	// outs = delegado.findOutcomeByNameProgram(proga);
	// for (Outcome outcome : outs) {
	// System.out.println(outcome.getCriterion());
	// }
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	// }

	// String d =
	// "java:global/SMCIcesi/SMCIcesiLogic/MessUserLogic!co.com.novatech.smc.logic.IMessUserLogic";
	// System.out.println(gl.pruebita("MessUserLogic"));
	// System.out.println(d);
	//
	// // delegado.saveStateType("PRUEBA_2");
	// delegado.saveOutcome("T", "Prueba delegadito", "Prueba delegado",
	// "SIS", 3);
	// System.out.println(delegado.findByIdUser(3500).getNameUser());
	// delegado.saveUser("AGUIRRE", "AGUIRRE", "AGUIRRE", "AGUIRRE",
	// "AGUIRRE", "AGUIRRE", 3);

}
