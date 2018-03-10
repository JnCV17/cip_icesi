package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ASSESSMENT_PLAN_LOG database table.
 * 
 */
@Entity
@Table(name="ASSESSMENT_PLAN_LOG")
@NamedQuery(name="AssessmentPlanLog.findAll", query="SELECT a FROM AssessmentPlanLog a")
public class AssessmentPlanLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSESSMENT_PLAN_LOG_IDASSESSMENTPLANLOG_GENERATOR", allocationSize = 1, sequenceName="SEQ_ASSESSMENT_PLAN_LOG")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSESSMENT_PLAN_LOG_IDASSESSMENTPLANLOG_GENERATOR")
	@Column(name="ID_ASSESSMENT_PLAN_LOG", unique=true, nullable=false)
	private long idAssessmentPlanLog;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTION_DATE", nullable=false)
	private Date actionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE", nullable=false)
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="EVALUATION_DATE")
	private Date evaluationDate;

	@Column(name="EVALUATION_FREQUENCY", length=20)
	private String evaluationFrequency;

	@Column(name="ID_CYCLE", nullable=false)
	private BigDecimal idCycle;

	@Column(name="ID_PERIOD", nullable=false)
	private BigDecimal idPeriod;

	@Column(name="ID_STATE", nullable=false)
	private BigDecimal idState;

	@Column(name="ID_STUDENT_OUTCOME", nullable=false)
	private BigDecimal idStudentOutcome;

	@Column(name="ID_USER", nullable=false)
	private BigDecimal idUser;

	@Column(name="LAST_ID_STATE")
	private BigDecimal lastIdState;

	@Column(name="LOG_ACTION", nullable=false, length=300)
	private String logAction;

	public AssessmentPlanLog() {
	}

	public long getIdAssessmentPlanLog() {
		return this.idAssessmentPlanLog;
	}

	public void setIdAssessmentPlanLog(long idAssessmentPlanLog) {
		this.idAssessmentPlanLog = idAssessmentPlanLog;
	}

	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
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

	public BigDecimal getIdCycle() {
		return this.idCycle;
	}

	public void setIdCycle(BigDecimal idCycle) {
		this.idCycle = idCycle;
	}

	public BigDecimal getIdPeriod() {
		return this.idPeriod;
	}

	public void setIdPeriod(BigDecimal idPeriod) {
		this.idPeriod = idPeriod;
	}

	public BigDecimal getIdState() {
		return this.idState;
	}

	public void setIdState(BigDecimal idState) {
		this.idState = idState;
	}

	public BigDecimal getIdStudentOutcome() {
		return this.idStudentOutcome;
	}

	public void setIdStudentOutcome(BigDecimal idStudentOutcome) {
		this.idStudentOutcome = idStudentOutcome;
	}

	public BigDecimal getIdUser() {
		return this.idUser;
	}

	public void setIdUser(BigDecimal idUser) {
		this.idUser = idUser;
	}

	public BigDecimal getLastIdState() {
		return this.lastIdState;
	}

	public void setLastIdState(BigDecimal lastIdState) {
		this.lastIdState = lastIdState;
	}

	public String getLogAction() {
		return this.logAction;
	}

	public void setLogAction(String logAction) {
		this.logAction = logAction;
	}

}