package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RUBRIC_FILE database table.
 * 
 */
@Entity
@Table(name="RUBRIC_FILE")
@NamedQuery(name="RubricFile.findAll", query="SELECT r FROM RubricFile r")
public class RubricFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RUBRIC_FILE_IDFILE_GENERATOR", allocationSize = 1, sequenceName="SEQ_RUBRIC_FILE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RUBRIC_FILE_IDFILE_GENERATOR")
	@Column(name="ID_FILE", unique=true, nullable=false)
	private long idFile;

	@Column(nullable=false, length=500)
	private String decription;

	@Column(name="FILE_NAME", nullable=false, length=200)
	private String fileName;

	@Lob
	@Column(name="FILE_RAW", nullable=false)
	private byte[] fileRaw;

	//bi-directional many-to-one association to EvalReport
	@OneToMany(mappedBy="rubricFile")
	private List<EvalReport> evalReports;

	//bi-directional many-to-one association to PlanSmc
	@OneToMany(mappedBy="rubricFile")
	private List<PlanSmc> planSmcs;

	public RubricFile() {
	}

	public long getIdFile() {
		return this.idFile;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileRaw() {
		return this.fileRaw;
	}

	public void setFileRaw(byte[] fileRaw) {
		this.fileRaw = fileRaw;
	}

	public List<EvalReport> getEvalReports() {
		return this.evalReports;
	}

	public void setEvalReports(List<EvalReport> evalReports) {
		this.evalReports = evalReports;
	}

	public EvalReport addEvalReport(EvalReport evalReport) {
		getEvalReports().add(evalReport);
		evalReport.setRubricFile(this);

		return evalReport;
	}

	public EvalReport removeEvalReport(EvalReport evalReport) {
		getEvalReports().remove(evalReport);
		evalReport.setRubricFile(null);

		return evalReport;
	}

	public List<PlanSmc> getPlanSmcs() {
		return this.planSmcs;
	}

	public void setPlanSmcs(List<PlanSmc> planSmcs) {
		this.planSmcs = planSmcs;
	}

	public PlanSmc addPlanSmc(PlanSmc planSmc) {
		getPlanSmcs().add(planSmc);
		planSmc.setRubricFile(this);

		return planSmc;
	}

	public PlanSmc removePlanSmc(PlanSmc planSmc) {
		getPlanSmcs().remove(planSmc);
		planSmc.setRubricFile(null);

		return planSmc;
	}

}