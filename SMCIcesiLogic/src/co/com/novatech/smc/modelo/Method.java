package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METHOD database table.
 * 
 */
@Entity
@Table(name="METHOD")
@NamedQuery(name="Method.findAll", query="SELECT m FROM Method m")
public class Method implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="METHOD_IDASMETHOD_GENERATOR", allocationSize = 1, sequenceName="SEQ_METHOD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="METHOD_IDASMETHOD_GENERATOR")
	@Column(name="ID_AS_METHOD", unique=true, nullable=false)
	private long idAsMethod;

	@Column(nullable=false, length=400)
	private String description;

	@Column(name="\"DIRECT\"", nullable=false, length=1)
	private String direct;

	@Column(nullable=false, length=60)
	private String name;

	@Column(name="SHORT_DESCRIPTION", nullable=false, length=100)
	private String shortDescription;

	//bi-directional many-to-one association to AsSrc
	@OneToMany(mappedBy="method")
	private List<AsSrc> asSrcs;

	//bi-directional many-to-one association to ComplSrc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COMPL_SRC_ID_COMPL_SRC")
	private ComplSrc complSrc;

	public Method() {
	}

	public long getIdAsMethod() {
		return this.idAsMethod;
	}

	public void setIdAsMethod(long idAsMethod) {
		this.idAsMethod = idAsMethod;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirect() {
		return this.direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public List<AsSrc> getAsSrcs() {
		return this.asSrcs;
	}

	public void setAsSrcs(List<AsSrc> asSrcs) {
		this.asSrcs = asSrcs;
	}

	public AsSrc addAsSrc(AsSrc asSrc) {
		getAsSrcs().add(asSrc);
		asSrc.setMethod(this);

		return asSrc;
	}

	public AsSrc removeAsSrc(AsSrc asSrc) {
		getAsSrcs().remove(asSrc);
		asSrc.setMethod(null);

		return asSrc;
	}

	public ComplSrc getComplSrc() {
		return this.complSrc;
	}

	public void setComplSrc(ComplSrc complSrc) {
		this.complSrc = complSrc;
	}

}