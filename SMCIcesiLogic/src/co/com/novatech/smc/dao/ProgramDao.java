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

import co.com.novatech.smc.modelo.ProgramSmc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "ProgramDao", mappedName = "SMCIcesi-SMCIcesiLogic-ProgramDao")
public class ProgramDao implements IProgramDao {

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
	public ProgramDao() {
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
	 
	public ProgramSmc persistProgram(ProgramSmc program) {
		em.persist(program);
		return program;
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public ProgramSmc mergeProgram(ProgramSmc program) {
		return em.merge(program);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	public void removeProgram(ProgramSmc program) {
		program = em.find(ProgramSmc.class, program.getIdProgram());
		em.remove(program);
	}

	/**
	 * @generated DT_ID=none
	 */
	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProgramSmc> getProgramFindAll() {

		String sql = "SELECT p FROM ProgramSmc p";
		return em.createQuery(sql).getResultList();

	}

	 
	public ProgramSmc findByIdProgram(String idProgram) {
		return em.find(ProgramSmc.class, idProgram);
	}

	 
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProgramSmc> getProgramFindbyDirector(long idUser) {

		Query o = em.createQuery("SELECT p FROM ProgramSmc p WHERE p.userCip.idUser =:idUser");
		o.setParameter("idUser", idUser);

		return o.getResultList();

	}
}
