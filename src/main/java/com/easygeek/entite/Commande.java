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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "commande", uniqueConstraints = @UniqueConstraint(columnNames = { "client_id" }))
public class Commande implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer commandeId;
	private Client client;
	private Date dateCommande;
	private Double prixHt;
	private Integer typeLivraisonId;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commande_id", unique = true, nullable = false)
	public Integer getCommandeId() {
		return this.commandeId;
	}

	public void setCommandeId(Integer commandeId) {
		this.commandeId = commandeId;
	}

	@OneToOne(cascade = CascadeType.ALL)
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
