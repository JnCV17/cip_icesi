package co.com.novatech.smc.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.logic.EvaluationReportLogic;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean(name = "EvaluationReportViewConsultController")
@SessionScoped
public class EvaluationReportViewConsultController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private PlanSmc assessmentPlan;
	private EvalReport evalReport;
	private DefaultStreamedContent filedownload;
	private UploadedFile file;
	private StateSmc state;

	private List<AsSrc> lasFuentes;
	private List<StateSmc> losEstados;

	public EvaluationReportViewConsultController() {
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");

		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);

		try {
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public PlanSmc getAssessmentPlan() {

		EvalReport eval = (EvalReport) FacesUtils.getfromSession("eval");
		assessmentPlan = eval.getEvalCycle().getPlanSmc();

		return assessmentPlan;
	}

	public void setAssessmentPlan(PlanSmc assessmentPlan) {
		this.assessmentPlan = assessmentPlan;
	}

	public EvalReport getEvalReport() {

		evalReport = (EvalReport) FacesUtils.getfromSession("eval");

		evalReport = businessDelegate.findByIdEvalReport(evalReport.getIdEvalReport());
		return evalReport;
	}

	public void setEvalReport(EvalReport evalReport) {
		this.evalReport = evalReport;
	}

	public List<AsSrc> getLasFuentes() {

		return lasFuentes;
	}

	public void setLasFuentes(List<AsSrc> lasFuentes) {
		this.lasFuentes = lasFuentes;
	}

	public StateSmc getState() {
		return state;
	}

	public void setState(StateSmc state) {
		this.state = state;
	}

	public List<StateSmc> getLosEstados() {

		if (losEstados == null) {
			losEstados = new ArrayList<StateSmc>();
			List<StateSmc> estados = businessDelegate.findAllState();
			for (StateSmc stateSmc : estados) {
				if (stateSmc.getIdState() == EvaluationReportLogic.COMPLETED
						|| stateSmc.getIdState() == EvaluationReportLogic.IN_PROCESS) {
					losEstados.add(stateSmc);
				}
			}

		}

		return losEstados;

	}

	public void setLosEstados(List<StateSmc> losEstados) {
		this.losEstados = losEstados;
	}

	public DefaultStreamedContent getFiledownload() {
		EvalReport miPlan = getEvalReport();
		try {

			businessDelegate.validateDownloadReport((miPlan.getIdEvalReport()));
			EvalReport plansito = businessDelegate.findByIdEvalReport(miPlan.getIdEvalReport());
			String nameFile = plansito.getRubricFile().getFileName();
			byte[] arch = plansito.getRubricFile().getFileRaw();
			InputStream is = new ByteArrayInputStream(arch);

			String extension = getExtension(nameFile);

			DefaultStreamedContent nuevo = new DefaultStreamedContent(is, extension, nameFile);

			filedownload = nuevo;
		} catch (Exception e) {
			FacesUtils.addErrorMessage("", e.getMessage());
		}

		return filedownload;
	}

	public void setFiledownload(DefaultStreamedContent filedownload) {
		this.filedownload = filedownload;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void exportAsPdf(ActionEvent e) {
		try {

			EvalReport pl = getEvalReport();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("evaluation", (int) pl.getIdEvalReport());
			FacesContext context = FacesContext.getCurrentInstance();
			ServletContext serveletContext = (ServletContext) context.getExternalContext().getContext();
			String jasper = serveletContext.getRealPath("/report4.jasper");

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition",
					"attachment;filename="
							+ pl.getEvalCycle().getPlanSmc().getOutcomeCycleA().getOutcome().getCriterion()
							+ "--Assessment Report" + ".pdf");

			// TODO la conexion hay que cambiarla por una estandar :v
			// Grave: java.lang.NoClassDefFoundError:
			// org/codehaus/groovy/control/CompilationFailedException
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters,
					DriverManager.getConnection("jdbc:oracle:thin:@200.3.193.24:1522:ESTUD", "P09713_1_5", "nhtkPFEL"));
			System.out.println("la direccion y esas cosas");

			ServletOutputStream stream = response.getOutputStream();

			stream.write(JasperExportManager.exportReportToPdf(jasperPrint));

			stream.flush();
			stream.close();
			context.renderResponse();
			context.getApplication().getStateManager().saveView(context);
			context.responseComplete();

		} catch (Exception u) {
			u.printStackTrace();
		}
	}

	public void upload(FileUploadEvent event) {

		UploadedFile file = event.getFile();

		try {

			EvalReport miPlan = getEvalReport();
			PlanSmc miPlan2 = getAssessmentPlan();

			if (file != null) {

				byte[] arch = file.getContents();

				businessDelegate.saveRubricFileReport(miPlan.getIdEvalReport(), file.getFileName(),
						miPlan2.getOutcomeCycleA().getOutcome().getCriterion() + "Assessment Evaluation Report", arch);
				FacesUtils.addInfoMessage("file loaded");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage("", "upload failed");
		}

	}

	private String getExtension(String name) {

		StringBuilder builder = new StringBuilder(name);
		String sCadenaInvertida = builder.reverse().toString();
		String extension = "";

		for (int i = 0; i < sCadenaInvertida.length(); i++) {

			if (sCadenaInvertida.charAt(i) != '.') {
				extension += sCadenaInvertida.charAt(i);
			} else {
				break;
			}

		}

		StringBuilder builder2 = new StringBuilder(extension);
		String sCadenaInvertida2 = builder2.reverse().toString();

		return sCadenaInvertida2;
	}

	public String getCursos(long idPi) {
		String cruso = "";
		// List<PiSmc> pis = assessmentPlan.getPiSmcs();
		// for (PiSmc piSmc : pis) {

		List<Course> lasFuente = businessDelegate.findAllAsSrc(idPi);

		for (Course asSrc : lasFuente) {

			cruso = asSrc.getNameCourse();
		}
		// }
		return cruso;

	}

	private boolean esMecaDirector(List<RoleCip> roles) {
		boolean esMecaODirector = false;
		for (RoleCip rol : roles) {
			if (rol.getIdRole() == 2 || rol.getIdRole() == 3) {
				esMecaODirector = true;
			}
		}

		return esMecaODirector;
	}

	public void cambiarEstado() {
		UserCip usuarioSesion = (UserCip) FacesUtils.getfromSession("usuarioSesion");
		System.out.println("entro cambiar");
		getEvalReport();

		List<RoleCip> roles = businessDelegate.findRoleByUser(usuarioSesion.getIdUser());
		if (esMecaDirector(roles)) {

			// if (state != null && evalReport != null) {
			try {
				businessDelegate.cambiarEstadoEvalReport(evalReport.getIdEvalReport(), state.getIdState(),
						usuarioSesion.getIdUser());
				System.out.println("gg wp");
				FacesUtils.addInfoMessage("", "Plan have changed state");

				// " You cannot change the state because you're not an
				// Outcome
				// leader or Director Program or MECA")}
			} catch (Exception e) {
				e.printStackTrace();

				FacesUtils.addErrorMessage("", e.getMessage());
			}

			// }
		}

		// public void preProcessPDF(FacesContext context,Object document,
		// UIComponent component) throws IOException, BadElementException,
		// DocumentException {
		// Document pdf = (Document) document;
		// DataTable tab = (DataTable) component;
		// pdf.open();
		// pdf.setPageSize(PageSize.A4);
		// document.add(exportPDFTable(context, tab, false, false, "UTF-8"));
		// ExternalContext externalContext =
		// FacesContext.getCurrentInstance().getExternalContext();
		// String logo = externalContext.getRealPath("") + File.separator +
		// "resources" + File.separator + "demo" + File.separator + "images" +
		// File.separator + "prime_logo.png";
		//
		// pdf.add(Image.getInstance(logo));
		// }
	}
}
