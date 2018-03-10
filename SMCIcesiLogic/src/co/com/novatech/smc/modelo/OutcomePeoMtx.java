package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OUTCOME_PEO_MTX database table.
 * 
 */
@Entity
@Table(name="OUTCOME_PEO_MTX")
@NamedQuery(name="OutcomePeoMtx.findAll", query="SELECT o FROM OutcomePeoMtx o")
public class OutcomePeoMtx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTCOME_PEO_MTX_OUTCOMEPEO_GENERATOR", allocationSize = 1, sequenceName="SEQ_OUTCOME_PEO_MTX")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTCOME_PEO_MTX_OUTCOMEPEO_GENERATOR")
	@Column(name="OUTCOME_PEO", unique=true, nullable=false)
	private long outcomePeo;

	//bi-directional many-to-one association to Outcome
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OUTCOME_ID_ST_OUTCOME", nullable=false)
	private Outcome outcome;

	//bi-directional many-to-one association to Peo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PEO_ID_PEO", nullable=false)
	private Peo peo;

	public OutcomePeoMtx() {
	}

	public long getOutcomePeo() {
		return this.outcomePeo;
	}

	public void setOutcomePeo(long outcomePeo) {
		this.outcomePeo = outcomePeo;
	}

	public Outcome getOutcome() {
		return this.outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public Peo getPeo() {
		return this.peo;
	}

	public void setPeo(Peo peo) {
		this.peo = peo;
	}

}