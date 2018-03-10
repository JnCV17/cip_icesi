package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IOutcomeCycleADao;
import co.com.novatech.smc.modelo.OutcomeCycleA;

@Stateless
public class OutcomeCycleALogic implements IOutcomeCycleALogic {

	@EJB
	private IOutcomeCycleADao outcomeCycleA;

	@TransactionAttribute
	public List<OutcomeCycleA> findAllOutcomeCycleA() throws Exception {

		return outcomeCycleA.getOutcomeCycleAFindAll();
	}

	@TransactionAttribute
	public OutcomeCycleA findByIid(long idOutcoCycleA) throws Exception {

		return outcomeCycleA.getOutcomeCycleAFindById(idOutcoCycleA);
	}

	public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome) throws Exception {
		return (List<OutcomeCycleA>) outcomeCycleA.getOutcomeCycleAFindById(idOutcome);
	}

	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo) {
		return outcomeCycleA.findOutcomeCycleByidOutcome(idOutcome, idciclo);
	}

}
