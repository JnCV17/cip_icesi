package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.novatech.smc.dao.IAssessmentPlanLogDao;
import co.com.novatech.smc.modelo.AssessmentPlanLog;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.UserCip;

@Stateless
public class AssessmentPlanLogLogic implements IAssessmentPlanLogLogic {

	@EJB
	private IAssessmentPlanLogDao assessmentPlanLogDao;

	public void guardarCambioEstado(String descripcion, PlanSmc plan, UserCip usuario) {

		AssessmentPlanLog newAssessmentPlanLog = new AssessmentPlanLog();
		newAssessmentPlanLog.setActionDate(new Date());
		newAssessmentPlanLog.setCreationDate(plan.getCreationDate());
		newAssessmentPlanLog.setEvaluationDate(plan.getEvaluationDate());
		newAssessmentPlanLog.setEvaluationFrequency(plan.getEvaluationFrequency());
		newAssessmentPlanLog.setIdCycle(new BigDecimal("09"));
		newAssessmentPlanLog.setIdPeriod(plan.getPeriodIdPeriod());
		newAssessmentPlanLog.setLastIdState(new BigDecimal(plan.getIdPlan()));
		newAssessmentPlanLog.setIdState(new BigDecimal(plan.getStateSmc().getIdState()));
		newAssessmentPlanLog.setIdStudentOutcome(new BigDecimal(plan.getOutcomeCycleA().getIdOutcoCycle()));
		newAssessmentPlanLog.setIdUser(new BigDecimal(usuario.getIdUser()));
		newAssessmentPlanLog.setLogAction(descripcion);
		assessmentPlanLogDao.persistAssessmentPlanLog(newAssessmentPlanLog);
	}

	@Override
	public void guardarCambioEstadoEvalReport(String description, EvalReport evalReport, UserCip user) {
		AssessmentPlanLog newAssessmentPlanLog = new AssessmentPlanLog();
		newAssessmentPlanLog.setActionDate(new Date());
		newAssessmentPlanLog.setIdAssessmentPlanLog(evalReport.getIdEvalReport());
		newAssessmentPlanLog.setIdCycle(new BigDecimal("09"));
		newAssessmentPlanLog.setIdPeriod(evalReport.getPeriodIdPeriod());

		newAssessmentPlanLog.setIdState(new BigDecimal(evalReport.getStateSmc().getIdState()));
		newAssessmentPlanLog.setIdUser(new BigDecimal(user.getIdUser()));
		newAssessmentPlanLog.setLogAction(description);
		assessmentPlanLogDao.persistAssessmentPlanLog(newAssessmentPlanLog);

	}

}
