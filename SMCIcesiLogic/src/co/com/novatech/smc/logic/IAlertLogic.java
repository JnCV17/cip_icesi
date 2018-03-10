package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Alert;

@Remote
public interface IAlertLogic {

	public void saveAlert(Alert alert) throws Exception;

	public void updateAlert(Alert alert) throws Exception;

	// public void deleteAlert(Alert alert) throws Exception;

	public Alert findByIdAlert(long alertId) throws Exception;

	public List<Alert> findAllAlert();
}
