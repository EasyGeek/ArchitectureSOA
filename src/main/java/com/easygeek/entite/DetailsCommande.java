package com.easygeek.entite;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "details_commande", uniqueConstraints = @UniqueConstraint(columnNames = {"reference", "commande_id" }))
public class DetailsCommande implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Float quantite;
	private Composant composant;
	private Commande commande;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id
	public Integer getId() {
		return id;
	}

	@Column(name = "quantite", precision = 12, scale = 0)
	public Float getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Float quantite) {
		this.quantite = quantite;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reference")
	public Composant getComposant() {
		return this.composant;
	}

	public void setComposant(Composant composant) {
		this.composant = composant;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="commande_id")
	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
