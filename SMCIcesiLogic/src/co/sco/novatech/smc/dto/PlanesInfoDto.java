package co.sco.novatech.smc.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.novatech.smc.logic.IMainCycleLogic;
import co.com.novatech.smc.logic.IOutcomeCycleALogic;
import co.com.novatech.smc.logic.IOutcomeLogic;
import co.com.novatech.smc.logic.IPlanLogic;
import co.com.novatech.smc.logic.IUserCipLogic;
import co.com.novatech.smc.modelo.MainCycle;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.OutcomeCycleA;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.ProgramSmc;

/**
 * Session Bean implementation class PlanesInfo
 */
@Stateless
public class PlanesInfoDto implements IPlanesInfoDto {

	public String nombreplan;
	public String liderOutcome;
	public String fechaCreacion;
	public String estadoPlan;
	public String programa;
	public String ciclo;
	public String subciclo;
	public PlanSmc plan;
	public String idPlan;

	@EJB
	private IPlanLogic planLogic;
	@EJB
	private IMainCycleLogic mainCycleLogic;
	@EJB
	private IOutcomeCycleALogic outcomeCycleALogic;
	@EJB
	private IOutcomeLogic outcomeLogic;
	@EJB
	private IUserCipLogic userCipLogic;

	public PlanesInfoDto() {

	}

