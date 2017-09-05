package dev.paie.service;

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

	// @Autowired(required = true)
	// private PaieUtils paieUtils;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade

//		DataSource dataSource;
		gradeService.sauvegarder(nouveauGrade);

		System.out.println("1 : "+gradeService.lister());

		nouveauGrade=gradeService.lister().get(0);
		nouveauGrade.setCode("B12");
		gradeService.mettreAJour(nouveauGrade);
		System.out.println("2 : "+gradeService.lister());
	}
}
