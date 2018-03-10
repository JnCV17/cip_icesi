package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Cdio;

@Remote
public interface ICdioLogic {

	public Cdio findByIdCdio(long idCdio);

	public List<Cdio> findAllCdio();

}
