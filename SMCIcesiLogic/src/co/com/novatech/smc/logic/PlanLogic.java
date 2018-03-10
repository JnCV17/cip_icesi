package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.dao.IAsSrcDao;
import co.com.novatech.smc.dao.ICdioSkillPiDao;
import co.com.novatech.smc.dao.IPiDao;
import co.com.novatech.smc.dao.IPlanDao;
import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.CdioSkill;
import co.com.novatech.smc.modelo.CdioSkillPi;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.StateSmc;
import co.com.novatech.smc.modelo.UserAsSrc;
import co.com.novatech.smc.modelo.UserCip;

@Stateless
public class PlanLogic implements IPlanLogic {

	public final static long ESTADO_APROBADO = 10L;

	public final static long ESTADO_INPROCESS = 11L;

	public final static long IN_DRAFT = 9;
	public final static long APPROVED = 10;
	public final static long IN_PROCESS = 11;
	public final static long COMPLETED = 12;
	public final static long TYPE_STATE_PLANES = 4;

	@EJB
	private IMainCycleLogic mainCycleLogic;
	@EJB
	private IProgramLogic programLogic;
	@EJB
	private IPlanLogic planLogic;
	@EJB
	private IPiLogic piLogic;
	@EJB
	private ICDIOSkillLogic cdioLogic;
	@EJB
	private IAsSrcDao asSrcDao;
	@EJB
	private IAssessmentPlanLogLogic assessmentPlanLogLogic;

	@EJB
	private IPlanDao planDao;

	@EJB
	private IStateTypeLogic stateType;

	@EJB
	private ICdioSkillPiDao cdioSkillPiDao;

	@EJB
	private IAsSrcDao fuenteDao;

