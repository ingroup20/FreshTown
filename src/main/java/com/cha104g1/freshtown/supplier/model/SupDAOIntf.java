package com.cha104g1.freshtown.supplier.model;

import java.util.*;

public interface SupDAOIntf {
          public void insert(SupVO supVO);
          public void update(SupVO supVO);
          public void delete(Integer supId);
          public SupVO findByPrimaryKey(Integer supId);
          public SupVO findByKey(String supplierName);
          public SupVO findByCon(String supplierContact);
          public List<SupVO> getAll();
}
