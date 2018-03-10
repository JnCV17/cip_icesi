package co.com.novatech.smc.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.PlanSmc;;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IPlanDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public PlanSmc persistPlan(PlanSmc plan);

	/**
	 * @generated DT_ID=none
	 */
	public PlanSmc mergePlan(PlanSmc plan);

	/**
	 * @generated DT_ID=none
	 */
	// public void removePlan(PlanSmc plan);

	/**
	 * @generated DT_ID=none
	 */
	public List<PlanSmc> getPlanFindAll();

	/**
	 * 
	 * @param cycle
	 * @param subCycle
	 * @param outcome
	 * @return
	 */
	public PlanSmc findByid(long id);

	public List<PlanSmc> findByDateOfCreation(Date dateOfCreation);

	public PlanSmc findPlanByOutcome(long idOutcome);

	public List<MainCycle> findByMainCycle(MainCycle cycle);

	public List<MainCycle> findBySubCycle(MainCycle subcycle);
	
	public List<PlanSmc> findPlanStateApproved();

}
