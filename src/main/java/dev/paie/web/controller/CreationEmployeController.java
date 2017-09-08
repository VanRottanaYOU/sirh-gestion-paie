package dev.paie.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationRepository;
import dev.paie.service.EntrepriseServiceJpa;



@Controller
@RequestMapping("/employes")
public class CreationEmployeController {
	
	@Autowired 
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired 
	private ProfilRepository profilRepository;
	
	@Autowired 
	private GradeRepository gradeRepository;
	
	@Autowired 
	private RemunerationRepository remunerationRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
//		mv.addObject("prefixMatricule","M00");
		
//		ArrayList<Entreprise> listeNomsEntreprises = new ArrayList();
//		for (Entreprise monEntreprise : listeEntreprise) {
//			listeNomsEntreprises.add(monEntreprise);
//			System.out.println(monEntreprise);
//		}
		mv.addObject("listeNomEntreprise",entrepriseRepository.findAll());
//		
//		ArrayList<ProfilRemuneration> listeProfils = new ArrayList();
//		for (ProfilRemuneration monProfil : listeProfilRemuneration) {
//			listeProfils.add(monProfil);
//		}
		mv.addObject("listeProfils",profilRepository.findAll());
		
//		ArrayList<Grade> listeGrades = new ArrayList();
//		for (Grade monGrade : ListeGrade) {
//			listeGrades.add(monGrade);
//		}
		mv.addObject("listeGrades",gradeRepository.findAll());
		
		return mv;		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/ajouter")
	public ModelAndView visualiserEmploye(HttpServletRequest request) {
		
		String matricule = request.getParameter("matricule");
		System.out.println(matricule);
		
		String EntrepriseId = request.getParameter("listeEntreprises");
		System.out.println("Entreprise Id " +EntrepriseId);
		entrepriseRepository.findById(Integer.parseInt(EntrepriseId));
		System.out.println("aaaaa : " +entrepriseRepository.findById(Integer.parseInt(EntrepriseId)));
		
		String ProfilId = request.getParameter("listeProfils");
		System.out.println("Profil id " +ProfilId);
		profilRepository.findById(Integer.parseInt(ProfilId));
		System.out.println("aaaaa : " +profilRepository.findById(Integer.parseInt(ProfilId)));
		
		String GradeId = request.getParameter("listeGrades");
		System.out.println("grade Id " +GradeId);
		gradeRepository.findById(Integer.parseInt(GradeId));
		System.out.println("aaaaa : " +gradeRepository.findById(Integer.parseInt(GradeId)));
		
		
		RemunerationEmploye monEmploye = new RemunerationEmploye(matricule,entrepriseRepository.findById(Integer.parseInt(EntrepriseId)),
		profilRepository.findById(Integer.parseInt(ProfilId)),gradeRepository.findById(Integer.parseInt(GradeId)));
		
		remunerationRepository.save(monEmploye);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/employeAjoute");		
		mv.addObject("employe",monEmploye);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");		
		mv.addObject("listeEmployes",remunerationRepository.findAll());
		
		return mv;
	}
	
}