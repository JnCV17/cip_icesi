package co.com.novatech.smc.test;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.IRoleCIPDao;
import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.modelo.*;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.LookUpClass;
import co.com.novatech.smc.test.util.PruebasUtil;


public class RoleDaoTest {
	
	
	private static IRoleCIPDao roleDaoRemote;
	
	
	private static IUserCipDao userCipDao;
	

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();
	
		try {
			roleDaoRemote = (IRoleCIPDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IROLECIPDAO);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void bconsultarRol() throws Exception {
		
		RoleCip rol= roleDaoRemote.findByIdRoleCip(3);
	
			System.out.println(rol.getIdRole() + " " + rol.getName());
			
	
		
	}
	
	@Test
	public void findAllRoles() throws Exception {
	
	List<RoleCip> all=  roleDaoRemote.getRoleCipFindAll();	
		
	for (int i = 0; i < all.size(); i++) {
		System.out.println(all.get(i).getName());
		}

	
	}
	
	

	

}
