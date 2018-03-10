package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IMenuRoleDao;
import co.com.novatech.smc.modelo.MenuRole;

@Stateless
public class MenuRoleLogic implements IMenuRoleLogic {

	@EJB
	private IMenuRoleDao menuRoleDao;

	 
	public void saveMenuRole(MenuRole entity) throws Exception {

	}

	 
	public void updateMenuRole(MenuRole entity) throws Exception {

	}

	 
	public void deleteMenuRole(MenuRole entity) throws Exception {

	}

	 
	@TransactionAttribute
	public MenuRole findByIidMenuRole(Long idMenu) {

		return menuRoleDao.findMenuRoleById(idMenu);
	}

	 
	@TransactionAttribute
	public List<MenuRole> findAllMenuRole() {

		return menuRoleDao.getMenuRoleFindAll();
	}

}
