package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BLOCK_COURSE database table.
 * 
 */
@Entity
@Table(name="BLOCK_COURSE")
@NamedQuery(name="BlockCourse.findAll", query="SELECT b FROM BlockCourse b")
public class BlockCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLOCK_COURSE_IDBLOCK_GENERATOR", allocationSize = 1, sequenceName="SEQ_BLOCK_COURSE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLOCK_COURSE_IDBLOCK_GENERATOR")
	@Column(name="ID_BLOCK", unique=true, nullable=false)
	private long idBlock;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROGRAM_ID_PROGRAM", nullable=false)
	private ProgramSmc programSmc;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_CIP_ID_USER", nullable=false)
	private UserCip userCip;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="blockCourse")
	private List<Course> courses;

	public BlockCourse() {
	}

	public long getIdBlock() {
		return this.idBlock;
	}

	public void setIdBlock(long idBlock) {
		this.idBlock = idBlock;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setBlockCourse(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setBlockCourse(null);

		return cours;
	}

}