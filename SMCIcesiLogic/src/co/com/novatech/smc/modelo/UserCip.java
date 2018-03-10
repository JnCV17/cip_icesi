package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USER_CIP database table.
 * 
 */
@Entity
@Table(name="USER_CIP")
@NamedQuery(name="UserCip.findAll", query="SELECT u FROM UserCip u")
public class UserCip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_CIP_IDUSER_GENERATOR", allocationSize = 1, sequenceName="SEQ_USER_CIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_CIP_IDUSER_GENERATOR")
	@Column(name="ID_USER", unique=true, nullable=false)
	private long idUser;

	@Column(nullable=false, length=60)
	private String email;

	@Column(nullable=false, length=60)
	private String identification;

	@Column(name="LAST_NAME", nullable=false, length=60)
	private String lastName;

	@Column(nullable=false, length=11)
	private String login;

	@Column(name="NAME_USER", nullable=false, length=60)
	private String nameUser;

	@Column(name="PASSWORD_USER", nullable=false, length=100)
	private String passwordUser;

	//bi-directional many-to-one association to BlockCourse
	@OneToMany(mappedBy="userCip")
	private List<BlockCourse> blockCourses;

	//bi-directional many-to-one association to CourseProfessor
	@OneToMany(mappedBy="userCip")
	private List<CourseProfessor> courseProfessors;

	//bi-directional many-to-one association to EvalReport
	@OneToMany(mappedBy="userCip1")
	private List<EvalReport> evalReports1;

	//bi-directional many-to-one association to EvalReport
	@OneToMany(mappedBy="userCip2")
	private List<EvalReport> evalReports2;

	//bi-directional many-to-one association to EvideFile
	@OneToMany(mappedBy="userCip")
	private List<EvideFile> evideFiles;

	//bi-directional many-to-one association to FacultyUser
	@OneToMany(mappedBy="userCip")
	private List<FacultyUser> facultyUsers;

	//bi-directional many-to-one association to Outcome
	@OneToMany(mappedBy="userCip")
	private List<Outcome> outcomes;

	//bi-directional many-to-one association to PlanSmc
	@OneToMany(mappedBy="userCip")
	private List<PlanSmc> planSmcs;

	//bi-directional many-to-one association to ProgramSmc
	@OneToMany(mappedBy="userCip")
	private List<ProgramSmc> programSmcs;

	//bi-directional many-to-one association to UserAsSrc
	@OneToMany(mappedBy="userCip")
	private List<UserAsSrc> userAsSrcs;

	//bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_ID_STATE", nullable=false)
	private StateSmc stateSmc;

	//bi-directional many-to-one association to UserCipRoleCip
	@OneToMany(mappedBy="userCip")
	private List<UserCipRoleCip> userCipRoleCips;

	public UserCip() {
	}

	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public List<BlockCourse> getBlockCourses() {
		return this.blockCourses;
	}

	public void setBlockCourses(List<BlockCourse> blockCourses) {
		this.blockCourses = blockCourses;
	}

	public BlockCourse addBlockCours(BlockCourse blockCours) {
		getBlockCourses().add(blockCours);
		blockCours.setUserCip(this);

		return blockCours;
	}

	public BlockCourse removeBlockCours(BlockCourse blockCours) {
		getBlockCourses().remove(blockCours);
		blockCours.setUserCip(null);

		return blockCours;
	}

	public List<CourseProfessor> getCourseProfessors() {
		return this.courseProfessors;
	}

	public void setCourseProfessors(List<CourseProfessor> courseProfessors) {
		this.courseProfessors = courseProfessors;
	}

	public CourseProfessor addCourseProfessor(CourseProfessor courseProfessor) {
		getCourseProfessors().add(courseProfessor);
		courseProfessor.setUserCip(this);

		return courseProfessor;
	}

	public CourseProfessor removeCourseProfessor(CourseProfessor courseProfessor) {
		getCourseProfessors().remove(courseProfessor);
		courseProfessor.setUserCip(null);

		return courseProfessor;
	}

	public List<EvalReport> getEvalReports1() {
		return this.evalReports1;
	}

	public void setEvalReports1(List<EvalReport> evalReports1) {
		this.evalReports1 = evalReports1;
	}

	public EvalReport addEvalReports1(EvalReport evalReports1) {
		getEvalReports1().add(evalReports1);
		evalReports1.setUserCip1(this);

		return evalReports1;
	}

	public EvalReport removeEvalReports1(EvalReport evalReports1) {
		getEvalReports1().remove(evalReports1);
		evalReports1.setUserCip1(null);

		return evalReports1;
	}

	public List<EvalReport> getEvalReports2() {
		return this.evalReports2;
	}

	public void setEvalReports2(List<EvalReport> evalReports2) {
		this.evalReports2 = evalReports2;
	}

	public EvalReport addEvalReports2(EvalReport evalReports2) {
		getEvalReports2().add(evalReports2);
		evalReports2.setUserCip2(this);

		return evalReports2;
	}

	public EvalReport removeEvalReports2(EvalReport evalReports2) {
		getEvalReports2().remove(evalReports2);
		evalReports2.setUserCip2(null);

		return evalReports2;
	}

	public List<EvideFile> getEvideFiles() {
		return this.evideFiles;
	}

	public void setEvideFiles(List<EvideFile> evideFiles) {
		this.evideFiles = evideFiles;
	}

	public EvideFile addEvideFile(EvideFile evideFile) {
		getEvideFiles().add(evideFile);
		evideFile.setUserCip(this);

		return evideFile;
	}

	public EvideFile removeEvideFile(EvideFile evideFile) {
		getEvideFiles().remove(evideFile);
		evideFile.setUserCip(null);

		return evideFile;
	}

	public List<FacultyUser> getFacultyUsers() {
		return this.facultyUsers;
	}

	public void setFacultyUsers(List<FacultyUser> facultyUsers) {
		this.facultyUsers = facultyUsers;
	}

	public FacultyUser addFacultyUser(FacultyUser facultyUser) {
		getFacultyUsers().add(facultyUser);
		facultyUser.setUserCip(this);

		return facultyUser;
	}

	public FacultyUser removeFacultyUser(FacultyUser facultyUser) {
		getFacultyUsers().remove(facultyUser);
		facultyUser.setUserCip(null);

		return facultyUser;
	}

	public List<Outcome> getOutcomes() {
		return this.outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public Outcome addOutcome(Outcome outcome) {
		getOutcomes().add(outcome);
		outcome.setUserCip(this);

		return outcome;
	}

	public Outcome removeOutcome(Outcome outcome) {
		getOutcomes().remove(outcome);
		outcome.setUserCip(null);

		return outcome;
	}

	public List<PlanSmc> getPlanSmcs() {
		return this.planSmcs;
	}

	public void setPlanSmcs(List<PlanSmc> planSmcs) {
		this.planSmcs = planSmcs;
	}

	public PlanSmc addPlanSmc(PlanSmc planSmc) {
		getPlanSmcs().add(planSmc);
		planSmc.setUserCip(this);

		return planSmc;
	}

	public PlanSmc removePlanSmc(PlanSmc planSmc) {
		getPlanSmcs().remove(planSmc);
		planSmc.setUserCip(null);

		return planSmc;
	}

	public List<ProgramSmc> getProgramSmcs() {
		return this.programSmcs;
	}

	public void setProgramSmcs(List<ProgramSmc> programSmcs) {
		this.programSmcs = programSmcs;
	}

	public ProgramSmc addProgramSmc(ProgramSmc programSmc) {
		getProgramSmcs().add(programSmc);
		programSmc.setUserCip(this);

		return programSmc;
	}

	public ProgramSmc removeProgramSmc(ProgramSmc programSmc) {
		getProgramSmcs().remove(programSmc);
		programSmc.setUserCip(null);

		return programSmc;
	}

	public List<UserAsSrc> getUserAsSrcs() {
		return this.userAsSrcs;
	}

	public void setUserAsSrcs(List<UserAsSrc> userAsSrcs) {
		this.userAsSrcs = userAsSrcs;
	}

	public UserAsSrc addUserAsSrc(UserAsSrc userAsSrc) {
		getUserAsSrcs().add(userAsSrc);
		userAsSrc.setUserCip(this);

		return userAsSrc;
	}

	public UserAsSrc removeUserAsSrc(UserAsSrc userAsSrc) {
		getUserAsSrcs().remove(userAsSrc);
		userAsSrc.setUserCip(null);

		return userAsSrc;
	}

	public StateSmc getStateSmc() {
		return this.stateSmc;
	}

	public void setStateSmc(StateSmc stateSmc) {
		this.stateSmc = stateSmc;
	}

	public List<UserCipRoleCip> getUserCipRoleCips() {
		return this.userCipRoleCips;
	}

	public void setUserCipRoleCips(List<UserCipRoleCip> userCipRoleCips) {
		this.userCipRoleCips = userCipRoleCips;
	}

	public UserCipRoleCip addUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		getUserCipRoleCips().add(userCipRoleCip);
		userCipRoleCip.setUserCip(this);

		return userCipRoleCip;
	}

	public UserCipRoleCip removeUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		getUserCipRoleCips().remove(userCipRoleCip);
		userCipRoleCip.setUserCip(null);

		return userCipRoleCip;
	}

}