package com.cha104g1.freshtown.itemsclass.model;

import java.util.*;

public interface Items_classDAO_interface {
      public void insert(Items_classVO items_classVO);
      public void update(Items_classVO items_classVO);
      public Items_classVO findByPrimaryKey(Integer itemclassid);
      public List<Items_classVO> getAll();      
      
}
