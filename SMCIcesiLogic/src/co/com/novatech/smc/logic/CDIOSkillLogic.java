package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.ICdioSkillDao;
import co.com.novatech.smc.modelo.CdioSkill;

@Stateless
public class CDIOSkillLogic implements ICDIOSkillLogic {

	@EJB
	private ICdioSkillDao cdioSkillDao;

	@TransactionAttribute
	public CdioSkill findByIdCdioSkill(long cdioSkill) {

		return cdioSkillDao.findByIdCdioSkill(cdioSkill);
	}

	@TransactionAttribute
	public List<CdioSkill> findAllCdioSkill() {
		return cdioSkillDao.getCdioSkillFindAll();
	}

	public List<CdioSkill> findAllCdioByPi(long idPi) {
		return cdioSkillDao.findAllCdioSkillByPi(idPi);
	}

	@TransactionAttribute
	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2) {
		return cdioSkillDao.findAllCdioSkillLevel3ByLevel2(idCdioSkillLevel2);
	}

}
