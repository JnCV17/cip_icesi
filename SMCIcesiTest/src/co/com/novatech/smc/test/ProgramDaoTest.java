
package co.com.novatech.smc.test;

import javax.ejb.EJBException;

import org.junit.Test;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.test.util.LookUpClass;

public class ProgramDaoTest {

	private IBusinessDelegate programDaoRemote;

	@Test
	public void aBuscarProgram() {

		try {

			System.out.println(((IBusinessDelegate) LookUpClass.lookUp(programDaoRemote,
					"java:global/SMCIcesi/SMCIcesiDelegate/BusinessDelegate!co.com.novatech.smc.view.IBusinessDelegate"))
							.findProgramById("TEL").getNameProgram());

		} catch (EJBException e) {

			e.printStackTrace();
		}

	}

}
