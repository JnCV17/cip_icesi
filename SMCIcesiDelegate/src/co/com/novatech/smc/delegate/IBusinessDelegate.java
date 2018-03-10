package co.com.novatech.smc.delegate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.CdioCourseMtx;
import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.EvalCycle;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.EvideFile;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.Menu;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.StateType;
import co.com.novatech.smc.modelo.UserAsSrc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;
import co.sco.novatech.smc.dto.PlanesInfoDto;

@Remote
public interface IBusinessDelegate {

	// Alert
	// TODO agregarle parametros a los metodos de las alertas
	public void saveAlert(String alertName, long idStateSmc) throws Exception;

	// public void updateAlert(long idAlert, String alertName, long idStateSmc)
	// throws Exception;

	// public void deleteAlert(Alert alert) throws Exception;
	// public Alert findByIdAlert(long alertId) throws Exception;

	// public List<Alert> findAllAlert();

	// AlertsManagement
	public void envioCorreoAsignacionOutcome(long idUsuario, String idProgram, long idStOutcome, long idUser);

	// public void envioCorreoDesasignacionOutcome(String idProgram, long
	// idStOutcome, long idUser);

	// public void envioCorreoCambioEstadoPlanAsesssment(long idPlan, String
	// idProgram);

	// public void envioCorreoFechaRecoleccionEvidencias();

	// public void envioCorreoFechaEvaluacion(PlanSmc planSmc);

	// AlertType
	// public void saveAlertType(String alertTypeName, String description, long
	// idMessUser) throws Exception;
	//
	// public void updateAlertType(long idAlertType, String alertTypeName,
	// String description, long idMessUser)
	// throws Exception;

	// public void deleteAlertType(AlertType alertType) throws Exception;
	// public AlertType findByIdAlertType(long alertTypeId) throws Exception;
	//
	// public List<AlertType> findAllAlertType();

	// AssessmentPlan
	// public void crearNuevoPlan(PlanSmc plan) throws Exception;

	public List<PlanSmc> filtrarPlanesPorPrograma(String idProgram);

	public List<PlanSmc> filtrarPlanesPorOutcome(long idOutcome);

	public void createPlanFromAnother(PlanSmc plan, UserCip user, StateSmc state, BigDecimal period, OutcomeCycleA out,
			Date fecha) throws Exception;

	public void cambiarEstadoPlan(long idPlan, long idEstado, long idUser) throws Exception;

	// AssignOutcome
	// public void unassignOutcome(long idOutcome) throws Exception;

	public void toAssignOutcome(long idOutcome, long idUserCIp) throws Exception;

	// BlockCourse
	// public void saveBlockCourse(String name, String idProgramSmc, long
	// idUserCip) throws Exception;
	//
	// public void updateBlockCourse(long idBlock, String name, String
	// idProgramSmc, long idUserCip) throws Exception;

	// CDIOCourseMtx
	// public void saveCDIOCourseMtx(String version, long idCdioLvl, long
	// idCourse) throws Exception;
	//
	// public void updateCDIOCourseMtx(long idCdioCourse, String version, long
	// idCdioLvl, long idCourse) throws Exception;

	// public CdioCourseMtx findByIdCDIOCourseMtx(long cdioCourseMtx);

	// public List<CdioCourseMtx> findAllCDIOCourseMt();

	// CDIO
	// public void saveCdio(String description, String name) throws Exception;
	//
	// public void updateCdio(long idCdio, String description, String name)
	// throws Exception;

	// public Cdio findByIdCdio(long idCdio);

	// public List<Cdio> findAllCdio();

	// CDIOlvl
	// public void saveCdioLvl(String description, String symbol, long
	// idCdioSkill) throws Exception;
	//
	// public void updateCdioLvl(long idCdioLvl, String description, String
	// symbol, long idCdioSkill) throws Exception;
	//
	// public CdioLvl findByIdCdioLvl(long cdioLvl);
	//
	// public List<CdioLvl> findAllCdioLvl();

	// CDIOOutcomeMtx
	// public void saveCdioOutcomeMtx(String version, long idCdioSkill, long
	// idOutcome) throws Exception;
	//
	// public void updateCdioOutcomeMtx(String version, long idCdioSkill, long
	// idOutcome) throws Exception;

	// public CdioOutcomeMtx findByIdCdioOutcomeMtx(long cdioOutcomeMtx);

	public List<CdioOutcomeMtx> findAll();

	// CDIOSkill
	// public void saveCdioSkill(String description, long idCdio) throws
	// Exception;
	//
	// public void updateCdioSkill(long idCdioSkill, String description, long
	// idCdio) throws Exception;

	// public CdioSkill findByIdCdioSkill(long cdioSkill);

	public List<CdioSkill> findAllCdioSkill();

