package co.com.novatech.smc.delegate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.logic.IAlertLogic;
import co.com.novatech.smc.logic.IAlertsManagement;
import co.com.novatech.smc.logic.IAsSrcLogic;
import co.com.novatech.smc.logic.IAssignOutcomeLogic;
import co.com.novatech.smc.logic.ICDIOCourseMtxLogic;
import co.com.novatech.smc.logic.ICDIOOutcomeMtxLogic;
import co.com.novatech.smc.logic.ICDIOSkillLogic;
import co.com.novatech.smc.logic.ICdioLogic;
import co.com.novatech.smc.logic.ICdioSkillPiLogic;
import co.com.novatech.smc.logic.IEvalCycleLogic;
import co.com.novatech.smc.logic.IEvaluationReportLogic;
import co.com.novatech.smc.logic.IEvideFileLogic;
import co.com.novatech.smc.logic.IMainCycleLogic;
import co.com.novatech.smc.logic.IMenuLogic;
import co.com.novatech.smc.logic.IMenuRoleLogic;
import co.com.novatech.smc.logic.IMethodLogic;
import co.com.novatech.smc.logic.IOutcomeCycleALogic;
import co.com.novatech.smc.logic.IOutcomeLogic;
import co.com.novatech.smc.logic.IParameterLogic;
import co.com.novatech.smc.logic.IPeriodLogic;
import co.com.novatech.smc.logic.IPiLogic;
import co.com.novatech.smc.logic.IPlanLogic;
import co.com.novatech.smc.logic.IProgramLogic;
import co.com.novatech.smc.logic.IRoleCipLogic;
import co.com.novatech.smc.logic.IRubricFileLogic;
import co.com.novatech.smc.logic.IStateLogic;
import co.com.novatech.smc.logic.IStateTypeLogic;
import co.com.novatech.smc.logic.IUserAsrcLogic;
import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.logic.IUserCipRoleCipLogic;
import co.com.novatech.smc.modelo.Alert;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.CdioCourseMtx;
import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;
import co.com.novatech.smc.modelo.CdioSkillPi;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.EvalCycle;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.EvideFile;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.Menu;
import co.com.novatech.smc.modelo.MenuRole;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.RubricFile;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.StateType;
import co.com.novatech.smc.modelo.UserAsSrc;
import co.com.novatech.smc.modelo.UserCip;
//import co.com.novatech.smc.view.IBusinessDelegate;
import co.com.novatech.smc.modelo.UserCipRoleCip;
import co.com.novatech.smc.util.FacesUtils;
import co.sco.novatech.smc.dto.IPlanesInfoDto;
import co.sco.novatech.smc.dto.PlanesInfoDto;

@Stateless
public class BusinessDelegate implements IBusinessDelegate {

	static GenericLookup gl;
	static {
		gl = new GenericLookup();
	}

	private IAlertLogic alertLogic = (IAlertLogic) gl.lookupLogic("AlertLogic");

	private IAlertsManagement alertsManagement = (IAlertsManagement) gl.lookup2Logic(
			"java:global/SMCIcesi/SMCIcesiLogic/AlertsManagementLogic!co.com.novatech.smc.logic.IAlertsManagement");

	private IEvideFileLogic evideFileLogic = (IEvideFileLogic) gl.lookupLogic("EvideFileLogic");

	private IEvalCycleLogic evalCycleLogic = (IEvalCycleLogic) gl.lookupLogic("EvalCycleLogic");

	private IAsSrcLogic asSrcLogic = (IAsSrcLogic) gl.lookupLogic("AsSrcLogic");

	private IAssignOutcomeLogic assignOutcomeLogic = (IAssignOutcomeLogic) gl.lookupLogic("AssignOutcomeLogic");;

	private ICDIOCourseMtxLogic cdioCourseMtxLogic = (ICDIOCourseMtxLogic) gl.lookupLogic("CDIOCourseMtxLogic");;

	private ICdioLogic cdioLogic = (ICdioLogic) gl.lookupLogic("CdioLogic");;

	private ICDIOOutcomeMtxLogic cdioOutcomeMtxLogic = (ICDIOOutcomeMtxLogic) gl.lookupLogic("CDIOOutcomeMtxLogic");;

	private ICDIOSkillLogic cdioSkillLogic = (ICDIOSkillLogic) gl.lookupLogic("CDIOSkillLogic");;

	private IEvaluationReportLogic evaluationReportLogic = (IEvaluationReportLogic) gl
			.lookupLogic("EvaluationReportLogic");;

	// private ICourseLogic courseLogic = (ICourseLogic)
	// gl.lookupLogic("CourseLogic");;

	private IMainCycleLogic mainCycleLogic = (IMainCycleLogic) gl.lookupLogic("MainCycleLogic");;

	private IMenuLogic menuLogic = (IMenuLogic) gl.lookupLogic("MenuLogic");;

	private IOutcomeCycleALogic outcomeCycleALogic = (IOutcomeCycleALogic) gl.lookupLogic("OutcomeCycleALogic");;

	private IOutcomeLogic outcomeLogic = (IOutcomeLogic) gl.lookupLogic("OutcomeLogic");;

	private IParameterLogic parameterLogic = (IParameterLogic) gl.lookupLogic("ParameterLogic");;

	private IPeriodLogic periodLogic = (IPeriodLogic) gl.lookupLogic("PeriodLogic");;

	private IPiLogic piLogic = (IPiLogic) gl.lookupLogic("PiLogic");;

	private IPlanLogic planLogic = (IPlanLogic) gl.lookupLogic("PlanLogic");;

	private IProgramLogic programLogic = (IProgramLogic) gl.lookupLogic("ProgramLogic");;

	private IRoleCipLogic roleCipLogic = (IRoleCipLogic) gl.lookupLogic("RoleCipLogic");;

	private IStateLogic stateLogic = (IStateLogic) gl.lookupLogic("StateLogic");;

	private IStateTypeLogic stateTypeLogic = (IStateTypeLogic) gl.lookupLogic("StateTypeLogic");;

	private IUserCipLogic userCipLogic = (IUserCipLogic) gl.lookupLogic("UserCipLogic");

	private IUserCipRoleCipLogic userCipRoleCipLogic = (IUserCipRoleCipLogic) gl.lookupLogic("UserCipRoleCipLogic");

	private IRubricFileLogic rubricFileLogic = (IRubricFileLogic) gl.lookupLogic("RubricFileLogic");

	private IPlanesInfoDto planesInfoDTO = (IPlanesInfoDto) gl
			.lookup2Logic("java:global/SMCIcesi/SMCIcesiLogic/PlanesInfoDto!co.sco.novatech.smc.dto.IPlanesInfoDto");

	private IMenuRoleLogic menuRoleLogic = (IMenuRoleLogic) gl.lookupLogic("MenuRoleLogic");;

	private ICdioSkillPiLogic cdioSkillPiLogic = (ICdioSkillPiLogic) gl.lookupLogic("CdioSkillPiLogic");

	private IMethodLogic methodLogic = (IMethodLogic) gl.lookupLogic("MethodLogic");

	private IUserAsrcLogic userAsrcLogic = (IUserAsrcLogic) gl.lookupLogic("UserAsrcLogic");;

