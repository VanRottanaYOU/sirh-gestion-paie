package dev.paie.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.ProfilRemuneration;

@Service
@Transactional
public class ProfilRemunerationServiceJpa implements ProfilRemunerationService {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public void sauvegarder(ProfilRemuneration nouvelleProfilRemuneration) {
		em.persist(nouvelleProfilRemuneration);
		
	}

	@Override
	public void mettreAJour(ProfilRemuneration profilRenumeration) {
		ProfilRemuneration exintingProfilRemuneration = em.find(ProfilRemuneration.class, profilRenumeration.getId());		
		exintingProfilRemuneration.setAvantages(profilRenumeration.getAvantages());
		exintingProfilRemuneration.setCode(profilRenumeration.getCode());
		exintingProfilRemuneration.setCotisationsImposables(profilRenumeration.getCotisationsImposables());
		exintingProfilRemuneration.setCotisationsNonImposables(profilRenumeration.getCotisationsNonImposables());
		em.persist(exintingProfilRemuneration);
	
	}

	@Override
	public List<ProfilRemuneration> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM ProfilRemuneration e");
	    return (List<ProfilRemuneration>) query.getResultList();
	}

}
