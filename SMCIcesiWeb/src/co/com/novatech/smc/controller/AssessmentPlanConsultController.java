package co.com.novatech.smc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.util.FacesUtils;
import co.sco.novatech.smc.dto.PlanesInfoDto;

@ManagedBean(name = "AssessmentPlanConsultController")
@SessionScoped
public class AssessmentPlanConsultController {

	Logger log = LoggerFactory.getLogger(AssessmentPlanConsultController.class);

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private MainCycle subcycle;
	private PlanesInfoDto planInfo;
	private MainCycle cycle;

	private List<MainCycle> losCiclos;
	private List<ProgramSmc> losProgramas;
	private List<MainCycle> losSubciclos;
	private List<PlanesInfoDto> infoPlans;

	public AssessmentPlanConsultController() {
		try {
			program = (ProgramSmc) FacesUtils.getfromSession("programConsul");
			subcycle = (MainCycle) FacesUtils.getfromSession("subcycleConsul");
			cycle = (MainCycle) FacesUtils.getfromSession("cycleConsul");

		} catch (Exception e) {
			this.program = null;
			this.cycle = null;
			this.subcycle = null;
			this.planInfo = null;
			e.printStackTrace();
		}

		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);

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

	public ProgramSmc getProgram() {
		return program;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public MainCycle getCycle() {
		return cycle;
	}

	public void setCycle(MainCycle cycle) {
		this.cycle = cycle;
	}

	public MainCycle getSubcycle() {
		return subcycle;
	}

	public void setSubcycle(MainCycle subcycle) {
		this.subcycle = subcycle;
	}

	public List<MainCycle> getLosCiclos() {
		return losCiclos;
	}

	public void setLosCiclos(List<MainCycle> losCiclos) {
		this.losCiclos = losCiclos;
	}

	public List<MainCycle> getLosSubciclos() {

		return losSubciclos;
	}

	public void setLosSubciclos(List<MainCycle> losSubciclos) {
		this.losSubciclos = losSubciclos;
	}

	public IBusinessDelegate getBusinessDelegate() {
		return businessDelegate;
	}

	public void setBusinessDelegate(IBusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	/**
	 * @return the planInfo
	 */
	public PlanesInfoDto getPlanInfo() {
		return planInfo;
	}

	/**
	 * @param planInfo
	 *            the planInfo to set
	 */
	public void setPlanInfo(PlanesInfoDto planInfo) {
		this.planInfo = planInfo;
	}

	/**
	 * @return the infoPlans
	 */
	public List<PlanesInfoDto> getInfoPlans() {

		return infoPlans;
	}

	/**
	 * @param infoPlans
	 *            the infoPlans to set
	 */
	public void setInfoPlans(List<PlanesInfoDto> infoPlans) {
		this.infoPlans = infoPlans;
	}

	@PostConstruct
	public void precargaBusqueda() {
		if (program != null) {
			infoPlans = businessDelegate.AssessmentPlanInfoLoad(program, cycle, subcycle);

		}
	}

	public void onProgramChange() {
		if (program != null) {
			losCiclos = businessDelegate.findMainCycleByProgram(program.getIdProgram());
		}
	}

	public void onCycleChange() {
		if (cycle != null) {
			losSubciclos = businessDelegate.findAllCycleByMainCycle(cycle.getIdCycle());
		}
	}

	public void actionConsult() {
		FacesMessage msg = new FacesMessage("");
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (program != null) {
			infoPlans = businessDelegate.AssessmentPlanInfoLoad(program, cycle, subcycle);
			if (infoPlans.isEmpty()) {
				if(idioma.getLanguage().equals(new Locale("en").getLanguage())) {
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "No Assessment Plans records found");

				}else {
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se encontraron planes de assessment para esta consulta");
				}
			} else {
				if(idioma.getLanguage().equals(new Locale("en").getLanguage())) {
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "Assessment plans successfully Loaded");

				}else {
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Planes de assessment cargados correctamente");
				}
			}
		} else {
			if(idioma.getLanguage().equals(new Locale("en").getLanguage())) {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Information",
						"To consult, please select at least a program");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Información",
						"Para realizar la consulta por favor seleccione al menos un programa");			}
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String onPageLoadForNewTab() {
		PlanSmc pl = planInfo.getPlan();

		FacesUtils.putinSession("plan", pl);
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

		FacesUtils.putinSession("programConsul", program);
		FacesUtils.putinSession("subcycleConsul", subcycle);
		FacesUtils.putinSession("cycleConsul", cycle);
		return "";
	}

	public String showConsult() {

		String retor = "";
		PlanSmc pl = planInfo.getPlan();

		FacesUtils.putinSession("plan", pl);
		retor = "/system/AssessmentView.xhtml";

		return retor;
	}
}
