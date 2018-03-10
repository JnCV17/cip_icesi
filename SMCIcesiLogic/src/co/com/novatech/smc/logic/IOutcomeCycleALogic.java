package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.OutcomeCycleA;

@Remote
public interface IOutcomeCycleALogic {

	public OutcomeCycleA findByIid(long idOutcoCycle) throws Exception;

	public List<OutcomeCycleA> findAllOutcomeCycleA() throws Exception;

	public List<OutcomeCycleA> findCycleByidOutcome(long idOutcome) throws Exception;

	public OutcomeCycleA findOutcomeCycleByidOutcome(long idOutcome, long idciclo);

}
