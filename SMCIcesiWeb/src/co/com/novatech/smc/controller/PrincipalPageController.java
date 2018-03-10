package co.com.novatech.smc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;

@ManagedBean(name = "PrincipalPageController")
@ViewScoped()
public class PrincipalPageController {

	public static String PROGRAMA = "SIS";
	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private MainCycle cycle;
	private MainCycle subcycle;
	private MainCycle cycleSesion;
	private MainCycle subcycleSesion;
	private UserCip userSesion;
	private ProgramSmc programSesion;

	private String nameUser;
	private String roles;
	private boolean showAssigment;
	private boolean showPlan;
	private boolean showCreationPlan;
	private boolean showConsultPlan;
	private boolean showEvaluation;
	private boolean showCreationEvaluation;
	private boolean showConsultEvaluation;

	private List<ProgramSmc> losProgramas;
	private List<MainCycle> losCiclos;
	private List<MainCycle> losSubciclos;

	public PrincipalPageController() {
		this.program = null;
		this.cycle = null;
		this.subcycle = null;
		this.programSesion = null;
		this.cycleSesion = null;
		this.subcycleSesion = null;
		nameUser = null;
		roles = "";
		userSesion = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
	}

	public boolean isShowAssigment() {

		if (isDirector(userSesion) || isMECA(userSesion)) {
			showAssigment = true;
		} else {
			showAssigment = false;
		}
		return showAssigment;
	}

	public void setShowAssigment(boolean showAssigment) {
		this.showAssigment = showAssigment;
	}

	public boolean isShowPlan() {
		showPlan = true;
		return showPlan;
	}

	public void setShowPlan(boolean showPlan) {
		this.showPlan = showPlan;
	}

	public boolean isShowCreationPlan() {
		showCreationPlan = false;
		if (isDirector(userSesion) || isMECA(userSesion) || isLider(userSesion)) {
			showCreationPlan = true;
		}
		return showCreationPlan;
	}

	public void setShowCreationPlan(boolean showCreationPlan) {
		this.showCreationPlan = showCreationPlan;
	}

	public boolean isShowConsultPlan() {
		showConsultPlan = true;
		return showConsultPlan;
	}

	public void setShowConsultPlan(boolean showConsultPlan) {
		this.showConsultPlan = showConsultPlan;
	}

	public boolean isShowEvaluation() {
		showEvaluation = false;
		return showEvaluation;
	}

	public void setShowEvaluation(boolean showEvaluation) {
		this.showEvaluation = showEvaluation;
	}

	public boolean isShowCreationEvaluation() {
		showCreationEvaluation = true;

		return showCreationEvaluation;
	}

	public void setShowCreationEvaluation(boolean showCreationEvaluation) {
		this.showCreationEvaluation = showCreationEvaluation;
	}

	public boolean isShowConsultEvaluation() {
		showConsultEvaluation = true;
		return showConsultEvaluation;
	}

	public void setShowConsultEvaluation(boolean showConsultEvaluation) {
		this.showConsultEvaluation = showConsultEvaluation;
	}

	public ProgramSmc getProgramSesion() {

		programSesion = businessDelegate.findProgramById(PROGRAMA);
		for (ProgramSmc programa : getLosProgramas()) {
			if (programa.getIdProgram().equals(programSesion.getIdProgram())) {
				program = programa;
				break;
			}
		}

		return program;
	}

	public void setProgramSesion(ProgramSmc programSesion) {
		this.programSesion = programSesion;
	}

	public MainCycle getCycleSesion() {

		ParamSmc parameter = businessDelegate.findCycleActiveByProgram(program.getIdProgram());

		String cicloSubciclo = parameter.getTextValue();
		String[] x = cicloSubciclo.split("-");
		String ciclo = x[0];

		MainCycle cicloactivoMain = businessDelegate.findByICycle(Long.parseLong(ciclo));

		cycleSesion = cicloactivoMain;

		for (MainCycle mainCycle : getLosCiclos()) {
			if (mainCycle.getIdCycle() == cycleSesion.getIdCycle()) {
				cycle = mainCycle;
				break;
			}
		}
		actionIrACiclo();
		return cycle;

	}

	public void setCycleSesion(MainCycle cycleSesion) {
		this.cycleSesion = cycleSesion;
	}

	public MainCycle getSubcycleSesion() {

		ParamSmc parameter = businessDelegate.findCycleActiveByProgram(program.getIdProgram());

		String cicloSubciclo = parameter.getTextValue();
		String[] x = cicloSubciclo.split("-");
		String ciclo = x[1];

		MainCycle subCicloactivoMain = businessDelegate.findByICycle(Long.parseLong(ciclo));
		subcycle = subCicloactivoMain;

		subcycleSesion = subCicloactivoMain;

		for (MainCycle subCycle2 : getLosSubciclos()) {
			if (subCycle2.getIdCycle() == subcycleSesion.getIdCycle()) {
				subcycle = subCycle2;
				break;
			}
		}
		actionIrACiclo();
		return subcycle;

	}

