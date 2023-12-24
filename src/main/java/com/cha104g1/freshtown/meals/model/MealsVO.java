package com.cha104g1.freshtown.meals.model;

import java.sql.Time;

public class MealsVO {
	private Integer mealNo;
	private String mealName;
	private Integer mealPrice;
	private Integer mealTypeNo;
	private Integer mealOnsale;
	private Integer storeId;
	private byte[] mealPicture;
	private Time cookingTime;
	
	public MealsVO() {
		super();
	}

	public Integer getMealNo() {
		return mealNo;
	}

	public void setMealNo(Integer mealNo) {
		this.mealNo = mealNo;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Integer getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(Integer mealPrice) {
		this.mealPrice = mealPrice;
	}

	public Integer getMealTypeNo() {
		return mealTypeNo;
	}

	public void setMealTypeNo(Integer mealTypeNo) {
		this.mealTypeNo = mealTypeNo;
	}

	public Integer getMealOnsale() {
		return mealOnsale;
	}

	public void setMealOnsale(Integer mealOnsale) {
		this.mealOnsale = mealOnsale;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public byte[] getMealPicture() {
		return mealPicture;
	}

	public void setMealPicture(byte[] mealPicture) {
		this.mealPicture = mealPicture;
	}

	public Time getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(Time cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	

}
