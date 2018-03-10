package co.com.novatech.smc.test;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import co.com.novatech.smc.dao.ICdioCourseMtxDao;
import co.com.novatech.smc.modelo.CdioCourseMtx;
import co.com.novatech.smc.modelo.Course;
import co.com.novatech.smc.test.util.PruebasUtil;

public class CdioMtxCourseTest {

	private static ICdioCourseMtxDao cdioMtxDao;
	static {
		PruebasUtil pruebasUtil = new PruebasUtil();

		try {
			cdioMtxDao = (ICdioCourseMtxDao) new InitialContext(pruebasUtil.getProperties()).lookup(
					"java:global/SMCIcesi/SMCIcesiLogic/CdioCourseMtxDao!co.com.novatech.smc.dao.ICdioCourseMtxDao");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void test() {

		List<CdioCourseMtx> cursos = cdioMtxDao.findByCdio(9);

		for (CdioCourseMtx course : cursos) {

			System.out.println(course.getCourse().getNameCourse());
		}

	}

}
