package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.ICdioOutcomeMtxDao;
import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;

@Stateless
public class CDIOOutcomeMtxLogic implements ICDIOOutcomeMtxLogic {

	@EJB
	private ICdioOutcomeMtxDao cdioOutcomeMtxDao;

	@TransactionAttribute
	public CdioOutcomeMtx findByIdCdioOutcomeMtx(long cdioOutcomeMtx) {

		return cdioOutcomeMtxDao.findByIdCdioOutcomeMtx(cdioOutcomeMtx);
	}

	@TransactionAttribute
	public List<CdioOutcomeMtx> findAllCdioOutcomeMtx() {

		return cdioOutcomeMtxDao.getCdioOutcomeMtxFindAll();
	}

	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd) {
		return cdioOutcomeMtxDao.findAllCdioSkillByOutcome(idStd);
	}

}
