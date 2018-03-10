package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.com.novatech.smc.dao.IOutcomeDao;
import co.com.novatech.smc.dao.IProgramDao;
import co.com.novatech.smc.dao.IUserCipDao;
import co.com.novatech.smc.modelo.Alert;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.EvalReport;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.ParamSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.UserCip;

@Stateless
public class AlertsManagementLogic implements IAlertsManagement {

	/** Hora de ejecución: 23 horas */
	private static final int START_HOUR = 15;

	/** Minutos de ejecución: 0 minutos */
	private static final int START_MINUTES = 55;

	/** Segundos de ejecución: 00 */
	private static final int START_SECONDS = 0;

	/** Intervalo de la ejecución: 1440 = 24 horas */
	private static final int INTERVAL_IN_MINUTES = 1;

	@EJB
	private IUserCipDao userCipDao;

	@EJB
	private IOutcomeDao outcomeDao;

	@EJB
	private IProgramDao programDao;

	@EJB
	private IUserCipLogic userCipLogic;

	@EJB
	private IOutcomeLogic outcomeLogic;

	@EJB
	private IProgramLogic programLogic;

	@EJB
	private IPlanLogic planLogic;

	@EJB
	private IAlertLogic alertLogic;

	@EJB
	private IAsSrcLogic asSrcLogic;

	@EJB
	private IParameterLogic parameterLogic;

	@Resource
	TimerService timer;

	@TransactionAttribute
	public void envioCorreoAsignacionOutcome(long idUsuario, String idProgram, long idStOutcome, long idUser) {

		UserCip userProfesor = userCipLogic.findByIdUser(idUser);

		Outcome outcome = outcomeLogic.findbyId(idStOutcome);

		ProgramSmc program = programLogic.findProgramById(idProgram);

		UserCip userSesion = userCipLogic.findByIdUser(idUsuario);

		String subject = "Asignación de outcome";

		String correo = userProfesor.getEmail();

		// String cuerpoCorreo = "Usted " + userProfesor.getNameUser() + "
		// perteneciente al programa "
		// + program.getNameProgram() + " ha sido asignado como lider del
		// outcome " + outcome.getCriterion()
		// + " - " + outcome.getShortDescription() + " por " +
		// userSesion.getNameUser();

		ParamSmc mensaje = parameterLogic.findParameterByName("AlertAsignacion");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", userProfesor.getNameUser());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{Outcome}", outcome.getCriterion() + " - " + outcome.getShortDescription());
		cuerpo = cuerpo.replace("{Autor}", userSesion.getNameUser());

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
			message.setSubject(subject);
			// message.setText(cuerpoCorreo);
			message.setText(cuerpo);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	@TransactionAttribute
	public void envioCorreoDesasignacionOutcome(String idProgram, long idStOutcome, long idUser) {

		UserCip user = userCipLogic.findByIdUser(idUser);

		Outcome outcome = outcomeLogic.findbyId(idStOutcome);

		ProgramSmc program = programLogic.findProgramById(idProgram);

		String subject = "Desasignación de outcome";

		String correo = user.getEmail();

//		String cuerpoCorreo = "Usted " + user.getNameUser() + " perteneciente al programa " + program.getNameProgram()
//				+ " ha sido desasignado como lider del outcome " + outcome.getCriterion() + " - "
//				+ outcome.getShortDescription();

		ParamSmc mensaje = parameterLogic.findParameterByName("AlertDesasignacion");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", user.getNameUser());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{Outcome}", outcome.getCriterion() + " - " + outcome.getShortDescription());

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
			message.setSubject(subject);
			message.setText(cuerpo);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void envioCorreoCambioEstadoPlanAsesssment(long idPlan, String idProgram) {

		PlanSmc planSmc = planLogic.findByid(idPlan);

		UserCip user = planSmc.getOutcomeCycleA().getOutcome().getUserCip();

		Outcome outcome = planSmc.getOutcomeCycleA().getOutcome();

		ProgramSmc program = programLogic.findProgramById(idProgram);

		String subject = "Cambio de estado de Plan de Assesment del outcome " + outcome.getCriterion();

		String correo = user.getEmail();

//		String cuerpoCorreo = "Estimad@ " + user.getNameUser()
//				+ ", le notificamos que el plan de assessment del outcome " + outcome.getCriterion() + " - "
//				+ outcome.getShortDescription() + " perteneciente al programa " + program.getNameProgram()
//				+ " del cual usted es líder ha sido actualizado al estado " + planSmc.getStateSmc().getStateName();

		ParamSmc mensaje = parameterLogic.findParameterByName("AlertCambioEstadoAssessment");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", user.getNameUser());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{Outcome}", outcome.getCriterion() + " - " + outcome.getShortDescription());
		cuerpo = cuerpo.replace("{State}", planSmc.getStateSmc().getStateName());

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject(subject);
			message.setText(cuerpo);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void envioCorreoFechaRecoleccionEvidencias(AsSrc fuente, String idProgram) {

		BigDecimal iduser = fuente.getUserCipIdUser();
		Long lo = iduser.longValue();
		UserCip user = userCipLogic.findByIdUser(lo);

		ProgramSmc program = programLogic.findProgramById(idProgram);

		Outcome outcome = fuente.getPiSmc().getPlanSmc().getOutcomeCycleA().getOutcome();
		String subject = "Carga de Recolección de de la fuente  " + fuente.getCourse().getNameCourse();
		String fechaRec = fuente.getCollectionDate().toString();
		String correo = user.getEmail();

		// String cuerpoCorreo = "Estimad@ " + user.getNameUser() + ", le
		// notificamos que la fuente de recolección "
		// + fuente.getCourse().getNameCourse() + " de el plan de assessment del
		// outcome " + outcome.getCriterion()
		// + " - " + outcome.getShortDescription() + "perteneciente al programa
		// " + program.getNameProgram()
		// + " del cual usted es encargado de recolección, tiene fecha limite el
		// día " + fechaRec;

		ParamSmc mensaje = parameterLogic.findParameterByName("AlertfechaRecoleccion");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", user.getNameUser());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{Outcome}", outcome.getCriterion() + " - " + outcome.getShortDescription());
		cuerpo = cuerpo.replace("{AssessmentSource}", fuente.getCourse().getNameCourse());
		cuerpo = cuerpo.replace("{Date}", fechaRec);

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject(subject);

