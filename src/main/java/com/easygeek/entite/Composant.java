package com.easygeek.entite;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Composant", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Type_id", "marque_id" }))
public class Composant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String reference;
	private String nom;
	private String description;
	private Double prixHt;
	private Double pourcentageMarge;
	private String image;
	private Double promotion;
	private Marque marque;
	private Type type;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reference", unique = true, nullable = false)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "nom")
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Prix_HT", precision = 22, scale = 0)
	public Double getPrixHt() {
		return this.prixHt;
	}

	public void setPrixHt(Double prixHt) {
		this.prixHt = prixHt;
	}

	@Column(name = "pourcentage_marge", precision = 22, scale = 0)
	public Double getPourcentageMarge() {
		return this.pourcentageMarge;
	}

	public void setPourcentageMarge(Double pourcentageMarge) {
		this.pourcentageMarge = pourcentageMarge;
	}

	@Column(name = "image", length = 65535)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "promotion", precision = 22, scale = 0)
	public Double getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Double promotion) {
		this.promotion = promotion;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marque_id")
	public Marque getMarqueId() {
		return this.marque;
	}

	public void setMarqueId(Marque marqueId) {
		this.marque = marqueId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Type_id")
	public Type getTypeId() {
		return this.type;
	}

	public void setTypeId(Type typeId) {
		this.type = typeId;
	}

}
