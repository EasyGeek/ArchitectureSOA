package com.easygeek.classes;
// Generated 6 avr. 2015 19:09:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Type generated by hbm2java
 */
@Entity
@Table(name = "Type", catalog = "easygeek")
public class Type implements java.io.Serializable {

	private Integer typeId;
	private String libelle;

	public Type() {
	}

	public Type(String libelle) {
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "Libelle")
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