			// message.setText(cuerpoCorreo);
			message.setText(cuerpo);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void envioCorreoFechaEvaluacion(PlanSmc planSmc) {
		UserCip user = planSmc.getUserCip();

		Outcome outcome = planSmc.getOutcomeCycleA().getOutcome();
		ProgramSmc program = planSmc.getOutcomeCycleA().getOutcome().getProgramSmc();

		String subject = "Carga de evaluación de Plan de Assesment del outcome " + outcome.getCriterion();

		String correo = user.getEmail();

		String fechaEval = planSmc.getEvaluationDate().toString();

//		String cuerpoCorreo = "Estimad@ " + user.getNameUser()
//				+ ", le notificamos que el plan de assessment del outcome " + outcome.getCriterion() + " - "
//				+ outcome.getShortDescription() + " perteneciente al programa " + program.getNameProgram()
//				+ " del cual usted es líder tiene fecha de evaluación el día " + fechaEval;

		ParamSmc mensaje = parameterLogic.findParameterByName("AlertfechaEvaluacion");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", user.getNameUser());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{Outcome}", outcome.getCriterion() + " - " + outcome.getShortDescription());
		cuerpo = cuerpo.replace("{Date}", fechaEval);

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject(subject);
			message.setText(cuerpo);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void envioCorreoEvidencias() {

		List<Alert> alertas = alertLogic.findAllAlert();

		if (alertas != null) {

			for (Alert alert : alertas) {
				if (alert.getStateSmc().getStateName().equals("Pendiente")
						&& alert.getAlertName().equals("Recoleccion")) {

					DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
					String fechaEnvio = df.format(alert.getDateAlert());
					String fechaActual = df.format(new Date());

					System.out.println("-------------------------------------------------->" + fechaEnvio);
					System.out.println("-------------------------------------------------->" + fechaActual);

					boolean estado = alert.getPlanSmc().getStateSmc().getStateName().equals("In Process");

					if (fechaEnvio.equals(fechaActual)) {

						PlanSmc plan = alert.getPlanSmc();
						try {
							AsSrc fuente = asSrcLogic.findByIdAsSrc(plan.getIdPlan());

							String programa = fuente.getPiSmc().getPlanSmc().getOutcomeCycleA().getOutcome()
									.getProgramSmc().getIdProgram().toString();
							envioCorreoFechaRecoleccionEvidencias(fuente, programa);
						} catch (Exception e) {

							e.printStackTrace();
						}

						System.out.println(
								"--------------------------------------------------------------------------------->ENVIO CORREOS EVIDENCIAS SATISFACTORIAMENTE");
					} else {
						System.out.println("---------------------------------------------------> NO ENVIÓ ALERTAS");
					}
				}
			}
		}

	}

