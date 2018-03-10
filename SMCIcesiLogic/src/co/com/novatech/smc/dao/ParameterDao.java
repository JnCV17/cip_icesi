package co.com.novatech.smc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.novatech.smc.modelo.ParamSmc;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "ParameterDao", mappedName = "SMCIcesi-SMCIcesiLogic-ParameterDao")
public class ParameterDao implements IParameterDao {

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
	public ParameterDao() {
	}

	public long getParameterNextValue() throws SQLException {

		Query query = em.createQuery("select SEC_PARAMETER.NEXTVAL from DUAL");

		ResultSet rs = (ResultSet) query.getSingleResult();

		long cust_id = 0;

		if (rs != null && rs.next()) {
			cust_id = rs.getLong(1);
		}

		rs.close();

		return cust_id;
	}

	@TransactionAttribute
	public ParamSmc findByIdParameter(Long idParam) {

		return em.find(ParamSmc.class, idParam);
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
	public ParamSmc persistParameter(ParamSmc parameter) {
		em.persist(parameter);
		return parameter;
	}

	/**
	 * @generated DT_ID=none
	 */
	public ParamSmc mergeParameter(ParamSmc parameter) {
		return em.merge(parameter);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeParameter(ParamSmc parameter) {
		parameter = em.find(ParamSmc.class, parameter.getIdParameter());
		em.remove(parameter);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ParamSmc> getParameterFindAll() {
		return em.createNamedQuery("Parameter.findAll").getResultList();
	}

	public ParamSmc findByIdParameter(long idParameter) {

		return em.find(ParamSmc.class, idParameter);
	}

	public ParamSmc findCycleActiveByProgram(String idParameter) {
		Query o = em.createQuery("SELECT param FROM ParamSmc param  WHERE param.parameterName =:idParameter ");
		o.setParameter("idParameter", idParameter);

		return (ParamSmc) o.getSingleResult();

	}

}
