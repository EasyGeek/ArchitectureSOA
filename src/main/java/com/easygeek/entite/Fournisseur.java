package com.easygeek.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fournisseur", catalog = "easygeek")
public class Fournisseur implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer fournisseurId;
	private String nom;
	private String telephone;
	private String adresse;
	private String codePostal;
	private String ville;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Fournisseur_id", unique = true, nullable = false)
	public Integer getFournisseurId() {
		return this.fournisseurId;
	}

	public void setFournisseurId(Integer fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	@Column(name = "nom")
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "telephone", length = 25)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "adresse")
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "code_postal", length = 25)
	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "Ville")
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
