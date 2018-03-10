
package co.com.novatech.smc.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "AlertCambioAssessmentController")
@SessionScoped
public class AlertCambioAssessmentController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private String descripcion;

	public AlertCambioAssessmentController() {
		descripcion = "descripcion correo";
	}

	public String getDescripcion() {
		ParamSmc mensaje = businessDelegate.findCycleActiveByProgram("AlertCambioEstadoAssessment");

		descripcion = mensaje.getTextValue();
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void verificar() {

		System.out.println(
				"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ entro verificar con valor :"
						+ descripcion);
		if (!descripcion.contains("{Subject}")) {
			FacesUtils.addErrorMessage("", "falto la etiqueta  {Subject}");
			System.out.println("falto subject");
		} else if (!descripcion.contains("{Program}")) {
			FacesUtils.addErrorMessage("", "falto la etiqueta  {Program}");
			System.out.println("falto program");
		} else if (!descripcion.contains("{Outcome}")) {
			FacesUtils.addErrorMessage("", "falto la etiqueta  {Outcome}");
			System.out.println("falto outcome");
		} else if (!descripcion.contains("{State}")) {
			FacesUtils.addErrorMessage("", "falto la etiqueta  {State}");
			System.out.println("falto state");
		} else {
			try {
				businessDelegate.updateAlertCambioAssessent(descripcion);
				FacesUtils.addInfoMessage("", "Alerta actualizada con exito");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				FacesMessage msg = new FacesMessage("error actualizando");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				System.out.println("++++++++++++++++++++++++++++++++++++error actualizando");
			}

		}

		//
		//
		// if (!descripcion.contains("{Subject}")) {
		// FacesMessage msg = new FacesMessage("falta usar subject");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto subject");
		// } else if (!descripcion.contains("{Program}")) {
		// FacesMessage msg = new FacesMessage("falta usar program");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto program");
		// } else if (!descripcion.contains("{Date}")) {
		// FacesMessage msg = new FacesMessage("falta usar date");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto date");
		// } else if (!descripcion.contains("{Outcome}")) {
		// FacesMessage msg = new FacesMessage("falta usar outcome");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto outcome");
		// } else if (!descripcion.contains("{AssessmentSource}")) {
		// FacesMessage msg = new FacesMessage("falta usar AssessmentSource");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto AssessmentSource");
		// } else if (!descripcion.contains("{Autor}")) {
		// FacesMessage msg = new FacesMessage("falta usar Autor");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto Autor");
		// } else if (!descripcion.contains("{State}")) {
		// FacesMessage msg = new FacesMessage("falta usar state");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("falto state");
		// } else {
		// try {
		// businessDelegate.updateAlertAsignacion(txtDescripcion.getValue().toString());
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// FacesMessage msg = new FacesMessage("error actualizando");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// System.out.println("++++++++++++++++++++++++++++++++++++error
		// actualizando");
		// }
		// }

	}

}