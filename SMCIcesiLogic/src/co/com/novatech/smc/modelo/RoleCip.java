package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROLE_CIP database table.
 * 
 */
@Entity
@Table(name="ROLE_CIP")
@NamedQuery(name="RoleCip.findAll", query="SELECT r FROM RoleCip r")
public class RoleCip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_CIP_IDROLE_GENERATOR", allocationSize = 1, sequenceName="SEQ_ROLE_CIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_CIP_IDROLE_GENERATOR")
	@Column(name="ID_ROLE", unique=true, nullable=false)
	private long idRole;

	@Column(nullable=false, length=60)
	private String name;

	//bi-directional many-to-one association to MenuRole
	@OneToMany(mappedBy="roleCip")
	private List<MenuRole> menuRoles;

	//bi-directional many-to-one association to StateSmc
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_ID_STATE", nullable=false)
	private StateSmc stateSmc;

	//bi-directional many-to-one association to UserCipRoleCip
	@OneToMany(mappedBy="roleCip")
	private List<UserCipRoleCip> userCipRoleCips;

	public RoleCip() {
	}

	public long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuRole> getMenuRoles() {
		return this.menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public MenuRole addMenuRole(MenuRole menuRole) {
		getMenuRoles().add(menuRole);
		menuRole.setRoleCip(this);

		return menuRole;
	}

	public MenuRole removeMenuRole(MenuRole menuRole) {
		getMenuRoles().remove(menuRole);
		menuRole.setRoleCip(null);

		return menuRole;
	}

	public StateSmc getStateSmc() {
		return this.stateSmc;
	}

	public void setStateSmc(StateSmc stateSmc) {
		this.stateSmc = stateSmc;
	}

	public List<UserCipRoleCip> getUserCipRoleCips() {
		return this.userCipRoleCips;
	}

	public void setUserCipRoleCips(List<UserCipRoleCip> userCipRoleCips) {
		this.userCipRoleCips = userCipRoleCips;
	}

	public UserCipRoleCip addUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		getUserCipRoleCips().add(userCipRoleCip);
		userCipRoleCip.setRoleCip(this);

		return userCipRoleCip;
	}

	public UserCipRoleCip removeUserCipRoleCip(UserCipRoleCip userCipRoleCip) {
		getUserCipRoleCips().remove(userCipRoleCip);
		userCipRoleCip.setRoleCip(null);

		return userCipRoleCip;
	}

}