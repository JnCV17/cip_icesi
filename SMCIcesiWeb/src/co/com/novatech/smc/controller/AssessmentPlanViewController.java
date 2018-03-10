package co.com.novatech.smc.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.logic.PlanLogic;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.CdioCourseMtx;
import co.com.novatech.smc.modelo.CdioSkill;
import co.com.novatech.smc.modelo.CdioSkillPi;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.EvideFile;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserAsSrc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean(name = "AssessmentPlanViewConsultController")
@SessionScoped
public class AssessmentPlanViewController {

	@EJB
	private IBusinessDelegate delegadoDeNegocio;

	private PlanSmc assessmentPlan;
	private UploadedFile file;
	private CdioSkill cdioS;
	private Course curso;
	private AsSrc evidencia;
	private Date dateFR;
	private Date dateFE;
	private UserCip userCip;
	private Course cursoCdio;
	private PiSmc selectedPi;
	private Method selM;
	private AsSrc fuenteAssessment;
	private DefaultStreamedContent filedownload;
	private UserCip usuarioSesion;
	private StateSmc state;

	private String descriptionE;
	private String frequencyE;
	private String descripcionRubrica = "add description";

	private List<PiSmc> pisPlan;
	private List<CdioSkill> cdioPlanOutcome;
	private List<Course> cursosCdio;
	private List<CdioSkill> cdioSkills;
	private List<Course> cursos;
	private List<AsSrc> fuentesAs;
	private List<UserCip> usersCip;
	private List<UserCip> selectedUsers;
	private List<Course> selectedCourses;
	private List<Method> listMet;
	private List<EvideFile> listaEvidenciasFuenteAssessment;
	private List<StateSmc> losEstados;
	private List<AsSrc> fuentesAssessment;
	private List<UserCip> UsuariosFuente;

