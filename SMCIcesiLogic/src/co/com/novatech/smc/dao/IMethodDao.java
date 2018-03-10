package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Method;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IMethodDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public Method persistMethod(Method method);

	/**
	 * @generated DT_ID=none
	 */
	// public Method mergeMethod(Method method);

	/**
	 * @generated DT_ID=none
	 */
	// public void removeMethod(Method method);

	/**
	 * @generated DT_ID=none
	 */
	public List<Method> getMethodFindAll();

	Method findById(long idMethod);

}
