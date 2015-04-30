package com.easygeek.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Marque", catalog = "easygeek")
public class Marque implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer marqueId;
	private String libelle;

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
