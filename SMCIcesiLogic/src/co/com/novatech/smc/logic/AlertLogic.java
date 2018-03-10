package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IAlertDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.Alert;

@Stateless
public class AlertLogic implements IAlertLogic {

	// TODO revisar validaciones de los nuevos atributos
	@EJB
	private IAlertDao alertDAO;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveAlert(Alert alert) throws Exception {

		if (alert == null) {

			throw new ZMessManager().new NullEntityExcepcion("Alert");
		}

		Alert entity = alertDAO.findByIdAlert(alert.getIdAlert());

		if (entity != null) {

			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		if (alert.getStateSmc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("State");
		}

		alertDAO.persistAlert(alert);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateAlert(Alert alert) throws Exception {

		if (alert == null) {

			throw new ZMessManager().new NullEntityExcepcion("Alert");
		}

		if (alert.getStateSmc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("State");
		}

		alertDAO.mergeAlert(alert);

	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// public void deleteAlert(Alert alert) throws Exception {
	// alertDAO.removeAlert(alert);
	// }

	@TransactionAttribute
	public Alert findByIdAlert(long alertId) throws Exception {

		return alertDAO.findByIdAlert(alertId);
	}

	@TransactionAttribute
	public List<Alert> findAllAlert() {
		return alertDAO.getAlertFindAll();
	}

}
