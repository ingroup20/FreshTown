package com.cha104g1.freshtown.suporder.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sup_order")
public class SupOrderH {

	@Id
	@Column(name = "id", updatable = false)
	private Integer id;
	
	@Column(name = "supId")
	private Integer supId;
	
	@Column(name = "purNo")
	private Integer purNo;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "unitPrice")
	private Integer unitPrice;
	
	@Column(name = "purDate")
	private Date purDate;
	
	@Column(name = "preDate")
	private Date preDate;
	
	@Column(name = "oStatus")
	private Byte oStatus;
	
	@Column(name = "deliDate")
	private Date deliDate;
	
	@Column(name = "storeId")
	private String storeId;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSupId() {
		return supId;
	}

	public void setSupId(Integer supId) {
		this.supId = supId;
	}

	public Integer getPurNo() {
		return purNo;
	}

	public void setPurNo(Integer purNo) {
		this.purNo = purNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getPurDate() {
		return purDate;
	}

	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}

	public Date getPreDate() {
		return preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	public Byte getoStatus() {
		return oStatus;
	}

	public void setoStatus(Byte oStatus) {
		this.oStatus = oStatus;
	}

	public Date getDeliDate() {
		return deliDate;
	}

	public void setDeliDate(Date deliDate) {
		this.deliDate = deliDate;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	
}
