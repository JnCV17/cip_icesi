package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EVAL_REPORT database table.
 * 
 */
@Entity
@Table(name = "EVAL_REPORT")
@NamedQuery(name = "EvalReport.findAll", query = "SELECT e FROM EvalReport e")
public class EvalReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EVAL_REPORT_IDEVALREPORT_GENERATOR", allocationSize = 1, sequenceName = "SEQ_EVAL_REPORT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVAL_REPORT_IDEVALREPORT_GENERATOR")
	@Column(name = "ID_EVAL_REPORT", unique = true, nullable = false)
	private long idEvalReport;

	private BigDecimal period;

	@Column(name = "PERIOD_ID_PERIOD", nullable = false)
	private BigDecimal periodIdPeriod;

	// bi-directional many-to-one association to UserCip
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ASSIGNED_TO")
	private UserCip userCip1;

	// bi-directional many-to-one association to EvalCycle
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EVAL_CYCLE", nullable = false)
	private EvalCycle evalCycle;

	// bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATE_ID_STATE", nullable = false)
	private StateSmc stateSmc;

	// bi-directional many-to-one association to RubricFile
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATISTIC")
	private RubricFile rubricFile;

	// bi-directional many-to-one association to UserCip
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_CIP_ID_USER", nullable = false)
	private UserCip userCip2;

	public EvalReport() {
	}

	public long getIdEvalReport() {
		return this.idEvalReport;
	}

	public void setIdEvalReport(long idEvalReport) {
		this.idEvalReport = idEvalReport;
	}

	public BigDecimal getPeriod() {
		return this.period;
	}

	public void setPeriod(BigDecimal period) {
		this.period = period;
	}

	public BigDecimal getPeriodIdPeriod() {
		return this.periodIdPeriod;
	}

	public void setPeriodIdPeriod(BigDecimal periodIdPeriod) {
		this.periodIdPeriod = periodIdPeriod;
	}

	public UserCip getUserCip1() {
		return this.userCip1;
	}

	public void setUserCip1(UserCip userCip1) {
		this.userCip1 = userCip1;
	}

	public EvalCycle getEvalCycle() {
		return this.evalCycle;
	}

	public void setEvalCycle(EvalCycle evalCycle) {
		this.evalCycle = evalCycle;
	}

	public StateSmc getStateSmc() {
		return this.stateSmc;
	}

	public void setStateSmc(StateSmc stateSmc) {
		this.stateSmc = stateSmc;
	}

	public RubricFile getRubricFile() {
		return this.rubricFile;
	}

	public void setRubricFile(RubricFile rubricFile) {
		this.rubricFile = rubricFile;
	}

	public UserCip getUserCip2() {
		return this.userCip2;
	}

	public void setUserCip2(UserCip userCip2) {
		this.userCip2 = userCip2;
	}

}