package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IPiDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;

@Stateless
public class PiLogic implements IPiLogic {

	@EJB
	private IPiDao piDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void savePi(PiSmc pi) throws ZMessManager {

		if (pi == null) {
			throw new ZMessManager().new NullEntityExcepcion("PI");
		}

		if (pi.getCode() == null || pi.getCode().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("PI code");
		}

		if (pi.getDescription() == null || pi.getDescription().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("PI name");
		}

		if (pi.getPlanSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Plan's PI");
		}

		piDao.persistPi(pi);

	}

	public PiSmc findByIdPi(long id) throws ZMessManager {
		PiSmc pi = null;

		if (id == 0) {
			throw new ZMessManager().new EmptyFieldException("id PI");

		}

		pi = piDao.findById(id);

		return pi;
	}

	public PiSmc findByPlanPi(PlanSmc plan) throws ZMessManager {
		PiSmc pi = null;

		if (plan == null) {
			throw new ZMessManager().new NullEntityExcepcion("Plan's PI");
		}

		if (plan.getIdPlan() == 0) {
			throw new ZMessManager().new EmptyFieldException("id Plan' PI");

		}

		pi = piDao.findByPlan(plan);
		return pi;
	}

	public List<PiSmc> findAllPi() {
		return piDao.getPiFindAll();
	}

	public List<PiSmc> findAllPisByPlan(long idPlan) {

		return piDao.findAllPisByPlan(idPlan);
	}

	@Override
	public void updatePi(PiSmc pi) {
		if (pi == null) {
			throw new ZMessManager().new NullEntityExcepcion("PI");
		}

		if (pi.getDescription() == null || pi.getDescription().equals("")) {
			throw new ZMessManager().new NullEntityExcepcion("PI name");
		}

		if (pi.getPlanSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Plan's PI");
		}

		piDao.mergePi(pi);

	}

}
