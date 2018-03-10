package co.com.novatech.smc.controller;

import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "StateTypeController")
public class StateTypeController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private String strStateTypeName;

	public StateTypeController() {
		strStateTypeName = null;
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("en");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
	}

	public void clearAction(ActionEvent e) {
		strStateTypeName = null;
	}

	public String getStrStateTypeName() {
		return strStateTypeName;
	}

	public void setStrStateTypeName(String strStateTypeName) {
		this.strStateTypeName = strStateTypeName;
	}

	public void okAction(ActionEvent e) {
		try {

			businessDelegate.saveStateType(strStateTypeName);
		} catch (Exception e2) {
			e2.getMessage();
		}
	}

}
