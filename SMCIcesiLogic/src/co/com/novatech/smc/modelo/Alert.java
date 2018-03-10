package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ALERT database table.
 * 
 */
@Entity
@Table(name="ALERT")
@NamedQuery(name="Alert.findAll", query="SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALERT_IDALERT_GENERATOR", allocationSize = 1, sequenceName="SEQ_ALERT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERT_IDALERT_GENERATOR")
	@Column(name="ID_ALERT", unique=true, nullable=false)
	private long idAlert;

	@Column(name="ALERT_NAME", nullable=false, length=100)
	private String alertName;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ALERT", nullable=false)
	private Date dateAlert;

	//bi-directional many-to-one association to PlanSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PLAN", nullable=false)
	private PlanSmc planSmc;

	//bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_ID_STATE", nullable=false)
	private StateSmc stateSmc;

	public Alert() {
	}

	public long getIdAlert() {
		return this.idAlert;
	}

	public void setIdAlert(long idAlert) {
		this.idAlert = idAlert;
	}

	public String getAlertName() {
		return this.alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	public Date getDateAlert() {
		return this.dateAlert;
	}

	public void setDateAlert(Date dateAlert) {
		this.dateAlert = dateAlert;
	}

	public PlanSmc getPlanSmc() {
		return this.planSmc;
	}

	public void setPlanSmc(PlanSmc planSmc) {
		this.planSmc = planSmc;
	}

	public StateSmc getStateSmc() {
		return this.stateSmc;
	}

	public void setStateSmc(StateSmc stateSmc) {
		this.stateSmc = stateSmc;
	}

}