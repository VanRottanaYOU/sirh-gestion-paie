package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = {ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired 
	private CotisationService cotisationService;
	
	@Autowired
	private List<Cotisation> listeCotisation;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		{
			cotisationService.sauvegarder(listeCotisation.get(0));	
			System.out.println(cotisationService.lister());
			listeCotisation.get(0).setCode("VAN");
			cotisationService.mettreAJour(listeCotisation.get(0));
			System.out.println(cotisationService.lister());
		}
		{// test insertion en base
			System.out.println(listeCotisation);
			System.out.println(listeCotisation.get(0));
			cotisationService.sauvegarder(listeCotisation.get(0));
			List<Cotisation> cotisations = cotisationService.lister();
			System.out.println(cotisations);
			assertTrue(!cotisations.isEmpty());
			assertEquals(1, cotisationService.lister().size());
		}
		{
			List<Cotisation> cotisations = cotisationService.lister();
			if (!cotisations.isEmpty()) {
				Cotisation cotisationUpdated = cotisations.get(0);
				cotisationUpdated.setCode("YOU");
				cotisationService.mettreAJour(cotisationUpdated);
				System.out.println("1 : "+cotisationUpdated);
				cotisations = cotisationService.lister();
				System.out.println("2 : "+cotisations);
				assertTrue(cotisationUpdated.equals(cotisations.get(0)));

			}
		}
	
	}
}
