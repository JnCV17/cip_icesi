package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERIOD database table.
 * 
 */
@Entity
@Table(name="PERIOD")
@NamedQuery(name="Period.findAll", query="SELECT p FROM Period p")
public class Period implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERIOD_IDPERIOD_GENERATOR", allocationSize = 1, sequenceName="SEQ_PERIOD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERIOD_IDPERIOD_GENERATOR")
	@Column(name="ID_PERIOD", unique=true, nullable=false)
	private long idPeriod;

	@Column(name="NAME_PERIOD", nullable=false, length=30)
	private String namePeriod;

	//bi-directional many-to-one association to Peo
	@OneToMany(mappedBy="period")
	private List<Peo> peos;

	public Period() {
	}

	public long getIdPeriod() {
		return this.idPeriod;
	}

	public void setIdPeriod(long idPeriod) {
		this.idPeriod = idPeriod;
	}

	public String getNamePeriod() {
		return this.namePeriod;
	}

	public void setNamePeriod(String namePeriod) {
		this.namePeriod = namePeriod;
	}

	public List<Peo> getPeos() {
		return this.peos;
	}

	public void setPeos(List<Peo> peos) {
		this.peos = peos;
	}

	public Peo addPeo(Peo peo) {
		getPeos().add(peo);
		peo.setPeriod(this);

		return peo;
	}

	public Peo removePeo(Peo peo) {
		getPeos().remove(peo);
		peo.setPeriod(null);

		return peo;
	}

}