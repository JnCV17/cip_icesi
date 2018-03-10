package co.com.novatech.smc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_CIP_ROLE_CIP database table.
 * 
 */
@Entity
@Table(name="USER_CIP_ROLE_CIP")
@NamedQuery(name="UserCipRoleCip.findAll", query="SELECT u FROM UserCipRoleCip u")
public class UserCipRoleCip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_CIP_ROLE_CIP_IDUSERCIPROLE_GENERATOR", allocationSize = 1, sequenceName="SEQ_USER_CIP_ROLE_CIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_CIP_ROLE_CIP_IDUSERCIPROLE_GENERATOR")
	@Column(name="ID_USER_CIP_ROLE", unique=true, nullable=false)
	private long idUserCipRole;

	//bi-directional many-to-one association to RoleCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_CIP_ID_ROLE", nullable=false)
	private RoleCip roleCip;

	//bi-directional many-to-one association to UserCip
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_CIP_ID_USER", nullable=false)
	private UserCip userCip;

	public UserCipRoleCip() {
	}

	public long getIdUserCipRole() {
		return this.idUserCipRole;
	}

	public void setIdUserCipRole(long idUserCipRole) {
		this.idUserCipRole = idUserCipRole;
	}

	public RoleCip getRoleCip() {
		return this.roleCip;
	}

	public void setRoleCip(RoleCip roleCip) {
		this.roleCip = roleCip;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

}