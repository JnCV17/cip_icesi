package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IMenuDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.Menu;

@Stateless
public class MenuLogic implements IMenuLogic {

	@EJB
	private IMenuDao menuDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveMenu(Menu entity) throws Exception {

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateMenu(Menu entity) throws Exception {

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteMenu(Menu entity) throws Exception {

	}

	@TransactionAttribute
	public Menu findByIidMenu(Long idMenu) throws Exception {
		Menu menu = menuDao.findByIdMenu(idMenu);
		if (menu == null) {
			throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
		}

		return menu;
	}

	@TransactionAttribute
	public List<Menu> findAllMenus() throws Exception {
		return menuDao.getMenuFindAll();
	}

}
