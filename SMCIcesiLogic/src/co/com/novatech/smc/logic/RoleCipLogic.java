package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IRoleCIPDao;
import co.com.novatech.smc.modelo.RoleCip;

@Stateless
public class RoleCipLogic implements IRoleCipLogic {

	@EJB
	private IRoleCIPDao roleCipDao;

	@TransactionAttribute
	public RoleCip findByIdRoleCip(long idRole) {
		return roleCipDao.findByIdRoleCip(idRole);
	}

	@TransactionAttribute
	public List<RoleCip> findAllRole() {
		return roleCipDao.getRoleCipFindAll();
	}

}
