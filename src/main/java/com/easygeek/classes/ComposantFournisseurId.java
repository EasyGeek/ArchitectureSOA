package com.easygeek.classes;
// Generated 6 avr. 2015 19:09:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ComposantFournisseurId generated by hbm2java
 */
@Embeddable
public class ComposantFournisseurId implements java.io.Serializable {

	private String reference;
	private int fournisseurId;

	public ComposantFournisseurId() {
	}

	public ComposantFournisseurId(String reference, int fournisseurId) {
		this.reference = reference;
		this.fournisseurId = fournisseurId;
	}

	@Column(name = "reference", nullable = false)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "Fournisseur_id", nullable = false)
	public int getFournisseurId() {
		return this.fournisseurId;
	}

	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComposantFournisseurId))
			return false;
		ComposantFournisseurId castOther = (ComposantFournisseurId) other;

		return ((this.getReference() == castOther.getReference()) || (this
				.getReference() != null && castOther.getReference() != null && this
				.getReference().equals(castOther.getReference())))
				&& (this.getFournisseurId() == castOther.getFournisseurId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getReference() == null ? 0 : this.getReference().hashCode());
		result = 37 * result + this.getFournisseurId();
		return result;
	}

}
