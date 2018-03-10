package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.util.List;

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

/**
 * The persistent class for the CDIO_SKILL database table.
 * 
 */
@Entity
@Table(name = "CDIO_SKILL")
@NamedQuery(name = "CdioSkill.findAll", query = "SELECT c FROM CdioSkill c")
public class CdioSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CDIO_SKILL_IDCDIOSKILL_GENERATOR", allocationSize = 1, sequenceName = "SEQ_CDIO_SKILL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDIO_SKILL_IDCDIOSKILL_GENERATOR")
	@Column(name = "ID_CDIO_SKILL", unique = true, nullable = false)
	private long idCdioSkill;

	@Column(nullable = false, length = 300)
	private String description;

	// bi-directional many-to-one association to CdioCourseMtx
	@OneToMany(mappedBy = "cdioSkill", fetch = FetchType.EAGER)
	private List<CdioCourseMtx> cdioCourseMtxs;

	// bi-directional many-to-one association to CdioOutcomeMtx
	@OneToMany(mappedBy = "cdioSkill", fetch = FetchType.EAGER)
	private List<CdioOutcomeMtx> cdioOutcomeMtxs;

	// bi-directional many-to-one association to Cdio
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CDIO_ID_CDIO", nullable = false)
	private Cdio cdio;

	// bi-directional many-to-one association to CdioSkill
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CDIO_SKILL_ID_CDIO_SKILL")
	private CdioSkill cdioSkill;

	// bi-directional many-to-one association to CdioSkill
	@OneToMany(mappedBy = "cdioSkill")
	private List<CdioSkill> cdioSkills;

	// bi-directional many-to-one association to CdioSkillPi
	@OneToMany(mappedBy = "cdioSkill", fetch = FetchType.EAGER)
	private List<CdioSkillPi> cdioSkillPis;

	public CdioSkill() {
	}

	public long getIdCdioSkill() {
		return this.idCdioSkill;
	}

	public void setIdCdioSkill(long idCdioSkill) {
		this.idCdioSkill = idCdioSkill;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CdioCourseMtx> getCdioCourseMtxs() {
		return this.cdioCourseMtxs;
	}

	public void setCdioCourseMtxs(List<CdioCourseMtx> cdioCourseMtxs) {
		this.cdioCourseMtxs = cdioCourseMtxs;
	}

	public CdioCourseMtx addCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().add(cdioCourseMtx);
		cdioCourseMtx.setCdioSkill(this);

		return cdioCourseMtx;
	}

	public CdioCourseMtx removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().remove(cdioCourseMtx);
		cdioCourseMtx.setCdioSkill(null);

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
		cdioOutcomeMtx.setCdioSkill(this);

		return cdioOutcomeMtx;
	}

	public CdioOutcomeMtx removeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		getCdioOutcomeMtxs().remove(cdioOutcomeMtx);
		cdioOutcomeMtx.setCdioSkill(null);

		return cdioOutcomeMtx;
	}

	public Cdio getCdio() {
		return this.cdio;
	}

	public void setCdio(Cdio cdio) {
		this.cdio = cdio;
	}

	public CdioSkill getCdioSkill() {
		return this.cdioSkill;
	}

	public void setCdioSkill(CdioSkill cdioSkill) {
		this.cdioSkill = cdioSkill;
	}

	public List<CdioSkill> getCdioSkills() {
		return this.cdioSkills;
	}

	public void setCdioSkills(List<CdioSkill> cdioSkills) {
		this.cdioSkills = cdioSkills;
	}

	public CdioSkill addCdioSkill(CdioSkill cdioSkill) {
		getCdioSkills().add(cdioSkill);
		cdioSkill.setCdioSkill(this);

		return cdioSkill;
	}

	public CdioSkill removeCdioSkill(CdioSkill cdioSkill) {
		getCdioSkills().remove(cdioSkill);
		cdioSkill.setCdioSkill(null);

		return cdioSkill;
	}

	public List<CdioSkillPi> getCdioSkillPis() {
		return this.cdioSkillPis;
	}

	public void setCdioSkillPis(List<CdioSkillPi> cdioSkillPis) {
		this.cdioSkillPis = cdioSkillPis;
	}

	public CdioSkillPi addCdioSkillPi(CdioSkillPi cdioSkillPi) {
		getCdioSkillPis().add(cdioSkillPi);
		cdioSkillPi.setCdioSkill(this);

		return cdioSkillPi;
	}

	public CdioSkillPi removeCdioSkillPi(CdioSkillPi cdioSkillPi) {
		getCdioSkillPis().remove(cdioSkillPi);
		cdioSkillPi.setCdioSkill(null);

		return cdioSkillPi;
	}

}