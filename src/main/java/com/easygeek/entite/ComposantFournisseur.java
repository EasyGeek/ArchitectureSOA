package com.easygeek.entite;
// Generated 13 avr. 2015 14:02:45 by Hibernate Tools 4.3.1

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * ComposantFournisseur generated by hbm2java
 */
@Entity
@Table(name = "Composant_Fournisseur", uniqueConstraints = @UniqueConstraint(columnNames = {"reference", "fournisseur_id" }))
public class ComposantFournisseur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double prixAchatHt;
	private Composant composant;
	private Fournisseur fournisseur;

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Composant_Fournisseur_Id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "prix_achat_HT", precision = 12, scale = 0)
	public Double getPrixAchatHT() {
		return this.prixAchatHt;
	}

	public void setPrixAchatHT(Double prixAchatHt) {
		this.prixAchatHt = prixAchatHt;
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
	@JoinColumn(name="Fournisseur_id")
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}
