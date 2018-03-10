package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the CDIO_LVL database table.
 * 
 */
@Entity
@Table(name = "CDIO_LVL")
@NamedQuery(name = "CdioLvl.findAll", query = "SELECT c FROM CdioLvl c")
public class CdioLvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CDIO_LVL_IDCDIOLVL_GENERATOR", allocationSize = 1, sequenceName = "SEQ_CDIO_LVL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDIO_LVL_IDCDIOLVL_GENERATOR")
	@Column(name = "ID_CDIO_LVL", unique = true, nullable = false)
	private long idCdioLvl;

	@Column(nullable = false, length = 20)
	private String description;

	@Column(nullable = false, length = 10)
	private String symbol;

	// bi-directional many-to-one association to CdioCourseMtx
	@OneToMany(mappedBy = "cdioLvl")
	private List<CdioCourseMtx> cdioCourseMtxs;

	public CdioLvl() {
	}

	public long getIdCdioLvl() {
		return this.idCdioLvl;
	}

	public void setIdCdioLvl(long idCdioLvl) {
		this.idCdioLvl = idCdioLvl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<CdioCourseMtx> getCdioCourseMtxs() {
		return this.cdioCourseMtxs;
	}

	public void setCdioCourseMtxs(List<CdioCourseMtx> cdioCourseMtxs) {
		this.cdioCourseMtxs = cdioCourseMtxs;
	}

	public CdioCourseMtx addCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().add(cdioCourseMtx);
		cdioCourseMtx.setCdioLvl(this);

		return cdioCourseMtx;
	}

	public CdioCourseMtx removeCdioCourseMtx(CdioCourseMtx cdioCourseMtx) {
		getCdioCourseMtxs().remove(cdioCourseMtx);
		cdioCourseMtx.setCdioLvl(null);

		return cdioCourseMtx;
	}

}