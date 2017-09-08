package dev.paie.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Entreprise;

@Service
@Transactional
public class EntrepriseServiceJpa implements EntrepriseService {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public void sauvegarder(Entreprise nouvelleEntreprise) {
		em.persist(nouvelleEntreprise);
		
	}

	@Override
	public void mettreAJour(Entreprise entreprise) {
		Entreprise exintingEntreprise = em.find(Entreprise.class, entreprise.getId());		
		exintingEntreprise.setAdresse(entreprise.getAdresse());
		exintingEntreprise.setCodeNaf(entreprise.getCodeNaf());
		exintingEntreprise.setDenomination(entreprise.getDenomination());
		exintingEntreprise.setSiret(entreprise.getSiret());
		exintingEntreprise.setUrssaf(entreprise.getUrssaf());
		em.persist(exintingEntreprise);
	
	}

	@Override
	public List<Entreprise> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM Entreprise e");
	    return (List<Entreprise>) query.getResultList();
	}

}
