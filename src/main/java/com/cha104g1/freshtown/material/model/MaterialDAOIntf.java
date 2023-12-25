package com.cha104g1.freshtown.material.model;

import java.util.*;

public interface MaterialDAOIntf {
    public void insert(MaterialVO materialVO);
    public void update(MaterialVO materialVO);
    public MaterialVO findByPrimaryKey(Integer itemNumber);
    public List<MaterialVO> getAll();
}
