package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.Method;

@FacesConverter("MethodConverter")
public class MethodConverter implements Converter {

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<Method> methods = new ArrayList<Method>();
				methods = (List<Method>) uiSel.getValue();

				if (methods == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (Method method : methods) {
					Long idMethod = method.getIdAsMethod();
					if (idMethod.equals(id)) {
						return method;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Method method = (Method) value;
			Long idMethod = method.getIdAsMethod();
			return idMethod.toString();
		} else {
			return "";
		}

	}

}