	public List<PlanesInfoDto> cargaInformacionPlanes(ProgramSmc programa, MainCycle ciclo, MainCycle subciclo) {

		List<PlanSmc> planes = planLogic.findAll();
		List<PlanesInfoDto> planesInfo = new ArrayList();

		for (PlanSmc planSmc : planes) {
			PlanesInfoDto infoPlanes = new PlanesInfoDto();
			try {
				OutcomeCycleA outcomeCycleA = planSmc.getOutcomeCycleA();
				Outcome outcome = outcomeCycleA.getOutcome();
				if (programa != null) {
					if (outcome.getProgramSmc().getIdProgram().equals(programa.getIdProgram())) {

						if (ciclo != null) {
							if (outcomeCycleA.getMainCycle().getMainCycle().getIdCycle() == ciclo.getIdCycle()) {
								if (subciclo != null) {
									if (outcomeCycleA.getMainCycle().getIdCycle() == subciclo.getIdCycle()) {
										
										infoPlanes.setPlan(planSmc);
										Long idP = planSmc.getIdPlan();
										infoPlanes.setIdPlan(idP.toString());
										infoPlanes.setNombreplan(outcome.getShortDescription());
										infoPlanes.setFechaCreacion(planSmc.getCreationDate().toString());
										infoPlanes.setSubciclo(outcomeCycleA.getMainCycle().getCycleName());
										infoPlanes.setCiclo(outcomeCycleA.getMainCycle().getMainCycle().getCycleName());
										infoPlanes.setPrograma(outcome.getProgramSmc().getNameProgram());
										infoPlanes.setLiderOutcome(outcome.getUserCip().getNameUser());
										infoPlanes.setEstadoPlan(planSmc.getStateSmc().getStateName());
										planesInfo.add(infoPlanes);

									}

								} else {

									infoPlanes.setPlan(planSmc);
									Long idP = planSmc.getIdPlan();
									infoPlanes.setIdPlan(idP.toString());
									infoPlanes.setNombreplan(outcome.getShortDescription());
									infoPlanes.setFechaCreacion(planSmc.getCreationDate().toString());
									infoPlanes.setSubciclo(outcomeCycleA.getMainCycle().getCycleName());
									infoPlanes.setCiclo(outcomeCycleA.getMainCycle().getMainCycle().getCycleName());
									infoPlanes.setPrograma(outcome.getProgramSmc().getNameProgram());
									infoPlanes.setLiderOutcome(outcome.getUserCip().getNameUser());
									infoPlanes.setEstadoPlan(planSmc.getStateSmc().getStateName());
									planesInfo.add(infoPlanes);
								}

							}

						} else {

							infoPlanes.setPlan(planSmc);
							Long idP = planSmc.getIdPlan();
							infoPlanes.setIdPlan(idP.toString());
							infoPlanes.setNombreplan(outcome.getShortDescription());
							infoPlanes.setFechaCreacion(planSmc.getCreationDate().toString());
							infoPlanes.setSubciclo(outcomeCycleA.getMainCycle().getCycleName());
							infoPlanes.setCiclo(outcomeCycleA.getMainCycle().getMainCycle().getCycleName());
							infoPlanes.setPrograma(outcome.getProgramSmc().getNameProgram());
							infoPlanes.setLiderOutcome(outcome.getUserCip().getNameUser());
							infoPlanes.setEstadoPlan(planSmc.getStateSmc().getStateName());

							planesInfo.add(infoPlanes);
						}

					}

				} else {

					if (ciclo != null) {
						if (outcomeCycleA.getMainCycle().getMainCycle().getIdCycle() == ciclo.getIdCycle()) {
							if (subciclo != null) {
								if (outcomeCycleA.getMainCycle().getIdCycle() == subciclo.getIdCycle()) {

									infoPlanes.setPlan(planSmc);
									Long idP = planSmc.getIdPlan();
									infoPlanes.setIdPlan(idP.toString());
									infoPlanes.setNombreplan(outcome.getShortDescription());
									infoPlanes.setFechaCreacion(planSmc.getCreationDate().toString());
									infoPlanes.setSubciclo(outcomeCycleA.getMainCycle().getCycleName());
									infoPlanes.setCiclo(outcomeCycleA.getMainCycle().getMainCycle().getCycleName());
									infoPlanes.setPrograma(outcome.getProgramSmc().getNameProgram());
									infoPlanes.setLiderOutcome(outcome.getUserCip().getNameUser());
									infoPlanes.setEstadoPlan(planSmc.getStateSmc().getStateName());
									planesInfo.add(infoPlanes);

								}

							} else {

								infoPlanes.setPlan(planSmc);
								Long idP = planSmc.getIdPlan();
								infoPlanes.setIdPlan(idP.toString());
								infoPlanes.setNombreplan(outcome.getShortDescription());
								infoPlanes.setFechaCreacion(planSmc.getCreationDate().toString());
								infoPlanes.setSubciclo(outcomeCycleA.getMainCycle().getCycleName());
								infoPlanes.setCiclo(outcomeCycleA.getMainCycle().getMainCycle().getCycleName());
								infoPlanes.setPrograma(outcome.getProgramSmc().getNameProgram());
								infoPlanes.setLiderOutcome(outcome.getUserCip().getNameUser());
								infoPlanes.setEstadoPlan(planSmc.getStateSmc().getStateName());
								planesInfo.add(infoPlanes);
							}

						}

					}

				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return planesInfo;

	}
	
	public PlanSmc getPlan(){
		return plan;
	}
	
	public void setPlan(PlanSmc plan){
		this.plan = plan;
	}

	public String getNombreplan() {
		return nombreplan;
	}

	public void setNombreplan(String nombreplan) {
		this.nombreplan = nombreplan;
	}

	public String getLiderOutcome() {
		return liderOutcome;
	}

	public void setLiderOutcome(String liderOutcome) {
		this.liderOutcome = liderOutcome;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstadoPlan() {
		return estadoPlan;
	}

	public void setEstadoPlan(String estadoPlan) {
		this.estadoPlan = estadoPlan;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getSubciclo() {
		return subciclo;
	}

	public void setSubciclo(String subciclo) {
		this.subciclo = subciclo;
	}

	/**
	 * @return the idPlan
	 */
	public String getIdPlan() {
		return idPlan;
	}

	/**
	 * @param idPlan the idPlan to set
	 */
	public void setIdPlan(String idPlan) {
		this.idPlan = idPlan;
	}

}
