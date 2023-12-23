package com.cha104g1.freshtown.itemsclass.model;

import java.util.List;


public class ItemsClassService {
         private ItemsClassDAOIntf dao;
         
         public ItemsClassService() {
        	 dao = new ItemsClassJDBCDAO();
         }
         
         public ItemsClassVO addItemsclass(Integer itemClassId, String itemClassName, 
         		Integer storeId) {
        	 
        	 ItemsClassVO itemsClassVO= new  ItemsClassVO();
         	
        	 itemsClassVO.setItemClassId(itemClassId);
        	 itemsClassVO.setItemClassName(itemClassName);
        	 itemsClassVO.setStoreId(storeId);
        	 dao.insert(itemsClassVO);
        	 
        	 return itemsClassVO;
         }
         
         public ItemsClassVO updateItemsclass(Integer itemClassId, String itemClassName, 
          	Integer storeId) {
         	 
         	 ItemsClassVO itemsClassVO= new  ItemsClassVO();
          	
         	 itemsClassVO.setItemClassId(itemClassId);
         	 itemsClassVO.setItemClassName(itemClassName);
         	 itemsClassVO.setStoreId(storeId);
         	 dao.insert(itemsClassVO);
         	 
         	 return itemsClassVO;
          }
         
         public ItemsClassVO getItemsclass(Integer itemClassId) {
         	return dao.findByPrimaryKey(itemClassId);
         }
     	public List<ItemsClassVO> getAll() {
    		return dao.getAll();
    	}
}
