package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.StateSmc;

@FacesConverter("StateConverter")
public class StateConverter implements Converter {

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<StateSmc> states = new ArrayList<StateSmc>();
				states = (List<StateSmc>) uiSel.getValue();

				if (states == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (StateSmc outcomes : states) {
					Long idOutcome = outcomes.getIdState();
					if (idOutcome.equals(id)) {
						return outcomes;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			StateSmc outcome = (StateSmc) value;
			Long idOutcome = outcome.getIdState();
			return idOutcome.toString();
		} else {
			return "";
		}

	}


}
