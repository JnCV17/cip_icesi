package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CDIO_COURSE_MTX database table.
 * 
 */
@Entity
@Table(name="CDIO_COURSE_MTX")
@NamedQuery(name="CdioCourseMtx.findAll", query="SELECT c FROM CdioCourseMtx c")
public class CdioCourseMtx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CDIO_COURSE_MTX_IDMTXCOURSECDIOLVL_GENERATOR", allocationSize = 1, sequenceName="SEQ_CDIO_COURSE_MTX")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CDIO_COURSE_MTX_IDMTXCOURSECDIOLVL_GENERATOR")
	@Column(name="ID_MTX_COURSE_CDIO_LVL", unique=true, nullable=false)
	private long idMtxCourseCdioLvl;

	@Column(name="\"VERSION\"", nullable=false, length=10)
	private String version;

	//bi-directional many-to-one association to CdioLvl
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CDIO_LVL", nullable=false)
	private CdioLvl cdioLvl;

	//bi-directional many-to-one association to CdioSkill
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CDIO_SKILL", nullable=false)
	private CdioSkill cdioSkill;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COURSE", nullable=false)
	private Course course;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROGRAM", nullable=false)
	private ProgramSmc programSmc;

	public CdioCourseMtx() {
	}

	public long getIdMtxCourseCdioLvl() {
		return this.idMtxCourseCdioLvl;
	}

	public void setIdMtxCourseCdioLvl(long idMtxCourseCdioLvl) {
		this.idMtxCourseCdioLvl = idMtxCourseCdioLvl;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public CdioLvl getCdioLvl() {
		return this.cdioLvl;
	}

	public void setCdioLvl(CdioLvl cdioLvl) {
		this.cdioLvl = cdioLvl;
	}

	public CdioSkill getCdioSkill() {
		return this.cdioSkill;
	}

	public void setCdioSkill(CdioSkill cdioSkill) {
		this.cdioSkill = cdioSkill;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

}