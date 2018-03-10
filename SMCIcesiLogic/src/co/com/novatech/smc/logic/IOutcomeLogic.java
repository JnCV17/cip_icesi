package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Outcome;
import co.com.novatech.smc.modelo.ProgramSmc;

@Remote
public interface IOutcomeLogic {

	/**
	 * Método que actualiza un Student Outcome
	 * 
	 * @param outcome,
	 *            Outcome que se va a actualizar
	 * @throws Exception
	 *             Si el outcome es nulo, si el criterio, la descripción la
	 *             descripción corta son nulos. Si el programa asociado es nulo,
	 *             si el estado del outcome es nulo, si el Ciclo asociado es
	 *             nulo
	 */
	public void updateOutcome(Outcome outcome) throws Exception;

	/**
	 * Busca un outcome por id
	 * 
	 * @param id
	 *            el id del outcome a buscar
	 * @return
	 * 
	 */
	public Outcome findbyId(long id);

	/**
	 * Método que retorna una Lista de todos los Students Outcome dentro del
	 * sistema
	 * 
	 * @return
	 */
	public List<Outcome> findAllOutcome();

	/**
	 * Busca los outcomes de un programa
	 * 
	 * @param programa
	 * @return la lista de outcomes
	 */
	public List<Outcome> findOutcomeByProgram(ProgramSmc programa) throws Exception;

	/**
	 * 
	 * @param idUser
	 *            usuario quien tiene los outcoems
	 * @return todos los outcomes del usuario sin importar programa
	 */
	public List<Outcome> findOutcomesByProgram(String idProgram);

	public List<Outcome> findOutcomeByUser(long idUser);

	public List<Outcome> findOutcomeByStateAndUser(long idState, String idProgram);
}
