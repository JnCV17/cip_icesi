package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ProgramSmc;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IProgramDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	// public ProgramSmc persistProgram(ProgramSmc program);

	/**
	 * @generated DT_ID=none
	 */
	// public ProgramSmc mergeProgram(ProgramSmc program);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeProgram(ProgramSmc program);

	/**
	 * @generated DT_ID=none
	 */
	public List<ProgramSmc> getProgramFindAll();

	public ProgramSmc findByIdProgram(String idProgram);

	public List<ProgramSmc> getProgramFindbyDirector(long idUser);

}
