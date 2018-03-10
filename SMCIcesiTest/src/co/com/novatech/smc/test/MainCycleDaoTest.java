package co.com.novatech.smc.test;

import org.junit.Test;

import co.com.novatech.smc.logic.IMainCycleLogic;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.LookUpClass;

public class MainCycleDaoTest {

	private IMainCycleLogic mainCycleDaoRemote;

	@Test
	public void atest() {

		MainCycle ciclo = ((IMainCycleLogic) LookUpClass.lookUp(mainCycleDaoRemote, InfoLookUp.IMAINCYCLELOGIC))
				.findByIdCycle(6);
		System.out.println(ciclo.getCycleName());
		// for (MainCycle mainCycle : programas) {
		// System.out.println(mainCycle.getCycleName());
		// }

	}

}
