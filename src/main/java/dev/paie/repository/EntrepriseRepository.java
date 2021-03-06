package dev.paie.repository;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Avantage;
import dev.paie.entite.Entreprise;

@Transactional
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
	
//	List<Avantage> findById(Integer id);
	
//	@Query("select t from Avantage t")
	List<Entreprise> findAll();
	
//	@Query("select u from Avantage u where u.id = :Id")
//	Avantage findById(@Param("Id") Integer id);
	Entreprise findById(Integer id);
	
// création d'une méthode update au lieu d'utiliser save	
	@Modifying
	@Query("update Avantage u set u.code = ?1, u.nom = ?2, u.montant = ?3 where u.id = ?4")
	int setUpdate(String code, String nom, BigDecimal montant, Integer id);
}
