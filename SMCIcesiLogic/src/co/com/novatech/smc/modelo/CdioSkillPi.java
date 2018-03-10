package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CDIO_SKILL_PI database table.
 * 
 */
@Entity
@Table(name="CDIO_SKILL_PI")
@NamedQuery(name="CdioSkillPi.findAll", query="SELECT c FROM CdioSkillPi c")
public class CdioSkillPi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CDIO_SKILL_PI_PCDIOSKILLPI_GENERATOR", allocationSize = 1, sequenceName="SEQ_CDIO_SKILL_PI")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CDIO_SKILL_PI_PCDIOSKILLPI_GENERATOR")
	@Column(name="P_CDIO_SKILL_PI", unique=true, nullable=false)
	private long pCdioSkillPi;

	//bi-directional many-to-one association to CdioSkill
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CDIO_SKILL_ID_CDIO_SKILL", nullable=false)
	private CdioSkill cdioSkill;

	//bi-directional many-to-one association to PiSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PI_ID_PI", nullable=false)
	private PiSmc piSmc;

	public CdioSkillPi() {
	}

	public long getPCdioSkillPi() {
		return this.pCdioSkillPi;
	}

	public void setPCdioSkillPi(long pCdioSkillPi) {
		this.pCdioSkillPi = pCdioSkillPi;
	}

	public CdioSkill getCdioSkill() {
		return this.cdioSkill;
	}

	public void setCdioSkill(CdioSkill cdioSkill) {
		this.cdioSkill = cdioSkill;
	}

	public PiSmc getPiSmc() {
		return this.piSmc;
	}

	public void setPiSmc(PiSmc piSmc) {
		this.piSmc = piSmc;
	}

}