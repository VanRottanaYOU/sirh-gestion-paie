package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	
//	@ManyToMany
//	private List<Cotisation> cotisationsNonImposables;
//	
//	@ManyToMany
//	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany
	@JoinTable(name = "PRF_COT_NOT_IMP", 
		joinColumns = @JoinColumn(name = "ID_PRF", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID")
	)
	private List<Cotisation> cotisationsNonImposables;

	@ManyToMany
	@JoinTable(name = "PRF_COT_IMP", joinColumns =
	@JoinColumn(name = "ID_PRF", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID")
	)
	private List<Cotisation> cotisationsImposables;
	
	@OneToMany(mappedBy = "profilRemuneration")
	private List<Avantage> avantages;
	
	public ProfilRemuneration(String code, List<Cotisation> cotisationsNonImposables,
			List<Cotisation> cotisationsImposables, List<Avantage> avantages) {
		super();
		this.code = code;
		this.cotisationsNonImposables = cotisationsNonImposables;
		this.cotisationsImposables = cotisationsImposables;
		this.avantages = avantages;
	}

	public ProfilRemuneration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
