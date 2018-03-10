package co.com.novatech.smc.alertasAuto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import co.com.novatech.smc.dao.IAsSrcDao;
import co.com.novatech.smc.dao.IPiDao;
import co.com.novatech.smc.dao.IPlanDao;
import co.com.novatech.smc.logic.IAlertsManagement;
import co.com.novatech.smc.logic.IPlanLogic;
import co.com.novatech.smc.logic.IStateLogic;
import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.logic.PlanLogic;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.sco.novatech.smc.dto.PlanesInfoDto;

@Stateless
public class AlarmScheduler implements IAlarmScheduler {

	/** Hora de ejecución: 23 horas */
	private static final int START_HOUR = 6;

	/** Minutos de ejecución: 0 minutos */
	private static final int START_MINUTES = 14;

	/** Segundos de ejecución: 00 */
	private static final int START_SECONDS = 0;

	/** Intervalo de la ejecución: 1440 = 24 horas */
	private static final int INTERVAL_IN_MINUTES = 1440;

	@EJB
	private IAlertsManagement alertManagement;
	
	@EJB
	private IPlanDao planDao;
	@EJB
	private IPiDao piDao;
	@EJB
	private IAsSrcDao asSrcDao;
	@EJB
	private IPlanLogic planLogic;
	@EJB
	private IUserCipLogic userLogic;
	@EJB
	private IStateLogic stateLogic;

	@Resource
	TimerService timer;

	 
	public void startUpTimer() {
		System.out.println("------------------------------------------------------->ENTRO STAR TIMER");

		shutDownTimer();
		Calendar initialExpiration = Calendar.getInstance();
		initialExpiration.set(Calendar.HOUR_OF_DAY, START_HOUR);
		initialExpiration.set(Calendar.MINUTE, START_MINUTES);
		initialExpiration.set(Calendar.SECOND, START_SECONDS);

		long intervalDuration = new Integer(INTERVAL_IN_MINUTES).longValue() * 60 * 1000;

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++"
				+ "startUpTimer - create new timer service at \"" + initialExpiration.getTime() + "\", with \""
				+ intervalDuration + "\" interval in milis.");
		timer.createTimer(initialExpiration.getTime(), intervalDuration, null);

	}

	 
	public void shutDownTimer() {
		Collection<Timer> timers = timer.getTimers();
		System.out.println("shutDownTimer - existing timers? " + timers);
		if (timers != null) {
			for (Iterator iterator = timers.iterator(); iterator.hasNext();) {
				Timer t = (Timer) iterator.next();
				t.cancel();
				System.out.println("shutDownTimer - timer \"" + t + "\" canceled.");
			}
		}

	}

	@Timeout
	public void execute(Timer timer) throws Exception {
		System.out.println("executing - " + new Date());
		System.out
				.println("------------------------------------------------------------------------------>LANZO TIMER");
		
		alertManagement.envioCorreoEvidencias();
		alertManagement.envioCorreoEvaluacion();
		List<PlanSmc> planes=planesACambiarEstado();
		
		UserCip user=userLogic.findByIdUser(5001);
		StateSmc state=stateLogic.findById(PlanLogic.IN_PROCESS);
		for(PlanSmc plan : planes){
			planLogic.cambiarEstadoPlanAssessment(plan, state, user);
		}
		System.out.println("-------------------------------------------------------------------------->Proximo Timer: "
				+ timer.getNextTimeout());
	}


	
	private List<PlanSmc> planesACambiarEstado() {
		// TODO Auto-generated method stub
		
		List<PlanSmc> planes=planDao.findPlanStateApproved();
		ArrayList<PlanSmc> planesACambiar=new ArrayList<PlanSmc>();
		System.out
		.println("------------------------------------------------------------------------------>CAMBIO DE ESTADO AUTOMATICO"+planes.size());
		for(PlanSmc plan : planes){
			List<PiSmc> piS=piDao.findAllPisByPlan(plan.getIdPlan());
			boolean seCambia=false;
			
			for(PiSmc pi : piS){
				List<AsSrc> asSrcs=asSrcDao.findAllAsSrc(pi.getIdPi());
				
				for(AsSrc asSrc : asSrcs){
					Date date=new Date();
					if(asSrc.getCollectionDate().before(date)){
						seCambia=true;
						break;
					}
				}
				if(seCambia){
					break;
				}
			}
			if(seCambia){
				planesACambiar.add(plan);
			}
			
		}
		System.out
		.println("------------------------------------------------------------------------------>CAMBIO DE ESTADO AUTOMATICO "+planesACambiar.size());
		
		return planesACambiar;
	}
	

}
