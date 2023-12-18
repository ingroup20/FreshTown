package com.cha104g1.freshtown.service.model;

import java.io.Serializable;
import java.sql.Date;

public class ServiceVO implements Serializable{
    private Integer custserno;
    private Integer pempid;
    private Integer storeid;
    private Integer customerid;
    private String custmessage;
    private Date custtime;
    
	public ServiceVO() {
		super();
	}

	public Integer getCustserno() {
		return custserno;
	}

	public void setCustserno(Integer custserno) {
		this.custserno = custserno;
	}

	public Integer getPempid() {
		return pempid;
	}

	public void setPempid(Integer pempid) {
		this.pempid = pempid;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustmessage() {
		return custmessage;
	}

	public void setCustmessage(String custmessage) {
		this.custmessage = custmessage;
	}

	public Date getCusttime() {
		return custtime;
	}

	public void setCusttime(Date custtime) {
		this.custtime = custtime;
	}
	
    
    
}


