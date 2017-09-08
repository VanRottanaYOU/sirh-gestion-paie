package dev.paie.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Periode;

@Service
@Transactional
public class PeriodeServiceJpa implements PeriodeService {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public void sauvegarder(Periode nouvellePeriode) {
		em.persist(nouvellePeriode);
		
	}

	@Override
	public void mettreAJour(Periode periode) {
		Periode exintingPeriode = em.find(Periode.class, periode.getId());		
		exintingPeriode.setDateDebut(periode.getDateDebut());
		exintingPeriode.setDateFin(periode.getDateFin());
		em.persist(exintingPeriode);
	
	}

	@Override
	public List<Periode> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM Periode e");
	    return (List<Periode>) query.getResultList();
	}

}
