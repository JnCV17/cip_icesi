package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.com.novatech.smc.modelo.Period;

@Remote
public interface IPeriodLogic {

	public Period findById(long idPeriod);

	public List<Period> findAll();

	public Period findByIdPeriod(long periodId) throws Exception;

	/**
	 * 
	 * @param date
	 *            fecha para saber que semestre es
	 * @return 10 si la fecha es de los primeros 6 meses, 20 en caso contrario
	 */
	public String whatSemesterIsDate(Date date);

	public BigDecimal periodToPlan();

}
