package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FACULTY_USER database table.
 * 
 */
@Entity
@Table(name="FACULTY_USER")
@NamedQuery(name="FacultyUser.findAll", query="SELECT f FROM FacultyUser f")
public class FacultyUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACULTY_USER_IDFACULTYUSER_GENERATOR", allocationSize = 1, sequenceName="SEQ_FACULTY_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACULTY_USER_IDFACULTYUSER_GENERATOR")
	@Column(name="ID_FACULTY_USER", unique=true, nullable=false)
	private long idFacultyUser;

	//bi-directional many-to-one association to Faculty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FACULTY_ID_FACULTY", nullable=false)
	private Faculty faculty;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_CIP_ID_USER", nullable=false)
	private UserCip userCip;

	public FacultyUser() {
	}

	public long getIdFacultyUser() {
		return this.idFacultyUser;
	}

	public void setIdFacultyUser(long idFacultyUser) {
		this.idFacultyUser = idFacultyUser;
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