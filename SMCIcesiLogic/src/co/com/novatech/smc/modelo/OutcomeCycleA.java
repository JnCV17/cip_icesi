package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OUTCOME_CYCLE_AS database table.
 * 
 */
@Entity
@Table(name="OUTCOME_CYCLE_AS")
@NamedQuery(name="OutcomeCycleA.findAll", query="SELECT o FROM OutcomeCycleA o")
public class OutcomeCycleA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTCOME_CYCLE_AS_IDOUTCOCYCLE_GENERATOR", allocationSize = 1, sequenceName="SEQ_OUTCOME_CYCLE_AS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTCOME_CYCLE_AS_IDOUTCOCYCLE_GENERATOR")
	@Column(name="ID_OUTCO_CYCLE", unique=true, nullable=false)
	private long idOutcoCycle;

	//bi-directional many-to-one association to MainCycle
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MAIN_CYCLE_ID_CYCLE", nullable=false)
	private MainCycle mainCycle;

	//bi-directional many-to-one association to Outcome
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OUTCOME_ID_ST_OUTCOME", nullable=false)
	private Outcome outcome;

	//bi-directional many-to-one association to PlanSmc
	@OneToMany(mappedBy="outcomeCycleA")
	private List<PlanSmc> planSmcs;

	public OutcomeCycleA() {
	}

	public long getIdOutcoCycle() {
		return this.idOutcoCycle;
	}

	public void setIdOutcoCycle(long idOutcoCycle) {
		this.idOutcoCycle = idOutcoCycle;
	}

	public MainCycle getMainCycle() {
		return this.mainCycle;
	}

	public void setMainCycle(MainCycle mainCycle) {
		this.mainCycle = mainCycle;
	}

	public Outcome getOutcome() {
		return this.outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public List<PlanSmc> getPlanSmcs() {
		return this.planSmcs;
	}

	public void setPlanSmcs(List<PlanSmc> planSmcs) {
		this.planSmcs = planSmcs;
	}

	public PlanSmc addPlanSmc(PlanSmc planSmc) {
		getPlanSmcs().add(planSmc);
		planSmc.setOutcomeCycleA(this);

		return planSmc;
	}

	public PlanSmc removePlanSmc(PlanSmc planSmc) {
		getPlanSmcs().remove(planSmc);
		planSmc.setOutcomeCycleA(null);

		return planSmc;
	}

}