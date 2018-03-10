package co.com.novatech.smc.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.ProgramSmc;

@FacesConverter("ProgramConverter")
public class ProgramConverter implements Converter{


	 
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		List<UIComponent> componentes = arg1.getChildren();
		for (UIComponent uiComponent : componentes) {
			if(uiComponent instanceof UISelectItems){
				UISelectItems uiSel = (UISelectItems) uiComponent;
				
				List<ProgramSmc> programs = new ArrayList<ProgramSmc>();
				programs = (List<ProgramSmc>) uiSel.getValue();
				
				if(programs==null){
					return null;
				}
				
				for (ProgramSmc programSmc : programs) {
					if(programSmc.getIdProgram().equals(arg2)){
						return programSmc;
					}
				}
			}
		}

		return null;
	}

	 
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {		
		if(arg2 !=null){
			ProgramSmc program = (ProgramSmc)arg2;
			return program.getIdProgram();
		}else{
			return "";
		}
	}

}
