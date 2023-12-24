package com.cha104g1.freshtown.suporder.model;

import java.util.*;

public interface SupOrderDAOIntf {
          public void insert(SupOrderVO supOrderVO);
          public void update(SupOrderVO supOrderVO);
          public void delete(Integer supOrderId);
//          public SupOrderVO findByPrimaryKey(Integer id);
//          public SupOrderVO findByKey(String supplierName);
//          public SupOrderVO findByCon(String supplierContact);
          public List<SupOrderVO> getAll();
}
