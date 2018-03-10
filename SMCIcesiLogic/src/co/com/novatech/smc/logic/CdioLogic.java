package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.ICdioDao;
import co.com.novatech.smc.modelo.Cdio;

@Stateless
public class CdioLogic implements ICdioLogic {

	@EJB
	private ICdioDao cdioDao;

	@TransactionAttribute
	public Cdio findByIdCdio(long idCdio) {

		return cdioDao.findByIdCdio(idCdio);
	}

	@TransactionAttribute
	public List<Cdio> findAllCdio() {
		return cdioDao.getCdioFindAll();
	}

}
