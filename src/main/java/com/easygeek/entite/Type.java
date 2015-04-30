package com.easygeek.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Type", catalog = "easygeek")
public class Type implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer typeId;
	private String libelle;

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
