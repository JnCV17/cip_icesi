package co.com.novatech.smc.logic;

import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.ProgramSmc;

@Remote
public interface IProgramLogic {

	/**
	 * Método que busca un programa
	 * 
	 * @param programId,
	 *            id del programa que se va a buscar
	 * 
	 */
	public ProgramSmc findProgramById(String programId);

	/**
	 * Método que busca todas los programas
	 * 
	 * @return lista de todas los programas
	 * 
	 */
	public List<ProgramSmc> findAllProgramas();

	/**
	 * Buscar el programa por nombre, para la vista, ya que este solo conoce el
	 * text del nombre que se selecione
	 * 
	 * @param programId,
	 *            el nombre del programa
	 * @return retorna el programa
	 */
	public ProgramSmc findProgramByName(String programId);

	public List<ProgramSmc> getProgramFindbyDirector(long idUser);

}
