package co.com.novatech.smc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private String txtUser;
	private String txtPassword;
	private String txtIdioma;
	private Locale idioma;

	private List<ProgramSmc> losProgramas;

	public LoginController() {
		txtUser = null;
		txtPassword = null;
		Locale idioma = null;
		try {
			idioma = (Locale) FacesUtils.getfromSession("idioma");
		} catch (Exception e) {
			idioma = new Locale("es");
		}
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
		FacesUtils.putinSession("idioma", idioma);
	}

	public ProgramSmc getProgram() {
		return program;
	}

	public String getTxtIdioma() {
		return txtIdioma;
	}

	public String getTxtUser() {
		return txtUser;
	}

	public String getTxtPassword() {
		return txtPassword;
	}

	public Locale getIdioma() {
		return idioma;
	}

	public List<ProgramSmc> getLosProgramas() {
		if (losProgramas == null) {
			losProgramas = new ArrayList<ProgramSmc>();
			List<ProgramSmc> programas = businessDelegate.findAllProgramas();
			for (ProgramSmc programSmc : programas) {
				losProgramas.add(programSmc);
			}
		}
		return losProgramas;
	}

	public void setTxtIdioma(String txtIdioma) {
		this.txtIdioma = txtIdioma;
	}

	public void setTxtUser(String txtUser) {
		this.txtUser = txtUser;
	}

	public void setLosProgramas(List<ProgramSmc> losProgramas) {
		this.losProgramas = losProgramas;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	public void setIdioma(Locale idioma) {
		this.idioma = idioma;
	}

	public void changeLanguage(String locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
	}

	public String changeSpanish() {

		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
		String uri = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getRequestURI();

		FacesUtils.putinSession("idioma", new Locale("es"));
		String rutica[] = uri.split("SMCIcesiWeb");
		return rutica[1];
	}

	public String changeEnglish() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
		String uri = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getRequestURI();
		FacesUtils.putinSession("idioma", new Locale("en"));

		String rutica[] = uri.split("SMCIcesiWeb");
		return rutica[1];
	}

	public String ingresoSistema() {

		try {
			UserCip user = businessDelegate.validateUser(txtUser, txtPassword);
			if (user == null) {
				FacesUtils.addErrorMessage("No hay un usuario registrado con ese username");
				return "/LoginView.xhtml";
			} else {

				if (program != null) {

					String idProgram = businessDelegate.findProgramById("SIS").getIdProgram();

					ParamSmc parameter = businessDelegate.findCycleActiveByProgram(idProgram);

					String cicloSubciclo = parameter.getTextValue();
					String[] x = cicloSubciclo.split("-");
					String ciclo = x[0];
					String subciclo = x[1];
					MainCycle cicloactivoMain = businessDelegate.findByICycle(Long.parseLong(ciclo));
					MainCycle cicloactivoSub = businessDelegate.findByICycle(Long.parseLong(subciclo));

					FacesUtils.putinSession("MainCycle", cicloactivoMain);
					FacesUtils.putinSession("SubCycle", cicloactivoSub);
				}

				FacesUtils.putinSession("usuarioSesion", user);
				return "/Principal/PrincipalPage.xhtml";
			}
		} catch (Exception e) {

			FacesUtils.addErrorMessage(e.getMessage());

			return "/LoginView.xhtml";
		}

	}

}
