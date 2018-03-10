package co.com.novatech.smc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.ProgramSmc;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;
import co.com.novatech.smc.util.FacesUtils;

@ManagedBean(name = "AssignmentOutcomeController")
@SessionScoped
public class AssignmentOutcomeController {

	private static final int PROFESOR = 4;
	private static final int LIDER_OUTCOME = 1;
	private static final int DIRECTOR_PROGRAMA = 2;
	private static final int MECA = 3;

	@EJB
	private IBusinessDelegate businessDelegate;

	private ProgramSmc program;
	private Outcome outcome;
	private UserCip usuarioSesion;
	private UserCip profesor;

	private List<ProgramSmc> programs;
	private List<Outcome> outcomes;
	private List<Outcome> listaOutcomes;
	private List<UserCipRoleCip> usuariosRoles;
	private List<UserCip> profesores;

	public AssignmentOutcomeController() {

		this.program = null;
		this.outcome = null;
		this.profesor = null;
		this.listaOutcomes = new ArrayList<Outcome>();
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
	}

	public List<Outcome> getListaOutcomes() {
		return listaOutcomes;
	}

	public void setListaOutcomes(List<Outcome> listaOutcomes) {
		this.listaOutcomes = listaOutcomes;
	}

	public List<ProgramSmc> getPrograms() {
		int roles = 0;
		if (programs == null) {
			programs = new ArrayList<ProgramSmc>();

			UserCip usuarioDeSesion = getUsuarioSesion();

			List<RoleCip> listaRoles = businessDelegate.findRoleByUser(usuarioDeSesion.getIdUser());
			boolean usuarioMeca = false;
			for (RoleCip roleCip : listaRoles) {
				if (roleCip.getIdRole() == MECA) {
					roles = MECA;
				} else if (roleCip.getIdRole() == DIRECTOR_PROGRAMA) {
					roles = DIRECTOR_PROGRAMA;
				}
			}

			if (roles == MECA) {
				List<ProgramSmc> programas = businessDelegate.findAllProgramas();
				for (ProgramSmc programSmc : programas) {
					programs.add(programSmc);
				}
			}

			if (roles == DIRECTOR_PROGRAMA) {
				programs = businessDelegate.getProgramFindbyDirector(usuarioDeSesion.getIdUser());
			}
		}

		return programs;
	}

	public void setPrograms(List<ProgramSmc> programs) {
		this.programs = programs;
	}

	public ProgramSmc getProgram() {
		return program;
	}

	public void setProgram(ProgramSmc program) {
		this.program = program;
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	public List<UserCip> getProfesores() {

		if (profesores == null) {
			profesores = new ArrayList<UserCip>();
			List<UserCip> LosProfesores = businessDelegate.findUserByRole(PROFESOR);
			for (UserCip userCip : LosProfesores) {
				profesores.add(userCip);
			}
		}

		return profesores;
	}

	public void setProfesores(List<UserCip> profesores) {
		this.profesores = profesores;
	}

	public UserCip getProfesor() {
		return profesor;
	}

	public void setProfesor(UserCip profesor) {
		this.profesor = profesor;
	}

	public IBusinessDelegate getBusinessDelegate() {
		return businessDelegate;
	}

	public void setBusinessDelegate(IBusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	public UserCip getUsuarioSesion() {

		usuarioSesion = (UserCip) FacesUtils.getfromSession("usuarioSesion");

		return usuarioSesion;
	}

	public void setUsuarioSesion(UserCip usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public List<UserCipRoleCip> getUsuariosRoles() {

		if (usuariosRoles == null) {

			usuariosRoles = businessDelegate.findAllUserCipRoleCip();
		}

		return usuariosRoles;
	}

	public void setUsuariosRoles(List<UserCipRoleCip> usuariosRoles) {
		this.usuariosRoles = usuariosRoles;
	}

	public void listenerOutcomes() {

		if (program != null) {
			try {

				outcomes = businessDelegate.findOutcomeByStateAndUser(5L, program.getIdProgram());

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public void asignarOutcome() {
		usuarioSesion = getUsuarioSesion();
		if (outcome != null && profesor != null && program != null) {

			try {
				businessDelegate.toAssignOutcome(outcome.getIdStOutcome(), profesor.getIdUser());
				businessDelegate.envioCorreoAsignacionOutcome(usuarioSesion.getIdUser(), program.getIdProgram(),
						outcome.getIdStOutcome(), profesor.getIdUser());
			} catch (Exception e) {

				e.printStackTrace();
			}

			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El outcome " + outcome.getCriterion() + " ha sido asignado a " + profesor.getNameUser(), ""));

		} else {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos los campos son obligatorios", ""));

		}

	}

}