	@Override
	public void saveAlert(String alertName, long idStateSmc) throws Exception {
		Alert alert = new Alert();
		alert.setAlertName(alertName);

		StateSmc stateSmc = stateLogic.findById(idStateSmc);

		alert.setStateSmc(stateSmc);

		alertLogic.saveAlert(alert);

	}

	// @Override
	// public void updateAlert(long idAlert, String alertName, long idStateSmc)
	// throws Exception {
	// Alert alert = new Alert();
	// alert.setAlertName(alertName);
	//
	// StateSmc stateSmc = stateLogic.findById(idStateSmc);
	//
	// alert.setStateSmc(stateSmc);
	//
	// alertLogic.updateAlert(alert);
	//
	// }
	//
	// @Override
	// public Alert findByIdAlert(long alertId) throws Exception {
	// return alertLogic.findByIdAlert(alertId);
	// }
	//
	// @Override
	// public List<Alert> findAllAlert() {
	// return alertLogic.findAllAlert();
	// }

	@Override
	public void cambiarEstadoEvalReport(long idEvalReport, long idState, long idUser) throws Exception {

		EvalReport evalReport = evaluationReportLogic.findByIdEvalReport(idEvalReport);
		StateSmc estado = stateLogic.findById(idState);
		UserCip user = userCipLogic.findByIdUser(idUser);

		evaluationReportLogic.cambiarEstadoEvalReport(evalReport, estado, user);
	}

	@Override
	public void envioCorreoAsignacionOutcome(long idUsuario, String idProgram, long idStOutcome, long idUser) {
		alertsManagement.envioCorreoAsignacionOutcome(idUsuario, idProgram, idStOutcome, idUser);
	}

	// @Override
	// public void envioCorreoDesasignacionOutcome(String idProgram, long
	// idStOutcome, long idUser) {
	// alertsManagement.envioCorreoDesasignacionOutcome(idProgram, idStOutcome,
	// idUser);
	// }
	//
	// @Override
	// public void envioCorreoCambioEstadoPlanAsesssment(long idPlan, String
	// idProgram) {
	// alertsManagement.envioCorreoCambioEstadoPlanAsesssment(idPlan,
	// idProgram);
	// }
	//
	// @Override
	// public void envioCorreoFechaRecoleccionEvidencias() {
	//
	// }
	//
	// @Override
	// public void envioCorreoFechaEvaluacion(PlanSmc planSmc) {
	// alertsManagement.envioCorreoFechaEvaluacion(planSmc);
	// }

	@Override
	public List<PlanSmc> filtrarPlanesPorPrograma(String idProgram) {
		ProgramSmc programSmc = programLogic.findProgramById(idProgram);
		List<PlanSmc> planes = planLogic.findAll();
		return planLogic.filtrarPlanesPorPrograma(planes, programSmc);
	}

	@Override
	public List<PlanSmc> filtrarPlanesPorOutcome(long idOutcome) {
		Outcome outcome = outcomeLogic.findbyId(idOutcome);
		List<PlanSmc> planes = planLogic.findAll();
		return planLogic.filtrarPlanesPorOutcome(planes, outcome);
	}

	// @Override
	// public void unassignOutcome(long idOutcome) throws Exception {
	// Outcome outcome = outcomeLogic.findbyId(idOutcome);
	// assignOutcomeLogic.unassignOutcome(outcome);
	// }

	@Override
	public void toAssignOutcome(long idOutcome, long idUserCIp) throws Exception {
		Outcome outcome = outcomeLogic.findbyId(idOutcome);
		UserCip userCip = userCipLogic.findByIdUser(idUserCIp);
		assignOutcomeLogic.toAssignOutcome(outcome, userCip);
	}

	// public void saveBlockCourse(String name, String idProgramSmc, long
	// idUserCip) throws Exception {
	// BlockCourse blockCourse = new BlockCourse();
	// blockCourse.setName(name);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgramSmc);
	//
	// UserCip userCip = userCipLogic.findByIdUser(idUserCip);
	//
	// blockCourse.setProgramSmc(programSmc);
	// blockCourse.setUserCip(userCip);
	//
	// blockCourseLogic.saveBlockCourse(blockCourse);
	// }
	//
	// public void updateBlockCourse(long idBlock, String name, String
	// idProgramSmc, long idUserCip) throws Exception {
	// BlockCourse blockCourse = new BlockCourse();
	// blockCourse.setName(name);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgramSmc);
	//
	// UserCip userCip = userCipLogic.findByIdUser(idUserCip);
	//
	// blockCourse.setProgramSmc(programSmc);
	// blockCourse.setUserCip(userCip);
	//
	// blockCourseLogic.updateBlockCourse(blockCourse);
	// }
	//
	// public void saveCDIOCourseMtx(String version, long idCdioLvl, long
	// idCourse) throws Exception {
	// CdioCourseMtx cdioCourseMtx = new CdioCourseMtx();
	// cdioCourseMtx.setVersion(version);
	//
	// CdioLvl cdioLvl = cdioLvlLogic.findByIdCdioLvl(idCdioLvl);
	//
	// Course course = courseLogic.findByIdCourse(idCourse);
	//
	// cdioCourseMtx.setCdioLvl(cdioLvl);
	// cdioCourseMtx.setCourse(course);
	//
	// cdioCourseMtxLogic.saveCDIOCourseMtx(cdioCourseMtx);
	// }
	//
	// public void updateCDIOCourseMtx(long idCdioCourse, String version, long
	// idCdioLvl, long idCourse) throws Exception {
	// CdioCourseMtx cdioCourseMtx = new CdioCourseMtx();
	// cdioCourseMtx.setVersion(version);
	//
	// CdioLvl cdioLvl = cdioLvlLogic.findByIdCdioLvl(idCdioLvl);
	//
	// Course course = courseLogic.findByIdCourse(idCourse);
	//
	// cdioCourseMtx.setCdioLvl(cdioLvl);
	// cdioCourseMtx.setCourse(course);
	//
	// cdioCourseMtxLogic.updateCDIOCourseMtx(cdioCourseMtx);
	// }

	// @Override
	// public CdioCourseMtx findByIdCDIOCourseMtx(long cdioCourseMtx) {
	// return cdioCourseMtxLogic.findByIdCDIOCourseMtx(cdioCourseMtx);
	// }
	//
	// @Override
	// public List<CdioCourseMtx> findAllCDIOCourseMt() {
	// return cdioCourseMtxLogic.findAllCDIOCourseMtx();
	// }

	// public void saveCdio(String description, String name) throws Exception {
	// Cdio cdio = new Cdio();
	// cdio.setDescription(description);
	// cdio.setName(name);
	//
	// cdioLogic.saveCdio(cdio);
	// }

	// public void updateCdio(long idCdio, String description, String name)
	// throws Exception {
	// Cdio cdio = new Cdio();
	// cdio.setDescription(description);
	// cdio.setName(name);
	//
	// cdioLogic.updateCdio(cdio);
	// }

	// @Override
	// public Cdio findByIdCdio(long idCdio) {
	// return cdioLogic.findByIdCdio(idCdio);
	// }
	//
	// @Override
	// public List<Cdio> findAllCdio() {
	// return cdioLogic.findAllCdio();
	// }

