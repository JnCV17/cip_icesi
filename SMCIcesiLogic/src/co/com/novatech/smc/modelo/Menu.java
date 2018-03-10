package co.com.novatech.smc.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
@Table(name = "MENU")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MENU_IDMENU_GENERATOR", allocationSize = 1, sequenceName = "SEQ_MENU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_IDMENU_GENERATOR")
	@Column(name = "ID_MENU", unique = true, nullable = false)
	private long idMenu;

	@Column(name = "MENU_NAME", nullable = false, length = 80)
	private String menuName;

	@Column(nullable = false, length = 20)
	private String tipo;

	@Column(nullable = false, length = 300)
	private String url;

	// bi-directional many-to-one association to Menu
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MENU_PADRE")
	private Menu menu;

	// bi-directional many-to-one association to Menu
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<Menu> menus;

	// bi-directional many-to-one association to MenuRole
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<MenuRole> menuRoles;

	public Menu() {
	}

	public long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setMenu(null);

		return menus;
	}

	public List<MenuRole> getMenuRoles() {
		return this.menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public MenuRole addMenuRole(MenuRole menuRole) {
		getMenuRoles().add(menuRole);
		menuRole.setMenu(this);

		return menuRole;
	}

	public MenuRole removeMenuRole(MenuRole menuRole) {
		getMenuRoles().remove(menuRole);
		menuRole.setMenu(null);

		return menuRole;
	}

}