package co.com.novatech.smc.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.novatech.smc.modelo.Outcome;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "OutcomeDao", mappedName = "SMCIcesi-SMCIcesiLogic-OutcomeDao")
public class OutcomeDao implements IOutcomeDao {

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName = "SMCIcesiLogic")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public OutcomeDao() {
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public Outcome persistOutcome(Outcome outcome) {
		em.persist(outcome);
		return outcome;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public Outcome mergeOutcome(Outcome outcome) {
		return em.merge(outcome);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeOutcome(Outcome outcome) {
		outcome = em.find(Outcome.class, outcome.getIdStOutcome());
		em.remove(outcome);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Outcome> getOutcomeFindAll() {
		return em.createNamedQuery("Outcome.findAll").getResultList();
	}

	 
	public Outcome findbyid(long idOutcome) {
		return em.find(Outcome.class, idOutcome);
	}

	 
	public List<Outcome> findOutcomesByProgram(String idProgram) {

		Query o = em
				.createQuery("SELECT outcomes FROM Outcome outcomes WHERE outcomes.programSmc.idProgram =: idProgram");

		o.setParameter("idProgram", idProgram);

		return o.getResultList();
	}

	 

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Outcome> findOutcomeByUser(long idUser) {

		Query o = em.createQuery("SELECT outcomes FROM Outcome outcomes  WHERE outcomes.userCip.idUser =:idUser");
		o.setParameter("idUser", idUser);

		return o.getResultList();
	}

	 
	public Outcome findOutcomeCycleByidOutcome(String criterio, String programa) {
		Query o = em.createQuery(
				"SELECT outcomes FROM Outcome outcomes  WHERE outcomes.criterion =:criterio AND outcomes.programSmc.idProgram= :programa");
		o.setParameter("criterio", criterio);
		o.setParameter("programa", programa);

		return (Outcome) o.getSingleResult();
	}

	 
	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram) {

		Query o = em.createQuery(
				"SELECT outcomes FROM Outcome outcomes WHERE outcomes.stateSmc.idState =:idState AND outcomes.programSmc.idProgram=:idProgram ");
		o.setParameter("idState", idState);
		o.setParameter("idProgram", idProgram);

		return o.getResultList();
	}

}
