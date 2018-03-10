package co.com.novatech.smc.logic;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import co.com.novatech.smc.dao.IPeriodDao;
import co.com.novatech.smc.modelo.Period;

@Stateless
public class PeriodLogic implements IPeriodLogic {

	@EJB
	private IPeriodDao periodDao;

	@TransactionAttribute
	public Period findById(long idPeriod) {

		return periodDao.findByIdPeriod(idPeriod);
	}

	@TransactionAttribute
	public List<Period> findAll() {

		return periodDao.getPeriodFindAll();
	}

	public Period findByIdPeriod(long periodId) throws Exception {

		return periodDao.findByIdPeriod(periodId);
	}

	public String whatSemesterIsDate(Date date) {
		String semester = "10";

		if (date.getMonth() > 6) {
			semester = "20";
		}
		return semester;
	}

	public BigDecimal periodToPlan() {
		Date fecha = new Date();
		String semester = whatSemesterIsDate(fecha);
		Calendar fe = Calendar.getInstance();
		String actualDate = Integer.toString(fe.get(Calendar.YEAR));
		BigDecimal period = new BigDecimal(actualDate + semester);
		return period;

	}
}
