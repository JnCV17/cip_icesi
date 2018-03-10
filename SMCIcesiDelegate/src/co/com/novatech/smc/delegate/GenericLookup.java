package co.com.novatech.smc.delegate;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GenericLookup {

	Properties props;

	public GenericLookup() {
		getProperties();
	}

	public Object lookupLogic(String name) {
		Object clase = null;
		String path = "java:global/SMCIcesi/SMCIcesiLogic/";
		String path2 = "!co.com.novatech.smc.logic.";
		try {
			clase = new InitialContext(props).lookup(path + name + path2 + "I" + name);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return clase;
	}

	public Object lookup2Logic(String cons) {
		Object clase = null;
		try {
			clase = new InitialContext(props).lookup(cons);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clase;
	}

	public IBusinessDelegate lookupDelegate() {
		IBusinessDelegate businessDelegate = null;
		try {
			businessDelegate = (IBusinessDelegate) new InitialContext(props).lookup(
					"java:global/SMCIcesi/SMCIcesiDelegate/BusinessDelegate!co.com.novatech.smc.delegate.IBusinessDelegate");

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return businessDelegate;

	}

	public String pruebita(String name) {
		String path = "java:global/SMCIcesi/SMCIcesiLogic/";
		String path2 = "!co.com.novatech.smc.logic.";
		return path + name + path2 + "I" + name;
	}

	private void getProperties() {
		props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		// optional. Defaults to localhost. Only needed if web server is running
		// on a different host than the appserver
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		// optional. Defaults to 3700. Only needed if target orb port is not
		// 3700.
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		// return props;
	}
}
