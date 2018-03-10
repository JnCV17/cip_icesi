package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.novatech.smc.modelo.Course;

@FacesConverter("CourseConverter")
public class CourseConverter implements Converter {

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if (uiComponent instanceof UISelectItems) {
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<Course> course = new ArrayList<Course>();
				course = (List<Course>) uiSel.getValue();

				if (course == null) {
					return null;
				}

				Long id = Long.parseLong(value);

				for (Course courses : course) {
					Long idCourse = courses.getIdCourse();
					if (idCourse.equals(id)) {
						return courses;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Course course = (Course) value;
			Long idCourse = course.getIdCourse();
			return idCourse.toString();
		} else {
			return "";
		}

	}

}
