package dev.paie.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Grade;

@Service
@Transactional
public class GradeServiceJpa implements GradeService {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public void sauvegarder(Grade nouvelleGrade) {
		em.persist(nouvelleGrade);
		
	}

	@Override
	public void mettreAJour(Grade grade) {
		Grade exintingGrade = em.find(Grade.class, grade.getId());		
		exintingGrade.setCode(grade.getCode());
		exintingGrade.setNbHeuresBase(grade.getNbHeuresBase());
		exintingGrade.setTauxBase(grade.getTauxBase());
		em.persist(exintingGrade);
	
	}

	@Override
	public List<Grade> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM Grade e");
	    return (List<Grade>) query.getResultList();
	}

}
