package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.*;
import dev.paie.spring.DataSourceMySQLConfig;


@Service
public class InitialiserDonneesServiceDev {

	@Autowired 
	private CotisationService cotisationService;
	
	@Autowired
	private List<Cotisation> listeCotisation;
	
	@Autowired 
	private EntrepriseService entrepriseService;
	
	@Autowired
	private List<Entreprise> listeEntreprise;
	
	@Autowired
	private GradeService gradeService;

	@Autowired
	private List<Grade> ListeGrade;
	
	@Autowired
	private ProfilRemunerationService profilRemunerationService;
	
	@Autowired
	private List<ProfilRemuneration> listeProfilRemuneration;
	
	@Autowired
	private PeriodeService periodeService;
	

	public void initialiser() {
		
		for (int i = 0 ; i< listeCotisation.size();i++)
		{
			cotisationService.sauvegarder(listeCotisation.get(i));
		}
		
		for (int i = 0 ; i< listeEntreprise.size();i++)
		{
			entrepriseService.sauvegarder(listeEntreprise.get(i));
		}
		
		for (int i = 1 ; i< 13;i++)
		{
			Periode maPeriode = new Periode(i);
			System.out.println(maPeriode);
			periodeService.sauvegarder(maPeriode);
		}
		
		for (int i = 0 ; i< listeProfilRemuneration.size();i++)
		{
			profilRemunerationService.sauvegarder(listeProfilRemuneration.get(i));
		}
		
		for (int i = 0 ; i< ListeGrade.size();i++)
		{
			gradeService.sauvegarder(ListeGrade.get(i));
		}
				
	}
	
}
