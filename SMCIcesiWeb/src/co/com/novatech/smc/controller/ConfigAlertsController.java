
package co.com.novatech.smc.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "ConfigAlertsController")
@SessionScoped
public class ConfigAlertsController {

	@EJB
	private IBusinessDelegate businessDelegate;

	public ConfigAlertsController() {

	}

	public String actionIrAsignacion() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro asignacion");
		FacesUtils.putinSession("alerta", "AlertAsignacion");
		return "AsignacionAlertaView.xhtml";
	}

	public String actionIrDesasignacion() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro des");
		FacesUtils.putinSession("alerta", "AlertDesasignacion");
		return "DesasignacionAlertaView.xhtml";
	}

	public String actionIrCambioAssessment() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro cambio aseesment");
		FacesUtils.putinSession("alerta", "AlertCambioEstadoAssessment");
		return "CambioAssessmentAlertaView.xhtml";
	}

	public String actionIrRecoleccion() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro fecha recolec");
		FacesUtils.putinSession("alerta", "AlertfechaRecoleccion");
		return "RecoleccionAlertaView.xhtml";
	}

	public String actionIrEvaluacion() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro fecha eva");
		FacesUtils.putinSession("alerta", "AlertfechaEvaluacion");
		return "EvaluacionAlertaView.xhtml";
	}

	public String actionIrCambioEvaluacion() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++entro fcambio evalaucion");
		FacesUtils.putinSession("alerta", "AlertCambioEstadoEvaluacion");
		return "CambioEvaluacionAlertaView.xhtml";
	}

}