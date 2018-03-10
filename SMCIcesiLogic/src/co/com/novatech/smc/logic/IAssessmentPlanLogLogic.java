package co.com.novatech.smc.logic;

import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.UserCip;

public interface IAssessmentPlanLogLogic {

	public void guardarCambioEstado(String description, PlanSmc plan, UserCip user);

	public void guardarCambioEstadoEvalReport(String description, EvalReport evalReport, UserCip user);

}
