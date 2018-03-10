package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CDIO database table.
 * 
 */
@Entity
@Table(name="CDIO")
@NamedQuery(name="Cdio.findAll", query="SELECT c FROM Cdio c")
public class Cdio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CDIO_IDCDIO_GENERATOR", allocationSize = 1, sequenceName="SEQ_CDIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CDIO_IDCDIO_GENERATOR")
	@Column(name="ID_CDIO", unique=true, nullable=false)
	private long idCdio;

	@Column(nullable=false, length=200)
	private String description;

	@Column(nullable=false, length=60)
	private String name;

	//bi-directional many-to-one association to CdioSkill
	@OneToMany(mappedBy="cdio")
	private List<CdioSkill> cdioSkills;

	public Cdio() {
	}

	public long getIdCdio() {
		return this.idCdio;
	}

	public void setIdCdio(long idCdio) {
		this.idCdio = idCdio;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CdioSkill> getCdioSkills() {
		return this.cdioSkills;
	}

	public void setCdioSkills(List<CdioSkill> cdioSkills) {
		this.cdioSkills = cdioSkills;
	}

	public CdioSkill addCdioSkill(CdioSkill cdioSkill) {
		getCdioSkills().add(cdioSkill);
		cdioSkill.setCdio(this);

		return cdioSkill;
	}

	public CdioSkill removeCdioSkill(CdioSkill cdioSkill) {
		getCdioSkills().remove(cdioSkill);
		cdioSkill.setCdio(null);

		return cdioSkill;
	}

}