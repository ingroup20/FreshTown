package com.cha104g1.freshtown.itemsclass.model;

import java.io.Serializable;

public class Items_classVO implements Serializable{
      private Integer itemclassid;
      private String itemclassname;
      private Integer storeid;
      
	public Items_classVO() {
		super();
	}

	public Integer getItemsid() {
		return itemclassid;
	}

	public void setitemClassid(Integer itemclassid) {
		this.itemclassid = itemclassid;	
	}

	public String getItemclassname() {
		return itemclassname;
	}

	public void setItemclassname(String itemclassname) {
		this.itemclassname = itemclassname;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}
      
}
