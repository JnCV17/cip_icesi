package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.PlanSmc;

@FacesConverter("PlanConverter")
public class PlanConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<PlanSmc> plans = new ArrayList<PlanSmc>();
				plans = (List<PlanSmc>) uiSel.getValue();

				if (plans == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (PlanSmc plan : plans) {
					Long idPlan = plan.getIdPlan();
					if (idPlan.equals(id)) {
						return plan;
					}
				}
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			PlanSmc plan = (PlanSmc) value;
			Long idPlan = plan.getIdPlan();
			return idPlan.toString();
		} else {
			return "";
		}

	}

}
