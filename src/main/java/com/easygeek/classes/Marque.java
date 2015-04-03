package com.easygeek.classes;
// Generated 3 avr. 2015 10:14:55 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Marque generated by hbm2java
 */
@Entity
@Table(name = "Marque", catalog = "easygeek")
public class Marque implements java.io.Serializable {

	private Integer marqueId;
	private String libelle;

	public Marque() {
	}

	public Marque(String libelle) {
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "marque_id", unique = true, nullable = false)
	public Integer getMarqueId() {
		return this.marqueId;
	}

	public void setMarqueId(Integer marqueId) {
		this.marqueId = marqueId;
	}

	@Column(name = "Libelle")
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
