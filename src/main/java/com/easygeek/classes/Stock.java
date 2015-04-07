package com.easygeek.classes;
// Generated 6 avr. 2015 19:09:30 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Stock generated by hbm2java
 */
@Entity
@Table(name = "stock", catalog = "easygeek")
public class Stock implements java.io.Serializable {

	private Integer stockId;
	private Date dateStock;
	private Boolean reapprovisionnement;
	private Integer quantite;
	private String reference;

	public Stock() {
	}

	public Stock(String reference) {
		this.reference = reference;
	}

	public Stock(Date dateStock, Boolean reapprovisionnement, Integer quantite,
			String reference) {
		this.dateStock = dateStock;
		this.reapprovisionnement = reapprovisionnement;
		this.quantite = quantite;
		this.reference = reference;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stock_id", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_stock", length = 10)
	public Date getDateStock() {
		return this.dateStock;
	}

	public void setDateStock(Date dateStock) {
		this.dateStock = dateStock;
	}

	@Column(name = "reapprovisionnement")
	public Boolean getReapprovisionnement() {
		return this.reapprovisionnement;
	}

	public void setReapprovisionnement(Boolean reapprovisionnement) {
		this.reapprovisionnement = reapprovisionnement;
	}

	@Column(name = "quantite")
	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Column(name = "reference", nullable = false)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
