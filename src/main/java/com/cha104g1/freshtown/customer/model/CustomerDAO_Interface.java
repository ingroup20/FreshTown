package com.cha104g1.freshtown.customer.model;

import java.util.*;

public interface CustomerDAO_Interface {
	
	 public void insert(CustomerVO customerVO);
     public void update(CustomerVO customerVO);
     public void delete(Integer customerId);
     public CustomerVO findByPrimaryKey(Integer customerId);
     public List<CustomerVO> getAll();

}
