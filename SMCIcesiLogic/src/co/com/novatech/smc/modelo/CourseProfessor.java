package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COURSE_PROFESSOR database table.
 * 
 */
@Entity
@Table(name="COURSE_PROFESSOR")
@NamedQuery(name="CourseProfessor.findAll", query="SELECT c FROM CourseProfessor c")
public class CourseProfessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COURSE_PROFESSOR_IDCOURSEPROFESSOR_GENERATOR", allocationSize = 1, sequenceName="SEQ_COURSE_PROFESSOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_PROFESSOR_IDCOURSEPROFESSOR_GENERATOR")
	@Column(name="ID_COURSE_PROFESSOR", unique=true, nullable=false)
	private long idCourseProfessor;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COURSE_ID_COURSE", nullable=false)
	private Course course;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_CIP_ID_USER", nullable=false)
	private UserCip userCip;

	public CourseProfessor() {
	}

	public long getIdCourseProfessor() {
		return this.idCourseProfessor;
	}

	public void setIdCourseProfessor(long idCourseProfessor) {
		this.idCourseProfessor = idCourseProfessor;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

}