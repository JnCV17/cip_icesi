package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COURSE database table.
 * 
 */
@Entity
@Table(name="COURSE")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURSE_IDCOURSE_GENERATOR", allocationSize = 1, sequenceName="SEQ_COURSE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_IDCOURSE_GENERATOR")
	@Column(name="ID_COURSE", unique=true, nullable=false)
	private long idCourse;

	@Column(nullable=false, length=10)
	private String code;

	@Column(nullable=false)
	private BigDecimal credits;

	@Column(name="NAME_COURSE", nullable=false, length=60)
	private String nameCourse;

	//bi-directional many-to-one association to AsSrc
	@OneToMany(mappedBy="course")
	private List<AsSrc> asSrcs;

	//bi-directional many-to-one association to CdioCourseMtx
	@OneToMany(mappedBy="course")
	private List<CdioCourseMtx> cdioCourseMtxs;

	//bi-directional many-to-one association to BlockCourse
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BLOCK_COURSE_ID_BLOCK")
	private BlockCourse blockCourse;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROGRAM_ID_PROGRAM", nullable=false)
	private ProgramSmc programSmc;

	//bi-directional many-to-one association to CourseProfessor
	@OneToMany(mappedBy="course")
	private List<CourseProfessor> courseProfessors;

	public Course() {
	}

	public long getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(long idCourse) {
		this.idCourse = idCourse;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getNameCourse() {
		return this.nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public List<AsSrc> getAsSrcs() {
		return this.asSrcs;
	}

	public void setAsSrcs(List<AsSrc> asSrcs) {
		this.asSrcs = asSrcs;
	}

	public AsSrc addAsSrc(AsSrc asSrc) {
		getAsSrcs().add(asSrc);
		asSrc.setCourse(this);

		return asSrc;
	}

	public AsSrc removeAsSrc(AsSrc asSrc) {
		getAsSrcs().remove(asSrc);
		asSrc.setCourse(null);

		return asSrc;
	}

	public List<CdioCourseMtx> getCdioCourseMtxs() {
		return this.cdioCourseMtxs;
	}

	public void setCdioCourseMtxs(List<CdioCourseMtx> cdioCourseMtxs) {
		this.cdioCourseMtxs = cdioCourseMtxs;
	}

	public CdioCourseMtx addCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().add(cdioCourseMtx);
		cdioCourseMtx.setCourse(this);

		return cdioCourseMtx;
	}

	public CdioCourseMtx removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().remove(cdioCourseMtx);
		cdioCourseMtx.setCourse(null);

		return cdioCourseMtx;
	}

	public BlockCourse getBlockCourse() {
		return this.blockCourse;
	}

	public void setBlockCourse(BlockCourse blockCourse) {
		this.blockCourse = blockCourse;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

	public List<CourseProfessor> getCourseProfessors() {
		return this.courseProfessors;
	}

	public void setCourseProfessors(List<CourseProfessor> courseProfessors) {
		this.courseProfessors = courseProfessors;
	}

	public CourseProfessor addCourseProfessor(CourseProfessor courseProfessor) {
		getCourseProfessors().add(courseProfessor);
		courseProfessor.setCourse(this);

		return courseProfessor;
	}

	public CourseProfessor removeCourseProfessor(CourseProfessor courseProfessor) {
		getCourseProfessors().remove(courseProfessor);
		courseProfessor.setCourse(null);

		return courseProfessor;
	}

}