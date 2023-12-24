package com.cha104g1.freshtown.meals.model;

import java.util.List;

public interface MealsDAO_interface {
	public void insert(MealsVO mealsVO);
	public void update(MealsVO mealsVO);
	public MealsVO findByPrimaryKey(Integer mealNo);
	public List<MealsVO> getAll();
}
