package com.cha104g1.freshtown.picking.model;

import java.util.*;

public interface PickingDAO_interface {
        public void insert(PickingVO pickingVO);
        public void update(PickingVO pickingVO);
        public PickingVO findByPrimaryKey(Integer pickingNo);
        public List<PickingVO> getAll();
}