	public AssessmentPlanViewController() {
		selectedPi = null;
		userCip = null;
		cdioSkills = null;
		dateFR = null;
		dateFE = null;
		cdioS = null;
		cursos = null;
		state = null;
		selM = null;
		losEstados = null;
		fuentesAssessment = new ArrayList<AsSrc>();
		UsuariosFuente = new ArrayList<UserCip>();
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

	// Getters and Setters

	public Course getCurso() {

		return curso;
	}

	public void setCurso(Course curso) {
		this.curso = curso;
	}

	public Method getMetodo() {

		return evidencia.getMethod();
	}

	public UploadedFile getFile() {
		return file;
	}

	public AsSrc getFuenteAssessment() {
		return fuenteAssessment;
	}

	public void setAssessmentPlan(PlanSmc assessmentPlan) {

		this.assessmentPlan = assessmentPlan;
	}

	public List<EvideFile> getListaEvidenciasFuenteAssessment() {
		return listaEvidenciasFuenteAssessment;
	}

	public Course getCursoCdio() {
		return cursoCdio;
	}

	public StateSmc getState() {
		return state;
	}

	public String getDescripcionRubrica() {
		return descripcionRubrica;
	}

	public UserCip getUsuarioSesion() {
		usuarioSesion = (UserCip) FacesUtils.getfromSession("usuarioSesion");
		return usuarioSesion;
	}

	public PlanSmc getAssessmentPlan() {

		PlanSmc miPlan2 = (PlanSmc) FacesUtils.getfromSession("plan");
		assessmentPlan = miPlan2;
		assessmentPlan = delegadoDeNegocio.findByidPlan(assessmentPlan.getIdPlan());

		return assessmentPlan;
	}

	public List<PiSmc> getPisPlan() {
		PlanSmc plan = getAssessmentPlan();

		if (plan.getPiSmcs() == null) {
			List<PiSmc> pis = new ArrayList<PiSmc>();
			plan.setPiSmcs(pis);
		} else {
			pisPlan = new ArrayList<PiSmc>();
			for (int i = 0; i < plan.getPiSmcs().size(); i++) {
				PiSmc p = plan.getPiSmcs().get(i);
				pisPlan.add(p);
			}
		}
		return pisPlan;
	}

	public List<CdioSkill> getCdioPlanOutcome() {
		if (cdioPlanOutcome == null) {
			cdioPlanOutcome = new ArrayList<CdioSkill>();
			PlanSmc plan = getAssessmentPlan();
			long outcomeId = plan.getOutcomeCycleA().getOutcome().getIdStOutcome();
			List<CdioSkill> cdioNivel2 = delegadoDeNegocio.findAllCdioSkillByOutcome(outcomeId);
			List<List<CdioSkill>> cdioNivel3 = new ArrayList<List<CdioSkill>>();
			for (CdioSkill cdioSkill : cdioNivel2) {
				CdioSkill cd = cdioSkill;
				cdioNivel3.add(delegadoDeNegocio.findAllCdioSkillLevel3ByLevel2(cd.getIdCdioSkill()));
			}
			for (int i = 0; i < cdioNivel3.size(); i++) {
				List<CdioSkill> cdLevel3 = cdioNivel3.get(i);
				for (int j = 0; j < cdLevel3.size(); j++) {
					cdioPlanOutcome.add(cdLevel3.get(j));
				}

			}
		}

		return cdioPlanOutcome;
	}

	public List<StateSmc> getLosEstados() {

		if (losEstados == null) {
			losEstados = new ArrayList<StateSmc>();
			List<StateSmc> estados = delegadoDeNegocio.findAllState();
			for (StateSmc stateSmc : estados) {
				if (stateSmc.getIdState() == PlanLogic.APPROVED || stateSmc.getIdState() == PlanLogic.COMPLETED
						|| stateSmc.getIdState() == PlanLogic.IN_DRAFT) {
					losEstados.add(stateSmc);
				}
			}

		}

		return losEstados;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void setFiledownload(DefaultStreamedContent filedownload) {
		this.filedownload = filedownload;
	}

	public void setFuenteAssessment(AsSrc fuenteAssessment) {
		this.fuenteAssessment = fuenteAssessment;
	}

	public void setListaEvidenciasFuenteAssessment(List<EvideFile> listaEvidenciasFuenteAssessment) {
		this.listaEvidenciasFuenteAssessment = listaEvidenciasFuenteAssessment;
	}

	public void setCursoCdio(Course cursoCdio) {
		this.cursoCdio = cursoCdio;
	}

	public void setCursos(List<Course> cursos) {
		this.cursos = cursos;
	}

	public void setState(StateSmc state) {
		this.state = state;
	}

	public void setLosEstados(List<StateSmc> losEstados) {
		this.losEstados = losEstados;
	}

	public void setUsuarioSesion(UserCip usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public void setDescripcionRubrica(String descripcionRubrica) {
		this.descripcionRubrica = descripcionRubrica;
	}

	public List<CdioSkill> getCdioSkills() {
		if (cdioSkills == null) {
			cdioSkills = new ArrayList<CdioSkill>();
			List<CdioSkill> skills = delegadoDeNegocio.findAllCdioSkill();

			for (CdioSkill cdioSkill : skills) {
				if (cdioSkill.getCdioSkill() != null) {
					cdioSkills.add(cdioSkill);
				}
			}
		}

		return cdioSkills;
	}

	public void setCdioSkills(List<CdioSkill> cdioSkills) {
		this.cdioSkills = cdioSkills;
	}

	public CdioSkill getCdioS() {
		return cdioS;
	}

	public void setCdioS(CdioSkill cdioS) {
		this.cdioS = cdioS;
	}

	public Date getDateFR() {
		return dateFR;
	}

	public void setDateFR(Date dateFR) {
		this.dateFR = dateFR;
	}

	public Date getDateFE() {
		return dateFE;
	}

	public void setDateFE(Date dateFE) {
		this.dateFE = dateFE;
	}

	public PiSmc getSelectedPi() {

		return selectedPi;
	}

	public void setSelectedPi(PiSmc selectedPi) {
		this.selectedPi = selectedPi;
	}

	public List<UserCip> getUsersCip() {

		if (usersCip == null) {
			usersCip = new ArrayList<UserCip>();
			List<UserCipRoleCip> usersCipRole = delegadoDeNegocio.findAllUserCipRoleCip();
			for (UserCipRoleCip userCipRoleCip : usersCipRole) {
				if (userCipRoleCip.getRoleCip().getIdRole() == 4L) {
					usersCip.add(userCipRoleCip.getUserCip());
				}
			}

		}

		return usersCip;

	}

	public void setUsersCip(List<UserCip> usersCip) {
		this.usersCip = usersCip;
	}

	public UserCip getUserCip() {
		return userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

	public List<Course> getCursosCdio() {
		if (cursosCdio == null) {
			cursosCdio = new ArrayList<Course>();
			List<CdioCourseMtx> skills = delegadoDeNegocio.findByCdio(27);

			for (CdioCourseMtx cdioCourseMtx : skills) {
				cursosCdio.add(cdioCourseMtx.getCourse());
			}
		}

		return cursosCdio;
	}

	public void setCursosCdio(List<Course> cursosCdio) {
		this.cursosCdio = cursosCdio;
	}

	public List<Course> getSelectedCourses() {
		return selectedCourses;
	}

	public Method getSelM() {
		return selM;
	}

	public void setSelM(Method selM) {
		this.selM = selM;
	}

	public List<Method> getListMet() {
		if (listMet == null) {
			listMet = new ArrayList<Method>();
			List<Method> metodos = delegadoDeNegocio.findAllMethod();

			for (Method method : metodos) {
				listMet.add(method);
			}
		}
		return listMet;
	}

	public void setListMet(List<Method> listMet) {
		this.listMet = listMet;
	}

	public List<AsSrc> getFuentesAs() {
		return fuentesAs;
	}

	public void setFuentesAs(List<AsSrc> fuentesAs) {
		this.fuentesAs = fuentesAs;
	}

	public String getDescriptionE() {
		return descriptionE;
	}

	public void setDescriptionE(String descriptionE) {
		this.descriptionE = descriptionE;
	}

	public String getFrequencyE() {
		return frequencyE;
	}

	public void setFrequencyE(String frequencyE) {
		this.frequencyE = frequencyE;
	}

	public List<UserCip> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedCourses(List<Course> selectedCourses) {
		fuentesAs.clear();
		for (Course course : selectedCourses) {
			AsSrc newF = new AsSrc();
			newF.setCourse(course);
			fuentesAs.add(newF);
		}
		this.selectedCourses = selectedCourses;
		for (Course course : selectedCourses) {
			System.out.println("Curso seleccionado: " + course.getNameCourse());
		}
	}

	// METODOS
	public String getCreationDate() {
		PlanSmc pl = getAssessmentPlan();
		return pl.getCreationDate().toString();
	}

	public String getOutcomePlan() {
		PlanSmc pl = getAssessmentPlan();
		Outcome out = pl.getOutcomeCycleA().getOutcome();
		return out.getCriterion() + " - " + out.getDescription();
	}

	public UserCip getOutcomeLeader() {
		PlanSmc pl = getAssessmentPlan();
		Outcome out = delegadoDeNegocio.findbyIdOutcome(pl.getOutcomeCycleA().getOutcome().getIdStOutcome());

		return out.getUserCip();
	}

	public String getCursos() {

		List<CdioCourseMtx> cursos1 = delegadoDeNegocio.findByCdio(27);

		cursos = new ArrayList<Course>();
		String cur = "";

		for (CdioCourseMtx course : cursos1) {
			Course c = course.getCourse();
			cursos.add(c);
		}

		for (int i = 0; i < cursos.size(); i++) {
			if (i == cursos.size() - 1) {
				cur += "*" + cursos.get(i).getNameCourse() + "";
			} else {
				cur += "*" + cursos.get(i).getNameCourse() + "<br/>";
			}
		}

		return cur;
	}

	private boolean estaCursoMapeo(String cursoCode) {

		for (Course curso : cursos) {
			if (curso.getCode().equals(cursoCode)) {
				return true;
			}
		}
		return false;
	}

	public String getCursos1(CdioSkill cdioSkill) {

		List<CdioCourseMtx> cursos1 = delegadoDeNegocio.findByCdio(cdioSkill.getIdCdioSkill());

		cursos = new ArrayList<Course>();
		String cur = "";

		for (CdioCourseMtx course : cursos1) {
			Course c = course.getCourse();
			if (!estaCursoMapeo(c.getCode())) {
				cursos.add(c);
			}
		}

		for (int i = 0; i < cursos.size(); i++) {
			if (i == cursos.size() - 1) {
				cur += "*" + cursos.get(i).getNameCourse() + "";
			} else {
				cur += "*" + cursos.get(i).getNameCourse() + "<br/>";
			}
		}

		return cur;
	}

	public String getCursos2(PiSmc pi) {

		List<CdioSkillPi> cdioSkillsPi = pi.getCdioSkillPis();

		cursos = new ArrayList<Course>();
		String cur = "";

		for (CdioSkillPi cdioSkillPi : cdioSkillsPi) {
			List<CdioCourseMtx> cursos1 = delegadoDeNegocio.findByCdio(cdioSkillPi.getCdioSkill().getIdCdioSkill());

			for (CdioCourseMtx course : cursos1) {
				Course c = course.getCourse();
				if (!estaCursoMapeo(c.getCode())) {
					cursos.add(c);
				}
			}
		}

		for (int i = 0; i < cursos.size(); i++) {
			if (i == cursos.size() - 1) {
				cur += "*" + cursos.get(i).getNameCourse() + "";
			} else {
				cur += "*" + cursos.get(i).getNameCourse() + "<br/>";
			}
		}

		return cur;
	}

	public DefaultStreamedContent getFiledownload() {
		PlanSmc miPlan = getAssessmentPlan();
		try {

			delegadoDeNegocio.validarDescarga(miPlan.getIdPlan());
			PlanSmc plansito = delegadoDeNegocio.findByidPlan(miPlan.getIdPlan());
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

	public void upload(FileUploadEvent event) {

		UploadedFile file = event.getFile();

		try {

			PlanSmc miPlan = getAssessmentPlan();

			UserCip usuario = getUsuarioSesion();

			if (delegadoDeNegocio.validarUsuarioCarga(usuario.getIdUser(), miPlan.getIdPlan()) == true) {

				delegadoDeNegocio.validarCargaRubricFile(miPlan.getIdPlan());

				if (file != null) {

					byte[] arch = file.getContents();

					if (descripcionRubrica.equals("add description")) {

						FacesUtils.addErrorMessage("you must add a description for the file");

					} else {

						delegadoDeNegocio.saveRubricFile(miPlan.getIdPlan(), file.getFileName(), descripcionRubrica,
								arch);
						FacesUtils.addInfoMessage("file loaded");
					}

				}

			}

			else {
				FacesUtils.addErrorMessage("you do not have the permissions to perform this action");
			}

		}

		catch (Exception e) {

			FacesUtils.addErrorMessage("", e.getMessage());
		}

	}

	public void uploadEvideFile(FileUploadEvent event) {

		UploadedFile file = event.getFile();

		try {

			if (file != null) {

				byte[] arch = file.getContents();

			}

		} catch (Exception e) {
			e.printStackTrace();
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
		usuarioSesion = getUsuarioSesion();
		List<RoleCip> roles = delegadoDeNegocio.findRoleByUser(usuarioSesion.getIdUser());
		if (esMecaDirector(roles)) {

			if (state != null && assessmentPlan != null) {
				try {
					delegadoDeNegocio.cambiarEstadoPlan(assessmentPlan.getIdPlan(), state.getIdState(),
							getUsuarioSesion().getIdUser());

					FacesUtils.addInfoMessage("", "Plan have changed state");
				} catch (Exception e) {
					FacesUtils.addErrorMessage("", e.getMessage());
				}

			}
		} else {
			FacesUtils.addErrorMessage("", "Only if you are Meca or Director progam can do this action");
		}
	}

	public void guardarPdf(ActionEvent e) {
		try {

			PlanSmc pl = getAssessmentPlan();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("assesment", (int) pl.getIdPlan());
			FacesContext context = FacesContext.getCurrentInstance();
			ServletContext serveletContext = (ServletContext) context.getExternalContext().getContext();
			String jasper = serveletContext.getRealPath("/Plan_assesment.jasper");

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment;filename=" + "Plan Assessment Outcome"
					+ pl.getOutcomeCycleA().getOutcome().getCriterion() + ".pdf");

			// TODO la conexion hay que cambiarla por una estandar :v
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

	public String createPlanFromAnother() {
		String ruta = "";
		try {
			UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
			PlanSmc miPlan2 = getAssessmentPlan();
			Date fecha = new Date();
			BigDecimal period = delegadoDeNegocio.periodToPlan();
			ProgramSmc programa = assessmentPlan.getOutcomeCycleA().getOutcome().getProgramSmc();
			long subcycle = delegadoDeNegocio.subcycleActiveByProgram(programa);
			OutcomeCycleA out = delegadoDeNegocio
					.findOutcomeCycleByidOutcome(miPlan2.getOutcomeCycleA().getOutcome().getIdStOutcome(), subcycle);

			StateSmc state = delegadoDeNegocio.findById(9);
			assessmentPlan = miPlan2;
			delegadoDeNegocio.createPlanFromAnother(miPlan2, user, state, period, out, fecha);

			List<PiSmc> piPlan = miPlan2.getPiSmcs();

			PlanSmc pl2 = delegadoDeNegocio.findPlanByOutcome(out.getIdOutcoCycle());
			for (PiSmc piSmc : piPlan) {
				delegadoDeNegocio.savePi(piSmc.getCode(), piSmc.getDescription(), pl2.getIdPlan());
				List<CdioSkillPi> lsCdio = piSmc.getCdioSkillPis();
				List<AsSrc> asSrc = piSmc.getAsSrcs();
				List<PiSmc> asSrc3 = delegadoDeNegocio.findAllPisByPlan(pl2.getIdPlan());

				for (AsSrc asSrc2 : asSrc) {
					for (PiSmc piSmc2 : asSrc3) {

						AsSrc asN = new AsSrc();
						asN.setMethod(asSrc2.getMethod());
						asN.setPiSmc(piSmc2);
						asN.setCollectionDate(asSrc2.getCollectionDate());
						asN.setCollectionFrequency(asSrc2.getCollectionFrequency());
						asN.setCourse(asSrc2.getCourse());
						asN.setUserCipIdUser(asSrc2.getUserCipIdUser());

						delegadoDeNegocio.saveAsSrc(asN);

						for (CdioSkillPi cdioSkillPi : lsCdio) {

							delegadoDeNegocio.saveCdioSkillPiLogic(cdioSkillPi.getCdioSkill().getIdCdioSkill(),
									piSmc2.getIdPi());
						}
					}

				}

			}

			FacesUtils.addInfoMessage("", "The assessment plan was created sucessfull");
			ruta = "/system/AssessmentView.xhtml";
		} catch (Exception e) {
			FacesUtils.addErrorMessage("", e.getMessage());
		}
		return ruta;
	}

	public void onCdioSkillChange() {

		if (cdioS != null) {

			List<CdioCourseMtx> cursos1 = delegadoDeNegocio.findByCdio(cdioS.getIdCdioSkill());

			cursosCdio = new ArrayList<Course>();

			for (CdioCourseMtx course : cursos1) {
				Course c = course.getCourse();
				cursosCdio.add(c);
			}
		}
	}

	public void loadPi(PiSmc selPi) {
		fuentesAs = new ArrayList<AsSrc>();
		cdioS = null;
		selectedCourses = null;
		userCip = null;
		selectedPi = selPi;
		cdioPlanOutcome = null;

		Map<String, Object> options = new HashMap<String, Object>();

		options.put("modal", true);
		options.put("position", "center");
		options.put("widgetVar", "event");
		options.put("width", 800);
		options.put("height", 800);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		RequestContext.getCurrentInstance().openDialog("AssessmentUpdateView.xhtml", options, null);
	}

	public void asSrcCreate() {
		fuentesAs.clear();

		for (Course course : selectedCourses) {
			AsSrc newF = new AsSrc();
			newF.setCourse(course);
			fuentesAs.add(newF);
		}
	}

	public void addMethod(Course cou) {

		for (AsSrc assrc : fuentesAs) {
			Long idCourse = assrc.getCourse().getIdCourse();
			Long compareCourse = cou.getIdCourse();
			if (idCourse.compareTo(compareCourse) == 0) {
				assrc.setMethod(selM);
			}
		}
	}

	public void addProfessor(Course cou) {
		for (AsSrc assrc : fuentesAs) {
			Long idCourse = assrc.getCourse().getIdCourse();
			Long compareCourse = cou.getIdCourse();
			if (idCourse.compareTo(compareCourse) == 0) {
				UserAsSrc newUsrAs = new UserAsSrc();
				newUsrAs.setAsSrc(assrc);
				newUsrAs.setUserCip(userCip);
				List<UserAsSrc> nuas = new ArrayList<UserAsSrc>();
				nuas.add(newUsrAs);
				assrc.setUserAsSrcs(nuas);
			}
		}
	}

	public void addNewPi() {
		List<PiSmc> pis = assessmentPlan.getPiSmcs();
		if (pis == null || pis.isEmpty()) {
			delegadoDeNegocio.savePi(assessmentPlan.getOutcomeCycleA().getOutcome().getCriterion() + "-PI1", "new PI",
					assessmentPlan.getIdPlan());
		} else {
			delegadoDeNegocio.savePi(
					assessmentPlan.getOutcomeCycleA().getOutcome().getCriterion() + "-PI" + (pis.size() + 1), "new PI",
					assessmentPlan.getIdPlan());
		}
	}

	public String modifyPlan() {
		try {
			// delegadoDeNegocio.savePi(selectedPi.getCode(),
			// descriptionE,
			// getAssessmentPlan().getIdPlan());

			delegadoDeNegocio.saveCdioSkillPi(cdioS, selectedPi);

			// for (int i = 0; i < fuentesAssessment.size(); i++) {
			// fuentesAssessment.get(i).setPiSmc(selectedPi);
			// delegadoDeNegocio.saveAsSrc(fuentesAssessment.get(i));
			//
			// }
			// for (int i = 0; i < UsuariosFuente.size(); i++) {
			// UserCip usuarioF = UsuariosFuente.get(i);
			// AsSrc fuenteA = fuentesAssessment.get(i);
			// delegadoDeNegocio.saveUserASsrc(fuenteA, usuarioF,
			// usuarioF.getIdUser());
			// }
			delegadoDeNegocio.updatePi(selectedPi.getCode(), descriptionE, getAssessmentPlan().getIdPlan());
			fuentesAssessment = new ArrayList<AsSrc>();
			RequestContext contexto = RequestContext.getCurrentInstance();

			contexto.closeDialog(null);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "";
	}

	public void setSelectedUsers(List<UserCip> selectedUsers) {
		this.selectedUsers = selectedUsers;
		for (UserCip userCip : selectedUsers) {
			System.out.println("Curso seleccionado: " + userCip.getNameUser());
		}

	}

	public String addAction() {

		AsSrc fuente = new AsSrc();
		fuente.setCollectionDate(dateFR);
		fuente.setMethod(selM);
		fuente.setCourse(curso);
		fuente.setCollectionFrequency(frequencyE);
		fuente.setUserCipIdUser(new BigDecimal(userCip.getIdUser()));
		fuente.setPiSmc(selectedPi);

		UserAsSrc usuarioF = new UserAsSrc();
		usuarioF.setUserCip(userCip);

		try {
			delegadoDeNegocio.saveAsSrc(fuente);
			fuentesAssessment.add(fuente);
			UsuariosFuente.add(userCip);
			usuarioF.setAsSrc(fuente);
			delegadoDeNegocio.saveUserASsrc(usuarioF);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Source saved",
					"Id:" + fuente.getIdAsSrc());

			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", e.getMessage());
			System.out.println("El error es: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return null;

	}

	public List<AsSrc> getFuentesAssessment() {
		return fuentesAssessment;
	}

	public void setFuentesAssessment(List<AsSrc> fuentesAssessment) {
		this.fuentesAssessment = fuentesAssessment;
	}

}
