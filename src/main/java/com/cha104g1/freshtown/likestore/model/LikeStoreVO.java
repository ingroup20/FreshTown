package com.cha104g1.freshtown.likestore.model;


public class Like_storeVO {
	private Integer	id;
	private Integer	customerId;
	private Integer	storeId;
	private Integer	likeUnlike;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getLikeUnlike() {
		return likeUnlike;
	}
	public void setLikeUnlike(Integer likeUnlike) {
		this.likeUnlike = likeUnlike;
	}
	

}
