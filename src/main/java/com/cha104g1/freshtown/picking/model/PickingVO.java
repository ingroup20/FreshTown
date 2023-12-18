package com.cha104g1.freshtown.picking.model;

import java.io.Serializable;
import java.sql.Date;

public class PickingVO implements Serializable{
	private Integer pickingno;
	private Integer itemnumber;
	private Integer storeid;
	private Integer sempid;
	private Integer pickingquantity;
	private String pickingunit;
	private Integer pickingstatus;
	private Integer pickingclass;
	private Date pickingdate;
	private String marks;

	public PickingVO() {
		super();
	}

	public Integer getPickingno() {
		return pickingno;
	}

	public void setPickingno(Integer pickingno) {
		this.pickingno = pickingno;
	}

	public Integer getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(Integer itemnumber) {
		this.itemnumber = itemnumber;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public Integer getSempid() {
		return sempid;
	}

	public void setSempid(Integer sempid) {
		this.sempid = sempid;
	}

	public Integer getPickingquantity() {
		return pickingquantity;
	}

	public void setPickingquantity(Integer pickingquantity) {
		this.pickingquantity = pickingquantity;
	}

	public String getPickingunit() {
		return pickingunit;
	}

	public void setPickingunit(String pickingunit) {
		this.pickingunit = pickingunit;
	}

	public Integer getPickingstatus() {
		return pickingstatus;
	}

	public void setPickingstatus(Integer pickingstatus) {
		this.pickingstatus = pickingstatus;
	}

	public Integer getPickingclass() {
		return pickingclass;
	}

	public void setPickingclass(Integer pickingclass) {
		this.pickingclass = pickingclass;
	}
	

	public Date getPickingdate() {
		return pickingdate;
	}

	public void setPickingdate(Date pickingdate) {
		this.pickingdate = pickingdate;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

}
