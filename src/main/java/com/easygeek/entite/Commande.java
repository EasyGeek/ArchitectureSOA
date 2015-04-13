package com.easygeek.entite;
// Generated 6 avr. 2015 19:09:30 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Commande generated by hbm2java
 */
@Entity
@Table(name = "Commande", catalog = "easygeek")
public class Commande implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer commandeId;
	@JsonBackReference
	private Client client;
	private Date dateCommande;
	private Double prixHt;
	private Integer typeLivraisonId;

	public Commande() {
	}

	public Commande(Client client, Date dateCommande, Double prixHt,
			Integer typeLivraisonId) {
		this.client = client;
		this.dateCommande = dateCommande;
		this.prixHt = prixHt;
		this.typeLivraisonId = typeLivraisonId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commande_id", unique = true, nullable = false)
	public Integer getCommandeId() {
		return this.commandeId;
	}

	public void setCommandeId(Integer commandeId) {
		this.commandeId = commandeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_commande", length = 10)
	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	@Column(name = "prixHT", precision = 22, scale = 0)
	public Double getPrixHt() {
		return this.prixHt;
	}

	public void setPrixHt(Double prixHt) {
		this.prixHt = prixHt;
	}

	@Column(name = "TypeLivraison_id")
	public Integer getTypeLivraisonId() {
		return this.typeLivraisonId;
	}

	public void setTypeLivraisonId(Integer typeLivraisonId) {
		this.typeLivraisonId = typeLivraisonId;
	}

}
