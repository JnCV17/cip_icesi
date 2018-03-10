package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvalCycle;

@Remote
public interface IEvalCycleLogic {

	public EvalCycle findByIdEvalCycle(long idEvalCycle);

	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan);

	public List<EvalCycle> findIdEvalByIdCycle(long idCycle);

}