	// Course
	// public void saveCourse(String code, BigDecimal credits, String
	// nameCourse, String idProgramSmc) throws Exception;
	//
	// public void updateCourse(long idCourse, String code, BigDecimal credits,
	// String nameCourse, String idProgramSmc)
	// throws Exception;
	//
	// // public void deleteCourse(Course course) throws Exception;
	// public Course findByIdCourse(long idCourse) throws Exception;
	//
	// public List<Course> findAllCourse();

	// Faculty
	// public void saveFaculty(String code, String name) throws Exception;
	//
	// public void updateFaculty(long idFaculty, String code, String name)
	// throws Exception;
	//
	// public Faculty findFacultyById(long facultyId);
	//
	// public List<Faculty> findAllFaculties();

	// public List<ProgramSmc> getProgramsByFaculty(long idFaculty);

	// public List<UserCip> getUserCipByFaculty(long idFaculty);

	// Language
	// public void saveLanguage(String languageName) throws Exception;
	//
	// public void updateLanguage(long idLanguage, String languageName) throws
	// Exception;
	//
	// public LanguageSmc findByIDLanguage(long language);
	//
	// public List<LanguageSmc> findAllLanguage();

	// MainCycle
	// public void saveMainCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle)
	// throws Exception;
	//
	// public void updateMainCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle)
	// throws Exception;

	// public void delete(MainCycle mainCycle) throws Exception;
	// public void deleteByIdMainCycle(long idCycle) throws Exception;
	// public MainCycle findByIdMainCycle(long idCycle);

	// public List<MainCycle> findAllMainCycle();

	// Cycle
	// public void saveCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle,
	// long idMainCycle) throws Exception;
	//
	// public void updateCycle(String cycleName, BigDecimal duration, String
	// initialDateCycle, String finalDateCycle,
	// long idMainCycle) throws Exception;

	public MainCycle findByICycle(long idCycle);

	public List<MainCycle> findAllCycles();

	public List<MainCycle> findAllCycleByMainCycle(long idMainCycle);

	// Menu
	// public void saveMenu(String menuName) throws Exception;
	//
	// public void updateMenu(String menuName) throws Exception;

	// public void deleteMenu(Menu entity) throws Exception;
	public Menu findByIidMenu(long idMenu) throws Exception;

	public List<Menu> findAllMenus() throws Exception;

	// OutcomeCycleALogic
	// public void saveOutcomeCycleA(long idMainCycle, long idOutcome) throws
	// Exception;
	//
	// public void updateOutcomeCycleA(long idMainCycle, long idOutcome) throws
	// Exception;

	// public void deleteOutcomeCycleA(OutcomeCycleA entity) throws Exception;
	// public OutcomeCycleA findByIidOutcomeCycleA(long idOutcoCycle) throws
	// Exception;

	// public List<OutcomeCycleA> findAllOutcomeCycleA() throws Exception;

	// Outcome
	// public void saveOutcome(String criterion, String description, String
	// shortDescription, String idProgram,
	// long idState) throws Exception;
	//
	// public void updateOutcome(String criterion, String description, String
	// shortDescription, String idProgram,
	// long idState) throws Exception;

	public Outcome findbyIdOutcome(long id);

	// public void deleteOutcome(Outcome outcome) throws Exception;
	// public List<Outcome> findAllOutcome();

	// Page
	// public void savePage(String pageName, String url) throws Exception;
	//
	// public void updatePage(String pageName, String url) throws Exception;

	// public void deletePage(PageSmc entity) throws Exception;
	// public PageSmc findByIidPage(long idPage) throws Exception;
	//
	// public List<PageSmc> findAllPages() throws Exception;

	// Parameter
	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de
	 * asignaci�n
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertAsignacion(String descripcion) throws Exception;

	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de
	 * desasignaci�n
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertDesasignacion(String descripcion) throws Exception;

	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de cambio de
	 * estado de un plan de assessment
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertCambioAssessent(String descripcion) throws Exception;

	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de cambio de
	 * estado de un reporte de evaluaci�n
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertCambioEvaluacion(String descripcion) throws Exception;

	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de fecha
	 * limite de recolecci�n
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertFechaRecoleccion(String descripcion) throws Exception;

	/**
	 * Metodo que actualiza el mensaje parametrizado para la alerta de fecha
	 * limite de evaluaci�n
	 * 
	 * @param descripcion
	 *            , mensaje a ser guardado, tipo String,
	 * @return void
	 * @throws lanza
	 *             excepcion por problemas por el update de logic
	 */
	public void updateAlertFechaEvaluacion(String descripcion) throws Exception;

	public void createBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception;

	public void createCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception;

	public void createFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception;

	public void createFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception;

	public void createInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception;

	public void createInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception;

	public void createTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception;

	// public void saveParameter(ParamSmc param) throws Exception;

	// public void updateParameter(ParamSmc param) throws Exception;

