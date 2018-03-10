package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IRubricFileDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.RubricFile;

@Stateless
public class RubricFileLogic implements IRubricFileLogic {

	@EJB
	private IRubricFileDao rubricFileDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveRubricFile(RubricFile rubric) throws Exception {

		if (rubric == null) {

			throw new ZMessManager().new NullEntityExcepcion("Rubric File");
		}

		RubricFile entity = rubricFileDao.findByIdRubric(rubric.getIdFile());

		if (entity != null) {

			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);

		}

		if (rubric.getFileName() == null || rubric.getFileName().trim().equals("")) {

			throw new ZMessManager().new NullEntityExcepcion("Name");
		}

		if (rubric.getDecription() == null || rubric.getDecription().trim().equals("")) {

			throw new ZMessManager().new NullEntityExcepcion("Description");

		}

		if (rubric.getFileRaw() == null) {

			throw new ZMessManager().new NullEntityExcepcion("File");
		}

		rubricFileDao.persistRubricFile(rubric);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateRubricFile(RubricFile rubric) throws Exception {

		if (rubric == null) {

			throw new ZMessManager().new NullEntityExcepcion("Rubric File");
		}

		if (rubric.getFileName() == null || rubric.getFileName().trim().equals("")) {

			throw new ZMessManager().new NullEntityExcepcion("Name");
		}

		if (rubric.getDecription() == null || rubric.getDecription().trim().equals("")) {

			throw new ZMessManager().new NullEntityExcepcion("Description");

		}

		if (rubric.getFileRaw() == null) {

			throw new ZMessManager().new NullEntityExcepcion("File");
		}

		rubricFileDao.mergeRubricFile(rubric);

	}

	 
	public void deleteRubricFile(RubricFile rubric) throws Exception {

	}

	@TransactionAttribute
	public List<RubricFile> findAllRubricFile() {

		return rubricFileDao.getRubricFileFindAll();
	}

	@TransactionAttribute
	public RubricFile findByIdRubricFile(long idRubricFile) {

		return rubricFileDao.findByIdRubric(idRubricFile);
	}

}
