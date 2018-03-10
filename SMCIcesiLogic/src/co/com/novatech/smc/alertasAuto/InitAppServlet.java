package co.com.novatech.smc.alertasAuto;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitAppServlet extends HttpServlet {

	private static IAlarmScheduler alarmScheduler;

	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			alarmScheduler = (IAlarmScheduler) new InitialContext(pruebasUtil.getProperties())
					.lookup(InfoLookUp.IALARMCHEDULER);

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Método que permite levantar el timer dentro del servidor para que se
	 * ejecute dentro de un intervalo determinado.
	 */
	public void init() throws ServletException {
		try {
			alarmScheduler.startUpTimer();
			// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
			// ENTRO AL INIT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// do nothing, only for initialization purposes
	}

}
