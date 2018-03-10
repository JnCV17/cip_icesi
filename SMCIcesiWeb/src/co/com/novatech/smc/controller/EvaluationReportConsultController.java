package co.com.novatech.smc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "EvaluationReportConsultController")
@SessionScoped
public class EvaluationReportConsultController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private MainCycle subcycle;
	private EvalReport infoEvalu;
	private MainCycle cycle;

	private List<MainCycle> losCiclos;
	private List<ProgramSmc> losProgramas;
	private List<MainCycle> losSubciclos;
	private List<EvalReport> infoEval;

	public EvaluationReportConsultController() {
		try {
			program = (ProgramSmc) FacesUtils.getfromSession("programConsul");
			subcycle = (MainCycle) FacesUtils.getfromSession("subcycleConsul");
			cycle = (MainCycle) FacesUtils.getfromSession("cycleConsul");

		} catch (Exception e) {
			this.program = null;
			this.cycle = null;
			this.subcycle = null;
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

	public EvalReport getInfoEvalu() {
		return infoEvalu;
	}

	public void setInfoEvalu(EvalReport infoEvalu) {
		this.infoEvalu = infoEvalu;
	}

	public List<EvalReport> getInfoEval() {
		return infoEval;
	}

	public void setInfoEval(List<EvalReport> infoEval) {
		this.infoEval = infoEval;
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

		try {
			this.infoEval = businessDelegate.findAllEvalCycleByProgramCycleSubcicle(program, losCiclos, losSubciclos,
					cycle);
			FacesUtils.addInfoMessage("", "Evaluation reports loaded ");

		} catch (Exception e) {

			FacesUtils.addInfoMessage("", "not records found  ");

			e.printStackTrace();
		}

	}

	public String onPageLoadForNewTab() {
		// PlanSmc pl = infoEvalu.getPlan();
		//
		// EvalReport eva =
		getInfoEval();
		FacesUtils.putinSession("eval", infoEvalu);
		HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String uri = req.getRequestURI();
		try {
			res.getWriter()
					.println("<script>window.open('" + "EvalReportView.xhtml"
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
		getInfoEval();
		FacesUtils.putinSession("eval", infoEvalu);

		retor = "/system/AssessmentView.xhtml";

		return retor;
	}

}
