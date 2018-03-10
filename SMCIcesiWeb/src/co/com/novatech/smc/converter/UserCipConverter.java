package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.UserCip;

@FacesConverter("UserCipConverter")
public class UserCipConverter implements Converter {

	 
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<UIComponent> componentes = arg1.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<UserCip> usuarios = new ArrayList<UserCip>();
				usuarios = (List<UserCip>) uiSel.getValue();

				if (usuarios == null) {
					return null;
				}

				Long id = Long.parseLong(arg2);

				for (UserCip userCip : usuarios) {
					Long idUserCip = userCip.getIdUser();
					if (idUserCip.equals(id)) {
						return userCip;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {

			UserCip user = (UserCip) arg2;
			Long userId = user.getIdUser();
			return userId.toString();
		} else {
			return "";
		}
	}
}
