package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.novatech.smc.dao.ICdioSkillPiDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.CdioSkillPi;

@Stateless
public class CdioSkillPiLogic implements ICdioSkillPiLogic {

	@EJB
	private ICdioSkillPiDao cdioSkillPiDao;

	public void saveCdioSkillPiLogic(CdioSkillPi cdioSkillPi) throws Exception {
		if (cdioSkillPi == null) {
			throw new ZMessManager().new NullEntityExcepcion("CdioSkillPi");
		}
		if (cdioSkillPi.getCdioSkill() == null) {
			throw new ZMessManager().new NullEntityExcepcion("CdioSkill");
		}
		if (cdioSkillPi.getPiSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Pi");
		}
		cdioSkillPiDao.persistCdioSkillPi(cdioSkillPi);
	}

	public CdioSkillPi findByIdCdioSkillPi(long cdioSkillPi) {

		return cdioSkillPiDao.findByIdCdioSkillPi(cdioSkillPi);
	}

	public List<CdioSkillPi> findAllCdioSkillPi() {

		return cdioSkillPiDao.getCdioSkillPiFindAll();
	}

}
