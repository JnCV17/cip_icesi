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
 * The persistent class for the PI_SMC database table.
 * 
 */
@Entity
@Table(name = "PI_SMC")
@NamedQuery(name = "PiSmc.findAll", query = "SELECT p FROM PiSmc p")
public class PiSmc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PI_SMC_IDPI_GENERATOR", allocationSize = 1, sequenceName = "SEQ_PI_SMC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PI_SMC_IDPI_GENERATOR")
	@Column(name = "ID_PI", unique = true, nullable = false)
	private long idPi;

	@Column(nullable = false, length = 40)
	private String code;

	@Column(nullable = false, length = 200)
	private String description;

	// bi-directional many-to-one association to AsSrc
	@OneToMany(mappedBy = "piSmc", fetch = FetchType.EAGER)
	private List<AsSrc> asSrcs;

	// bi-directional many-to-one association to CdioSkillPi
	@OneToMany(mappedBy = "piSmc", fetch = FetchType.EAGER)
	private List<CdioSkillPi> cdioSkillPis;

	// bi-directional many-to-one association to PlanSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAN_ID_PLAN", nullable = false)
	private PlanSmc planSmc;

	public PiSmc() {
	}

	public long getIdPi() {
		return this.idPi;
	}

	public void setIdPi(long idPi) {
		this.idPi = idPi;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AsSrc> getAsSrcs() {
		return this.asSrcs;
	}

	public void setAsSrcs(List<AsSrc> asSrcs) {
		this.asSrcs = asSrcs;
	}

	public AsSrc addAsSrc(AsSrc asSrc) {
		getAsSrcs().add(asSrc);
		asSrc.setPiSmc(this);

		return asSrc;
	}

	public AsSrc removeAsSrc(AsSrc asSrc) {
		getAsSrcs().remove(asSrc);
		asSrc.setPiSmc(null);

		return asSrc;
	}

	public List<CdioSkillPi> getCdioSkillPis() {
		return this.cdioSkillPis;
	}

	public void setCdioSkillPis(List<CdioSkillPi> cdioSkillPis) {
		this.cdioSkillPis = cdioSkillPis;
	}

	public CdioSkillPi addCdioSkillPi(CdioSkillPi cdioSkillPi) {
		getCdioSkillPis().add(cdioSkillPi);
		cdioSkillPi.setPiSmc(this);

		return cdioSkillPi;
	}

	public CdioSkillPi removeCdioSkillPi(CdioSkillPi cdioSkillPi) {
		getCdioSkillPis().remove(cdioSkillPi);
		cdioSkillPi.setPiSmc(null);

		return cdioSkillPi;
	}

	public PlanSmc getPlanSmc() {
		return this.planSmc;
	}

	public void setPlanSmc(PlanSmc planSmc) {
		this.planSmc = planSmc;
	}

}