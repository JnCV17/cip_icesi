package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATE_SMC database table.
 * 
 */
@Entity
@Table(name="STATE_SMC")
@NamedQuery(name="StateSmc.findAll", query="SELECT s FROM StateSmc s")
public class StateSmc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATE_SMC_IDSTATE_GENERATOR", allocationSize = 1, sequenceName="SEQ_STATE_SMC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATE_SMC_IDSTATE_GENERATOR")
	@Column(name="ID_STATE", unique=true, nullable=false)
	private long idState;

	@Column(name="STATE_NAME", nullable=false, length=60)
	private String stateName;

	//bi-directional many-to-one association to Alert
	@OneToMany(mappedBy="stateSmc")
	private List<Alert> alerts;

	//bi-directional many-to-one association to EvalReport
	@OneToMany(mappedBy="stateSmc")
	private List<EvalReport> evalReports;

	//bi-directional many-to-one association to Outcome
	@OneToMany(mappedBy="stateSmc")
	private List<Outcome> outcomes;

	//bi-directional many-to-one association to PlanSmc
	@OneToMany(mappedBy="stateSmc")
	private List<PlanSmc> planSmcs;

	//bi-directional many-to-one association to RoleCip
	@OneToMany(mappedBy="stateSmc")
	private List<RoleCip> roleCips;

	//bi-directional many-to-one association to StateType
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_TYPE_ID_STATE_TYPE", nullable=false)
	private StateType stateType;

	//bi-directional many-to-one association to UserCip
	@OneToMany(mappedBy="stateSmc")
	private List<UserCip> userCips;

	public StateSmc() {
	}

	public long getIdState() {
		return this.idState;
	}

	public void setIdState(long idState) {
		this.idState = idState;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Alert addAlert(Alert alert) {
		getAlerts().add(alert);
		alert.setStateSmc(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setStateSmc(null);

		return alert;
	}

	public List<EvalReport> getEvalReports() {
		return this.evalReports;
	}

	public void setEvalReports(List<EvalReport> evalReports) {
		this.evalReports = evalReports;
	}

	public EvalReport addEvalReport(EvalReport evalReport) {
		getEvalReports().add(evalReport);
		evalReport.setStateSmc(this);

		return evalReport;
	}

	public EvalReport removeEvalReport(EvalReport evalReport) {
		getEvalReports().remove(evalReport);
		evalReport.setStateSmc(null);

		return evalReport;
	}

	public List<Outcome> getOutcomes() {
		return this.outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public Outcome addOutcome(Outcome outcome) {
		getOutcomes().add(outcome);
		outcome.setStateSmc(this);

		return outcome;
	}

	public Outcome removeOutcome(Outcome outcome) {
		getOutcomes().remove(outcome);
		outcome.setStateSmc(null);

		return outcome;
	}

	public List<PlanSmc> getPlanSmcs() {
		return this.planSmcs;
	}

	public void setPlanSmcs(List<PlanSmc> planSmcs) {
		this.planSmcs = planSmcs;
	}

	public PlanSmc addPlanSmc(PlanSmc planSmc) {
		getPlanSmcs().add(planSmc);
		planSmc.setStateSmc(this);

		return planSmc;
	}

	public PlanSmc removePlanSmc(PlanSmc planSmc) {
		getPlanSmcs().remove(planSmc);
		planSmc.setStateSmc(null);

		return planSmc;
	}

	public List<RoleCip> getRoleCips() {
		return this.roleCips;
	}

	public void setRoleCips(List<RoleCip> roleCips) {
		this.roleCips = roleCips;
	}

	public RoleCip addRoleCip(RoleCip roleCip) {
		getRoleCips().add(roleCip);
		roleCip.setStateSmc(this);

		return roleCip;
	}

	public RoleCip removeRoleCip(RoleCip roleCip) {
		getRoleCips().remove(roleCip);
		roleCip.setStateSmc(null);

		return roleCip;
	}

	public StateType getStateType() {
		return this.stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}

	public List<UserCip> getUserCips() {
		return this.userCips;
	}

	public void setUserCips(List<UserCip> userCips) {
		this.userCips = userCips;
	}

	public UserCip addUserCip(UserCip userCip) {
		getUserCips().add(userCip);
		userCip.setStateSmc(this);

		return userCip;
	}

	public UserCip removeUserCip(UserCip userCip) {
		getUserCips().remove(userCip);
		userCip.setStateSmc(null);

		return userCip;
	}

}