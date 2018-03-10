package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MENU_ROLE database table.
 * 
 */
@Entity
@Table(name="MENU_ROLE")
@NamedQuery(name="MenuRole.findAll", query="SELECT m FROM MenuRole m")
public class MenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_ROLE_IDMENUROL_GENERATOR", allocationSize = 1, sequenceName="SEQ_MENU_ROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_ROLE_IDMENUROL_GENERATOR")
	@Column(name="ID_MENU_ROL", unique=true, nullable=false)
	private long idMenuRol;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MENU_ID_MENU", nullable=false)
	private Menu menu;

	//bi-directional many-to-one association to RoleCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_CIP_ID_ROLE", nullable=false)
	private RoleCip roleCip;

	public MenuRole() {
	}

	public long getIdMenuRol() {
		return this.idMenuRol;
	}

	public void setIdMenuRol(long idMenuRol) {
		this.idMenuRol = idMenuRol;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public RoleCip getRoleCip() {
		return this.roleCip;
	}

	public void setRoleCip(RoleCip roleCip) {
		this.roleCip = roleCip;
	}

}