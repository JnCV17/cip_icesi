package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PLAN_SMC database table.
 * 
 */
@Entity
@Table(name = "PLAN_SMC")
@NamedQuery(name = "PlanSmc.findAll", query = "SELECT p FROM PlanSmc p")
public class PlanSmc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PLAN_SMC_IDPLAN_GENERATOR", allocationSize = 1, sequenceName = "SEQ_PLAN_SMC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAN_SMC_IDPLAN_GENERATOR")
	@Column(name = "ID_PLAN", unique = true, nullable = false)
	private long idPlan;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "EVALUATION_DATE")
	private Date evaluationDate;

	@Column(name = "EVALUATION_FREQUENCY", length = 20)
	private String evaluationFrequency;

	@Column(name = "PERIOD_ID_PERIOD", nullable = false)
	private BigDecimal periodIdPeriod;

	// bi-directional many-to-one association to Alert
	@OneToMany(mappedBy = "planSmc", fetch = FetchType.EAGER)
	private List<Alert> alerts;

	// bi-directional many-to-one association to ComplSrc
	@OneToMany(mappedBy = "planSmc", fetch = FetchType.EAGER)
	private List<ComplSrc> complSrcs;

	// bi-directional many-to-one association to EvalCycle
	@OneToMany(mappedBy = "planSmc", fetch = FetchType.EAGER)
	private List<EvalCycle> evalCycles;

	// bi-directional many-to-one association to PiSmc
	@OneToMany(mappedBy = "planSmc", fetch = FetchType.EAGER)
	private List<PiSmc> piSmcs;

	// bi-directional many-to-one association to OutcomeCycleA
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_OUTCOME_CYCLE_AS", nullable = false)
	private OutcomeCycleA outcomeCycleA;

	// bi-directional many-to-one association to RubricFile
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_RUBRIC_FILE")
	private RubricFile rubricFile;

	// bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE_ID_STATE", nullable = false)
	private StateSmc stateSmc;

	// bi-directional many-to-one association to UserCip
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_CIP_ID_USER", nullable = false)
	private UserCip userCip;

	public PlanSmc() {
	}

	public long getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(long idPlan) {
		this.idPlan = idPlan;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEvaluationDate() {
		return this.evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public String getEvaluationFrequency() {
		return this.evaluationFrequency;
	}

	public void setEvaluationFrequency(String evaluationFrequency) {
		this.evaluationFrequency = evaluationFrequency;
	}

	public BigDecimal getPeriodIdPeriod() {
		return this.periodIdPeriod;
	}

	public void setPeriodIdPeriod(BigDecimal periodIdPeriod) {
		this.periodIdPeriod = periodIdPeriod;
	}

	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Alert addAlert(Alert alert) {
		getAlerts().add(alert);
		alert.setPlanSmc(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setPlanSmc(null);

		return alert;
	}

	public List<ComplSrc> getComplSrcs() {
		return this.complSrcs;
	}

	public void setComplSrcs(List<ComplSrc> complSrcs) {
		this.complSrcs = complSrcs;
	}

	public ComplSrc addComplSrc(ComplSrc complSrc) {
		getComplSrcs().add(complSrc);
		complSrc.setPlanSmc(this);

		return complSrc;
	}

	public ComplSrc removeComplSrc(ComplSrc complSrc) {
		getComplSrcs().remove(complSrc);
		complSrc.setPlanSmc(null);

		return complSrc;
	}

	public List<EvalCycle> getEvalCycles() {
		return this.evalCycles;
	}

	public void setEvalCycles(List<EvalCycle> evalCycles) {
		this.evalCycles = evalCycles;
	}

	public EvalCycle addEvalCycle(EvalCycle evalCycle) {
		getEvalCycles().add(evalCycle);
		evalCycle.setPlanSmc(this);

		return evalCycle;
	}

	public EvalCycle removeEvalCycle(EvalCycle evalCycle) {
		getEvalCycles().remove(evalCycle);
		evalCycle.setPlanSmc(null);

		return evalCycle;
	}

	public List<PiSmc> getPiSmcs() {
		return this.piSmcs;
	}

	public void setPiSmcs(List<PiSmc> piSmcs) {
		this.piSmcs = piSmcs;
	}

	public PiSmc addPiSmc(PiSmc piSmc) {
		getPiSmcs().add(piSmc);
		piSmc.setPlanSmc(this);

		return piSmc;
	}

	public PiSmc removePiSmc(PiSmc piSmc) {
		getPiSmcs().remove(piSmc);
		piSmc.setPlanSmc(null);

		return piSmc;
	}

	public OutcomeCycleA getOutcomeCycleA() {
		return this.outcomeCycleA;
	}

	public void setOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		this.outcomeCycleA = outcomeCycleA;
	}

	public RubricFile getRubricFile() {
		return this.rubricFile;
	}

	public void setRubricFile(RubricFile rubricFile) {
		this.rubricFile = rubricFile;
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

}