package com.cha104g1.freshtown.consumer;

import java.util.*;

public interface ConsumerDAO_Interface {
	
	 public void insert(ConsumerVO consumerVO);
     public void update(ConsumerVO consumerVO);
     public void delete(Integer customerId);
     public ConsumerVO findByPrimaryKey(Integer customerId);
     public List<ConsumerVO> getAll();

}
