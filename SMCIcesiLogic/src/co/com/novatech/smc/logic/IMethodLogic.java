package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Method;

@Remote
public interface IMethodLogic {

	public Method findByIdMethod(long idmethod) throws Exception;

	public List<Method> findAllMethod();
}
