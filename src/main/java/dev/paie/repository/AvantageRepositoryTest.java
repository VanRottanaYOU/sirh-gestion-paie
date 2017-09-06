package dev.paie.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	
	@Autowired 
	private AvantageRepository avantageRepository;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	//TODO sauvegarder un nouvel avantage
	//TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	//TODO modifier un avantage
	//TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
//		{
//			final Avantage avantage=new Avantage();		
//			avantage.setCode("TOTO");
//			avantage.setNom("VAN");
//			avantage.setMontant( new BigDecimal(20));
//			Avantage newAvantage=avantageRepository.save(avantage);
//			assertTrue(newAvantage.getId()>0);
//		}


		{
			Avantage avantageFound=avantageRepository.findById(20);	
			System.out.println("FindById : " +avantageFound);
			assertTrue(avantageFound.getId()>0);	
		}
		{
			List<Avantage> maListe = new ArrayList();
			maListe=avantageRepository.findAll();
			System.out.println("maListe : "+maListe);
		}
		{
			Avantage avantageFound=avantageRepository.findById(20);
			avantageRepository.setUpdate("houla", "YES", new BigDecimal(33), 20);
			Avantage avantageUpdated=avantageRepository.findById(20);
			assertTrue(avantageFound.equals(avantageUpdated));
		}
	}
}
