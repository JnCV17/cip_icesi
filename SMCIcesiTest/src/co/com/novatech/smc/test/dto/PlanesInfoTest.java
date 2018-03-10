package co.com.novatech.smc.test.dto;

import java.util.List;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.logic.IMainCycleLogic;
import co.com.novatech.smc.logic.IOutcomeCycleALogic;
import co.com.novatech.smc.logic.IProgramLogic;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.test.util.InfoLookUp;
import co.com.novatech.smc.test.util.PruebasUtil;
import co.sco.novatech.smc.dto.IPlanesInfoDto;
import co.sco.novatech.smc.dto.PlanesInfoDto;

public class PlanesInfoTest {

	private static IProgramLogic programalogicRemote;
	private static IPlanesInfoDto planDtoRemote;
	private static IOutcomeCycleALogic outcomeCycleRemote;
	private static IMainCycleLogic maynCycleRemote;
	
	
	


	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			programalogicRemote = (IProgramLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IPROGRAMLOGIC);
			planDtoRemote = (IPlanesInfoDto) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IPLANESINFODTO);
			outcomeCycleRemote = (IOutcomeCycleALogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IOUTCOMECYCLEALOGIC);
			maynCycleRemote= (IMainCycleLogic) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IMAINCYCLELOGIC);
					

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void cargaInformacionPlanesConPrograma(){
		
		
		try {
			
			
			ProgramSmc program = programalogicRemote.findProgramById("SIS");
			MainCycle cycle = maynCycleRemote.findByIdCycle(1);
			MainCycle subCycle = maynCycleRemote.findByIdCycle(5);
			System.out.println(program.getNameProgram());
			System.out.println(cycle.getCycleName());
			List<PlanesInfoDto> losPlanes =  planDtoRemote.cargaInformacionPlanes(program, cycle, subCycle);
			System.out.println(losPlanes==null);
			System.out.println(losPlanes.size());
			
			for (PlanesInfoDto planesInfoDto : losPlanes) {
				
				System.out.println(planesInfoDto.getNombreplan());
			}
			
			
		} catch (EJBException e) {
			
			e.printStackTrace(); 
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
