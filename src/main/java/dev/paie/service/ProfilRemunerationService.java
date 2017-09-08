package dev.paie.service;

import java.util.List;

import dev.paie.entite.*;

public interface ProfilRemunerationService {
	void sauvegarder(ProfilRemuneration profilRenumerationmeration);
	void mettreAJour(ProfilRemuneration profilRenumeration);
	List<ProfilRemuneration> lister();
}
