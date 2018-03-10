package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EVIDE_FILE database table.
 * 
 */
@Entity
@Table(name="EVIDE_FILE")
@NamedQuery(name="EvideFile.findAll", query="SELECT e FROM EvideFile e")
public class EvideFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVIDE_FILE_IDFILE_GENERATOR", allocationSize = 1, sequenceName="SEQ_EVIDE_FILE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVIDE_FILE_IDFILE_GENERATOR")
	@Column(name="ID_FILE", unique=true, nullable=false)
	private long idFile;

	@Column(nullable=false, length=200)
	private String description;

	@Lob
	@Column(name="FILE_RAW", nullable=false)
	private byte[] fileRaw;

	@Temporal(TemporalType.DATE)
	@Column(name="LOAD_DATE", nullable=false)
	private Date loadDate;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to AsSrc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_AS_SRC", nullable=false)
	private AsSrc asSrc;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_USER", nullable=false)
	private UserCip userCip;

	public EvideFile() {
	}

	public long getIdFile() {
		return this.idFile;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFileRaw() {
		return this.fileRaw;
	}

	public void setFileRaw(byte[] fileRaw) {
		this.fileRaw = fileRaw;
	}

	public Date getLoadDate() {
		return this.loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AsSrc getAsSrc() {
		return this.asSrc;
	}

	public void setAsSrc(AsSrc asSrc) {
		this.asSrc = asSrc;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

}