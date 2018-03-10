package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioSkill;

@Remote
public interface ICDIOSkillLogic {

	public CdioSkill findByIdCdioSkill(long cdioSkill);

	public List<CdioSkill> findAllCdioSkill();

	public List<CdioSkill> findAllCdioByPi(long idPi);

	public List<CdioSkill> findAllCdioSkillLevel3ByLevel2(long idCdioSkillLevel2);
}
