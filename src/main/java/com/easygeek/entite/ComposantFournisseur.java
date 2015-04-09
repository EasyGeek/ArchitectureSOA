package com.easygeek.entite;
// Generated 6 avr. 2015 19:09:30 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ComposantFournisseur generated by hbm2java
 */
@Entity
@Table(name = "Composant_Fournisseur", catalog = "easygeek")
public class ComposantFournisseur implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ComposantFournisseurId id;

	public ComposantFournisseur() {
	}

	public ComposantFournisseur(ComposantFournisseurId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "reference", column = @Column(name = "reference", nullable = false)),
			@AttributeOverride(name = "fournisseurId", column = @Column(name = "Fournisseur_id", nullable = false)) })
	public ComposantFournisseurId getId() {
		return this.id;
	}

	public void setId(ComposantFournisseurId id) {
		this.id = id;
	}

}