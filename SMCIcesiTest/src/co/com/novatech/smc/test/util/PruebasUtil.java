package co.com.novatech.smc.test.util;
import java.util.Properties;

public class PruebasUtil {

	private Properties props;
	
	
	public PruebasUtil()
	{
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
	}
	
	public Properties getProperties()
	{
		return props;
	}

}
