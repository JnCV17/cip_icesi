package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IMethodDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.Method;

@Stateless
public class MethodLogic implements IMethodLogic {

	@EJB
	private IMethodDao methodDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveMethod(Method method) throws Exception {
		if (method == null) {
			throw new ZMessManager().new NullEntityExcepcion("method");
		}

		Method entity = methodDao.findById(method.getIdAsMethod());

		if (entity != null) {

			throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
		}

		if (method.getDescription() == null) {
			throw new Exception("La descripcion del metodo es obligatoria");

		}

		if (method.getDirect() == null) {
			throw new Exception("El valor directo del metodo es obligatorio");

		}

		if (method.getName() == null) {
			throw new Exception("El nombre del metodo es obligatorio");

		}

		if (method.getName().isEmpty() == true) {
			throw new Exception("El nombre del metodo no puede estar vacio");
		}

		if (method.getShortDescription() == null) {
			throw new Exception("La descripcion corta del metodo es obligatoria");

		}

		if (method.getName().isEmpty() == true) {
			throw new Exception("La descripcion corta del metodo no puede estar vacia");
		}

		methodDao.persistMethod(method);

	}

	@TransactionAttribute
	public Method findByIdMethod(long idMethod) throws Exception {
		return methodDao.findById(idMethod);
	}

	@TransactionAttribute
	public List<Method> findAllMethod() {
		return methodDao.getMethodFindAll();
	}

}
