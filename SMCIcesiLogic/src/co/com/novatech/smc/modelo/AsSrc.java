package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the AS_SRC database table.
 * 
 */
@Entity
@Table(name = "AS_SRC")
@NamedQuery(name = "AsSrc.findAll", query = "SELECT a FROM AsSrc a")
public class AsSrc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "AS_SRC_IDASSRC_GENERATOR", allocationSize = 1, sequenceName = "SEQ_AS_SRC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AS_SRC_IDASSRC_GENERATOR")
	@Column(name = "ID_AS_SRC", unique = true, nullable = false)
	private long idAsSrc;

	@Temporal(TemporalType.DATE)
	@Column(name = "COLLECTION_DATE", nullable = false)
	private Date collectionDate;

	@Column(name = "COLLECTION_FREQUENCY", nullable = false, length = 20)
	private String collectionFrequency;

	@Column(name = "USER_CIP_ID_USER", nullable = false)
	private BigDecimal userCipIdUser;

	// bi-directional many-to-one association to Course
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COURSE_ID_COURSE", nullable = false)
	private Course course;

	// bi-directional many-to-one association to Method
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "METHOD_ID_AS_METHOD", nullable = false)
	private Method method;

	// bi-directional many-to-one association to PiSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PI_ID_PI", nullable = false)
	private PiSmc piSmc;

	@Column(length = 500)
	private String methodology;

	@Column(length = 500)
	private String result;

	@Column(length = 500)
	private String improvement;

	@Column(length = 20)
	private String assigned;

	private BigDecimal population;

	// bi-directional many-to-one association to EvideFile
	@OneToMany(mappedBy = "asSrc", fetch = FetchType.EAGER)
	private List<EvideFile> evideFiles;

	// bi-directional many-to-one association to UserAsSrc
	@OneToMany(mappedBy = "asSrc", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<UserAsSrc> userAsSrcs;

	public AsSrc() {
	}

	public long getIdAsSrc() {
		return this.idAsSrc;
	}

	public void setIdAsSrc(long idAsSrc) {
		this.idAsSrc = idAsSrc;
	}

	public Date getCollectionDate() {
		return this.collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionFrequency() {
		return this.collectionFrequency;
	}

	public void setCollectionFrequency(String collectionFrequency) {
		this.collectionFrequency = collectionFrequency;
	}

	public BigDecimal getUserCipIdUser() {
		return this.userCipIdUser;
	}

	public void setUserCipIdUser(BigDecimal userCipIdUser) {
		this.userCipIdUser = userCipIdUser;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Method getMethod() {
		return this.method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public PiSmc getPiSmc() {
		return this.piSmc;
	}

	public void setPiSmc(PiSmc piSmc) {
		this.piSmc = piSmc;
	}

	public String getMethodology() {
		return methodology;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public void setMethodology(String methodology) {
		this.methodology = methodology;
	}

	public BigDecimal getPopulation() {
		return population;
	}

	public void setPopulation(BigDecimal population) {
		this.population = population;
	}

	public List<EvideFile> getEvideFiles() {
		return this.evideFiles;
	}

	public void setEvideFiles(List<EvideFile> evideFiles) {
		this.evideFiles = evideFiles;
	}

	public EvideFile addEvideFile(EvideFile evideFile) {
		getEvideFiles().add(evideFile);
		evideFile.setAsSrc(this);

		return evideFile;
	}

	public EvideFile removeEvideFile(EvideFile evideFile) {
		getEvideFiles().remove(evideFile);
		evideFile.setAsSrc(null);

		return evideFile;
	}

	public List<UserAsSrc> getUserAsSrcs() {
		return this.userAsSrcs;
	}

	public void setUserAsSrcs(List<UserAsSrc> userAsSrcs) {
		this.userAsSrcs = userAsSrcs;
	}

	public UserAsSrc addUserAsSrc(UserAsSrc userAsSrc) {
		getUserAsSrcs().add(userAsSrc);
		userAsSrc.setAsSrc(this);

		return userAsSrc;
	}

	public UserAsSrc removeUserAsSrc(UserAsSrc userAsSrc) {
		getUserAsSrcs().remove(userAsSrc);
		userAsSrc.setAsSrc(null);

		return userAsSrc;
	}

}