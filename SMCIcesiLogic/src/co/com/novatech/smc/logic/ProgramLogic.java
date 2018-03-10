package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IProgramDao;
import co.com.novatech.smc.modelo.ProgramSmc;

@Stateless
public class ProgramLogic implements IProgramLogic {

	@EJB
	private IProgramDao programDao;

	@TransactionAttribute
	public ProgramSmc findProgramById(String programId) {
		return programDao.findByIdProgram(programId);
	}

	@TransactionAttribute
	public ProgramSmc findProgramByName(String programName) {

		List<ProgramSmc> pro = programDao.getProgramFindAll();
		ProgramSmc progr = null;

		for (int i = 0; i < pro.size() && progr == null; i++) {
			if (pro.get(i).getNameProgram().equals(programName)) {
				progr = pro.get(i);
			}
		}
		return progr;
	}

	@TransactionAttribute
	public List<ProgramSmc> findAllProgramas() {
		return programDao.getProgramFindAll();
	}

	@TransactionAttribute
	public List<ProgramSmc> getProgramFindbyDirector(long idUser) {
		return programDao.getProgramFindbyDirector(idUser);
	}

}
