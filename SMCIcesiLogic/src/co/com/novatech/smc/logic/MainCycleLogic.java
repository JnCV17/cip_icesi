package co.com.novatech.smc.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IMainCycleDao;
import co.com.novatech.smc.dao.IOutcomeCycleADao;
import co.com.novatech.smc.dao.IPlanDao;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PlanSmc;

@Stateless
public class MainCycleLogic implements IMainCycleLogic {
	@EJB
	private IMainCycleDao maincycleDao;
	@EJB
	private IPlanDao planDao;
	@EJB
	private IOutcomeCycleADao OutcomeCycleADao;

	@TransactionAttribute
	public MainCycle findByIdMainCycle(long idCycle) {

		return maincycleDao.findById(idCycle);
	}

	@TransactionAttribute
	public List<MainCycle> findAllMainCycles() {

		return maincycleDao.getMainCycleFindAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public MainCycle MaincycleConsult(Long idCiclo) {

		MainCycle mainCycle = maincycleDao.findById(idCiclo);
		return mainCycle;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<MainCycle> SubcycleConsult(MainCycle mainCycle) {

		List<MainCycle> Cycles = maincycleDao.getMainCycleFindAll();
		List<MainCycle> SubCycles = new ArrayList();

		Long idCycle = mainCycle.getIdCycle();
		boolean validacion = false;

		for (MainCycle mainCycle2 : Cycles) {

			MainCycle cycle = mainCycle2.getMainCycle();
			validacion = CycleValidate(cycle);
			if (validacion = true) {
				Long idCyleSubCycle = cycle.getMainCycle().getIdCycle();
				if (idCycle == idCyleSubCycle) {
					SubCycles.add(cycle);
				}
			}

		}
		return SubCycles;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean CycleValidate(MainCycle mainCycle) {

		Long cycle = mainCycle.getMainCycle().getIdCycle();
		boolean retorno = false;
		if (cycle != null) {

			retorno = false;
		} else {
			retorno = true;
		}

		return retorno;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PlanSmc> PlanConsult(List<MainCycle> subCycles) {

		List<OutcomeCycleA> outcomes = OutcomeCycleADao.getOutcomeCycleAFindAll();
		List<PlanSmc> planesFounded = null;
		Long idSubcycleOutcome = 0L;
		Long idSubcycle = 0L;
		for (OutcomeCycleA Outcomes : outcomes) {
			idSubcycleOutcome = Outcomes.getMainCycle().getIdCycle();

			for (MainCycle subCycles2 : subCycles) {
				idSubcycle = subCycles2.getIdCycle();

				if (idSubcycle == idSubcycleOutcome) {
					PlanSmc plan = planDao.findByid(Outcomes.getIdOutcoCycle());
					planesFounded.add(plan);
				}
			}
		}
		return planesFounded;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<MainCycle> CycleForProgram(String idProgram) {

		List<MainCycle> ciclos = findAllMainCycles();
		List<MainCycle> returnCiclos = new ArrayList();

		for (MainCycle mainCycle : ciclos) {

			if (mainCycle.getMainCycle() == null) {
				if (mainCycle.getProgramSmc().getIdProgram().equals(idProgram)) {
					returnCiclos.add(mainCycle);
				}
			}
		}
		return returnCiclos;

	}

	@TransactionAttribute
	public MainCycle findByIdCycle(long idCycle) {
		return maincycleDao.findById(idCycle);
	}

	@TransactionAttribute
	public List<MainCycle> findAllSubCycles() {
		List<MainCycle> all = findAllMainCycles();

		List<MainCycle> cycles = new ArrayList<MainCycle>();

		for (MainCycle mainCycle : all) {
			if (mainCycle.getMainCycle() != null) {
				cycles.add(mainCycle);
			}
		}

		return cycles;
	}

	@TransactionAttribute
	public List<MainCycle> findAllSubCyclesByMainCycle(long idMainCycle) {
		List<MainCycle> cycles = findAllSubCycles();

		List<MainCycle> filter = new ArrayList<MainCycle>();

		for (MainCycle cycle : cycles) {
			if (cycle.getMainCycle().getIdCycle() == idMainCycle) {
				filter.add(cycle);
			}
		}

		return filter;
	}

}
