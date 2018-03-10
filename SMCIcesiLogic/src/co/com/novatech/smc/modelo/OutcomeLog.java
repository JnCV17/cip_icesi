package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OUTCOME_LOG database table.
 * 
 */
@Entity
@Table(name="OUTCOME_LOG")
@NamedQuery(name="OutcomeLog.findAll", query="SELECT o FROM OutcomeLog o")
public class OutcomeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTCOME_LOG_IDOUTCOMELOG_GENERATOR", allocationSize = 1, sequenceName="SEQ_OUTCOME_LOG")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTCOME_LOG_IDOUTCOMELOG_GENERATOR")
	@Column(name="ID_OUTCOME_LOG", unique=true, nullable=false)
	private long idOutcomeLog;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTION_DATE", nullable=false)
	private Date actionDate;

	@Column(nullable=false, length=1)
	private String criterion;

	@Column(nullable=false, length=2000)
	private String description;

	@Column(name="ID_PROGRAM", nullable=false)
	private BigDecimal idProgram;

	@Column(name="ID_STATE", nullable=false)
	private BigDecimal idState;

	@Column(name="ID_USER")
	private BigDecimal idUser;

	@Column(name="LAST_ID_USER")
	private BigDecimal lastIdUser;

	@Column(name="LOG_ACTION", nullable=false, length=10)
	private String logAction;

	@Column(name="SHORT_DESCRIPTION", nullable=false, length=20)
	private String shortDescription;

	public OutcomeLog() {
	}

	public long getIdOutcomeLog() {
		return this.idOutcomeLog;
	}

	public void setIdOutcomeLog(long idOutcomeLog) {
		this.idOutcomeLog = idOutcomeLog;
	}

	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
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

	public BigDecimal getIdProgram() {
		return this.idProgram;
	}

	public void setIdProgram(BigDecimal idProgram) {
		this.idProgram = idProgram;
	}

	public BigDecimal getIdState() {
		return this.idState;
	}

	public void setIdState(BigDecimal idState) {
		this.idState = idState;
	}

	public BigDecimal getIdUser() {
		return this.idUser;
	}

	public void setIdUser(BigDecimal idUser) {
		this.idUser = idUser;
	}

	public BigDecimal getLastIdUser() {
		return this.lastIdUser;
	}

	public void setLastIdUser(BigDecimal lastIdUser) {
		this.lastIdUser = lastIdUser;
	}

	public String getLogAction() {
		return this.logAction;
	}

	public void setLogAction(String logAction) {
		this.logAction = logAction;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}