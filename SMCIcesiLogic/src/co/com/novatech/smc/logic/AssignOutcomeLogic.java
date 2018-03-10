package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.novatech.smc.exceptions.ZMessManager;
import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.RoleCip;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.modelo.UserCipRoleCip;

@Stateless
public class AssignOutcomeLogic implements IAssignOutcomeLogic {

	@EJB
	private IOutcomeLogic outcomeLogic;

	@EJB
	private IUserCipLogic userCipLogic;

	@EJB
	private IRoleCipLogic roleCipLogic;

	@EJB
	private IUserCipRoleCipLogic userRolLogic;

	@EJB
	private IAlertsManagement alertsManagement;

	private static final int PROFESOR = 4;
	private static final int LIDER_OUTCOME = 1;
	private static final int DIRECTOR_PROGRAMA = 2;
	private static final int MECA = 3;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void unassignOutcome(Outcome outcome) throws Exception {
		UserCip userCip = outcome.getUserCip();
		outcome.setUserCip(null);
		outcomeLogic.updateOutcome(outcome);

		List<Outcome> losOutcome = outcomeLogic.findOutcomeByUser(userCip.getIdUser());

		if (losOutcome == null) {
			List<UserCipRoleCip> user = userRolLogic.findAllUserCipRoleCip();
			for (UserCipRoleCip userRol : user) {
				if (userRol.getUserCip().getIdUser() == userCip.getIdUser()) {
					userRolLogic.removeUserCipRoleCip(userRol);
				}
			}
		}

	}

	public boolean isProfesor(UserCip user) {
		List<RoleCip> roles = userRolLogic.findRoleByUser(user.getIdUser());
		boolean encontrado = false;
		for (int i = 0; i < roles.size() && !encontrado; i++) {
			if (roles.get(i).getIdRole() == PROFESOR) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public boolean isLiderOutcome(UserCip user) {
		List<RoleCip> roles = userRolLogic.findRoleByUser(user.getIdUser());
		boolean encontrado = false;
		for (int i = 0; i < roles.size() && !encontrado; i++) {
			if (roles.get(i).getIdRole() == LIDER_OUTCOME) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public boolean isDirectorPrograma(UserCip user) {
		List<RoleCip> roles = userRolLogic.findRoleByUser(user.getIdUser());
		boolean encontrado = false;
		for (int i = 0; i < roles.size() && !encontrado; i++) {
			if (roles.get(i).getIdRole() == DIRECTOR_PROGRAMA) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	public boolean isMECA(UserCip user) {
		List<RoleCip> roles = userRolLogic.findRoleByUser(user.getIdUser());
		boolean encontrado = false;
		for (int i = 0; i < roles.size() && !encontrado; i++) {
			if (roles.get(i).getIdRole() == MECA) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void toAssignOutcome(Outcome outcome, UserCip userCIp) throws Exception {

		UserCip user = userCipLogic.findByIdUser(userCIp.getIdUser());
		if (user == null) {
			throw new ZMessManager().new NullEntityExcepcion("userCip");
		}

		boolean encontrado = isProfesor(user);

		if (encontrado) {
			if (outcome.getUserCip() != null) {
				alertsManagement.envioCorreoDesasignacionOutcome(outcome.getProgramSmc().getIdProgram(),
						outcome.getIdStOutcome(), outcome.getUserCip().getIdUser());
			}

			outcome.setUserCip(userCIp);
			outcomeLogic.updateOutcome(outcome);

			if (userRolLogic.findByUserAndRole(userCIp.getIdUser(), LIDER_OUTCOME) == null
					|| userRolLogic.findByUserAndRole(userCIp.getIdUser(), LIDER_OUTCOME).size() == 0) {
				UserCipRoleCip userRol = new UserCipRoleCip();

				userRol.setUserCip(userCIp);
				userRol.setRoleCip(roleCipLogic.findByIdRoleCip(LIDER_OUTCOME));
				userRolLogic.saveUserCipRoleCip(userRol);
			}
		}

	}

}
