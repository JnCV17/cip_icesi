package co.com.novatech.smc.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the USER_AS_SRC database table.
 * 
 */
@Entity
@Table(name = "USER_AS_SRC")
@NamedQuery(name = "UserAsSrc.findAll", query = "SELECT u FROM UserAsSrc u")
public class UserAsSrc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_AS_SRC_IDUSERASSRC_GENERATOR", allocationSize = 1, sequenceName = "SEQ_USER_AS_SRC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_AS_SRC_IDUSERASSRC_GENERATOR")
	@Column(name = "ID_USER_AS_SRC", unique = true, nullable = false, precision = 3)
	private long idUserAsSrc;

	// bi-directional many-to-one association to AsSrc
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AS_SRC_ID", nullable = false)
	private AsSrc asSrc;

	// bi-directional many-to-one association to UserCip
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SRC_USER_ID", nullable = false)
	private UserCip userCip;

	public UserAsSrc() {
	}

	public long getIdUserAsSrc() {
		return this.idUserAsSrc;
	}

	public void setIdUserAsSrc(long idUserAsSrc) {
		this.idUserAsSrc = idUserAsSrc;
	}

	public AsSrc getAsSrc() {
		return this.asSrc;
	}

	public void setAsSrc(AsSrc asSrc) {
		this.asSrc = asSrc;
	}

	public UserCip getUserCip() {
		return this.userCip;
	}

	public void setUserCip(UserCip userCip) {
		this.userCip = userCip;
	}

}