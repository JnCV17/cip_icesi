package co.com.novatech.smc.dao;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvideFile;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IEvideFileDao {

	/**
	 * @generated DT_ID=none
	 */
	// Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public EvideFile persistEvideFile(EvideFile evideFile);

	/**
	 * @generated DT_ID=none
	 */
	public EvideFile mergeEvideFile(EvideFile evideFile);

	/**
	 * @generated DT_ID=none
	 */
	public void removeEvideFile(EvideFile evideFile);

	/**
	 * @generated DT_ID=none
	 */
	public List<EvideFile> getEvideFileFindAll();

	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc);

	public EvideFile getEvideFileById(long evideFileId);

}
