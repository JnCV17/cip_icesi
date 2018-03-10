package co.com.novatech.smc.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IEvalCycleDao;
import co.com.novatech.smc.dao.IEvalReportDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.EvalCycle;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;

@Stateless
public class EvaluationReportLogic implements IEvaluationReportLogic {

	public final static long IN_PROCESS = 11;
	public final static long COMPLETED = 12;

	@EJB
	private IEvalReportDao evaluationReportDao;

	@EJB
	private IEvalCycleDao evalCycleDao;

	@EJB
	private IPlanLogic planLogic;

	@EJB
	private IAssessmentPlanLogLogic assessmentPlanLogLogic;

	@EJB
	private IAlertsManagement alertManagementLogic;

	@EJB
	private IUserCipRoleCipLogic userCipRoleCipLogic;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveEvalReport(EvalReport evalReport) throws Exception {
		if (evalReport == null) {
			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}

		EvalReport evalReportPrueba = evaluationReportDao.findByIdEvalReport(evalReport.getIdEvalReport());
		if (evalReportPrueba != null) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		if (planWasCreate(evalReport.getEvalCycle().getIdEvalCycle())) {
			throw new Exception("Report is already exist");
		}

		// evalacycle,usercip2, statesmc, period

		if (evalReport.getEvalCycle() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Evalcycle id");
		}

		if (evalReport.getPeriodIdPeriod() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Period id");
		}

		if (evalReport.getStateSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("State");
		}
		if (evalReport.getUserCip2() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserCip id");
		}

		evaluationReportDao.persistEvalReport(evalReport);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateEvalReport(EvalReport evalReport) throws Exception {

		if (evalReport == null) {
			throw new ZMessManager().new NullEntityExcepcion("Evaluation Report");
		}

		if (evalReport.getEvalCycle() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Evalcycle id");
		}

		if (evalReport.getPeriodIdPeriod() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Period id");
		}

		if (evalReport.getStateSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("State");
		}
		if (evalReport.getUserCip2() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserCip id");
		}

		evaluationReportDao.mergeEvalReport(evalReport);

	}

	@Override
	public List<EvalReport> findAllEvalReport() {

		return evaluationReportDao.getEvalReportFindAll();
	}

	@Override
	public EvalReport findByIdEvalReport(long idEvalReport) {

		return evaluationReportDao.findByIdEvalReport(idEvalReport);
	}

	public boolean planWasCreate(long idEvalCycle) {
		boolean isCreate = false;
		List<EvalReport> losReportes = evaluationReportDao.getEvalReportFindAll();
		for (EvalReport report : losReportes) {
			if (report.getEvalCycle().getIdEvalCycle() == idEvalCycle) {
				isCreate = true;
				break;
			}
		}

		return isCreate;

	}

	@Override
	public void cambiarEstadoEvalReport(EvalReport evalReport, StateSmc estado, UserCip user) throws Exception {

		if (estado.getIdState() == IN_PROCESS) {
			if (evalReport.getStateSmc().getIdState() == COMPLETED) {
				throw new Exception(" You cannot change the state because the evaluation report is completed");
			}
		}
		// List<RoleCip> roles =
		// userCipRoleCipLogic.findRoleByUser(user.getIdUser());
		// for (RoleCip roleCip : roles) {
		// if (!(roleCip.getIdRole() != 1 || roleCip.getIdRole() != 2 ||
		// roleCip.getIdRole() != 3)) {
		// throw new Exception(
		// " You cannot change the state because you're not an Outcome leader or
		// Director Program or MECA");
		// }
		// }

		// assessmentPlanLogLogic.guardarCambioEstadoEvalReport("State
		// evaluation report have changed from"
		// + evalReport.getStateSmc().getStateName() + " to" +
		// estado.getStateName(), evalReport, user);
		evalReport.setStateSmc(estado);
		updateEvalReport(evalReport);
		alertManagementLogic.envioCorreoCambioEstadoReporteDeEvaluacion(evalReport);

	}

	@Override
	public List<EvalReport> findAllEvalCycleByProgramCycleSubcicle(ProgramSmc program, List<MainCycle> losCiclos,
			List<MainCycle> losSubciclos, MainCycle cycle) {

		List<EvalReport> filtrados = new ArrayList<EvalReport>();
		if (program != null) {
			List<PlanSmc> planes = planLogic.filtrarPlanesPorPrograma(planLogic.findAll(), program);

			for (PlanSmc planSmc : planes) {
				List<EvalCycle> eval = planSmc.getEvalCycles();

				for (EvalCycle evalCycle : eval) {

					for (EvalReport evalRe : evalCycle.getEvalReports()) {

						if (evalRe != null) {
							filtrados.add(evalRe);
							if (losCiclos != null && cycle != null) {
								List<EvalCycle> evalCicl = evalCycleDao.findIdEvalByIdCycle(cycle.getIdCycle());
								if (!evalCicl.isEmpty()) {

									for (EvalCycle evalCycl : evalCicl) {

										for (EvalReport evalR : evalCycl.getEvalReports()) {

											if (evalR != null) {

												filtrados.add(evalR);

												if (losSubciclos != null && cycle != null) {
													List<EvalCycle> evalCic = evalCycleDao
															.findIdEvalByIdCycle(cycle.getIdCycle());
													for (EvalCycle evalCyc : evalCic) {

														for (EvalReport eva : evalCyc.getEvalReports()) {

															if (eva != null) {

																filtrados.add(eva);
															}
														}
													}
												}

											}

										}
									}
								}

							}
						}

					}
				}
			}

			// return filtrados;
		}
		return filtrados;

	}

	@Override
	public void validarDescarga(EvalReport eval) throws Exception {
		if (eval == null) {

			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}

		if (eval.getRubricFile() == null) {

			throw new Exception("Evaluation Report  haven't a rubric file");
		}

	}

}
