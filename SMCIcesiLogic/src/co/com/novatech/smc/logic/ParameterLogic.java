package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IMainCycleDao;
import co.com.novatech.smc.dao.IParameterDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.ProgramSmc;

@Stateless
public class ParameterLogic implements IParameterLogic {

	@EJB
	private IParameterDao parameterDao;

	@EJB
	private IMainCycleDao mainCycleDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(parBlob);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue(parClob);
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(parFinalDate);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(parFinalNum);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(parInitialDate);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(parInitialParameter);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue(parText);

		saveParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(parBlob);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue(parClob);
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(parFinalDate);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(parFinalNum);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(parInitialDate);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(parInitialParameter);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue("");

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception {
		ParamSmc newPar = new ParamSmc();
		// newPar.setIdParameter(parameterDao.getParameterNextValue());
		newPar.setBlobValue(null);
		newPar.setClobValue("");
		newPar.setDataType("");
		newPar.setFinalDateValue(null);
		newPar.setFinalNumericValue(null);
		newPar.setInitialDateValue(null);
		newPar.setInitialNumericValue(null);
		newPar.setParameterDescription(parName);
		newPar.setParameterName(parDescription);
		newPar.setTextValue(parText);

		updateParameter(newPar);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveParameter(ParamSmc param) throws Exception {

		if (param == null) {
			throw new ZMessManager().new NullEntityExcepcion("Parameter");
		}

		ParamSmc entity = parameterDao.findByIdParameter(param.getIdParameter());

		if (entity != null) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		if (param.getParameterName() == null || param.getParameterName().trim().equals("")) {
			throw new ZMessManager().new EmptyFieldException("Parameter Name");
		}

		if (param.getParameterDescription() == null || param.getParameterDescription().trim().equals("")) {
			throw new ZMessManager().new EmptyFieldException("Parameter Description");
		}

		if (param.getDataType() == null || param.getDataType().trim().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("Data Type");
		}

		parameterDao.persistParameter(param);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateParameter(ParamSmc param) throws Exception {

		if (param == null) {
			throw new ZMessManager().new NullEntityExcepcion("Parameter");
		}

		// ParamSmc entity =
		// parameterDao.findByIdParameter(param.getIdParameter());
		//
		// if (entity != null) {
		// throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		// }

		if (param.getParameterName() == null || param.getParameterName().trim().equals("")) {
			throw new ZMessManager().new EmptyFieldException("Parameter Name");
		}

		if (param.getParameterDescription() == null || param.getParameterDescription().trim().equals("")) {
			throw new ZMessManager().new EmptyFieldException("Parameter Description");
		}

		if (param.getDataType() == null || param.getDataType().trim().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("Data Type");
		}

		parameterDao.mergeParameter(param);
	}

	@TransactionAttribute
	public ParamSmc findByIDParameter(long idParam) {
		return parameterDao.findByIdParameter(idParam);
	}

	@TransactionAttribute
	public List<ParamSmc> findAll() {
		return parameterDao.getParameterFindAll();
	}

	@Override
	@TransactionAttribute
	public ParamSmc findParameterByName(String idParameter) {

		return parameterDao.findCycleActiveByProgram(idParameter);
	}

	public long subcycleActiveByProgram(ProgramSmc program) {

		ParamSmc parameter = parameterDao.findCycleActiveByProgram(program.getIdProgram());

		String cicloSubciclo = parameter.getTextValue();
		String[] x = cicloSubciclo.split("-");
		String ciclo = x[1];

		return Long.parseLong(ciclo);

	}

}
