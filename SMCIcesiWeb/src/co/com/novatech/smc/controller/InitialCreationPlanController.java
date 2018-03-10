package co.com.novatech.smc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.Alert;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;

@ManagedBean(name = "InitialCreationPlanController")
@SessionScoped
public class InitialCreationPlanController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private Outcome outcome;
	private UserCip user;
	private MainCycle subCycle;
	
	

	private List<Outcome> outcomes;
	private List<ProgramSmc> programs;

	public InitialCreationPlanController() {

		this.program = null;
		this.outcome = null;
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
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

	public ProgramSmc getProgram() {
		return program;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public Outcome getOutcome() {

		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public UserCip getUser() {

		user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		return user;
	}

	public void setUser(UserCip user) {
		this.user = user;
	}

	public MainCycle getSubCycle() {
		subCycle = (MainCycle) SessionUtil.getFromSession("SubCycle");

		return subCycle;
	}

	public void setSubCycle(MainCycle subCycle) {
		this.subCycle = subCycle;
	}

	public void listenerOutcomes() {
		getUser();

		ProgramSmc op = program;
		ProgramSmc pro1 = businessDelegate.findProgramById(program.getIdProgram());

		// -----IMMPLEMENTACION PARA STRATEGY--------//
		int rul = 0;
		for (RoleCip role : businessDelegate.findRoleByUser(user.getIdUser())) {
			if (role.getIdRole() == 3) {
				rul = 3;// meca
				break;
			}

			if (role.getIdRole() == 2) {
				rul = 2; // director programa
				break;
			} else {

				rul = 1; // lider de outcome
			}
		}

		switch (rul) {
		case 3:
			try {
				if (outcome == null) {
					outcomes = new ArrayList<Outcome>();
					ProgramSmc pro = businessDelegate.findProgramById(program.getIdProgram());

					List<Outcome> outs = businessDelegate.findOutcomeByIdProgram(pro.getIdProgram());
					for (Outcome outcome : outs) {
						if (outcome.getStateSmc().getIdState() == 5)
							outcomes.add(outcome);

					}
				}
			} catch (Exception e) {

				FacesUtils.addErrorMessage("", e.getMessage());
			}
			break;
		case 2:

			if (pro1.getUserCip().getIdUser() == user.getIdUser()) {
				try {
					if (outcome == null) {
						outcomes = new ArrayList<Outcome>();

						List<ProgramSmc> proDir = businessDelegate.getFindProgramByDirector(user.getIdUser());

						for (ProgramSmc programSmc : proDir) {

							if (programSmc.getIdProgram().trim().equals(pro1.getIdProgram().trim())) {

								List<Outcome> outs = businessDelegate.findOutcomeByIdProgram(pro1.getIdProgram());
								for (Outcome outcome : outs) {
									if (outcome.getStateSmc().getIdState() == 5)
										outcomes.add(outcome);

								}
							}
						}

					}
				} catch (Exception e) {

					FacesUtils.addErrorMessage("", e.getMessage());
				}
				break;

			} else {
				List<Outcome> outcomes = new ArrayList<Outcome>();
				List<Outcome> outs;
				try {
					outs = businessDelegate.findOutcomeByIdProgram(pro1.getIdProgram());
					for (Outcome outcome : outs) {
						outcomes.add(outcome);
					}
					List<Outcome> outcomesss = businessDelegate.findOutcomeByUser(user.getIdUser());
					List<Outcome> filtrados = new ArrayList<Outcome>();
					for (Outcome outcome : outcomesss) {
						for (Outcome outc : outcomes) {
							if (outc.getIdStOutcome() == outcome.getIdStOutcome()) {
								if (outcome.getStateSmc().getIdState() == 5)
									filtrados.add(outcome);
								// this.outcome = outcome;
							}
						}

					}
					this.outcomes = filtrados;
				} catch (Exception e) {

					e.printStackTrace();
				}

			}
			break;
		default:

			try {

				List<Outcome> outcomes = new ArrayList<Outcome>();
				List<Outcome> outs = businessDelegate.findOutcomeByIdProgram(pro1.getIdProgram());
				for (Outcome outcome : outs) {
					outcomes.add(outcome);
				}

				List<Outcome> outcomesss = businessDelegate.findOutcomeByUser(user.getIdUser());
				List<Outcome> filtrados = new ArrayList<Outcome>();
				for (Outcome outcome : outcomesss) {
					for (Outcome outc : outcomes) {
						if (outc.getIdStOutcome() == outcome.getIdStOutcome()) {
							filtrados.add(outcome);
							// this.outcome = outcome;
						}
					}

				}
				this.outcomes = filtrados;

			} catch (Exception e) {

				FacesUtils.addErrorMessage("", e.getMessage());
			}
			break;

		}

	}

	public String cancelAction() {
		return "/Principal/PrincipalPage.xhtml";
	}

	public String createAction() {
		String retor = "";
		getUser();

		try {

			Date fecha = new Date();
			BigDecimal period = businessDelegate.periodToPlan();
			long subcycle = businessDelegate.subcycleActiveByProgram(program);
			StateSmc state = businessDelegate.findById(9);
			OutcomeCycleA out = businessDelegate.findOutcomeCycleByidOutcome(outcome.getIdStOutcome(), subcycle);

			businessDelegate.savePlanInicial(fecha, period, out.getIdOutcoCycle(), state.getIdState(),
					user.getIdUser());
			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			String uri = req.getRequestURI();
			
			PlanSmc pl= businessDelegate.findPlanByOutcome(out.getIdOutcoCycle());
			try {
				FacesUtils.putinSession("plan", pl);
				res.getWriter()
						.println("<script>window.open('" + "AssessmentView.xhtml"
								+ "','_blank', 'location=yes,height=600,width=800,scrollbars=yes,status=yes'); window.parent.location.href= '"
								+ uri + "';</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
			FacesUtils.addInfoMessage("", "The assessment plan was created sucessfull");

		} catch (Exception e2) {

			FacesUtils.addErrorMessage("", e2.getMessage());
		}
		return retor;

	}
	
	public String onPageLoadForNewTab() {
		// PlanSmc pl = infoEvalu.getPlan();
		//
		
	
		HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String uri = req.getRequestURI();
		
		try {
			res.getWriter()
					.println("<script>window.open('" + "AssessmentView.xhtml"
							+ "','_blank', 'location=yes,height=600,width=800,scrollbars=yes,status=yes'); window.parent.location.href= '"
							+ uri + "';</script>");
		} catch (IOException e) {

			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();

		return "";
	}
}
