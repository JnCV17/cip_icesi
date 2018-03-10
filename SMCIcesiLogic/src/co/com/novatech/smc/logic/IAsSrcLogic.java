package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Course;

@Remote
public interface IAsSrcLogic {

	public void saveAsSrc(AsSrc asSrc) throws Exception;

	public void updateAsSrc(AsSrc asSrc) throws Exception;

	// public void deleteAsSrc(AsSrc asSrc) throws Exception;

	public AsSrc findByIdAsSrc(long asSrcId) throws Exception;

	public List<Course> findAllAsSrc(long idPi);

}