	// public ParamSmc findByIDParameter(long cdioSkill);

	public ParamSmc findCycleActiveByProgram(String idParameter);

	// public List<ParamSmc> findAllParametres();

	// Peo
	// public void savePEO(String description, BigDecimal term, long idPeriod,
	// String idProgram) throws Exception;
	//
	// public void updatePEO(String description, BigDecimal term, long idPeriod,
	// String idProgram) throws Exception;
	//
	// // public void deletePEO(Peo peo) throws Exception;
	// // public void deleteByIdPEO(long peoId) throws Exception;
	// public Peo findByIdPEO(long peoId) throws Exception;
	//
	// public List<Peo> findAllPEO() throws Exception;

	// Period
	// public void savePeriod(String periodName) throws Exception;
	//
	// public void updatePeriod(String periodName) throws Exception;

	// public void deletePeriod(Period period) throws Exception;
	// public void deleteByIdPeriod(long idPeriod) throws Exception;
	// public Period findByIdPeriod(long idPeriod);

	// public List<Period> findAllPeriod();

	// Pi
	public void savePi(String code, String description, long idPlanSmc) throws ZMessManager;

	public void updatePi(String code, String description, long idPlanSmc) throws ZMessManager;

	// public void deletePi(PiSmc pi) throws ZMessManager;
	public PiSmc findByIdPi(long id) throws ZMessManager;

	// public PiSmc findByPlanPi(long idPlanSmc) throws ZMessManager;

	// public List<PiSmc> findAllPi();

	// Plan
	public void savePlan(Date creationDate, Date evaluation, String evaluationFrequency, BigDecimal periodIdPeriod,
			long idOutcomeCycleA, long stateSmc, long idUserCip) throws Exception;

	// public void updatePlan(long idPlan, Date creationDate, Date evaluation,
	// String evaluationFrequency,
	// BigDecimal periodIdPeriod, long idOutcomeCycleA, long stateSmc, long
	// idUserCip, long idRubricFile)
	// throws Exception;

	// public void delete(PlanSmc plan) throws Exception;
	// public List<PlanSmc> findAllPlan();

	public PlanSmc findByidPlan(long id);

	// public List<PlanSmc> findByDateOfCreation(Date dateOfCreation);

	public PlanSmc findPlanByOutcome(long idOutcome);

	// Program
	// public void saveProgram(String idProgram, String programName, long
	// facultyId, long idUserCip) throws Exception;

	// public void updateProgram(String idProgram, String programName, long
	// facultyId, long idUserCip) throws Exception;

	public ProgramSmc findProgramById(String programId);

	public List<ProgramSmc> findAllProgramas();

	// RoleCip
	// public void saveRoleCip(String name, long idState) throws Exception;

	// public void deletedRoleCip(RoleCip role) throws Exception;
	// public void updateRoleCip(String name, long idState) throws Exception;

	// public RoleCip findByIdRoleCip(long idRole);

	// public List<RoleCip> findAllRole();

	// State
	// public void saveState(String stateName, long idStateType) throws
	// ZMessManager;

	// public void updateState(String stateName, long idStateType) throws
	// ZMessManager;

	// public void deleteState(StateSmc state) throws ZMessManager;
	public StateSmc findById(long id) throws ZMessManager;

	public List<StateSmc> findAllState();

	// StateType
	public void saveStateType(String name) throws ZMessManager;

	// public void updateStateType(String name) throws ZMessManager;

	// public void deleteStateType(StateType stateType) throws ZMessManager;
	public StateType findByIdStateType(long id) throws ZMessManager;

	public List<StateType> findAllStateType();

	// UserCip
	// public void saveUser(String email, String identification, String name,
	// String lastName, String login,
	// String password, long idStateSmc) throws Exception;

	// public void updateUser(String email, String identification, String
	// lastName, String login, String password,
	// long idStateSmc) throws Exception;

	// public void deletedUser(UserCip user) throws Exception;
	// public UserCip findByIdUser(long idUser);

	// public List<UserCip> findAllUser();

	// public List<Outcome> findOutcomeByNameProgram(String idPrograma) throws
	// Exception;

	public List<Outcome> findOutcomeByIdProgram(String idPrograma) throws Exception;

	// public List<UserCip> findAllMentorUser();

	public UserCip validateUser(String username, String password) throws Exception;

	// public ProgramSmc findProgramByName(String programId);

	public boolean isProfesor(UserCip user);

	public boolean isLiderOutcome(UserCip user);

	public boolean isDirectorPrograma(UserCip user);

	public boolean isMECA(UserCip user);

	// public List<Outcome> findOutcomesByProgram(String idProgram);

	// public void saveUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws
	// Exception;

	// public void updateUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws
	// Exception;

	// public void deleteUserCipRoleCip(UserCipRoleCip userCipRoleCip) throws
	// Exception;