	// public void saveCdioLvl(String description, String symbol, long
	// idCdioSkill) throws Exception {
	// CdioLvl cdioLvl = new CdioLvl();
	// cdioLvl.setDescription(description);
	// cdioLvl.setSymbol(symbol);
	//
	// CdioSkill cdioSkill = cdioSkillLogic.findByIdCdioSkill(idCdioSkill);
	//
	// // cdioLvl.setCdioSkill(cdioSkill);
	//
	// cdioLvlLogic.saveCdioLvl(cdioLvl);
	// }

	// public void updateCdioLvl(long idCdioLvl, String description, String
	// symbol, long idCdioSkill) throws Exception {
	// CdioLvl cdioLvl = new CdioLvl();
	// cdioLvl.setDescription(description);
	// cdioLvl.setSymbol(symbol);
	//
	// CdioSkill cdioSkill = cdioSkillLogic.findByIdCdioSkill(idCdioSkill);
	//
	// cdioLvlLogic.updateCdioLvl(cdioLvl);
	// }
	//
	// public CdioLvl findByIdCdioLvl(long cdioLvl) {
	// return cdioLvlLogic.findByIdCdioLvl(cdioLvl);
	// }
	//
	// public List<CdioLvl> findAllCdioLvl() {
	// return cdioLvlLogic.findAll();
	// }

	// public void saveCdioOutcomeMtx(String version, long idCdioSkill, long
	// idOutcome) throws Exception {
	// CdioOutcomeMtx cdioOutcomeMtx = new CdioOutcomeMtx();
	// cdioOutcomeMtx.setVersion(version);
	//
	// CdioSkill cdioSkill = cdioSkillLogic.findByIdCdioSkill(idCdioSkill);
	//
	// Outcome outcome = outcomeLogic.findbyId(idOutcome);
	//
	// cdioOutcomeMtx.setCdioSkill(cdioSkill);
	// cdioOutcomeMtx.setOutcome(outcome);
	//
	// cdioOutcomeMtxLogic.saveCdioOutcomeMtx(cdioOutcomeMtx);
	// }
	//
	// public void updateCdioOutcomeMtx(String version, long idCdioSkill, long
	// idOutcome) throws Exception {
	// CdioOutcomeMtx cdioOutcomeMtx = new CdioOutcomeMtx();
	// cdioOutcomeMtx.setVersion(version);
	//
	// CdioSkill cdioSkill = cdioSkillLogic.findByIdCdioSkill(idCdioSkill);
	//
	// Outcome outcome = outcomeLogic.findbyId(idOutcome);
	//
	// cdioOutcomeMtx.setCdioSkill(cdioSkill);
	// cdioOutcomeMtx.setOutcome(outcome);
	//
	// cdioOutcomeMtxLogic.updateCdioOutcomeMtx(cdioOutcomeMtx);
	// }

	// @Override
	// public CdioOutcomeMtx findByIdCdioOutcomeMtx(long cdioOutcomeMtx) {
	// return cdioOutcomeMtxLogic.findByIdCdioOutcomeMtx(cdioOutcomeMtx);
	// }

	@Override
	public List<CdioOutcomeMtx> findAll() {
		return cdioOutcomeMtxLogic.findAllCdioOutcomeMtx();
	}

	// public void saveCdioSkill(String description, long idCdio) throws
	// Exception {
	// CdioSkill cdioSkill = new CdioSkill();
	// cdioSkill.setDescription(description);
	//
	// Cdio cdio = cdioLogic.findByIdCdio(idCdio);
	//
	// cdioSkill.setCdio(cdio);
	//
	// cdioSkillLogic.saveCdioSkill(cdioSkill);
	// }
	//
	// public void updateCdioSkill(long idCdioSkill, String description, long
	// idCdio) throws Exception {
	// CdioSkill cdioSkill = new CdioSkill();
	// cdioSkill.setDescription(description);
	//
	// Cdio cdio = cdioLogic.findByIdCdio(idCdio);
	//
	// cdioSkill.setCdio(cdio);
	//
	// cdioSkillLogic.updateCdioSkill(cdioSkill);
	// }
	//
	// @Override
	// public CdioSkill findByIdCdioSkill(long cdioSkill) {
	// return cdioSkillLogic.findByIdCdioSkill(cdioSkill);
	// }

	@Override
	public List<CdioSkill> findAllCdioSkill() {
		return cdioSkillLogic.findAllCdioSkill();
	}

	// public void saveCourse(String code, BigDecimal credits, String
	// nameCourse, String idProgramSmc) throws Exception {
	// Course course = new Course();
	// course.setCode(code);
	// course.setCredits(credits);
	// course.setNameCourse(nameCourse);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgramSmc);
	//
	// course.setProgramSmc(programSmc);
	//
	// courseLogic.saveCourse(course);
	// }

	// public void updateCourse(long idCourse, String code, BigDecimal credits,
	// String nameCourse, String idProgramSmc)
	// throws Exception {
	// Course course = new Course();
	// course.setCode(code);
	// course.setCredits(credits);
	// course.setNameCourse(nameCourse);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgramSmc);
	//
	// course.setProgramSmc(programSmc);
	//
	// courseLogic.updateCourse(course);
	// }
	//
	// public Course findByIdCourse(long idCourse) throws Exception {
	// return courseLogic.findByIdCourse(idCourse);
	// }
	//
	// public List<Course> findAllCourse() {
	// return courseLogic.findAllCourse();
	// }

	// public void saveFaculty(String code, String name) throws Exception {
	// Faculty faculty = new Faculty();
	// faculty.setCode(code);
	// faculty.setName(name);
	//
	// facultyLogic.saveFaculty(faculty);
	// }
	//
	// public void updateFaculty(long idFaculty, String code, String name)
	// throws Exception {
	// Faculty faculty = new Faculty();
	// faculty.setCode(code);
	// faculty.setName(name);
	//
	// facultyLogic.updateFaculty(faculty);
	// }
	//
	// public Faculty findFacultyById(long facultyId) {
	// return facultyLogic.findFacultyById(facultyId);
	// }
	//
	// public List<Faculty> findAllFaculties() {
	// return facultyLogic.findAllFaculties();
	// }
	//
	// public List<ProgramSmc> getProgramsByFaculty(long idFaculty) {
	// return facultyLogic.getProgramsByFaculty(idFaculty);
	// }
	//
	// public List<UserCip> getUserCipByFaculty(long idFaculty) {
	// return facultyLogic.getUserCipByFaculty(idFaculty);
	// }
	//
	// public void saveMainCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle)
	// throws Exception {
	// MainCycle mainCycle = new MainCycle();
	// mainCycle.setCycleName(cycleName);
	// mainCycle.setDuration(duration);
	// mainCycle.setInitialDateCycle(initialDateCycle);
	// mainCycle.setFinalDateCycle(finalDateCycle);
	//
	// mainCycleLogic.saveMainCycle(mainCycle);
	// }

	// public void updateMainCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle)
	// throws Exception {
	// MainCycle mainCycle = new MainCycle();
	// mainCycle.setCycleName(cycleName);
	// mainCycle.setDuration(duration);
	// mainCycle.setInitialDateCycle(initialDateCycle);
	// mainCycle.setFinalDateCycle(finalDateCycle);
	//
	// mainCycleLogic.updateMainCycle(mainCycle);
	// }

