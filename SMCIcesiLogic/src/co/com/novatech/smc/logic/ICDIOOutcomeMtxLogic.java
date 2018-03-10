package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioOutcomeMtx;
import co.com.novatech.smc.modelo.CdioSkill;

@Remote
public interface ICDIOOutcomeMtxLogic {

	public CdioOutcomeMtx findByIdCdioOutcomeMtx(long cdioOutcomeMtx);

	public List<CdioOutcomeMtx> findAllCdioOutcomeMtx();

	public List<CdioSkill> findAllCdioSkillByOutcome(long idStd);

}
