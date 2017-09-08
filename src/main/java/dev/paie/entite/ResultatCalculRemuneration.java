package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class ResultatCalculRemuneration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;
	
	
	
	public ResultatCalculRemuneration(String salaireDeBase, String salaireBrut, String totalRetenueSalarial,
			String totalCotisationsPatronales, String netImposable, String netAPayer) {
		super();
		this.salaireDeBase = salaireDeBase;
		this.salaireBrut = salaireBrut;
		this.totalRetenueSalarial = totalRetenueSalarial;
		this.totalCotisationsPatronales = totalCotisationsPatronales;
		this.netImposable = netImposable;
		this.netAPayer = netAPayer;
	}
	public ResultatCalculRemuneration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSalaireBrut() {
		// TODO Auto-generated method stub
		return salaireBrut;
	}
	public String getTotalRetenueSalarial() {
		// TODO Auto-generated method stub
		return totalRetenueSalarial;
	}
	public String getTotalCotisationsPatronales() {
		// TODO Auto-generated method stub
		return totalCotisationsPatronales;
	}
	public String getNetImposable() {
		// TODO Auto-generated method stub
		return netImposable;
	}
	public String getNetAPayer() {
		// TODO Auto-generated method stub
		return netAPayer;
	}
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}
	
	
}
