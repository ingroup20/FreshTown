package com.cha104g1.freshtown.service.model;

import java.util.*;

public interface ServiceDAOIntf {
    public void insert(ServiceVO serviceVO);
    public void update(ServiceVO serviceVO);
    public ServiceVO findByPrimaryKey(Integer custSerNo);
    public List<ServiceVO> getAll();
}
