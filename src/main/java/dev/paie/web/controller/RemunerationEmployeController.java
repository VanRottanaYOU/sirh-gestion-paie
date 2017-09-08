package dev.paie.web.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationRepository;
import dev.paie.service.EntrepriseServiceJpa;



@Controller
@RequestMapping("/bulletins")
public class RemunerationEmployeController {
	
	@Autowired 
	private RemunerationRepository remunerationRepository;
	
	@Autowired 
	private PeriodeRepository periodeRepository;
	
	@Autowired 
	private BulletinRepository bulletinRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/remunerer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/creerBulletin");
		mv.addObject("listeRemuneration",remunerationRepository.findAll());
		mv.addObject("listePeriode",periodeRepository.findAll());
				
		return mv;		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/AjouterRemuneration")
	public ModelAndView visualiserRemuneration(HttpServletRequest request) {
		
		String remunerationId = request.getParameter("listeRemunerations");
		System.out.println(remunerationId);
		
		String PeriodeId = request.getParameter("listePeriodes");
		System.out.println("Entreprise Id " +PeriodeId);
		periodeRepository.findById(Integer.parseInt(PeriodeId));
		System.out.println("aaaaa : " +periodeRepository.findById(Integer.parseInt(PeriodeId)));
		
		String ProfilId = request.getParameter("prime");
		System.out.println("Profil id " +ProfilId);

		
		
		BulletinSalaire monBulletinSalaire= new BulletinSalaire(remunerationRepository.findById(Integer.parseInt(remunerationId)),periodeRepository.findById(Integer.parseInt(PeriodeId)),
		new BigDecimal(Integer.parseInt(PeriodeId)));
		
		bulletinRepository.save(monBulletinSalaire);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/remunerationAjoutee");		
		mv.addObject("employe",monBulletinSalaire);
		
		return mv;
	}
}