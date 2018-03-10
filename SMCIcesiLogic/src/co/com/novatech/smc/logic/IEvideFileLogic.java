package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.EvideFile;

@Remote
public interface IEvideFileLogic {
	
	public void saveEvideFile(EvideFile evideFile) throws Exception;

	public void updateEvideFile(EvideFile evideFile) throws Exception;

	public void deleteEvideFile(EvideFile evideFile) throws Exception;

	public EvideFile findByIdEvideFile(long evideFileId) throws Exception;

	public List<EvideFile> findAllEvideFiles();
	
	public List<EvideFile> getEvideFileFindByAsSrc(long idAsSrc);
}
