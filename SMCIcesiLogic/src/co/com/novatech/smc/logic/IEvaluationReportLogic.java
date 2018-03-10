package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;

@Remote
public interface IEvaluationReportLogic {

	public void saveEvalReport(EvalReport evalReport) throws Exception;

	// public void updateEvalReport(EvalReport evalReport) throws Exception;

	public List<EvalReport> findAllEvalReport();

	public EvalReport findByIdEvalReport(long idEvalReport);

	public void cambiarEstadoEvalReport(EvalReport evalReport, StateSmc estado, UserCip user) throws Exception;

	public List<EvalReport> findAllEvalCycleByProgramCycleSubcicle(ProgramSmc program, List<MainCycle> losCiclos,
			List<MainCycle> losSubciclos, MainCycle cycle);
	
	public void  validarDescarga(EvalReport eval)throws Exception;

	void updateEvalReport(EvalReport evalReport) throws Exception;

}
