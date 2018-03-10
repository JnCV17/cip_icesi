package co.com.novatech.smc.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.Test;
import co.com.novatech.smc.dao.IAsSrcDao;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class AsSrcDaoTest {

	
	private static  IAsSrcDao asSrcDaoRemote;
	
	
	static {
		PruebasUtil pruebasUtil = new PruebasUtil();
	
		try {
			asSrcDaoRemote = (IAsSrcDao) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IASSRCDAO);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}
	
	@Test
	public void aConsultarAssessmentSource() {
		
		try {
			System.out.println(asSrcDaoRemote.findByIdAssessmentSource(3L));	
		} catch (EJBException e) {
			
			e.printStackTrace();
		}
	
		
		
	}
	
	
	@Test
	public void bConsultarTodoAssessmentSource(){
		
		try {
			
			List<AsSrc> all = asSrcDaoRemote.getAsSrcFindAll();
			
			for (int i = 0; i <all.size() ; i++) {
				
				System.out.println(all.get(i).getIdAsSrc());
			}
			
		} catch (EJBException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
