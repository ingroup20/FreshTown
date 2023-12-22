package com.cha104g1.freshtown.material.model;

import java.util.List;

public class MaterialService {
	
    private MaterialDAOIntf dao;
    
    public MaterialService() {
    	dao = new MaterialJDBCDAO();
    }
    
    public MaterialVO addMaterial(String itemName, Integer itemClassId, Integer stockQuantity, Integer quantityNot,
    		String itemUnit, Integer safetyStock, Integer itemStatus, java.sql.Date purDate, Integer storeId
    		) {
    	
    	MaterialVO materialVO= new  MaterialVO();
    	
    	materialVO.setItemName(itemName);
    	materialVO.setItemClassId(itemClassId);
    	materialVO.setStockQuantity(stockQuantity);
    	materialVO.setQuantityNot(quantityNot);
    	materialVO.setItemUnit(itemUnit);
    	materialVO.setSafetyStock(safetyStock);
    	materialVO.setItemStatus(itemStatus);
    	materialVO.setPurDate(purDate);
    	materialVO.setStoreId(storeId);
    	dao.insert(materialVO);
    	
    	return materialVO;
    }
    
    public MaterialVO updateMaterial(Integer itemNumber, String itemName, Integer itemClassId, Integer stockQuantity,
    		Integer quantityNot, String itemUnit, Integer safetyStock, Integer itemStatus, java.sql.Date purDate,
    		Integer storeId) {
    	
    	MaterialVO materialVO = new MaterialVO();
    	
    	materialVO.setItemNumber(itemNumber);
    	materialVO.setItemName(itemName);
    	materialVO.setItemClassId(itemClassId);
    	materialVO.setStockQuantity(stockQuantity);
    	materialVO.setQuantityNot(quantityNot);
    	materialVO.setItemUnit(itemUnit);
    	materialVO.setSafetyStock(safetyStock);
    	materialVO.setItemStatus(itemStatus);
    	materialVO.setPurDate(purDate);
    	materialVO.setStoreId(storeId);
    	dao.update(materialVO);
    	
    	return materialVO;
    }
    
    public MaterialVO getOneMaterial(Integer itemNumber) {
    	return dao.findByPrimaryKey(itemNumber);
    }
    
    public List<MaterialVO> getAll(){
    	return dao.getAll();
    }
    
    
}
