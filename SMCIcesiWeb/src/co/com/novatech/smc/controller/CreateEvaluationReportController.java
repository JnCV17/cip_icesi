package co.com.novatech.smc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.EvalCycle;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;

@ManagedBean(name = "CreateEvaluationReportController")
@SessionScoped
public class CreateEvaluationReportController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private PlanSmc plan;
	private UserCip user;

	private List<PlanSmc> plans;
	private List<ProgramSmc> programs;

	public CreateEvaluationReportController() {
		this.program = null;
		this.plan = null;
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
	}

	// Getters and setterss

	public ProgramSmc getProgram() {
		return program;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public PlanSmc getPlan() {
		return plan;
	}

	public void setPlan(PlanSmc plan) {
		this.plan = plan;
	}

	public UserCip getUser() {
		user = (UserCip) SessionUtil.getFromSession("usuarioSesion");

		return user;
	}

	public void setUser(UserCip user) {
		this.user = user;
	}

	public List<PlanSmc> getPlans() {
		return plans;
	}

	public void setPlans(List<PlanSmc> plans) {
		this.plans = plans;
	}

	public List<ProgramSmc> getPrograms() {

		if (programs == null) {
			programs = new ArrayList<ProgramSmc>();
			List<ProgramSmc> programas = businessDelegate.findAllProgramas();
			for (ProgramSmc programSmc : programas) {
				programs.add(programSmc);
			}
		}

		return programs;
	}

	public void setPrograms(List<ProgramSmc> programs) {
		this.programs = programs;
	}

	// METODOS

	public void listenerPlans() {
		getProgram();

		List<PlanSmc> planes = businessDelegate.filtrarPlanesPorPrograma(program.getIdProgram());
		long subcycle = businessDelegate.subcycleActiveByProgram(program);
		if (plan == null) {
			plans = new ArrayList<PlanSmc>();
			for (PlanSmc planSmc : planes) {

				if (planSmc.getOutcomeCycleA().getMainCycle().getIdCycle() == subcycle) {

					plans.add(planSmc);
				}
			}
			// for (PlanSmc planSmc : planes) {

			// plans.add(planSmc);
		}
		// }

	}

	public String cancelAction() {
		return "/Principal/PrincipalPage.xhtml";
	}

	public String createAction() {
		String retor = "";
		try {
			user = getUser();
			EvalCycle pl = businessDelegate.findByIdEvalCycleByIdPlan(plan.getIdPlan());
			// System.out.println(pl.getIdEvalCycle());
			// System.out.println(plan.getOutcomeCycleA().getOutcome().getCriterion());

			businessDelegate.saveEvalReport(user.getIdUser(), pl.getIdEvalCycle());

			FacesUtils.addInfoMessage("", "The evaluation report was created sucessfull");
			// retor = "/system/AssessmentView.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addInfoMessage("", e.getMessage());
		}

		return retor;
	}

}
