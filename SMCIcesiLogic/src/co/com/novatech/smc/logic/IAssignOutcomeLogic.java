package co.com.novatech.smc.logic;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.UserCip;

@Remote
public interface IAssignOutcomeLogic {

	/**
	 * M�todo que se desasigna un student Outcome a un usuario
	 * 
	 * @param outcome
	 *            Outcome al cual se le desasignara un usuario
	 *
	 * 
	 * @throws Exception
	 *             Si el student outcome no existe
	 */
	public void unassignOutcome(Outcome outcome) throws Exception;

	/**
	 * M�todo que asigna a un usuario como encargado de un Student Outcome. El
	 * usuario debe tener el rol de profesor
	 * 
	 * 
	 * @param outcome
	 *            Outcome a asignar
	 * @param userCIp
	 *            Usuario al que se le asginar� el outcome
	 *
	 * @throws Exception
	 *             Si el usuario no existe, si el outcome no existe, si el
	 *             usuario no es un profesor
	 */
	public void toAssignOutcome(Outcome outcome, UserCip userCIp) throws Exception;

	public boolean isProfesor(UserCip user);

	public boolean isLiderOutcome(UserCip user);

	public boolean isDirectorPrograma(UserCip user);

	public boolean isMECA(UserCip user);
}
