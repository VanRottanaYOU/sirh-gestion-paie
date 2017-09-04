package dev.paie.entite;

import org.springframework.stereotype.Component;

public class ResultatCalculRemuneration {
	
	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;
	
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
