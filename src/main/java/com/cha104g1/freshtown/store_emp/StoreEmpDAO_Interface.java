package com.cha104g1.freshtown.store_emp;

import java.util.*;

public interface StoreEmpDAO_Interface {
	
	public void insert(StoreEmpVO storeEmpVO);
    public void update(StoreEmpVO storeEmpVO);
    public void delete(Integer sEmpId);
    public StoreEmpVO findByPrimaryKey(Integer sEmpId);
    public List<StoreEmpVO> getAll();

}
