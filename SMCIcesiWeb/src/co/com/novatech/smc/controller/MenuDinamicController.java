
package co.com.novatech.smc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.Menu;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;

@ManagedBean(name = "MenuDinamicController")
@ViewScoped()
public class MenuDinamicController {

	@EJB
	private IBusinessDelegate businessDelegate;

	private UserCip userSesion;
	private MenuModel model;

	private String nameUser;
	private String roles;

	private List<Menu> listaMenus;

	public MenuDinamicController() {

		nameUser = null;
		roles = "";
		userSesion = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);

	}

	public UserCip getUserSesion() {
		return userSesion;
	}

	public void setUserSesion(UserCip userSesion) {
		this.userSesion = userSesion;
	}

	public MenuModel getModel() {
		return model;
	}

	public String getNameUser() {

		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		nameUser = user.getNameUser() + " " + user.getLastName();
		return nameUser;
	}

	public String getRoles() {
		roles = "";
		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		List<RoleCip> roles1 = businessDelegate.findRoleByUser(user.getIdUser());

		for (RoleCip roleCip : roles1) {
			roles += roleCip.getName() + " - ";
		}
		roles = roles.substring(0, roles.length() - 2);
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	@PostConstruct
	public void crearMenuDinamico() {

		try {
			listaMenus = businessDelegate.findAllMenus();
		} catch (Exception e) {

			e.printStackTrace();
		}
		model = new DefaultMenuModel();

		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		String selec = idioma.getLanguage();

		for (Menu mr : listaMenus) {

			if (mr.getTipo().equals("S") && businessDelegate.puedeVerMenu(mr, userSesion)) {

				String nombre = mr.getMenuName();
				String[] ambos = nombre.split("%");
				DefaultSubMenu submenu = null;
				if (selec.equals("es")) {
					submenu = new DefaultSubMenu(ambos[0]);
				} else if (selec.equals("en")) {
					submenu = new DefaultSubMenu(ambos[1]);
				}

				for (Menu mr2 : listaMenus) {

					Menu padre = mr2.getMenu();
					if (padre != null) {
						if (padre.getIdMenu() == mr.getIdMenu()) {

							String nombre2 = mr2.getMenuName();
							String[] ambos2 = nombre2.split("%");
							DefaultMenuItem item = null;
							if (selec.equals("es")) {
								item = new DefaultMenuItem(ambos2[0]);
							} else if (selec.equals("en")) {
								item = new DefaultMenuItem(ambos2[1]);
							}

							item.setUrl(mr2.getUrl());
							if (!ambos2[2].equals("x")) {
								item.setIcon(ambos2[2]);
							}

							item.setStyleClass("itemsMenu2");
							submenu.addElement(item);

						}
					}
				}
				submenu.setStyleClass("itemsMenu");
				model.addElement(submenu);

			} else {

				if (mr.getMenu() == null && businessDelegate.puedeVerMenu(mr, userSesion) && mr.getIdMenu() != 9
						&& mr.getIdMenu() != 10) {

					String nombre2 = mr.getMenuName();
					String[] ambos2 = nombre2.split("%");
					DefaultMenuItem item = null;
					if (selec.equals("es")) {
						item = new DefaultMenuItem(ambos2[0]);
					} else if (selec.equals("en")) {
						item = new DefaultMenuItem(ambos2[1]);
					}

					item.setUrl(mr.getUrl());
					if (!ambos2[2].equals("x")) {
						item.setIcon(ambos2[2]);
					}

					model.addElement(item);
					item.setStyleClass("itemsMenu");
				}
			}

		}

		try {

			Menu options;
			options = businessDelegate.findByIidMenu(10);
			if (businessDelegate.puedeVerMenu(options, userSesion)) {
				String nombre3 = options.getMenuName();
				String[] ambos3 = nombre3.split("%");
				DefaultMenuItem item2 = null;
				if (selec.equals("es")) {
					item2 = new DefaultMenuItem(ambos3[0]);
				} else if (selec.equals("en")) {
					item2 = new DefaultMenuItem(ambos3[1]);
				}

				item2.setUrl(options.getUrl());
				if (!ambos3[2].equals("x")) {

					item2.setIcon(ambos3[2]);
				}
				item2.setStyleClass("itemsMenu");
				model.addElement(item2);
			}

			Menu logout;
			logout = businessDelegate.findByIidMenu(9);
			String nombre2 = logout.getMenuName();
			String[] ambos2 = nombre2.split("%");
			DefaultMenuItem item = null;
			if (selec.equals("es")) {
				item = new DefaultMenuItem(ambos2[0]);
			} else if (selec.equals("en")) {
				item = new DefaultMenuItem(ambos2[1]);
			}

			item.setUrl(logout.getUrl());
			if (!ambos2[2].equals("x")) {

				item.setIcon(ambos2[2]);
			}
			item.setStyleClass("itemsMenu");
			model.addElement(item);

			// item = new DefaultMenuItem("Config");
			// item.setUrl("/configuracion/ConfigView.xhtml");
			// item.setStyleClass("itemsMenu");
			// model.addElement(item);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String actionHome() {
		return "/Principal/PrincipalPage.xhtml";
	}

	public String actionAsignar() {
		return "/Asignacion/AssignmentOutcomeView.xhtml";
	}

	public String actionCrearPlan() {
		return "/system/CreatePlanAssessmentView.xhtml";
	}

	public String actionConsultarPlan() {
		return "/system/AssessmentPlanConsult.xhtml";
	}

	public String actionLogout() {
		FacesUtils.getSession().invalidate();
		FacesUtils.getHttpSession(true);
		return "/Login/LoginView.xhtml";
	}

	public String actionRendered() {
		return "false";
	}

	public void reload() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public void isMECA() {
		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());
		// System.out.println("dasddfsdfs++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// meca");

		boolean retorno = false;
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 3) {
				System.out.println("dasddfsdfs++++++++++++++++++++++++++++++++++++++++++++++++++++++++ meca");
				retorno = true;
			}
		}
		RequestContext reqCtx = RequestContext.getCurrentInstance();
		reqCtx.addCallbackParam("returnedValue", retorno);

	}

	public boolean isDirector() {
		UserCip user = (UserCip) SessionUtil.getFromSession("usuarioSesion");
		List<RoleCip> roles2 = businessDelegate.findRoleByUser(user.getIdUser());
		// System.out.println("dasddfsdfs++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// director");
		for (RoleCip roleCip : roles2) {
			if (roleCip.getIdRole() == 2) {
				System.out.println("dasddfsdfs++++++++++++++++++++++++++++++++++++++++++++++++++++++++ director");
				return true;
			}
		}
		return false;
	}

}