package com.cha104g1.freshtown.platform_Emp;

import java.util.*;

public interface PlatformEmpDAO_Interface {
	
	public void insert(PlatformEmpVO platformEmpVO);
    public void update(PlatformEmpVO platformEmpVO);
    public void delete(Integer pEmpId);
    public PlatformEmpVO findByPrimaryKey(Integer pEmpId);
    public List<PlatformEmpVO> getAll();

}
