package com.cha104g1.freshtown.material.model;

import java.util.*;

public interface MaterialDAO_interface {
    public void insert(MaterialVO materialVO);
    public void update(MaterialVO materialVO);
    public MaterialVO findByPrimaryKey(Integer itemnumber);
    public List<MaterialVO> getAll();
}