	// @Override
	// public MainCycle findByIdMainCycle(long idCycle) {
	// return mainCycleLogic.findByIdMainCycle(idCycle);
	// }
	//
	// @Override
	// public List<MainCycle> findAllMainCycle() {
	// return mainCycleLogic.findAllMainCycles();
	// }

	// public void saveCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle,
	// long idMainCycle) throws Exception {
	// MainCycle cycle = new MainCycle();
	// cycle.setCycleName(cycleName);
	// cycle.setDuration(duration);
	// cycle.setInitialDateCycle(initialDateCycle);
	// cycle.setFinalDateCycle(finalDateCycle);
	//
	// MainCycle mainCycle = mainCycleLogic.findByIdMainCycle(idMainCycle);
	//
	// mainCycleLogic.saveCycle(cycle, mainCycle);
	// }

	// public void updateCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle,
	// long idMainCycle) throws Exception {
	// MainCycle cycle = new MainCycle();
	// cycle.setCycleName(cycleName);
	// cycle.setDuration(duration);
	// cycle.setInitialDateCycle(initialDateCycle);
	// cycle.setFinalDateCycle(finalDateCycle);
	//
	// MainCycle mainCycle = mainCycleLogic.findByIdMainCycle(idMainCycle);
	//
	// mainCycleLogic.updateCycle(cycle, mainCycle);
	// }

	@Override
	public MainCycle findByICycle(long idCycle) {
		return mainCycleLogic.findByIdCycle(idCycle);
	}

	@Override
	public List<MainCycle> findAllCycles() {
		return mainCycleLogic.findAllSubCycles();
	}

	@Override
	public List<MainCycle> findAllCycleByMainCycle(long idMainCycle) {
		return mainCycleLogic.findAllSubCyclesByMainCycle(idMainCycle);
	}

	// public void saveMenu(String menuName) throws Exception {
	// Menu menu = new Menu();
	// menu.setMenuName(menuName);
	//
	// menuLogic.saveMenu(menu);
	// }
	//
	// public void updateMenu(String menuName) throws Exception {
	// Menu menu = new Menu();
	// menu.setMenuName(menuName);
	//
	// menuLogic.updateMenu(menu);
	// }

	@Override
	public Menu findByIidMenu(long idMenu) throws Exception {
		return menuLogic.findByIidMenu(idMenu);
	}

	@Override
	public List<Menu> findAllMenus() throws Exception {
		return menuLogic.findAllMenus();
	}

	// public void saveOutcomeCycleA(long idMainCycle, long idOutcome) throws
	// Exception {
	// OutcomeCycleA outcomeCycleA = new OutcomeCycleA();
	//
	// MainCycle mainCycle = mainCycleLogic.findByIdMainCycle(idMainCycle);
	//
	// Outcome outcome = outcomeLogic.findbyId(idOutcome);
	//
	// outcomeCycleA.setOutcome(outcome);
	// outcomeCycleA.setMainCycle(mainCycle);
	//
	// outcomeCycleALogic.save(outcomeCycleA);
	// }
	//
	// public void updateOutcomeCycleA(long idMainCycle, long idOutcome) throws
	// Exception {
	// OutcomeCycleA outcomeCycleA = new OutcomeCycleA();
	//
	// MainCycle mainCycle = mainCycleLogic.findByIdMainCycle(idMainCycle);
	//
	// Outcome outcome = outcomeLogic.findbyId(idOutcome);
	//
	// outcomeCycleA.setOutcome(outcome);
	// outcomeCycleA.setMainCycle(mainCycle);
	//
	// outcomeCycleALogic.update(outcomeCycleA);
	// }
	//
	// @Override
	// public OutcomeCycleA findByIidOutcomeCycleA(long idOutcoCycle) throws
	// Exception {
	// return outcomeCycleALogic.findByIid(idOutcoCycle);
	// }
	//
	// @Override
	// public List<OutcomeCycleA> findAllOutcomeCycleA() throws Exception {
	// return outcomeCycleALogic.findAllOutcomeCycleA();
	// }

	// public void saveOutcome(String criterion, String description, String
	// shortDescription, String idProgram,
	// long idState) throws Exception {
	// Outcome outcome = new Outcome();
	// outcome.setCriterion(criterion);
	// outcome.setDescription(description);
	// outcome.setShortDescription(shortDescription);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgram);
	//
	// StateSmc stateSmc = stateLogic.findById(idState);
	//
	// outcome.setStateSmc(stateSmc);
	// outcome.setProgramSmc(programSmc);
	//
	// outcomeLogic.saveOutcome(outcome);
	// }

	public void updateOutcome(String criterion, String description, String shortDescription, String idProgram,
			long idState) throws Exception {
		Outcome outcome = new Outcome();
		outcome.setCriterion(criterion);
		outcome.setDescription(description);
		outcome.setShortDescription(shortDescription);

		ProgramSmc programSmc = programLogic.findProgramById(idProgram);

		StateSmc stateSmc = stateLogic.findById(idState);

		outcome.setStateSmc(stateSmc);
		outcome.setProgramSmc(programSmc);

		outcomeLogic.updateOutcome(outcome);
	}

	@Override
	public Outcome findbyIdOutcome(long id) {
		return outcomeLogic.findbyId(id);
	}
	//
	// @Override
	// public List<Outcome> findAllOutcome() {
	// return outcomeLogic.findAllOutcome();
	// }

	@Override
	public void createBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception {
		parameterLogic.createBLOBParameter(parName, parDescription, dataType, parBlob);
	}

	@Override
	public void createCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception {
		parameterLogic.createCLOBParameter(parName, parDescription, dataType, parClob);
	}

	@Override
	public void createFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception {
		parameterLogic.createFinalDateParameter(parName, parDescription, dataType, parFinalDate);
	}

	@Override
	public void createFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception {
		parameterLogic.createFinalNumericParameter(parName, parDescription, dataType, parFinalNum);
	}

	@Override
	public void createInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception {
		parameterLogic.createInitialDateParameter(parName, parDescription, dataType, parInitialDate);
	}

	@Override
	public void createInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception {
		parameterLogic.createInitialNumericParameter(parName, parDescription, dataType, parInitialParameter);
	}

	@Override
	public void createTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception {
		parameterLogic.createTextParameter(parName, parDescription, dataType, parText);
	}

	// @Override
	// public ParamSmc findByIDParameter(long cdioSkill) {
	// return parameterLogic.findByIDParameter(cdioSkill);
	// }
	//
	// @Override
	// public List<ParamSmc> findAllParametres() {
	// return parameterLogic.findAll();
	// }

	@Override
	public ParamSmc findCycleActiveByProgram(String idParameter) {
		return parameterLogic.findParameterByName(idParameter);

	}

	// public void savePEO(String description, BigDecimal term, long idPeriod,
	// String idProgram) throws Exception {
	// Peo peo = new Peo();
	// peo.setDescription(description);
	// peo.setTerm(term);
	//
	// Period period = periodLogic.findById(idPeriod);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgram);
	//
	// peo.setPeriod(period);
	// peo.setProgramSmc(programSmc);
	//
	// peoLogic.savePEO(peo);
	// }
	//
	// public void updatePEO(String description, BigDecimal term, long idPeriod,
	// String idProgram) throws Exception {
	// Peo peo = new Peo();
	// peo.setDescription(description);
	// peo.setTerm(term);
	//
	// Period period = periodLogic.findById(idPeriod);
	//
	// ProgramSmc programSmc = programLogic.findProgramById(idProgram);
	//
	// peo.setPeriod(period);
	// peo.setProgramSmc(programSmc);
	//
	// peoLogic.updatePEO(peo);
	// }
	//
	// public Peo findByIdPEO(long peoId) throws Exception {
	// return peoLogic.findByIdPEO(peoId);
	// }

