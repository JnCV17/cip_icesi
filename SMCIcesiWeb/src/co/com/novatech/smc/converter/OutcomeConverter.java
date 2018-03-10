package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.Outcome;

@FacesConverter("OutcomeConverter")
public class OutcomeConverter implements Converter {

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<Outcome> outcome = new ArrayList<Outcome>();
				outcome = (List<Outcome>) uiSel.getValue();

				if (outcome == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (Outcome outcomes : outcome) {
					Long idOutcome = outcomes.getIdStOutcome();
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
			Outcome outcome = (Outcome) value;
			Long idOutcome = outcome.getIdStOutcome();
			return idOutcome.toString();
		} else {
			return "";
		}

	}

}
