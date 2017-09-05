package dev.paie.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
@Transactional
public class CotisationServiceJpa implements CotisationService {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
		
	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		Cotisation exintingCotisation = em.find(Cotisation.class, cotisation.getId());		
		exintingCotisation.setCode(cotisation.getCode());
		exintingCotisation.setLibelle(cotisation.getLibelle());
		exintingCotisation.setTauxSalarial(cotisation.getTauxSalarial());
		exintingCotisation.setTauxPatronal(cotisation.getTauxPatronal());
		em.persist(exintingCotisation);
	
	}

	@Override
	public List<Cotisation> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM Cotisation e");
	    return (List<Cotisation>) query.getResultList();
	}

}