	// public List<Peo> findAllPEO() throws Exception {
	// return peoLogic.findAllPEO();
	// }
	//
	// public void savePeriod(String periodName) throws Exception {
	// Period period = new Period();
	// period.setNamePeriod(periodName);
	//
	// periodLogic.save(period);
	// }
	//
	// public void updatePeriod(String periodName) throws Exception {
	// Period period = new Period();
	// period.setNamePeriod(periodName);
	//
	// periodLogic.update(period);
	// }

	// @Override
	// public Period findByIdPeriod(long idPeriod) {
	// return periodLogic.findById(idPeriod);
	// }
	//
	// @Override
	// public List<Period> findAllPeriod() {
	// return periodLogic.findAll();
	// }

	@Override
	public void savePi(String code, String description, long idPlanSmc) throws ZMessManager {
		PiSmc piSmc = new PiSmc();
		piSmc.setCode(code);
		piSmc.setDescription(description);

		PlanSmc planSmc = planLogic.findByid(idPlanSmc);

		piSmc.setPlanSmc(planSmc);

		piLogic.savePi(piSmc);
	}

	@Override
	public void updatePi(String code, String description, long idPlanSmc) throws ZMessManager {
		PiSmc piSmc = new PiSmc();
		piSmc.setCode(code);
		piSmc.setDescription(description);

		PlanSmc planSmc = planLogic.findByid(idPlanSmc);

		piSmc.setPlanSmc(planSmc);

		piLogic.updatePi(piSmc);
	}

	@Override
	public PiSmc findByIdPi(long id) throws ZMessManager {
		return piLogic.findByIdPi(id);
	}

	// @Override
	// public PiSmc findByPlanPi(long idPlanSmc) throws ZMessManager {
	// PlanSmc planSmc = planLogic.findByid(idPlanSmc);
	//
	// return piLogic.findByPlanPi(planSmc);
	// }
	//
	// @Override
	// public List<PiSmc> findAllPi() {
	// return piLogic.findAllPi();
	// }

	@Override
	public void savePlan(Date creationDate, Date evaluation, String evaluationFrequency, BigDecimal periodIdPeriod,
			long idOutcomeCycleA, long idStateSmc, long idUserCip) throws Exception {
		PlanSmc planSmc = new PlanSmc();
		planSmc.setCreationDate(creationDate);
		planSmc.setEvaluationDate(evaluation);
		planSmc.setEvaluationFrequency(evaluationFrequency);
		planSmc.setPeriodIdPeriod(periodIdPeriod);

		OutcomeCycleA outcomeCycleA = outcomeCycleALogic.findByIid(idOutcomeCycleA);

		StateSmc stateSmc = stateLogic.findById(idStateSmc);

		UserCip userCip = userCipLogic.findByIdUser(idUserCip);

		planSmc.setOutcomeCycleA(outcomeCycleA);
		planSmc.setStateSmc(stateSmc);
		planSmc.setUserCip(userCip);

		planLogic.savePlan(planSmc);
	}

	@Override
	public void savePlanInicial(Date creationDate, BigDecimal periodIdPeriod, long idOutcomeCycleA, long idStateSmc,
			long idUserCip) throws Exception {
		PlanSmc planSmc = new PlanSmc();
		planSmc.setCreationDate(creationDate);
		planSmc.setPeriodIdPeriod(periodIdPeriod);

		OutcomeCycleA outcomeCycleA = outcomeCycleALogic.findByIid(idOutcomeCycleA);

		StateSmc stateSmc = stateLogic.findById(idStateSmc);

		UserCip userCip = userCipLogic.findByIdUser(idUserCip);

		planSmc.setOutcomeCycleA(outcomeCycleA);
		planSmc.setStateSmc(stateSmc);
		planSmc.setUserCip(userCip);
		FacesUtils.putinSession("plan", planSmc);

		planLogic.savePlan(planSmc);
	}

	// @Override
	// public void updatePlan(long idPlan, Date creationDate, Date evaluation,
	// String evaluationFrequency,
	// BigDecimal periodIdPeriod, long idOutcomeCycleA, long idStateSmc, long
	// idUserCip, long idRubricFile)
	// throws Exception {
	// PlanSmc planSmc = planLogic.findByid(idPlan);
	// planSmc.setCreationDate(creationDate);
	// planSmc.setEvaluationDate(evaluation);
	// planSmc.setEvaluationFrequency(evaluationFrequency);
	// planSmc.setPeriodIdPeriod(periodIdPeriod);
	//
	// OutcomeCycleA outcomeCycleA =
	// outcomeCycleALogic.findByIid(idOutcomeCycleA);
	//
	// StateSmc stateSmc = stateLogic.findById(idStateSmc);
	//
	// UserCip userCip = userCipLogic.findByIdUser(idUserCip);
	//
	// RubricFile rubricFile = rubricFileLogic.findByIdRubricFile(idRubricFile);
	//
	// planSmc.setOutcomeCycleA(outcomeCycleA);
	// planSmc.setStateSmc(stateSmc);
	// planSmc.setUserCip(userCip);
	// planSmc.setRubricFile(rubricFile);
	// planLogic.updatePlan(planSmc);
	// }
	//
	// @Override
	// public List<PlanSmc> findAllPlan() {
	// return planLogic.findAll();
	// }

	@Override
	public PlanSmc findByidPlan(long id) {
		return planLogic.findByid(id);
	}
	//
	// @Override
	// public List<PlanSmc> findByDateOfCreation(Date dateOfCreation) {
	// return planLogic.findByDateOfCreation(dateOfCreation);
	// }

	// public void saveProgram(String idProgram, String programName, long
	// facultyId, long idUserCip) throws Exception {
	// ProgramSmc programSmc = new ProgramSmc();
	// programSmc.setIdProgram(idProgram);
	// programSmc.setNameProgram(programName);
	//
	// Faculty faculty = facultyLogic.findFacultyById(facultyId);
	//
	// UserCip userCip = userCipLogic.findByIdUser(idUserCip);
	//
	// programSmc.setFaculty(faculty);
	// programSmc.setUserCip(userCip);
	//
	// programLogic.saveProgram(programSmc);
	// }

	// public void updateProgram(String idProgram, String programName, long
	// facultyId, long idUserCip) throws Exception {
	// ProgramSmc programSmc = new ProgramSmc();
	// programSmc.setIdProgram(idProgram);
	// programSmc.setNameProgram(programName);
	//
	// Faculty faculty = facultyLogic.findFacultyById(facultyId);
	//
	// UserCip userCip = userCipLogic.findByIdUser(idUserCip);
	//
	// programSmc.setFaculty(faculty);
	// programSmc.setUserCip(userCip);
	//
	// programLogic.updateProgram(programSmc);
	// }

