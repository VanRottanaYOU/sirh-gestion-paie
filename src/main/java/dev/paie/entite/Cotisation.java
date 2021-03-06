package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.transaction.annotation.Transactional;

@Entity
public class Cotisation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	private String libelle;
	
	private BigDecimal tauxSalarial;
	
	private BigDecimal tauxPatronal;
	
//	@ManyToMany
//	private List<Cotisation> profilRemunaration;
	
	
	
	public String getCode() {
		return code;
	}
	
	
	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
	super();
	this.code = code;
	this.libelle = libelle;
	this.tauxSalarial = tauxSalarial;
	this.tauxPatronal = tauxPatronal;
}


	public Cotisation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cotisation [id=" + id + ", code=" + code + ", libelle=" + libelle + ", tauxSalarial=" + tauxSalarial
				+ ", tauxPatronal=" + tauxPatronal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((tauxPatronal == null) ? 0 : tauxPatronal.hashCode());
		result = prime * result + ((tauxSalarial == null) ? 0 : tauxSalarial.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cotisation other = (Cotisation) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (tauxPatronal == null) {
			if (other.tauxPatronal != null)
				return false;
		} else if (!tauxPatronal.equals(other.tauxPatronal))
			return false;
		if (tauxSalarial == null) {
			if (other.tauxSalarial != null)
				return false;
		} else if (!tauxSalarial.equals(other.tauxSalarial))
			return false;
		return true;
	}
	
	
	
	

}