	@EJB
	private IPiDao piDao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void savePlan(PlanSmc plan) throws Exception {
		if (plan == null) {
			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}
		// if (plan.getIdPlan() == 0L) {
		// throw new ZMessManager().new NotValidFormatException("Plan id");
		// }
		PlanSmc planPrueba = planDao.findByid(plan.getIdPlan());
		if (planPrueba != null) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		if (plan.getOutcomeCycleA() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Outcome cycle id");
		}

		if (plan.getOutcomeCycleA().getOutcome().getUserCip() == null) {
			throw new Exception("The plan doesnt have a leader of outcome");
		}

		if (plan.getOutcomeCycleA().getOutcome() == null) {
			throw new Exception("Please choose one outcome ");
		}
		if (planWasCreate(plan.getOutcomeCycleA().getIdOutcoCycle())) {
			throw new Exception("Plan is already exist");
		}

		// if (plan.getOutcomeCycleA().getOutcome().getIdStOutcome() > 0) {
		// throw new ZMessManager().new EmptyFieldException("Outcome");
		// }
		if (plan.getCreationDate() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Creation date");
		}
		if (plan.getPeriodIdPeriod() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Period id");
		}

		if (plan.getStateSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("State");
		}
		if (plan.getUserCip() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserCip id");
		}

		planDao.persistPlan(plan);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updatePlan(PlanSmc plan) throws Exception {

		if (plan.getCreationDate() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Creation date");
		}
		if (plan.getPeriodIdPeriod() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Period id");
		}

		if (plan.getOutcomeCycleA() == null) {
			throw new ZMessManager().new NullEntityExcepcion("Outcome cycle id");
		}
		if (plan.getStateSmc() == null) {
			throw new ZMessManager().new NullEntityExcepcion("State");
		}
		if (plan.getUserCip() == null) {
			throw new ZMessManager().new NullEntityExcepcion("UserCip id");
		}

		planDao.mergePlan(plan);

	}

	@TransactionAttribute
	public List<PlanSmc> findAll() {

		return planDao.getPlanFindAll();
	}

	@TransactionAttribute
	public PlanSmc findByid(long id) {

		return planDao.findByid(id);
	}

	@TransactionAttribute
	public List<PlanSmc> findByDateOfCreation(Date dateOfCreation) {

		return planDao.findByDateOfCreation(dateOfCreation);
	}

	public boolean planWasCreate(long idOutcomeCycleAs) {
		boolean isCreate = false;
		List<PlanSmc> losPlanes = planDao.getPlanFindAll();
		for (PlanSmc planSmc : losPlanes) {
			if (planSmc.getOutcomeCycleA().getIdOutcoCycle() == idOutcomeCycleAs) {
				isCreate = true;
				break;
			}
		}

		return isCreate;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPlanFromAnother(PlanSmc plan, UserCip user, StateSmc state, BigDecimal period, OutcomeCycleA out,
			Date fecha) throws Exception {
		PlanSmc newPlan = new PlanSmc();
		newPlan.setPeriodIdPeriod(period);
		newPlan.setOutcomeCycleA(out);
		newPlan.setStateSmc(state);
		newPlan.setCreationDate(fecha);
		newPlan.setUserCip(user);
		newPlan.setComplSrcs(plan.getComplSrcs());
		newPlan.setPiSmcs(plan.getPiSmcs());
		newPlan.setRubricFile(plan.getRubricFile());
		newPlan.setEvalCycles(plan.getEvalCycles());

		savePlan(newPlan);

	}

	public void validarDescarga(PlanSmc plan) throws Exception {

		if (plan == null) {

			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}

		if (plan.getRubricFile() == null) {

			throw new Exception("Plan haven't a rubric file");
		}

	}

	public void validarCarga(PlanSmc plan) throws Exception {

		if (plan == null) {

			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}

		StateSmc estado = plan.getStateSmc();

		if (estado.getIdState() != ESTADO_APROBADO) {

			throw new Exception("Plan is not approved");
		}

	}

	public void validarCargaEvidencia(PlanSmc plan) throws Exception {

		if (plan == null) {

			throw new ZMessManager().new NullEntityExcepcion("Plan");
		}

		StateSmc estado = plan.getStateSmc();

		if (estado.getIdState() != ESTADO_INPROCESS) {

			throw new Exception("You cannot update or delete files because this Plan is not In Process");
		}

	}

	public PlanSmc findPlanByOutcome(long idOutcome) {
		return planDao.findPlanByOutcome(idOutcome);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modifyAssessmentPlan(long idAssessmentPlan, PiSmc pi, CdioSkill competenciaCdio, Course cursoFuente,
			Method metodoAs, Date recoleccion, String frecuencia, UserCip profesor, Date evaluacion) throws Exception {

		PlanSmc plan = planDao.findByid(idAssessmentPlan);

		pi.setPlanSmc(plan);
		piDao.persistPi(pi);

		CdioSkillPi cdioSP = new CdioSkillPi();
		cdioSP.setCdioSkill(competenciaCdio);
		cdioSP.setPiSmc(pi);

		cdioSkillPiDao.persistCdioSkillPi(cdioSP);
		AsSrc fuente = new AsSrc();
		fuente.setCourse(cursoFuente);
		fuente.setMethod(metodoAs);
		fuente.setCollectionDate(recoleccion);
		fuente.setCollectionFrequency(frecuencia);

		UserAsSrc u = new UserAsSrc();
		u.setUserCip(profesor);
		u.setAsSrc(fuente);

		pi.setPlanSmc(plan);
		piDao.persistPi(pi);
		planDao.mergePlan(plan);

	}

	@TransactionAttribute
	public List<PlanSmc> filtrarPlanesPorPrograma(List<PlanSmc> planes, ProgramSmc programa) {

		List<PlanSmc> filtro = new ArrayList<PlanSmc>();

		for (PlanSmc assessmentPlan : planes) {

			ProgramSmc programa1 = assessmentPlan.getOutcomeCycleA().getOutcome().getProgramSmc();

			if (programa1.getIdProgram().equals(programa.getIdProgram())) {
				filtro.add(assessmentPlan);
			}
		}

		return filtro;
	}

	@TransactionAttribute
	public List<PlanSmc> filtrarPlanesPorOutcome(List<PlanSmc> planes, Outcome outcome) {

		List<PlanSmc> filtro = new ArrayList<PlanSmc>();

		for (PlanSmc assessmentPlan : planes) {

			Outcome outcome1 = assessmentPlan.getOutcomeCycleA().getOutcome();

			if (String.valueOf(outcome1.getIdStOutcome()).equals(String.valueOf(outcome.getIdStOutcome()))) {
				filtro.add(assessmentPlan);
			}
		}

		return filtro;

	}

	public void crearNuevoPlan(PlanSmc plan) throws Exception {
		planLogic.savePlan(plan);

	}

	public void cambiarEstadoPlanAssessment(PlanSmc plan, StateSmc estado, UserCip user) throws Exception {

		if (estado.getIdState() == COMPLETED) {
			if (plan.getStateSmc().getIdState() != IN_PROCESS) {
				throw new Exception("El plan de Assessment debe estar en in process");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationFrequency() == null || plan.getEvaluationFrequency().trim().equals("")) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getPiSmcs() == null || plan.getPiSmcs().size() == 0) {
				throw new Exception("Complete todos los campos");
			}
			Date fechaDeHoy = new Date();
			if (plan.getEvaluationDate().compareTo(fechaDeHoy) > 0) {
				throw new Exception(
						"El plan de Assessment puede cambiar a este estado después de la fecha de evaluación");
			}
			assessmentPlanLogLogic.guardarCambioEstado(
					"State plan have changed from" + plan.getStateSmc().getStateName() + " to" + estado.getStateName(),
					plan, user);
			plan.setStateSmc(estado);
		}
		if (estado.getIdState() == IN_PROCESS) {
			if (plan.getStateSmc().getIdState() != APPROVED) {
				throw new Exception("El plan de Assessment debe estar en in approved");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationFrequency() == null || plan.getEvaluationFrequency().trim().equals("")) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getPiSmcs() == null || plan.getPiSmcs().size() == 0) {
				throw new Exception("Complete todos los campos");
			}
			assessmentPlanLogLogic.guardarCambioEstado(
					"State plan have changed from" + plan.getStateSmc().getStateName() + " to" + estado.getStateName(),
					plan, user);
			plan.setStateSmc(estado);
		}
		if (estado.getIdState() == APPROVED) {
			if (plan.getStateSmc().getIdState() != IN_DRAFT) {
				throw new Exception("El plan de Assessment debe estar en in draft");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationDate() == null) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getEvaluationFrequency() == null || plan.getEvaluationFrequency().trim().equals("")) {
				throw new Exception("Complete todos los campos");
			}
			if (plan.getPiSmcs() == null || plan.getPiSmcs().size() == 0) {
				throw new Exception("Complete todos los campos");
			}

			List<PiSmc> pisPlan = piLogic.findAllPisByPlan(plan.getIdPlan());

			for (PiSmc pi : pisPlan) {
				List<AsSrc> asSrc = asSrcDao.findAllAsSrc(pi.getIdPi());

				for (AsSrc arsrc : asSrc) {
					if (arsrc.getCollectionDate() == null) {
						throw new Exception("Complete todos los campos");
					}
					if (arsrc.getCollectionFrequency() == null || arsrc.getCollectionFrequency().trim().equals("")) {
						throw new Exception("Complete todos los campos");
					}
					if (arsrc.getCourse() == null) {
						throw new Exception("Complete todos los campos");
					}
					if (arsrc.getEvideFiles() == null) {
						throw new Exception("Complete todos los campos");
					}
					if (arsrc.getMethod() == null) {
						throw new Exception("Complete todos los campos");
					}
					if (arsrc.getUserAsSrcs() == null) {
						throw new Exception("Complete todos los campos");
					}
				}
			}
			assessmentPlanLogLogic.guardarCambioEstado(
					"State plan have changed from" + plan.getStateSmc().getStateName() + " to" + estado.getStateName(),
					plan, user);
			plan.setStateSmc(estado);
			planLogic.updatePlan(plan);
		}
		if (estado.getIdState() == IN_DRAFT) {
			if (plan.getStateSmc().getIdState() != APPROVED) {
				throw new Exception("El plan de Assessment debe estar en approved");
			}
			assessmentPlanLogLogic.guardarCambioEstado(
					"State plan have changed from" + plan.getStateSmc().getStateName() + " to" + estado.getStateName(),
					plan, user);
			plan.setStateSmc(estado);
		}
		planLogic.updatePlan(plan);
	}

}