	@Override
	public ProgramSmc findProgramById(String programId) {
		return programLogic.findProgramById(programId);
	}

	@Override
	public List<ProgramSmc> findAllProgramas() {
		return programLogic.findAllProgramas();
	}

	// public void saveRoleCip(String name, long idState) throws Exception {
	// RoleCip roleCip = new RoleCip();
	// roleCip.setName(name);
	//
	// StateSmc stateSmc = stateLogic.findById(idState);
	//
	// roleCip.setStateSmc(stateSmc);
	//
	// roleCipLogic.saveRoleCip(roleCip);
	// }

	// public void updateRoleCip(String name, long idState) throws Exception {
	// RoleCip roleCip = new RoleCip();
	// roleCip.setName(name);
	//
	// StateSmc stateSmc = stateLogic.findById(idState);
	//
	// roleCip.setStateSmc(stateSmc);
	//
	// roleCipLogic.updateRoleCip(roleCip);
	// }

	// @Override
	// public RoleCip findByIdRoleCip(long idRole) {
	// return roleCipLogic.findByIdRoleCip(idRole);
	// }
	//
	// @Override
	// public List<RoleCip> findAllRole() {
	// return roleCipLogic.findAllRole();
	// }

	// public void saveState(String stateName, long idStateType) throws
	// ZMessManager {
	// StateSmc stateSmc = new StateSmc();
	// stateSmc.setStateName(stateName);
	//
	// StateType stateType = stateTypeLogic.findByIdStateType(idStateType);
	//
	// stateSmc.setStateType(stateType);
	//
	// stateLogic.saveState(stateSmc);
	// }
	//
	// public void updateState(String stateName, long idStateType) throws
	// ZMessManager {
	// StateSmc stateSmc = new StateSmc();
	// stateSmc.setStateName(stateName);
	//
	// StateType stateType = stateTypeLogic.findByIdStateType(idStateType);
	//
	// stateSmc.setStateType(stateType);
	//
	// stateLogic.updateState(stateSmc);
	// }

	@Override
	public StateSmc findById(long id) throws ZMessManager {
		return stateLogic.findById(id);
	}

	@Override
	public List<StateSmc> findAllState() {
		return stateLogic.findAllState();
	}

	@Override
	public void saveStateType(String name) throws ZMessManager {
		StateType stateType = new StateType();
		stateType.setStateTypeName(name);

		stateTypeLogic.saveStateType(stateType);
	}

	// public void updateStateType(String name) throws ZMessManager {
	// StateType stateType = new StateType();
	// stateType.setStateTypeName(name);
	//
	// stateTypeLogic.updateStateType(stateType);
	// }

	@Override
	public StateType findByIdStateType(long id) throws ZMessManager {
		return stateTypeLogic.findByIdStateType(id);
	}

	@Override
	public List<StateType> findAllStateType() {
		return stateTypeLogic.findAllStateType();
	}

	// public void saveUser(String email, String identification, String name,
	// String lastName, String login,
	// String password, long idStateSmc) throws Exception {
	// UserCip userCip = new UserCip();
	// userCip.setEmail(email);
	// userCip.setNameUser(name);
	// userCip.setIdentification(identification);
	// userCip.setLastName(lastName);
	// userCip.setLogin(login);
	// userCip.setPasswordUser(password);
	//
	// StateSmc stateSmc = stateLogic.findById(idStateSmc);
	//
	// userCip.setStateSmc(stateSmc);
	//
	// userCipLogic.saveUser(userCip);
	// }
	//
	// public void updateUser(String email, String identification, String
	// lastName, String login, String password,
	// long idStateSmc) throws Exception {
	// UserCip userCip = new UserCip();
	// userCip.setEmail(email);
	// userCip.setIdentification(identification);
	// userCip.setLastName(lastName);
	// userCip.setLogin(login);
	// userCip.setPasswordUser(password);
	//
	// StateSmc stateSmc = stateLogic.findById(idStateSmc);
	//
	// userCip.setStateSmc(stateSmc);
	//
	// userCipLogic.updateUser(userCip);
	// }

	// @Override
	// public UserCip findByIdUser(long idUser) {
	// return userCipLogic.findByIdUser(idUser);
	// }
	//
	// @Override
	// public List<UserCip> findAllUser() {
	// return userCipLogic.findAllUser();
	// }

	@Override
	public UserCip validateUser(String username, String password) throws Exception {
		return userCipLogic.validateUser(username, password);
	}

	// @Override
	// public List<UserCip> findAllMentorUser() {
	// return userCipLogic.findAllMentorUser();
	// }

	@Override
	public List<Outcome> findOutcomeByIdProgram(String idPrograma) throws Exception {
		ProgramSmc programSmc = programLogic.findProgramById(idPrograma);
		return outcomeLogic.findOutcomeByProgram(programSmc);
	}

	@Override
	public boolean isProfesor(UserCip user) {
		return assignOutcomeLogic.isProfesor(user);
	}

	@Override
	public boolean isLiderOutcome(UserCip user) {
		return assignOutcomeLogic.isLiderOutcome(user);
	}

	@Override
	public boolean isDirectorPrograma(UserCip user) {
		return assignOutcomeLogic.isDirectorPrograma(user);
	}

	@Override
	public boolean isMECA(UserCip user) {
		return assignOutcomeLogic.isMECA(user);
	}

	// @Override
	// public List<Outcome> findOutcomesByProgram(String idProgram) {
	// return outcomeLogic.findOutcomesByProgram(idProgram);
	// }

	public void saveUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws Exception {
		userCipRoleCipLogic.saveUserCipRoleCip(userCipRoleCip);

	}

	// public void updateUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws
	// Exception {
	// userCipRoleCipLogic.updateUserCipRoleCip(userCipRoleCip);
	//
	// }
	//
	// public void deleteUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws
	// Exception {
	// userCipRoleCipLogic.deleteUserCipRoleCip(userCipRoleCip);
	//
	// }

	// @Override
	// public UserCipRoleCip findByIdUserCipRoleCip(long userCipRoleCipId)
	// throws Exception {
	// return userCipRoleCipLogic.findByIdUserCipRoleCip(userCipRoleCipId);
	// }

	@Override
	public List<UserCipRoleCip> findAllUserCipRoleCip() {
		return userCipRoleCipLogic.findAllUserCipRoleCip();
	}

	@Override
	public List<Outcome> findOutcomeByUser(long idUser) {

		return outcomeLogic.findOutcomeByUser(idUser);
	}

	@Override
	public List<UserCip> findUserByRole(long idRole) {
		return userCipRoleCipLogic.findUserByRole(idRole);
	}

	@Override
	public List<RoleCip> findRoleByUser(long id) {
		return userCipRoleCipLogic.findRoleByUser(id);
	}

	@Override
	public List<MainCycle> findMainCycleByProgram(String idProgram) {
		return mainCycleLogic.CycleForProgram(idProgram);
	}

	@Override
	public List<PlanesInfoDto> AssessmentPlanInfoLoad(ProgramSmc programa, MainCycle ciclo, MainCycle subciclo) {
		return planesInfoDTO.cargaInformacionPlanes(programa, ciclo, subciclo);
	}

	// @Override
	// public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome) throws
	// Exception {
	// return outcomeCycleALogic.findCycleByidOutcome(idOutcome);
	// }

