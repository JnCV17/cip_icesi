package co.com.novatech.smc.test.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LookUpClass {
	
	
	/**
	 * 
	 * @param InterfaceToLookUp interfaz a la que se le hara el lookup
	 * @param constantToLookUp constante que tiene la direccion del lookup sacada de la clase infolookup.getconstante
	 * @return el lookup
	 */
	public static Object lookUp(Object InterfaceToLookUp, String constantToLookUp){
		PruebasUtil pruebasUtil = new PruebasUtil();
	
		try {
			InterfaceToLookUp = (Object) new InitialContext(pruebasUtil.getProperties()).lookup(constantToLookUp)
					;

		} catch (NamingException e) {

			e.printStackTrace();
		}
		return InterfaceToLookUp;

	}

}
