package com.cha104g1.freshtown.itemsclass.model;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cha104g1.freshtown.material.model.MaterialVO;
@Entity
@Table(name= "items_class")
public class ItemsClassVO implements Serializable{
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="itemClassId", updatable= false)
      private Integer itemClassId;
	  
	  @Column(name="itemClassName", length=10)
      private String itemClassName;
	  
	  @Column(name="storeId")
      private Integer storeId;
	  
		@OneToMany(mappedBy = "itemsClass", cascade= CascadeType.ALL)
		@OrderBy("itemNumber asc")
	  private Set<MaterialVO> materials;
      
	public ItemsClassVO() {
		super();
	}

	public Integer getItemClassId() {
		return itemClassId;
	}

	public void setItemClassId(Integer itemClassId) {
		this.itemClassId = itemClassId;	
	}

	public String getItemClassName() {
		return itemClassName;
	}

	public void setItemClassName(String itemClassName) {
		this.itemClassName = itemClassName;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Set<MaterialVO> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<MaterialVO> materials) {
		this.materials = materials;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemClassId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsClassVO other = (ItemsClassVO) obj;
		return Objects.equals(itemClassId, other.itemClassId);
	}
	
	
      
}
