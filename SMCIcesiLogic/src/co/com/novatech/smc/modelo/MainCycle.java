package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MAIN_CYCLE database table.
 * 
 */
@Entity
@Table(name="MAIN_CYCLE")
@NamedQuery(name="MainCycle.findAll", query="SELECT m FROM MainCycle m")
public class MainCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAIN_CYCLE_IDCYCLE_GENERATOR", allocationSize = 1, sequenceName="SEQ_MAIN_CYCLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAIN_CYCLE_IDCYCLE_GENERATOR")
	@Column(name="ID_CYCLE", unique=true, nullable=false)
	private long idCycle;

	@Column(name="CYCLE_NAME", nullable=false, length=50)
	private String cycleName;

	@Column(nullable=false, precision=3)
	private BigDecimal duration;

	@Column(name="FINAL_DATE_CYCLE", nullable=false, length=15)
	private String finalDateCycle;

	@Column(name="INITIAL_DATE_CYCLE", nullable=false, length=15)
	private String initialDateCycle;

	//bi-directional many-to-one association to EvalCycle
	@OneToMany(mappedBy="mainCycle")
	private List<EvalCycle> evalCycles;

	//bi-directional many-to-one association to MainCycle
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MAIN_CYCLE_ID_CYCLE")
	private MainCycle mainCycle;

	//bi-directional many-to-one association to MainCycle
	@OneToMany(mappedBy="mainCycle")
	private List<MainCycle> mainCycles;

	//bi-directional many-to-one association to ProgramSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROGRAM_ID_PROGRAM", nullable=false)
	private ProgramSmc programSmc;

	//bi-directional many-to-one association to OutcomeCycleA
	@OneToMany(mappedBy="mainCycle")
	private List<OutcomeCycleA> outcomeCycleAs;

	public MainCycle() {
	}

	public long getIdCycle() {
		return this.idCycle;
	}

	public void setIdCycle(long idCycle) {
		this.idCycle = idCycle;
	}

	public String getCycleName() {
		return this.cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	public BigDecimal getDuration() {
		return this.duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public String getFinalDateCycle() {
		return this.finalDateCycle;
	}

	public void setFinalDateCycle(String finalDateCycle) {
		this.finalDateCycle = finalDateCycle;
	}

	public String getInitialDateCycle() {
		return this.initialDateCycle;
	}

	public void setInitialDateCycle(String initialDateCycle) {
		this.initialDateCycle = initialDateCycle;
	}

	public List<EvalCycle> getEvalCycles() {
		return this.evalCycles;
	}

	public void setEvalCycles(List<EvalCycle> evalCycles) {
		this.evalCycles = evalCycles;
	}

	public EvalCycle addEvalCycle(EvalCycle evalCycle) {
		getEvalCycles().add(evalCycle);
		evalCycle.setMainCycle(this);

		return evalCycle;
	}

	public EvalCycle removeEvalCycle(EvalCycle evalCycle) {
		getEvalCycles().remove(evalCycle);
		evalCycle.setMainCycle(null);

		return evalCycle;
	}

	public MainCycle getMainCycle() {
		return this.mainCycle;
	}

	public void setMainCycle(MainCycle mainCycle) {
		this.mainCycle = mainCycle;
	}

	public List<MainCycle> getMainCycles() {
		return this.mainCycles;
	}

	public void setMainCycles(List<MainCycle> mainCycles) {
		this.mainCycles = mainCycles;
	}

	public MainCycle addMainCycle(MainCycle mainCycle) {
		getMainCycles().add(mainCycle);
		mainCycle.setMainCycle(this);

		return mainCycle;
	}

	public MainCycle removeMainCycle(MainCycle mainCycle) {
		getMainCycles().remove(mainCycle);
		mainCycle.setMainCycle(null);

		return mainCycle;
	}

	public ProgramSmc getProgramSmc() {
		return this.programSmc;
	}

	public void setProgramSmc(ProgramSmc programSmc) {
		this.programSmc = programSmc;
	}

	public List<OutcomeCycleA> getOutcomeCycleAs() {
		return this.outcomeCycleAs;
	}

	public void setOutcomeCycleAs(List<OutcomeCycleA> outcomeCycleAs) {
		this.outcomeCycleAs = outcomeCycleAs;
	}

	public OutcomeCycleA addOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		getOutcomeCycleAs().add(outcomeCycleA);
		outcomeCycleA.setMainCycle(this);

		return outcomeCycleA;
	}

	public OutcomeCycleA removeOutcomeCycleA(OutcomeCycleA outcomeCycleA) {
		getOutcomeCycleAs().remove(outcomeCycleA);
		outcomeCycleA.setMainCycle(null);

		return outcomeCycleA;
	}

}