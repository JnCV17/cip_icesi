package co.com.novatech.smc.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IOutcomeDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.ProgramSmc;

@Stateless
public class OutcomeLogic implements IOutcomeLogic {

	@EJB
	private IOutcomeDao outcomeDao;

	@EJB
	private IProgramLogic programaLogic;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateOutcome(Outcome outcome) throws Exception {

		if (outcome == null) {
			throw new ZMessManager().new NullEntityExcepcion("Outcome");
		}
		Outcome outcomePrueba = outcomeDao.findbyid(outcome.getIdStOutcome());

		if (outcome == null) {
			throw new ZMessManager().new NullEntityExcepcion("Outcome");
		}

		if (outcome.getCriterion() == null || outcome.getCriterion().toString().trim().contentEquals("")) {
			throw new ZMessManager().new NullEntityExcepcion("Criterio");
		}
		if (outcome.getDescription() == null || outcome.getDescription().toString().trim().contentEquals("")) {
			throw new ZMessManager().new NullEntityExcepcion("Description");
		}
		if (outcome.getShortDescription() == null
				|| outcome.getShortDescription().toString().trim().contentEquals("")) {
			throw new ZMessManager().new NullEntityExcepcion("Short description");
		}
		if (outcome.getProgramSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Program id");
		}
		if (outcome.getStateSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("State id");
		}

		if (outcome.getOutcomeCycleAs() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Main cycle id");
		}

		outcomeDao.mergeOutcome(outcome);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Outcome> findAllOutcome() {

		return outcomeDao.getOutcomeFindAll();
	}

	@TransactionAttribute()
	public List<Outcome> findOutcomeByProgram(ProgramSmc programa) throws Exception {

		List<Outcome> out = new ArrayList<Outcome>();
		List<Outcome> outcomes = outcomeDao.getOutcomeFindAll();
		for (Outcome outcome : outcomes) {
			if (outcome.getProgramSmc().getIdProgram().equals(programa.getIdProgram())) {
				out.add(outcome);
			}
		}

		return out;
	}

	@TransactionAttribute
	public Outcome findbyId(long id) {

		return outcomeDao.findbyid(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Outcome> findOutcomesByProgram(String idProgram) {
		if (idProgram.trim().equals("")) {
			throw new ZMessManager("The idProgram cannot be empty");
		}

		ProgramSmc programa = programaLogic.findProgramById(idProgram);

		if (programa == null) {

			throw new ZMessManager("The program does not exists");
		}

		return outcomeDao.findOutcomesByProgram(idProgram);
	}

	@TransactionAttribute
	public List<Outcome> findOutcomeByUser(long idUser) {

		return outcomeDao.findOutcomeByUser(idUser);
	}

	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram) {
		return outcomeDao.findOutcomeByStateAndUser(idState, idProgram);
	}
}
