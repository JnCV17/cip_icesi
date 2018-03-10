package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PEO database table.
 * 
 */
@Entity
@Table(name="PEO")
@NamedQuery(name="Peo.findAll", query="SELECT p FROM Peo p")
public class Peo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PEO_IDPEO_GENERATOR", allocationSize = 1, sequenceName="SEQ_PEO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEO_IDPEO_GENERATOR")
	@Column(name="ID_PEO", unique=true, nullable=false)
	private long idPeo;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false)
	private BigDecimal term;

	//bi-directional many-to-one association to OutcomePeoMtx
	@OneToMany(mappedBy="peo")
	private List<OutcomePeoMtx> outcomePeoMtxs;

	//bi-directional many-to-one association to Period
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="APPLICATION_DATE", nullable=false)
	private Period period;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROGRAM_ID_PROGRAM", nullable=false)
	private ProgramSmc programSmc;

	public Peo() {
	}

	public long getIdPeo() {
		return this.idPeo;
	}

	public void setIdPeo(long idPeo) {
		this.idPeo = idPeo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTerm() {
		return this.term;
	}

	public void setTerm(BigDecimal term) {
		this.term = term;
	}

	public List<OutcomePeoMtx> getOutcomePeoMtxs() {
		return this.outcomePeoMtxs;
	}

	public void setOutcomePeoMtxs(List<OutcomePeoMtx> outcomePeoMtxs) {
		this.outcomePeoMtxs = outcomePeoMtxs;
	}

	public OutcomePeoMtx addOutcomePeoMtx(OutcomePeoMtx outcomePeoMtx) {
		getOutcomePeoMtxs().add(outcomePeoMtx);
		outcomePeoMtx.setPeo(this);

		return outcomePeoMtx;
	}

	public OutcomePeoMtx removeOutcomePeoMtx(OutcomePeoMtx outcomePeoMtx) {
		getOutcomePeoMtxs().remove(outcomePeoMtx);
		outcomePeoMtx.setPeo(null);

		return outcomePeoMtx;
	}

	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

}