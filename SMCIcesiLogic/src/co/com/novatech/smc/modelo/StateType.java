package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATE_TYPE database table.
 * 
 */
@Entity
@Table(name="STATE_TYPE")
@NamedQuery(name="StateType.findAll", query="SELECT s FROM StateType s")
public class StateType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATE_TYPE_IDSTATETYPE_GENERATOR", allocationSize = 1, sequenceName="SEQ_STATE_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATE_TYPE_IDSTATETYPE_GENERATOR")
	@Column(name="ID_STATE_TYPE", unique=true, nullable=false)
	private long idStateType;

	@Column(name="STATE_TYPE_NAME", nullable=false, length=60)
	private String stateTypeName;

	//bi-directional many-to-one association to StateSmc
	@OneToMany(mappedBy="stateType")
	private List<StateSmc> stateSmcs;

	public StateType() {
	}

	public long getIdStateType() {
		return this.idStateType;
	}

	public void setIdStateType(long idStateType) {
		this.idStateType = idStateType;
	}

	public String getStateTypeName() {
		return this.stateTypeName;
	}

	public void setStateTypeName(String stateTypeName) {
		this.stateTypeName = stateTypeName;
	}

	public List<StateSmc> getStateSmcs() {
		return this.stateSmcs;
	}

	public void setStateSmcs(List<StateSmc> stateSmcs) {
		this.stateSmcs = stateSmcs;
	}

	public StateSmc addStateSmc(StateSmc stateSmc) {
		getStateSmcs().add(stateSmc);
		stateSmc.setStateType(this);

		return stateSmc;
	}

	public StateSmc removeStateSmc(StateSmc stateSmc) {
		getStateSmcs().remove(stateSmc);
		stateSmc.setStateType(null);

		return stateSmc;
	}

}