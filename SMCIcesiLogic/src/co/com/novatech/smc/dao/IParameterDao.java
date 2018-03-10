package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ParamSmc;;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IParameterDao {

	// public long getParameterNextValue() throws SQLException;

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public ParamSmc persistParameter(ParamSmc parameter);

	/**
	 * @generated DT_ID=none
	 */
	public ParamSmc mergeParameter(ParamSmc parameter);

	/**
	 * @generated DT_ID=none
	 */
	public void removeParameter(ParamSmc parameter);

	/**
	 * @generated DT_ID=none
	 */
	public List<ParamSmc> getParameterFindAll();

	/**
	 * 
	 * @param idParameter
	 * @return
	 */
	public ParamSmc findByIdParameter(long idParameter);

	/**
	 * 
	 * @param idParameter
	 * @return
	 */
	public ParamSmc findCycleActiveByProgram(String idParameter);

	public ParamSmc findByIdParameter(Long idParam);

}
