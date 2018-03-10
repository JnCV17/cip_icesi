package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CDIO_OUTCOME_MTX database table.
 * 
 */
@Entity
@Table(name="CDIO_OUTCOME_MTX")
@NamedQuery(name="CdioOutcomeMtx.findAll", query="SELECT c FROM CdioOutcomeMtx c")
public class CdioOutcomeMtx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CDIO_OUTCOME_MTX_IDMTXOUTCOMECDIO_GENERATOR", allocationSize = 1, sequenceName="SEQ_CDIO_OUTCOME_MTX")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CDIO_OUTCOME_MTX_IDMTXOUTCOMECDIO_GENERATOR")
	@Column(name="ID_MTX_OUTCOME_CDIO", unique=true, nullable=false)
	private long idMtxOutcomeCdio;

	private BigDecimal correlation;

	@Column(name="\"VERSION\"", nullable=false, length=10)
	private String version;

	//bi-directional many-to-one association to CdioSkill
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CDIO_SKILL", nullable=false)
	private CdioSkill cdioSkill;

	//bi-directional many-to-one association to Outcome
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ST_OUTCOME", nullable=false)
	private Outcome outcome;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="\"PROGRAM\"", nullable=false)
	private ProgramSmc programSmc;

	public CdioOutcomeMtx() {
	}

	public long getIdMtxOutcomeCdio() {
		return this.idMtxOutcomeCdio;
	}

	public void setIdMtxOutcomeCdio(long idMtxOutcomeCdio) {
		this.idMtxOutcomeCdio = idMtxOutcomeCdio;
	}

	public BigDecimal getCorrelation() {
		return this.correlation;
	}

	public void setCorrelation(BigDecimal correlation) {
		this.correlation = correlation;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public CdioSkill getCdioSkill() {
		return this.cdioSkill;
	}

	public void setCdioSkill(CdioSkill cdioSkill) {
		this.cdioSkill = cdioSkill;
	}

	public Outcome getOutcome() {
		return this.outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

}