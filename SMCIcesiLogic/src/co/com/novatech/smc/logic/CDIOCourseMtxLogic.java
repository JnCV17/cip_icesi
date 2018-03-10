package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.ICdioCourseMtxDao;
import co.com.novatech.smc.modelo.CdioCourseMtx;

@Stateless
public class CDIOCourseMtxLogic implements ICDIOCourseMtxLogic {

	@EJB
	private ICdioCourseMtxDao cdioCourseMtxDao;

	// find course by CDIO skill
	// necesito que cuando seleccion un cdio skill automaticamente me aparezcan
	// los cursos
	//
	// findCourseByCdioSkill(long cdioSkill)

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<CdioCourseMtx> findAllCDIOCourseMtx() {

		return cdioCourseMtxDao.getCdioCourseMtxFindAll();
	}

	public CdioCourseMtx findByIdCDIOCourseMtx(long cdioCourseMtx) {

		return cdioCourseMtxDao.findByIdCDIOCourseMtx(cdioCourseMtx);
	}

	public List<CdioCourseMtx> findByCdio(long idCdioskill) {
		return cdioCourseMtxDao.findByCdio(idCdioskill);
	}

}
