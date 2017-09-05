package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.util.PaieUtils;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Autowired
	private Grade nouveauGrade;


	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade

//		{
//		//test présence en base
//		gradeService.sauvegarder(nouveauGrade);
//
//		nouveauGrade=gradeService.lister().get(0);			
//		nouveauGrade.setCode("B12");
//		
//		gradeService.mettreAJour(nouveauGrade);
//		}
		
		{//test insertion en base vide
			System.out.println(nouveauGrade);
			gradeService.sauvegarder(nouveauGrade);
			List<Grade> grades = gradeService.lister();
			System.out.println(grades);
			assertTrue(!grades.isEmpty());
			assertEquals(1, gradeService.lister().size());
		}
		
		{
			List<Grade> grades = gradeService.lister();
			if (!grades.isEmpty()) {
				Grade gradeUpdated = grades.get(0);
				gradeUpdated.setCode("YOU");
				gradeService.mettreAJour(gradeUpdated);
				System.out.println("1 : "+gradeUpdated);
				grades = gradeService.lister();
				System.out.println("2 : "+grades);
				assertTrue(gradeUpdated.equals(grades.get(0)));

			}
		}
		

	}
}
