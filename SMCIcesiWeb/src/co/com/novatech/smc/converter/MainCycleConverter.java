package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sun.xml.rpc.tools.wscompile.Main;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ProgramSmc;

@FacesConverter("MainCycleConverter")
public class MainCycleConverter implements Converter{

	 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<UIComponent> componentes = component.getChildren();
		for (UIComponent uiComponent : componentes) {
			if(uiComponent instanceof UISelectItems){
				UISelectItems uiSel = (UISelectItems) uiComponent;

				List<MainCycle> cycles = new ArrayList<MainCycle>();
				cycles = (List<MainCycle>) uiSel.getValue();

				if(cycles==null){
					return null;
				}

				Long id = Long.parseLong(value);

				for (MainCycle mainCycle : cycles) {
					Long idCycle = mainCycle.getIdCycle();
					if(idCycle.equals(id)){
						return mainCycle;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			MainCycle cycle = (MainCycle)value;
			Long idCycle = cycle.getIdCycle();
			return idCycle.toString();
		}else{
			return "";
		}

	}

}
