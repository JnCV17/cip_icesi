package co.com.novatech.smc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.Method;
import co.com.novatech.smc.modelo.PiSmc;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.UserCip;

@ManagedBean(name = "subtableC")
public class SubtableController {

	private List<PlanSmc> lista1;

	public List<PlanSmc> getLista1() {
		return lista1;
	}

	public void setLista1(List<PlanSmc> lista1) {
		this.lista1 = lista1;
	}

	@PostConstruct
	public void init() {

		lista1 = new ArrayList<PlanSmc>();
		PlanSmc plan = new PlanSmc();
		plan.setIdPlan(001);
		plan.setPiSmcs(new ArrayList<PiSmc>());
		plan.setEvaluationDate(new Date());
		UserCip usuario = new UserCip();
		usuario.setNameUser("Aguirre");
		plan.setUserCip(usuario);
		for (int i = 0; i < 2; i++) {
			PiSmc pi = new PiSmc();
			pi.setCode("Pi numero-" + i);
			pi.setDescription("Este es el nuevo pi");
			plan.getPiSmcs().add(pi);
			plan.setEvaluationFrequency("Anual");
		}
		List<PiSmc> pis = plan.getPiSmcs();
		List<AsSrc> fuentes = new ArrayList<AsSrc>();
		for (int i = 0; i < 5; i++) {
			AsSrc fuente = new AsSrc();
			Method metodo = new Method();
			metodo.setDescription("Este es el metodo:" + i + "");
			fuente.setIdAsSrc((i + 14));
			fuente.setCollectionDate(new Date());
			fuente.setMethod(metodo);
			fuentes.add(fuente);
		}

		pis.get(0).setAsSrcs(fuentes);

		pis.get(1).setAsSrcs(fuentes);
		lista1.add(plan);

	}

}
