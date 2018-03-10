package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.ProgramSmc;

@Remote
public interface IParameterLogic {

	public void createBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception;

	public void createCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception;

	public void createFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception;

	public void createFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception;

	public void createInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception;

	public void createInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception;

	public void createTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception;

	public void updateBLOBParameter(String parName, String parDescription, String dataType, byte[] parBlob)
			throws Exception;

	public void updateCLOBParameter(String parName, String parDescription, String dataType, String parClob)
			throws Exception;

	public void updateFinalDateParameter(String parName, String parDescription, String dataType, Date parFinalDate)
			throws Exception;

	public void updateFinalNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parFinalNum) throws Exception;

	public void updateInitialDateParameter(String parName, String parDescription, String dataType, Date parInitialDate)
			throws Exception;

	public void updateInitialNumericParameter(String parName, String parDescription, String dataType,
			BigDecimal parInitialParameter) throws Exception;

	public void updateTextParameter(String parName, String parDescription, String dataType, String parText)
			throws Exception;

	public void saveParameter(ParamSmc param) throws Exception;

	public void updateParameter(ParamSmc param) throws Exception;

	public ParamSmc findByIDParameter(long cdioSkill);

	public List<ParamSmc> findAll();

	/**
	 * Metodo que busca un parametro por nombre
	 * 
	 * @param idParameter,
	 *            nombre del parametro que quiere ser buscado
	 * @return ParamSmc objeto de tipo ParamSmc
	 */
	public ParamSmc findParameterByName(String idParameter);

	public long subcycleActiveByProgram(ProgramSmc program);

}
