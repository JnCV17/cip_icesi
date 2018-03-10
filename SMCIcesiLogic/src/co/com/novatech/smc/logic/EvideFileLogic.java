package co.com.novatech.smc.logic;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IEvideFileDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.EvideFile;

@Stateless
public class EvideFileLogic implements IEvideFileLogic {
	
	@EJB
	private IEvideFileDao evideFileDao;

	 
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveEvideFile(EvideFile evideFile) throws Exception {
		
		if (evideFile == null) {

			throw new ZMessManager().new NullEntityExcepcion("EvideFile");
		}

		

		if (evideFile.getAsSrc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("Fuente de Assessment");
		}

		evideFileDao.persistEvideFile(evideFile);

		
	}

	 
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateEvideFile(EvideFile evideFile) throws Exception {

		if (evideFile == null) {

			throw new ZMessManager().new NullEntityExcepcion("EvideFile");
		}

		if (evideFile.getAsSrc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("Fuente de Assessment");
		}

		evideFileDao.mergeEvideFile(evideFile);
		
		
	}

	 
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteEvideFile(EvideFile evideFile) throws Exception {
		evideFileDao.removeEvideFile(evideFile);
		
	}

	 
	@TransactionAttribute
	public EvideFile findByIdEvideFile(long evideFileId) throws Exception {
		return evideFileDao.getEvideFileById(evideFileId);
	}

	 
	@TransactionAttribute
	public List<EvideFile> findAllEvideFiles() {
		return evideFileDao.getEvideFileFindAll();
	}

	 
	@TransactionAttribute
	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc) {
		return evideFileDao.getEvideFileFindByAsSrc(idAsSrc);

	}
}
