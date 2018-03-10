package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PARAM_SMC database table.
 * 
 */
@Entity
@Table(name="PARAM_SMC")
@NamedQuery(name="ParamSmc.findAll", query="SELECT p FROM ParamSmc p")
public class ParamSmc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAM_SMC_IDPARAMETER_GENERATOR", allocationSize = 1, sequenceName="SEQ_PARAM_SMC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAM_SMC_IDPARAMETER_GENERATOR")
	@Column(name="ID_PARAMETER", unique=true, nullable=false)
	private long idParameter;

	@Lob
	@Column(name="BLOB_VALUE")
	private byte[] blobValue;

	@Lob
	@Column(name="CLOB_VALUE")
	private String clobValue;

	@Column(name="DATA_TYPE", nullable=false, length=20)
	private String dataType;

	@Temporal(TemporalType.DATE)
	@Column(name="FINAL_DATE_VALUE")
	private Date finalDateValue;

	@Column(name="FINAL_NUMERIC_VALUE")
	private BigDecimal finalNumericValue;

	@Temporal(TemporalType.DATE)
	@Column(name="INITIAL_DATE_VALUE")
	private Date initialDateValue;

	@Column(name="INITIAL_NUMERIC_VALUE")
	private BigDecimal initialNumericValue;

	@Column(name="PARAMETER_DESCRIPTION", nullable=false, length=500)
	private String parameterDescription;

	@Column(name="PARAMETER_NAME", nullable=false, length=30)
	private String parameterName;

	@Column(name="TEXT_VALUE", length=500)
	private String textValue;

	public ParamSmc() {
	}

	public long getIdParameter() {
		return this.idParameter;
	}

	public void setIdParameter(long idParameter) {
		this.idParameter = idParameter;
	}

	public byte[] getBlobValue() {
		return this.blobValue;
	}

	public void setBlobValue(byte[] blobValue) {
		this.blobValue = blobValue;
	}

	public String getClobValue() {
		return this.clobValue;
	}

	public void setClobValue(String clobValue) {
		this.clobValue = clobValue;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Date getFinalDateValue() {
		return this.finalDateValue;
	}

	public void setFinalDateValue(Date finalDateValue) {
		this.finalDateValue = finalDateValue;
	}

	public BigDecimal getFinalNumericValue() {
		return this.finalNumericValue;
	}

	public void setFinalNumericValue(BigDecimal finalNumericValue) {
		this.finalNumericValue = finalNumericValue;
	}

	public Date getInitialDateValue() {
		return this.initialDateValue;
	}

	public void setInitialDateValue(Date initialDateValue) {
		this.initialDateValue = initialDateValue;
	}

	public BigDecimal getInitialNumericValue() {
		return this.initialNumericValue;
	}

	public void setInitialNumericValue(BigDecimal initialNumericValue) {
		this.initialNumericValue = initialNumericValue;
	}

	public String getParameterDescription() {
		return this.parameterDescription;
	}

	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getTextValue() {
		return this.textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

}