package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FACULTY database table.
 * 
 */
@Entity
@Table(name="FACULTY")
@NamedQuery(name="Faculty.findAll", query="SELECT f FROM Faculty f")
public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACULTY_IDFACULTY_GENERATOR", allocationSize = 1, sequenceName="SEQ_FACULTY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACULTY_IDFACULTY_GENERATOR")
	@Column(name="ID_FACULTY", unique=true, nullable=false)
	private long idFaculty;

	@Column(nullable=false, length=10)
	private String code;

	@Column(nullable=false, length=30)
	private String name;

	//bi-directional many-to-one association to FacultyUser
	@OneToMany(mappedBy="faculty")
	private List<FacultyUser> facultyUsers;

	//bi-directional many-to-one association to ProgramSmc
	@OneToMany(mappedBy="faculty")
	private List<ProgramSmc> programSmcs;

	public Faculty() {
	}

	public long getIdFaculty() {
		return this.idFaculty;
	}

	public void setIdFaculty(long idFaculty) {
		this.idFaculty = idFaculty;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FacultyUser> getFacultyUsers() {
		return this.facultyUsers;
	}

	public void setFacultyUsers(List<FacultyUser> facultyUsers) {
		this.facultyUsers = facultyUsers;
	}

	public FacultyUser addFacultyUser(FacultyUser facultyUser) {
		getFacultyUsers().add(facultyUser);
		facultyUser.setFaculty(this);

		return facultyUser;
	}

	public FacultyUser removeFacultyUser(FacultyUser facultyUser) {
		getFacultyUsers().remove(facultyUser);
		facultyUser.setFaculty(null);

		return facultyUser;
	}

	public List<ProgramSmc> getProgramSmcs() {
		return this.programSmcs;
	}

	public void setProgramSmcs(List<ProgramSmc> programSmcs) {
		this.programSmcs = programSmcs;
	}

	public ProgramSmc addProgramSmc(ProgramSmc programSmc) {
		getProgramSmcs().add(programSmc);
		programSmc.setFaculty(this);

		return programSmc;
	}

	public ProgramSmc removeProgramSmc(ProgramSmc programSmc) {
		getProgramSmcs().remove(programSmc);
		programSmc.setFaculty(null);

		return programSmc;
	}

}