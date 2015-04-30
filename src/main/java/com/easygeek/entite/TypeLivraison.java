package com.easygeek.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Type_Livraison", catalog = "easygeek")
public class TypeLivraison implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer typeLivraisonId;
	private String libelle;
	private Double prix;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TypeLivraison_id", unique = true, nullable = false)
	public Integer getTypeLivraisonId() {
		return this.typeLivraisonId;
	}

	public void setTypeLivraisonId(Integer typeLivraisonId) {
		this.typeLivraisonId = typeLivraisonId;
	}

	@Column(name = "Libelle")
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "prix", precision = 22, scale = 0)
	public Double getPrix() {
		return this.prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

}