	// public UserCipRoleCip findByIdUserCipRoleCip(long userCipRoleCipId)
	// throws Exception;

	public List<UserCipRoleCip> findAllUserCipRoleCip();

	public List<Outcome> findOutcomeByUser(long idUser);

	public void savePlanInicial(Date creationDate, BigDecimal periodIdPeriod, long idOutcomeCycleA, long idStateSmc,
			long idUserCip) throws Exception;

	public List<UserCip> findUserByRole(long idRole);

	public List<RoleCip> findRoleByUser(long id);

	public List<MainCycle> findMainCycleByProgram(String idProgram);

	public List<PlanesInfoDto> AssessmentPlanInfoLoad(ProgramSmc programa, MainCycle ciclo, MainCycle subciclo);

	// public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome) throws
	// Exception;

	public List<ProgramSmc> getFindProgramByDirector(long idDir);

	// public String whatSemesterIsDate(Date date);

	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo);

	public BigDecimal periodToPlan();

	public long subcycleActiveByProgram(ProgramSmc program);

	// Rubric File

	public void saveRubricFile(long idPlan, String fileName, String Description, byte[] file) throws Exception;

	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram);

	public List<ProgramSmc> getProgramFindbyDirector(long idUser);

	public void validarDescarga(long idplan) throws Exception;

	public List<CdioCourseMtx> findByCdio(long idCdioskill);

	// MenuRole

	// public MenuRole findByIidMenuRole(Long idMenu);

	// public List<MenuRole> findAllMenuRole();

	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2);

	public void saveEvideFile(EvideFile evideFile) throws Exception;

	// public void updateEvideFile(EvideFile evideFile) throws Exception;

	public void deleteEvideFile(EvideFile evideFile) throws Exception;

	public EvideFile findByIdEvideFile(long evideFileId) throws Exception;

	// public List<EvideFile> findAllEvideFiles();

	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc);

	public void saveAsSrc(AsSrc asSrc) throws Exception;

	// public void updateAsSrc(AsSrc asSrc) throws Exception;

	// public void deleteAsSrc(AsSrc asSrc) throws Exception;

	// public AsSrc findByIdAsSrc(long asSrcId) throws Exception;

	public List<Course> findAllAsSrc(long idPi);

	public void validarCargaRubricFile(long idPlan) throws Exception;

	boolean puedeVerMenu(Menu menu, UserCip user);

	public void modifyAssessmentPlan(long idAssessmentPlan, PiSmc pi, CdioSkill competenciaCdio, Course cursoFuente,
			Method metodoAs, Date recoleccion, String frecuencia, UserCip profesor, Date evaluacion) throws Exception;

	List<Method> findAllMethod();

	public void saveCdioSkillPi(CdioSkill skill, PiSmc pi) throws Exception;

	// public boolean isMECA(long idUser);

	// public boolean isDirector(long idUser);

	// public boolean isLider(long idUser);

	// public boolean isProfesor(long idUser);

	public boolean validarUsuarioCarga(long idUser, long idPlan);

	public void saveCdioSkillPiLogic(long cdioSkill, long piSmc) throws Exception;

	// public List<CdioSkillPi> findAllCdioSkillPi();

	// public CdioSkillPi findByIdCdioSkillPi(long cdioSkillPi);

	public List<PiSmc> findAllPisByPlan(long idPlan);

	public void validarCargaEvidencia(long idPlan) throws Exception;

	public boolean validarUsuarioCargaEvidencia(long idUser, long idEncargadoFuente);

	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd);

	// UserASsrc
	public void saveUserASsrc(UserAsSrc usuarioF);

	public UserAsSrc findByIdUserASsrc(long idUserASsrc);

	public List<UserAsSrc> findAllUserASsrc();

	public void updateUserAsSrc(long idUserAsSrc, AsSrc fuente, UserCip usuarioFuente, long idUserCip);

	public void saveEvalReport(long creatorUSer, long evalCycle);

	// public void updateEvalReport(BigDecimal period, long state, long
	// creatorUSer, long evalCycle);

	public List<EvalReport> findAllEvalReport();

	public EvalReport findByIdEvalReport(long idEvalReport);

	public EvalCycle findByIdEvalCycle(long idEvalCycle);

	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan);

	public List<EvalCycle> findIdEvalByIdCycle(long idCycle);

	public List<EvalReport> findAllEvalCycleByProgramCycleSubcicle(ProgramSmc program, List<MainCycle> losCiclos,
			List<MainCycle> losSubciclos, MainCycle cycle);

	void validateDownloadReport(long idReport) throws Exception;

	void saveRubricFileReport(long idEvalReport, String fileName, String description, byte[] file) throws Exception;

	void cambiarEstadoEvalReport(long idEvalReport, long idState, long idUser) throws Exception;

}
