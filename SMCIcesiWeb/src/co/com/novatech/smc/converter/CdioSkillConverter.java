package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.CdioSkill;

@FacesConverter("CdioSkillConverter")
public class CdioSkillConverter implements Converter {

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<CdioSkill> cdioSkills = new ArrayList<CdioSkill>();
				cdioSkills = (List<CdioSkill>) uiSel.getValue();

				if (cdioSkills == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (CdioSkill cdioSkill : cdioSkills) {
					Long idCourse = cdioSkill.getIdCdioSkill();
					if (idCourse.equals(id)) {
						return cdioSkill;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			CdioSkill cdioSkill = (CdioSkill) value;
			Long idCdioSkill = cdioSkill.getIdCdioSkill();
			return idCdioSkill.toString();
		} else {
			return "";
		}

	}

}
