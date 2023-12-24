package com.cha104g1.freshtown.itemsclass.model;

import java.util.*;

public interface ItemsClassDAOIntf {
      public void insert(ItemsClassVO itemsClassVO);
      public void update(ItemsClassVO itemsClassVO);
      public ItemsClassVO findByPrimaryKey(Integer itemClassId);
      public List<ItemsClassVO> getAll();      
      
}
