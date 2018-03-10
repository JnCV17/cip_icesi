package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IPiDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public PiSmc persistPi(PiSmc pi);

	/**
	 * @generated DT_ID=none
	 */
	public PiSmc mergePi(PiSmc pi);

	/**
	 * @generated DT_ID=none
	 */
	// public void removePi(PiSmc pi);

	/**
	 * @generated DT_ID=none
	 */
	public List<PiSmc> getPiFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public PiSmc findById(Long id);

	/**
	 * @generated DT_ID=none
	 */
	public PiSmc findByPlan(PlanSmc plan);

	public List<PiSmc> findAllPisByPlan(long idPlan);

}
