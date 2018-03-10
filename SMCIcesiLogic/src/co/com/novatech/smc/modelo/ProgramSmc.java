package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROGRAM_SMC database table.
 * 
 */
@Entity
@Table(name="PROGRAM_SMC")
@NamedQuery(name="ProgramSmc.findAll", query="SELECT p FROM ProgramSmc p")
public class ProgramSmc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROGRAM_SMC_IDPROGRAM_GENERATOR", allocationSize = 1, sequenceName="SEQ_PROGRAM_SMC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROGRAM_SMC_IDPROGRAM_GENERATOR")
	@Column(name="ID_PROGRAM", unique=true, nullable=false, length=10)
	private String idProgram;

	@Column(name="NAME_PROGRAM", nullable=false, length=30)
	private String nameProgram;

	//bi-directional many-to-one association to BlockCourse
	@OneToMany(mappedBy="programSmc")
	private List<BlockCourse> blockCourses;

	//bi-directional many-to-one association to CdioCourseMtx
	@OneToMany(mappedBy="programSmc")
	private List<CdioCourseMtx> cdioCourseMtxs;

	//bi-directional many-to-one association to CdioOutcomeMtx
	@OneToMany(mappedBy="programSmc")
	private List<CdioOutcomeMtx> cdioOutcomeMtxs;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="programSmc")
	private List<Course> courses;

	//bi-directional many-to-one association to MainCycle
	@OneToMany(mappedBy="programSmc")
	private List<MainCycle> mainCycles;

	//bi-directional many-to-one association to Outcome
	@OneToMany(mappedBy="programSmc")
	private List<Outcome> outcomes;

	//bi-directional many-to-one association to Peo
	@OneToMany(mappedBy="programSmc")
	private List<Peo> peos;

	//bi-directional many-to-one association to Faculty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FACULTY_ID_FACULTY", nullable=false)
	private Faculty faculty;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_CIP_ID_USER", nullable=false)
	private UserCip userCip;

	public ProgramSmc() {
	}

	public String getIdProgram() {
		return this.idProgram;
	}

	public void setIdProgram(String idProgram) {
		this.idProgram = idProgram;
	}

	public String getNameProgram() {
		return this.nameProgram;
	}

	public void setNameProgram(String nameProgram) {
		this.nameProgram = nameProgram;
	}

	public List<BlockCourse> getBlockCourses() {
		return this.blockCourses;
	}

	public void setBlockCourses(List<BlockCourse> blockCourses) {
		this.blockCourses = blockCourses;
	}

	public BlockCourse addBlockCours(BlockCourse blockCours) {
		getBlockCourses().add(blockCours);
		blockCours.setProgramSmc(this);

		return blockCours;
	}

	public BlockCourse removeBlockCours(BlockCourse blockCours) {
		getBlockCourses().remove(blockCours);
		blockCours.setProgramSmc(null);

		return blockCours;
	}

	public List<CdioCourseMtx> getCdioCourseMtxs() {
		return this.cdioCourseMtxs;
	}

	public void setCdioCourseMtxs(List<CdioCourseMtx> cdioCourseMtxs) {
		this.cdioCourseMtxs = cdioCourseMtxs;
	}

	public CdioCourseMtx addCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().add(cdioCourseMtx);
		cdioCourseMtx.setProgramSmc(this);

		return cdioCourseMtx;
	}

	public CdioCourseMtx removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().remove(cdioCourseMtx);
		cdioCourseMtx.setProgramSmc(null);

		return cdioCourseMtx;
	}

	public List<CdioOutcomeMtx> getCdioOutcomeMtxs() {
		return this.cdioOutcomeMtxs;
	}

	public void setCdioOutcomeMtxs(List<CdioOutcomeMtx> cdioOutcomeMtxs) {
		this.cdioOutcomeMtxs = cdioOutcomeMtxs;
	}

	public CdioOutcomeMtx addCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		getCdioOutcomeMtxs().add(cdioOutcomeMtx);
		cdioOutcomeMtx.setProgramSmc(this);

		return cdioOutcomeMtx;
	}

	public CdioOutcomeMtx removeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		getCdioOutcomeMtxs().remove(cdioOutcomeMtx);
		cdioOutcomeMtx.setProgramSmc(null);

		return cdioOutcomeMtx;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setProgramSmc(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setProgramSmc(null);

		return cours;
	}

	public List<MainCycle> getMainCycles() {
		return this.mainCycles;
	}

	public void setMainCycles(List<MainCycle> mainCycles) {
		this.mainCycles = mainCycles;
	}

	public MainCycle addMainCycle(MainCycle mainCycle) {
		getMainCycles().add(mainCycle);
		mainCycle.setProgramSmc(this);

		return mainCycle;
	}

	public MainCycle removeMainCycle(MainCycle mainCycle) {
		getMainCycles().remove(mainCycle);
		mainCycle.setProgramSmc(null);

		return mainCycle;
	}

	public List<Outcome> getOutcomes() {
		return this.outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public Outcome addOutcome(Outcome outcome) {
		getOutcomes().add(outcome);
		outcome.setProgramSmc(this);

		return outcome;
	}

	public Outcome removeOutcome(Outcome outcome) {
		getOutcomes().remove(outcome);
		outcome.setProgramSmc(null);

		return outcome;
	}

	public List<Peo> getPeos() {
		return this.peos;
	}

	public void setPeos(List<Peo> peos) {
		this.peos = peos;
	}

	public Peo addPeo(Peo peo) {
		getPeos().add(peo);
		peo.setProgramSmc(this);

		return peo;
	}

	public Peo removePeo(Peo peo) {
		getPeos().remove(peo);
		peo.setProgramSmc(null);

		return peo;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

}