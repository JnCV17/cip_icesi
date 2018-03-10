package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.CdioCourseMtx;

@Remote
public interface ICDIOCourseMtxLogic {

	// public void saveCDIOCourseMtx(CdioCourseMtx cdioCourseMtxLogic) throws
	// Exception;

	// public void updateCDIOCourseMtx(CdioCourseMtx cdioCourseMtxLogic) throws
	// Exception;

	public CdioCourseMtx findByIdCDIOCourseMtx(long cdioCourseMtx);

	public List<CdioCourseMtx> findAllCDIOCourseMtx();

	public List<CdioCourseMtx> findByCdio(long idCdioskill);

}
