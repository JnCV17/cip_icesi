package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IAsSrcDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Course;

@Stateless
public class AsSrcLogic implements IAsSrcLogic {

	@EJB
	private IAsSrcDao asSrcDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveAsSrc(AsSrc asSrc) throws Exception {

		if (asSrc == null) {

			throw new ZMessManager().new NullEntityExcepcion("AsSrc");
		}

		AsSrc entity = asSrcDao.findByIdAssessmentSource(asSrc.getIdAsSrc());

		if (entity != null) {

			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		if (asSrc.getPiSmc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("PI");
		}

		asSrcDao.persistAsSrc(asSrc);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateAsSrc(AsSrc asSrc) throws Exception {
		if (asSrc == null) {

			throw new ZMessManager().new NullEntityExcepcion("AsSrc");
		}

		if (asSrc.getPiSmc() == null) {

			throw new ZMessManager().new NullEntityExcepcion("PI");
		}

		asSrcDao.mergeAsSrc(asSrc);
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// public void deleteAsSrc(AsSrc asSrc) throws Exception {
	// asSrcDao.removeAsSrc(asSrc);
	//
	// }

	@TransactionAttribute
	public AsSrc findByIdAsSrc(long asSrcId) throws Exception {
		return asSrcDao.findByIdAssessmentSource(asSrcId);
	}

	@TransactionAttribute
	public List<Course> findAllAsSrc(long idPi) {
		return asSrcDao.findAllAsSrcDistinct(idPi);
	}

}
