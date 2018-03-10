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
 * The persistent class for the OUTCOME database table.
 * 
 */
@Entity
@Table(name = "OUTCOME")
@NamedQuery(name = "Outcome.findAll", query = "SELECT o FROM Outcome o ORDER BY o.criterion")
public class Outcome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OUTCOME_IDSTOUTCOME_GENERATOR", allocationSize = 1, sequenceName = "SEQ_OUTCOME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OUTCOME_IDSTOUTCOME_GENERATOR")
	@Column(name = "ID_ST_OUTCOME", unique = true, nullable = false)
	private long idStOutcome;

	@Column(nullable = false, length = 1)
	private String criterion;

	@Column(nullable = false, length = 2000)
	private String description;

	@Column(name = "SHORT_DESCRIPTION", nullable = false, length = 50)
	private String shortDescription;

	// bi-directional many-to-one association to CdioOutcomeMtx
	@OneToMany(mappedBy = "outcome", fetch = FetchType.EAGER)
	private List<CdioOutcomeMtx> cdioOutcomeMtxs;

	// bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROGRAM_ID_PROGRAM", nullable = false)
	private ProgramSmc programSmc;

	// bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE_ID_STATE", nullable = false)
	private StateSmc stateSmc;

	// bi-directional many-to-one association to UserCip
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_CIP_ID_USER")
	private UserCip userCip;

	// bi-directional many-to-one association to OutcomeCycleA
	@OneToMany(mappedBy = "outcome")
	private List<OutcomeCycleA> outcomeCycleAs;

	// bi-directional many-to-one association to OutcomePeoMtx
	@OneToMany(mappedBy = "outcome", fetch = FetchType.EAGER)
	private List<OutcomePeoMtx> outcomePeoMtxs;

	public Outcome() {
	}

	public long getIdStOutcome() {
		return this.idStOutcome;
	}

	public void setIdStOutcome(long idStOutcome) {
		this.idStOutcome = idStOutcome;
	}

	public String getCriterion() {
		return this.criterion;
	}

	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public List<CdioOutcomeMtx> getCdioOutcomeMtxs() {
		return this.cdioOutcomeMtxs;
	}

	public void setCdioOutcomeMtxs(List<CdioOutcomeMtx> cdioOutcomeMtxs) {
		this.cdioOutcomeMtxs = cdioOutcomeMtxs;
	}

	public CdioOutcomeMtx addCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		getCdioOutcomeMtxs().add(cdioOutcomeMtx);
		cdioOutcomeMtx.setOutcome(this);

		return cdioOutcomeMtx;
	}

	public CdioOutcomeMtx removeCdioOutcomeMtx(CdioOutcomeMtx cdioOutcomeMtx) {
		getCdioOutcomeMtxs().remove(cdioOutcomeMtx);
		cdioOutcomeMtx.setOutcome(null);

		return cdioOutcomeMtx;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

	public StateSmc getStateSmc() {
		return this.stateSmc;
	}

	public void setStateSmc(StateSmc stateSmc) {
		this.stateSmc = stateSmc;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

	public List<OutcomeCycleA> getOutcomeCycleAs() {
		return this.outcomeCycleAs;
	}

	public void setOutcomeCycleAs(List<OutcomeCycleA> outcomeCycleAs) {
		this.outcomeCycleAs = outcomeCycleAs;
	}

	public OutcomeCycleA addOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		getOutcomeCycleAs().add(outcomeCycleA);
		outcomeCycleA.setOutcome(this);

		return outcomeCycleA;
	}

	public OutcomeCycleA removeOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		getOutcomeCycleAs().remove(outcomeCycleA);
		outcomeCycleA.setOutcome(null);

		return outcomeCycleA;
	}

	public List<OutcomePeoMtx> getOutcomePeoMtxs() {
		return this.outcomePeoMtxs;
	}

	public void setOutcomePeoMtxs(List<OutcomePeoMtx> outcomePeoMtxs) {
		this.outcomePeoMtxs = outcomePeoMtxs;
	}

	public OutcomePeoMtx addOutcomePeoMtx(OutcomePeoMtx outcomePeoMtx) {
		getOutcomePeoMtxs().add(outcomePeoMtx);
		outcomePeoMtx.setOutcome(this);

		return outcomePeoMtx;
	}

	public OutcomePeoMtx removeOutcomePeoMtx(OutcomePeoMtx outcomePeoMtx) {
		getOutcomePeoMtxs().remove(outcomePeoMtx);
		outcomePeoMtx.setOutcome(null);

		return outcomePeoMtx;
	}

}