package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioSkillPi;

@Remote
public interface ICdioSkillPiLogic {

	public void saveCdioSkillPiLogic(CdioSkillPi cdioSkillPi) throws Exception;

	public CdioSkillPi findByIdCdioSkillPi(long cdioSkillPi);

	public List<CdioSkillPi> findAllCdioSkillPi();

}
