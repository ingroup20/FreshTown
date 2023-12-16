package com.cha104g1.freshtown.supplier.model;

import java.util.*;

public interface SupDAO_interface {
          public void insert(SupVO supVO);
          public void update(SupVO supVO);
          public void delete(Integer supId);
          public SupVO findByPrimaryKey(Integer supId);
          public List<SupVO> getAll();
}
