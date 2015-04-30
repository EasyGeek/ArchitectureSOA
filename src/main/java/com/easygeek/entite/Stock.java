package com.easygeek.entite;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Stock", catalog = "easygeek")
public class Stock implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idStock;
	private Date dateStock;
	private Boolean reapprovisionnement;
	private Integer quantite;
	private Composant composant;
	private Fournisseur fournisseur;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IdStock", unique = true, nullable = false)
	public Integer getId() {
		return this.idStock;
	}

	public void setId(Integer idStock) {
		this.idStock = idStock;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reference")
	public Composant getComposant() {
		return this.composant;
	}

	public void setComposant(Composant composant) {
		this.composant = composant;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_stock", length = 19)
	public Date getDate() {
		return this.dateStock;
	}

	public void setDate(Date dateStock) {
		this.dateStock = dateStock;
	}

	@Column(name = "reapprovisionnement")
	public Boolean getReapprovisionnement() {
		return this.reapprovisionnement;
	}

	public void setReapprovisionnement(Boolean reapprovisionnement) {
		this.reapprovisionnement = reapprovisionnement;
	}

	@Column(name = "quantite")
	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Fournisseur_id")
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}
