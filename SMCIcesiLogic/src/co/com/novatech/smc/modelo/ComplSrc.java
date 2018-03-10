package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the COMPL_SRC database table.
 * 
 */
@Entity
@Table(name = "COMPL_SRC")
@NamedQuery(name = "ComplSrc.findAll", query = "SELECT c FROM ComplSrc c")
public class ComplSrc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COMPL_SRC_IDCOMPLSRC_GENERATOR", allocationSize = 1, sequenceName = "SEQ_COMPL_SRC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPL_SRC_IDCOMPLSRC_GENERATOR")
	@Column(name = "ID_COMPL_SRC", unique = true, nullable = false)
	private long idComplSrc;

	// bi-directional many-to-one association to PlanSmc
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAN_ID_PLAN", nullable = false)
	private PlanSmc planSmc;

	// bi-directional many-to-one association to Method
	@OneToMany(mappedBy = "complSrc")
	private List<Method> methods;

	public ComplSrc() {
	}

	public long getIdComplSrc() {
		return this.idComplSrc;
	}

	public void setIdComplSrc(long idComplSrc) {
		this.idComplSrc = idComplSrc;
	}

	public PlanSmc getPlanSmc() {
		return this.planSmc;
	}

	public void setPlanSmc(PlanSmc planSmc) {
		this.planSmc = planSmc;
	}

	public List<Method> getMethods() {
		return this.methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public Method addMethod(Method method) {
		getMethods().add(method);
		method.setComplSrc(this);

		return method;
	}

	public Method removeMethod(Method method) {
		getMethods().remove(method);
		method.setComplSrc(null);

		return method;
	}

}