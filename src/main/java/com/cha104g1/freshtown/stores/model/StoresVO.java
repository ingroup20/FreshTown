package com.cha104g1.freshtown.stores.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class StoresVO {
	private Integer	storeId;
	private String	storeAccount;
	private String	storePw;
	private String	storeName;
	private String	store_gui;
	private String	storeAddress;
	private String	storePhone;
	private Integer	storeState;
	private Integer	storeLv;
	private Date	createDate;
	private Date	payDate;
	private byte[]	photo;
	private String	storeDesc;
	private Integer	pushUp;
	private String	ownerName;
	private String	ownerMob;
	private String	ownerId;
	private String	ownerAddress;
	private String	ownerEmail;
	private Integer	scorePeople;
	private Integer	total_score;
	private BigDecimal	storeLat;
	private BigDecimal	storeLag;
	private String	openTime;
	private String	restDay;

	
	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreAccount() {
		return storeAccount;
	}
	public void setStoreAccount(String storeAccount) {
		this.storeAccount = storeAccount;
	}
	public String getStorePw() {
		return storePw;
	}
	public void setStorePw(String storePw) {
		this.storePw = storePw;
	}
	public Integer getStoreLv() {
		return storeLv;
	}
	public void setStoreLv(Integer storeLv) {
		this.storeLv = storeLv;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	public Integer getPushUp() {
		return pushUp;
	}
	public void setPushUp(Integer pushUp) {
		this.pushUp = pushUp;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerMob() {
		return ownerMob;
	}
	public void setOwnerMob(String ownerMob) {
		this.ownerMob = ownerMob;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public Integer getStoreState() {
		return storeState;
	}
	public void setStoreState(Integer storeState) {
		this.storeState = storeState;
	}
	public Integer getScorePeople() {
		return scorePeople;
	}
	public void setScorePeople(Integer scorePeople) {
		this.scorePeople = scorePeople;
	}
	public Integer getTotal_score() {
		return total_score;
	}
	public void setTotal_score(Integer total_score) {
		this.total_score = total_score;
	}
	public BigDecimal getStoreLat() {
		return storeLat;
	}
	public void setStoreLat(BigDecimal storeLat) {
		this.storeLat = storeLat;
	}
	public BigDecimal getStoreLag() {
		return storeLag;
	}
	public void setStoreLag(BigDecimal storeLag) {
		this.storeLag = storeLag;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
	public String getRestDay() {
		return restDay;
	}
	public void setRestDay(String restDay) {
		this.restDay = restDay;
	}
	public String getStore_gui() {
		return store_gui;
	}
	public void setStore_gui(String store_gui) {
		this.store_gui = store_gui;
	}

}
