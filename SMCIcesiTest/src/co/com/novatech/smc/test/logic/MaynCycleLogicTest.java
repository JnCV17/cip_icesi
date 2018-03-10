package co.com.novatech.smc.test.logic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.logic.IMainCycleLogic;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;

public class MaynCycleLogicTest {

	private static IMainCycleLogic mainCycleDaoRemote;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			mainCycleDaoRemote = (IMainCycleLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IMAINCYCLELOGIC);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void aFindAll() {

		try {

			List<MainCycle> ciclos = mainCycleDaoRemote.findAllMainCycles();

			for (MainCycle mainCycle : ciclos) {

				System.out.println(mainCycle.getCycleName());
			}
		} catch (EJBException e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void bFindById(){
		
		try {
			
			MainCycle ciclo = mainCycleDaoRemote.findByIdCycle(1);
			
			assertEquals("Main Sistemas1", ciclo.getCycleName());
			
		} catch (EJBException e) {
			
		}
		
	}
	
	

}
