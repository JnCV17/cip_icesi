package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.RubricFile;

@Remote
public interface IRubricFileLogic {

	public void saveRubricFile(RubricFile rubric) throws Exception;

	public void updateRubricFile(RubricFile rubric) throws Exception;

	public void deleteRubricFile(RubricFile rubric) throws Exception;

	public List<RubricFile> findAllRubricFile();

	public RubricFile findByIdRubricFile(long idRubricFile);

}