	public void setSubcycleSesion(MainCycle subcycleSesion) {
		this.subcycleSesion = subcycleSesion;

	}

	public ProgramSmc getProgram() {

		return program;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public List<ProgramSmc> getLosProgramas() {
		if (losProgramas == null) {
			losProgramas = new ArrayList<ProgramSmc>();
			List<ProgramSmc> programas = businessDelegate.findAllProgramas();
			for (ProgramSmc programSmc : programas) {
				losProgramas.add(programSmc);
			}
		}
		return losProgramas;
	}

	public void setLosProgramas(List<ProgramSmc> losProgramas) {
		this.losProgramas = losProgramas;
	}

	public MainCycle getCycle() {
		return cycle;
	}

	public void setCycle(MainCycle cycle) {
		this.cycle = cycle;
	}

	public List<MainCycle> getLosCiclos() {

		if (losCiclos == null) {
			losCiclos = new ArrayList<MainCycle>();

			List<MainCycle> ciclos = businessDelegate.findMainCycleByProgram(program.getIdProgram());

			for (MainCycle cycle : ciclos) {
				losCiclos.add(cycle);
			}
		}

		return losCiclos;
	}

	public void setLosCiclos(List<MainCycle> losCiclos) {
		this.losCiclos = losCiclos;
	}

	public MainCycle getSubcycle() {
		return subcycle;
	}

	public void setSubcycle(MainCycle subcycle) {
		this.subcycle = subcycle;
	}

	public List<MainCycle> getLosSubciclos() {

		if (losSubciclos == null) {
			losSubciclos = new ArrayList<MainCycle>();
			List<MainCycle> subCiclos = businessDelegate.findAllCycleByMainCycle(cycle.getIdCycle());
			for (MainCycle subcycle : subCiclos) {
				losSubciclos.add(subcycle);
			}

		}

		return losSubciclos;
	}

	public void setLosSubciclos(List<MainCycle> losSubciclos) {
		this.losSubciclos = losSubciclos;
	}

	public String getNameUser() {

		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		nameUser = user.getNameUser() + " " + user.getLastName();
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getRoles() {
		roles = "";
		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		List<RoleCip> roles1 = businessDelegate.findRoleByUser(user.getIdUser());

		for (RoleCip roleCip : roles1) {
			roles += roleCip.getName() + " - ";
		}
		roles = roles.substring(0, roles.length() - 2);
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String actionHome() {
		return "/Principal/PrincipalPage.xhtml";
	}

	public String actionAsignar() {
		return "/Asignacion/AssignmentOutcomeView.xhtml";
	}

	public String actionCrearPlan() {
		return "/system/CreatePlanAssessmentView.xhtml";
	}

	public String actionConsultarPlan() {
		return "/system/AssessmentPlanConsult.xhtml";
	}

	public String actionCreateReport() {
		return "/Reports/CreateEvaluationReportView.xhtml";
	}

	public String actionLogout() {
		FacesUtils.getSession().invalidate();
		FacesUtils.getHttpSession(true);
		return "/Login/LoginView.xhtml";
	}

	public String actionIrACiclo() {

		PROGRAMA = getProgram().getIdProgram();
		cycleSesion = cycle;
		subcycleSesion = subcycle;

		programSesion = getProgram();

		return "/Principal/PrincipalPage.xhtml";
	}

	public String actionRendered() {
		return "false";
	}

	public void onProgramChange() {

		if (program != null) {

			losCiclos = null;
			losSubciclos = null;

			losCiclos = businessDelegate.findMainCycleByProgram(program.getIdProgram());

		}

	}

	public void onCycleChange() {
		if (cycle != null) {
			losSubciclos = null;

			losSubciclos = businessDelegate.findAllCycleByMainCycle(cycle.getIdCycle());
		}
	}

	public void onSubCycleChange() {
		if (cycle != null) {
			System.out.println("onchangesubcycle");
		}
	}

	public void actionConsult() {

		FacesUtils.putinSession("ProgramC", program);
		FacesUtils.putinSession("MainCycle", cycle);
		FacesUtils.putinSession("SubCycle", subcycle);
		try {
			reload();
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public void reload() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public boolean isMECA(UserCip user) {
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());

		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 3) {

				return true;
			}
		}
		return false;
	}

	public boolean isDirector(UserCip user) {
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 2) {

				return true;
			}
		}
		return false;
	}

	public boolean isLider(UserCip user) {
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 1) {

				return true;
			}
		}
		return false;
	}

	public boolean isProfesor(UserCip user) {
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 4) {

				return true;
			}
		}
		return false;
	}

}
