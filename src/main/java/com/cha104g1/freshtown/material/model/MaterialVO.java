package com.cha104g1.freshtown.material.model;

import java.io.Serializable;
import java.sql.Date;

public class MaterialVO implements Serializable{
	private Integer itemnumber;
	private String itemname;
	private Integer itemclassid;
	private Integer stockquantity;
	private Integer quantitynot;
	private String itemunit;
	private Integer safetystock;
	private Integer itemstatus;
	private Date purdate;
	private Integer storeid;
	
	public MaterialVO() {
		super();
	}

	public Integer getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(Integer itemnumber) {
		this.itemnumber = itemnumber;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Integer getItemclassid() {
		return itemclassid;
	}

	public void setItemclassid(Integer itemclassid) {
		this.itemclassid = itemclassid;
	}

	public Integer getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(Integer stockquantity) {
		this.stockquantity = stockquantity;
	}

	public Integer getQuantitynot() {
		return quantitynot;
	}

	public void setQuantitynot(Integer quantitynot) {
		this.quantitynot = quantitynot;
	}

	public String getItemunit() {
		return itemunit;
	}

	public void setItemunit(String itemunit) {
		this.itemunit = itemunit;
	}

	public Integer getSafetystock() {
		return safetystock;
	}

	public void setSafetystock(Integer safetystock) {
		this.safetystock = safetystock;
	}

	public Integer getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(Integer itemstatus) {
		this.itemstatus = itemstatus;
	}
	
	public Date getPurdate() {
		return purdate;
	}

	public void setPurdate(Date purdate) {
		this.purdate = purdate;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}



	
}