	public void envioCorreoEvaluacion() {
		List<Alert> alertas = alertLogic.findAllAlert();
		if (alertas != null) {
			for (Alert alert : alertas) {
				if (alert.getStateSmc().getStateName().equals("Pendiente")
						&& alert.getAlertName().equals("Evaluacion")) {

					DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
					String fechaEnvio = df.format(alert.getDateAlert());
					String fechaActual = df.format(new Date());

					boolean estado = alert.getPlanSmc().getStateSmc().getStateName().equals("In Process");

					if (fechaEnvio.equals(fechaActual)) {
						envioCorreoFechaEvaluacion(alert.getPlanSmc());
						System.out.println(
								"--------------------------------------------------------------------------------->ENVIO CORREOS EVALUACION SATISFACTORIAMENTE");
					} else {
						System.out.println("---------------------------------------------------> NO ENVIÓ ALERTAS");
					}
				}
			}
		}

	}

	public Date calculoEnvioProximoCorreo(Date fecha) {
		// MÉTODO EN PROCESO
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String fechaUltimoCorreo = df.format(fecha);
		return new Date();
	}

	public Date calculoEnvioProximoCorreo(Date fecha, int semanas) {
		int dias = semanas * 7;
		Calendar calendar = toCalendar(fecha);
		calendar.add(Calendar.DATE, -dias);

		return new Date();
	}

	public Calendar toCalendar(Date fecha) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		return cal;
	}

	@Override
	public void envioCorreoCambioEstadoReporteDeEvaluacion(EvalReport idReporte) {

		// Estimad@ {Subject}, le notificamos que el reporte de evaluacion del
		// plan {Plan} perteneciente al programa {Program} del cual usted es
		// encargado ha sido actualizado al estado {State}

		long iduser = idReporte.getEvalCycle().getPlanSmc().getOutcomeCycleA().getOutcome().getUserCip().getIdUser();
		// Long lo = iduser.longValue();
		UserCip user = userCipLogic.findByIdUser(iduser);

		ProgramSmc program = programLogic.findProgramById(
				idReporte.getEvalCycle().getPlanSmc().getOutcomeCycleA().getOutcome().getProgramSmc().getIdProgram());

		Outcome outcome = idReporte.getEvalCycle().getPlanSmc().getOutcomeCycleA().getOutcome();

		String correo = user.getEmail();
		String subject = "Cambio estado reporte evaluación";
		ParamSmc mensaje = parameterLogic.findParameterByName("AlertCambioEstadoEvaluacion");
		String cuerpo = mensaje.getTextValue();

		cuerpo = cuerpo.replace("{Subject}", user.getNameUser());
		cuerpo = cuerpo.replace("{Plan}",
				"Plan de Assessment " + outcome.getCriterion() + " - " + outcome.getShortDescription());
		cuerpo = cuerpo.replace("{Program}", program.getNameProgram());
		cuerpo = cuerpo.replace("{State}", idReporte.getStateSmc().getStateName());

		final String username = "novatech.pi2@gmail.com";
		final String password = "integrador2";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("novatech.pi2@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject(subject);

			// message.setText(cuerpoCorreo);
			message.setText(cuerpo);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