	@Override
	public List<ProgramSmc> getFindProgramByDirector(long idDir) {

		return userCipLogic.getFindProgramByDirector(idDir);
	}
	//
	// @Override
	// public String whatSemesterIsDate(Date date) {
	// return periodLogic.whatSemesterIsDate(date);
	// }

	@Override
	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo) {

		return outcomeCycleALogic.findOutcomeCycleByidOutcome(idOutcome, idciclo);
	}

	@Override
	public long subcycleActiveByProgram(ProgramSmc program) {

		return parameterLogic.subcycleActiveByProgram(program);
	}

	@Override
	public BigDecimal periodToPlan() {

		return periodLogic.periodToPlan();
	}

	@Override
	public void createPlanFromAnother(PlanSmc plan, UserCip user, StateSmc state, BigDecimal period, OutcomeCycleA out,
			Date fecha) throws Exception {
		planLogic.createPlanFromAnother(plan, user, state, period, out, fecha);

	}

	@Override
	public void saveRubricFile(long idPlan, String fileName, String description, byte[] file) throws Exception {

		RubricFile loadFile = new RubricFile();

		loadFile.setFileName(fileName);
		loadFile.setDecription(description);
		loadFile.setFileRaw(file);

		PlanSmc miPlan = planLogic.findByid(idPlan);
		miPlan.setRubricFile(loadFile);

		planLogic.updatePlan(miPlan);

	}

	@Override
	public void saveRubricFileReport(long idEvalReport, String fileName, String description, byte[] file)
			throws Exception {

		RubricFile loadFile = new RubricFile();

		loadFile.setFileName(fileName);
		loadFile.setDecription(description);
		loadFile.setFileRaw(file);

		EvalReport miPlan = evaluationReportLogic.findByIdEvalReport(idEvalReport);
		miPlan.setRubricFile(loadFile);

		evaluationReportLogic.updateEvalReport(miPlan);

	}

	@Override
	public void cambiarEstadoPlan(long idPlan, long idEstado, long idUser) throws Exception {

		PlanSmc plan = planLogic.findByid(idPlan);
		StateSmc state = stateLogic.findById(idEstado);
		UserCip user = userCipLogic.findByIdUser(idUser);
		planLogic.cambiarEstadoPlanAssessment(plan, state, user);

		ProgramSmc idProgram = plan.getOutcomeCycleA().getOutcome().getProgramSmc();
		alertsManagement.envioCorreoCambioEstadoPlanAsesssment(idPlan, idProgram.getIdProgram());
	}

	@Override
	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram) {
		return outcomeLogic.findOutcomeByStateAndUser(idState, idProgram);
	}

	@Override
	public List<ProgramSmc> getProgramFindbyDirector(long idUser) {
		return programLogic.getProgramFindbyDirector(idUser);
	}

	@Override
	public void validarDescarga(long idplan) throws Exception {

		PlanSmc miPlan = planLogic.findByid(idplan);

		planLogic.validarDescarga(miPlan);

	}

	@Override
	public void validateDownloadReport(long idReport) throws Exception {

		EvalReport eval = evaluationReportLogic.findByIdEvalReport(idReport);

		evaluationReportLogic.validarDescarga(eval);

	}

	@Override
	public List<CdioCourseMtx> findByCdio(long idCdioskill) {
		return cdioCourseMtxLogic.findByCdio(idCdioskill);
	}

	// @Override
	// public MenuRole findByIidMenuRole(Long idMenu) {
	// return menuRoleLogic.findByIidMenuRole(idMenu);
	// }
	//
	// @Override
	// public List<MenuRole> findAllMenuRole() {
	// return menuRoleLogic.findAllMenuRole();
	// }

	@Override
	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2) {
		return cdioSkillLogic.findAllCdioSkillLevel3ByLevel2(idCdioSkillLevel2);
	}

	@Override
	public void saveEvideFile(EvideFile evideFile) throws Exception {
		evideFileLogic.saveEvideFile(evideFile);
	}

	// @Override
	// public void updateEvideFile(EvideFile evideFile) throws Exception {
	// evideFileLogic.updateEvideFile(evideFile);
	// }

	@Override
	public void deleteEvideFile(EvideFile evideFile) throws Exception {
		evideFileLogic.deleteEvideFile(evideFile);
	}

	@Override
	public EvideFile findByIdEvideFile(long evideFileId) throws Exception {
		return evideFileLogic.findByIdEvideFile(evideFileId);
	}
	//
	// @Override
	// public List<EvideFile> findAllEvideFiles() {
	// return evideFileLogic.findAllEvideFiles();
	// }

	@Override
	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc) {
		return evideFileLogic.getEvideFileFindByAsSrc(idAsSrc);
	}

	@Override
	public void saveAsSrc(AsSrc asSrc) throws Exception {
		asSrcLogic.saveAsSrc(asSrc);

	}

	// @Override
	// public void updateAsSrc(AsSrc asSrc) throws Exception {
	// asSrcLogic.updateAsSrc(asSrc);
	//
	// }

	// public void deleteAsSrc(AsSrc asSrc) throws Exception {
	// asSrcLogic.deleteAsSrc(asSrc);
	// }

	// @Override
	// public AsSrc findByIdAsSrc(long asSrcId) throws Exception {
	// return asSrcLogic.findByIdAsSrc(asSrcId);
	// }
	//
	@Override
	public List<Course> findAllAsSrc(long idPi) {
		return asSrcLogic.findAllAsSrc(idPi);
	}

	@Override
	public void validarCargaRubricFile(long idPlan) throws Exception {
		PlanSmc miPlan = planLogic.findByid(idPlan);

		planLogic.validarCarga(miPlan);

	}

	@Override
	public boolean puedeVerMenu(Menu menu, UserCip user) {
		for (MenuRole menuRole : menu.getMenuRoles()) {
			for (RoleCip rol : findRoleByUser(user.getIdUser())) {
				if (menuRole.getRoleCip().getIdRole() == rol.getIdRole()) {
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public List<Method> findAllMethod() {
		return methodLogic.findAllMethod();
	}

	@Override
	public PlanSmc findPlanByOutcome(long idOutcome) {
		return planLogic.findPlanByOutcome(idOutcome);
	}

	@Override
	public void modifyAssessmentPlan(long idAssessmentPlan, PiSmc pi, CdioSkill competenciaCdio, Course cursoFuente,
			Method metodoAs, Date recoleccion, String frecuencia, UserCip profesor, Date evaluacion) throws Exception {

	}

	@Override
	public void saveCdioSkillPi(CdioSkill skill, PiSmc pi) throws Exception {
		CdioSkillPi skillPi = new CdioSkillPi();
		skillPi.setCdioSkill(skill);
		skillPi.setPiSmc(pi);

		cdioSkillPiLogic.saveCdioSkillPiLogic(skillPi);
	}

	public boolean isMECA(long idUser) {

		List<RoleCip> roles2 = findRoleByUser(idUser);
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 3) {

				return true;
			}
		}
		return false;
	}

	public boolean isDirector(long idUser) {
		List<RoleCip> roles2 = findRoleByUser(idUser);
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 2) {

				return true;
			}
		}
		return false;
	}
	//
	// @Override
	// public boolean isLider(long idUser) {
	// List<RoleCip> roles2 = findRoleByUser(idUser);
	// for (RoleCip roleCip : roles2) {
	// if (roleCip.getIdRole() == 1) {
	//
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// @Override
	// public boolean isProfesor(long idUser) {
	// List<RoleCip> roles2 = findRoleByUser(idUser);
	// for (RoleCip roleCip : roles2) {
	// if (roleCip.getIdRole() == 4) {
	//
	// return true;
	// }
	// }
	// return false;
	// }

	@Override
	public boolean validarUsuarioCarga(long idUser, long idPlan) {

		PlanSmc miPlan = planLogic.findByid(idPlan);
		UserCip liderOutcomePlan = miPlan.getOutcomeCycleA().getOutcome().getUserCip();

		boolean carga = false;
		if (isMECA(idUser) == true || isDirector(idUser) == true || liderOutcomePlan.getIdUser() == idUser) {

			carga = true;

		}

		return carga;
	}

	@Override
	public boolean validarUsuarioCargaEvidencia(long idUser, long idEncargadoFuente) {

		boolean carga = false;

		if (isMECA(idUser) == true || isDirector(idUser) == true || idEncargadoFuente == idUser) {
			carga = true;
		}

		return carga;

	}

	// @Override
	// public CdioSkillPi findByIdCdioSkillPi(long cdioSkillPi) {
	// return cdioSkillPiLogic.findByIdCdioSkillPi(cdioSkillPi);
	// }
	//
	// @Override
	// public List<CdioSkillPi> findAllCdioSkillPi() {
	// return cdioSkillPiLogic.findAllCdioSkillPi();
	// }

	@Override
	public void saveCdioSkillPiLogic(long cdioSkill, long piSmc) throws Exception {
		CdioSkillPi cdio = new CdioSkillPi();
		CdioSkill cdioSkil = cdioSkillLogic.findByIdCdioSkill(cdioSkill);
		PiSmc pis = piLogic.findByIdPi(piSmc);

		cdio.setCdioSkill(cdioSkil);
		cdio.setPiSmc(pis);

		cdioSkillPiLogic.saveCdioSkillPiLogic(cdio);

	}

	@Override
	public List<PiSmc> findAllPisByPlan(long idPlan) {

		return piLogic.findAllPisByPlan(idPlan);
	}

	@Override
	public void validarCargaEvidencia(long idPlan) throws Exception {
		PlanSmc plan = planLogic.findByid(idPlan);

		planLogic.validarCargaEvidencia(plan);
	}

	@Override
	public void updateAlertAsignacion(String descripcion) throws Exception {
		ParamSmc parametro = parameterLogic.findParameterByName("AlertAsignacion");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);

	}

	@Override
	public void updateAlertDesasignacion(String descripcion) throws Exception {

		ParamSmc parametro = parameterLogic.findParameterByName("AlertDesasignacion");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);

	}

	@Override
	public void updateAlertCambioAssessent(String descripcion) throws Exception {

		ParamSmc parametro = parameterLogic.findParameterByName("AlertCambioEstadoAssessment");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);
	}

	@Override
	public void updateAlertCambioEvaluacion(String descripcion) throws Exception {
		ParamSmc parametro = parameterLogic.findParameterByName("AlertCambioEstadoEvaluacion");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);
	}

	@Override
	public void updateAlertFechaRecoleccion(String descripcion) throws Exception {
		ParamSmc parametro = parameterLogic.findParameterByName("AlertfechaRecoleccion");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);
	}

	@Override
	public void updateAlertFechaEvaluacion(String descripcion) throws Exception {
		ParamSmc parametro = parameterLogic.findParameterByName("AlertfechaEvaluacion");
		parametro.setTextValue(descripcion);
		parameterLogic.updateParameter(parametro);

	}

	@Override
	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd) {
		return cdioOutcomeMtxLogic.findAllCdioSkillByOutcome(idStd);
	}

	@Override
	public void saveUserASsrc(UserAsSrc usuarioF) {

		userAsrcLogic.saveUserAsrc(usuarioF);
	}

	@Override
	public UserAsSrc findByIdUserASsrc(long idUserASsrc) {
		return userAsrcLogic.findByIdUserAsrc(idUserASsrc);
	}

	@Override
	public List<UserAsSrc> findAllUserASsrc() {
		return userAsrcLogic.findAllUserAsrc();
	}

	@Override
	public void updateUserAsSrc(long UserAsrcId, AsSrc fuente, UserCip usuarioFuente, long idUserCip) {
		UserAsSrc usuario = userAsrcLogic.findByIdUserAsrc(UserAsrcId);
		usuario.setAsSrc(fuente);
		usuario.setIdUserAsSrc(idUserCip);
		usuario.setUserCip(usuarioFuente);
		userAsrcLogic.updateUserAsrc(usuario);

	}

	@Override
	public void saveEvalReport(long creatorUSer, long evalCycle) {

		try {
			BigDecimal period = periodToPlan();
			EvalReport evalReport = new EvalReport();

			UserCip userCip = userCipLogic.findByIdUser(creatorUSer);
			StateSmc stateSmc = stateLogic.findById(11);

			evalReport.setPeriodIdPeriod(period);
			evalReport.setUserCip2(userCip);
			evalReport.setEvalCycle(evalCycleLogic.findByIdEvalCycle(evalCycle));

			evalReport.setStateSmc(stateSmc);
			evaluationReportLogic.saveEvalReport(evalReport);

			FacesUtils.putinSession("eval", evalReport);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// public void updateEvalReport(BigDecimal period, long state, long
	// creatorUSer, long evalCycle) {
	//
	// try {
	//
	// EvalReport evalReport = new EvalReport();
	//
	// UserCip userCip = userCipLogic.findByIdUser(creatorUSer);
	// StateSmc stateSmc = stateLogic.findById(state);
	//
	// evalReport.setPeriodIdPeriod(period);
	// evalReport.setUserCip2(userCip);
	// evalReport.getEvalCycle().setIdEvalCycle(evalCycle);
	//
	// evalReport.setStateSmc(stateSmc);
	// evaluationReportLogic.updateEvalReport(evalReport);
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	//
	// }

	@Override
	public List<EvalReport> findAllEvalReport() {

		return evaluationReportLogic.findAllEvalReport();
	}

	@Override
	public EvalReport findByIdEvalReport(long idEvalReport) {
		return evaluationReportLogic.findByIdEvalReport(idEvalReport);
	}

	@Override
	public EvalCycle findByIdEvalCycle(long idEvalCycle) {

		return evalCycleLogic.findByIdEvalCycle(idEvalCycle);
	}

	@Override
	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan) {
		return evalCycleLogic.findByIdEvalCycleByIdPlan(idPLan);
	}

	@Override
	public List<EvalCycle> findIdEvalByIdCycle(long idCycle) {
		return evalCycleLogic.findIdEvalByIdCycle(idCycle);
	}

	@Override
	public List<EvalReport> findAllEvalCycleByProgramCycleSubcicle(ProgramSmc program, List<MainCycle> losCiclos,
			List<MainCycle> losSubciclos, MainCycle cycle) {

		return evaluationReportLogic.findAllEvalCycleByProgramCycleSubcicle(program, losCiclos, losSubciclos, cycle);
	}

}
