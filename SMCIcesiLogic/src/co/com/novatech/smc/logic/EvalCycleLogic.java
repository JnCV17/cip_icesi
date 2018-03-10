package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.novatech.smc.dao.IEvalCycleDao;
import co.com.novatech.smc.modelo.EvalCycle;

@Stateless
public class EvalCycleLogic implements IEvalCycleLogic {

	@EJB
	private IEvalCycleDao evalCycleDao;

	@Override
	public EvalCycle findByIdEvalCycle(long idEvalCycle) {

		return evalCycleDao.findByIdEvalCycle(idEvalCycle);
	}

	@Override
	public EvalCycle findByIdEvalCycleByIdPlan(long idPLan) {

		return evalCycleDao.findByIdEvalCycleByIdPlan(idPLan);
	}

	@Override
	public List<EvalCycle> findIdEvalByIdCycle(long idCycle) {
		return evalCycleDao.findIdEvalByIdCycle(idCycle);
	}

}
