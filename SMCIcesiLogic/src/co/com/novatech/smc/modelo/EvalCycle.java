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
 * The persistent class for the EVAL_CYCLE database table.
 * 
 */
@Entity
@Table(name = "EVAL_CYCLE")
@NamedQuery(name = "EvalCycle.findAll", query = "SELECT e FROM EvalCycle e")
public class EvalCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EVAL_CYCLE_IDEVALCYCLE_GENERATOR", allocationSize = 1, sequenceName = "SEQ_EVAL_CYCLE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVAL_CYCLE_IDEVALCYCLE_GENERATOR")
	@Column(name = "ID_EVAL_CYCLE", unique = true, nullable = false, precision = 3)
	private long idEvalCycle;

	// bi-directional many-to-one association to MainCycle
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MAIN_CYCLE_ID_CYCLE", nullable = false)
	private MainCycle mainCycle;

	// bi-directional many-to-one association to PlanSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAN_ID_PLAN", nullable = false)
	private PlanSmc planSmc;

	// bi-directional many-to-one association to EvalReport
	@OneToMany(mappedBy = "evalCycle", fetch = FetchType.EAGER)
	private List<EvalReport> evalReports;

	public EvalCycle() {
	}

	public long getIdEvalCycle() {
		return this.idEvalCycle;
	}

	public void setIdEvalCycle(long idEvalCycle) {
		this.idEvalCycle = idEvalCycle;
	}

	public MainCycle getMainCycle() {
		return this.mainCycle;
	}

	public void setMainCycle(MainCycle mainCycle) {
		this.mainCycle = mainCycle;
	}

	public PlanSmc getPlanSmc() {
		return this.planSmc;
	}

	public void setPlanSmc(PlanSmc planSmc) {
		this.planSmc = planSmc;
	}

	public List<EvalReport> getEvalReports() {
		return this.evalReports;
	}

	public void setEvalReports(List<EvalReport> evalReports) {
		this.evalReports = evalReports;
	}

	public EvalReport addEvalReport(EvalReport evalReport) {
		getEvalReports().add(evalReport);
		evalReport.setEvalCycle(this);

		return evalReport;
	}

	public EvalReport removeEvalReport(EvalReport evalReport) {
		getEvalReports().remove(evalReport);
		evalReport.setEvalCycle(null);

		return evalReport;
	}

}