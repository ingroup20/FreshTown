package com.cha104g1.freshtown.service.model;


import java.util.*;

public interface ServiceDAO_interface {
    public void insert(ServiceVO serviceVO);
    public void update(ServiceVO serviceVO);
    public ServiceVO findByPrimaryKey(Integer custserno);
    public List<ServiceVO> getAll();
}
