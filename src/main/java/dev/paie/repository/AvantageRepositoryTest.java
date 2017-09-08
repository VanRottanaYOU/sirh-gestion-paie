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
//			avantage.setId(21);
//			avantage.setCode("TOTO");
//			avantage.setNom("VAN");
//			avantage.setMontant( new BigDecimal(20));
//			Avantage newAvantage=avantageRepository.save(avantage);
//			assertTrue(newAvantage.getId()>0);
//		}


		{
			Avantage avantageFound=avantageRepository.findById(22);	
			System.out.println("FindById : " +avantageFound);
			assertTrue(avantageFound.getId()>0);	
		}
		{
			List<Avantage> maListe = new ArrayList();
			maListe=avantageRepository.findAll();
			System.out.println("maListe : "+maListe);
		}
		{
//			long T1 = System.currentTimeMillis();
//			for (int i =0 ; i<100 ; i++)
//			{
			// sans utiliser le save)
			Avantage avantageFound=avantageRepository.findById(22);
//			System.out.println("Update avant : " +avantageFound);
			avantageRepository.setUpdate("houla", "YES", new BigDecimal(33), 22);
			Avantage avantageUpdated=avantageRepository.findById(22);
//			System.out.println("Update après : " +avantageUpdated);
//			assertTrue(!avantageFound.equals(avantageUpdated));
//			}
//			long T2 = System.currentTimeMillis();
		}
		{
//			long T3 = System.currentTimeMillis();
//			for (int i =0 ; i<100 ; i++)
//			{
				
				Avantage avantageFound=avantageRepository.findById(22);
				avantageFound.setId(21);
				avantageFound.setCode("TATA");
				avantageFound.setNom("VAN");
				avantageFound.setMontant( new BigDecimal(20));
				Avantage newAvantage=avantageRepository.save(avantageFound);
				assertTrue(!avantageFound.equals(newAvantage));
				
//			}
//			long T4 = System.currentTimeMillis();
//			System.out.println(T2-T1);
//			System.out.println(T4-T3);
//			
		}
	}
}
