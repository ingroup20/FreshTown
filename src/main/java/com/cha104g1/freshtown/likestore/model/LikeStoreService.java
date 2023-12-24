package com.cha104g1.freshtown.likestore.model;

import static com.cha104g1.freshtown.util.Constants.PAGE_MAX_RESULT_M;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cha104g1.freshtown.stores.model.StoresVO;

//搭配後端渲染
public class LikeStoreService implements LikeStoreServiceIntf{

	private LikeStoreDAOIntf daoIntf;
	
	public LikeStoreService() {
		daoIntf = new LikeStoreDAO();
	}
	

	@Override
	public LikeStoreVO addLikeStore(LikeStoreVO likeStoreVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeStoreVO updateLikeStore(LikeStoreVO likeStoreVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LikeStoreVO getLikeStoreById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LikeStoreVO> getAllLikeStore(int currentPage) {
		// TODO Auto-generated method stub
		return daoIntf.getAll(currentPage);
	}

	@Override
	public int getPageTotal() {
		long total = daoIntf.getTotal();
		// 計算Emp數量每頁3筆的話總共有幾頁
		int pageQty = (int)(total% PAGE_MAX_RESULT_M == 0?(total/PAGE_MAX_RESULT_M):(total / PAGE_MAX_RESULT_M+1));	
		return pageQty;
	}

	@Override
	public List<LikeStoreVO> getLikeStoreByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<String,String>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String,String[]>> entry=map.entrySet();
		
		for(Map.Entry<String,String[]> row:entry) {
			String key = row.getKey();
			//因為請求參數裡包含了action，做個去除動作
			if("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0];// getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
			if(value == null || value.isEmpty()) {
				continue;
			}			
			query.put(key, value);
		}
		
		System.out.println(query);
		return daoIntf.getByCompositeQuery(query);
	}
	
	
	
	
//	private LikeStoreDAO_interface dao;
//	
//	public LikeStoreService() {
//		dao = new LikeStoreDAO();
//	}
//	
//	public LikeStoreVO addLikeStore( Integer customerId, StoresVO storesVO,  String likeUnlike) {
//		LikeStoreVO likeStoreVO = new LikeStoreVO();
//		
//
//		likeStoreVO.setCustomerId(customerId);
//		likeStoreVO.setStoresVO(storesVO);
//		likeStoreVO.setLikeUnlike(likeUnlike);
//		dao.insert(likeStoreVO);
//		
//		return likeStoreVO;
//	}
//	
//	public LikeStoreVO updateLikeStore( Integer id, Integer customerId, StoresVO storesVO,  String likeUnlike) {
//		LikeStoreVO likeStoreVO = new LikeStoreVO();
//		
//		likeStoreVO.setId(id);
//		likeStoreVO.setCustomerId(customerId);
//		likeStoreVO.setStoresVO(storesVO);
//		likeStoreVO.setLikeUnlike(likeUnlike);
//		dao.update(likeStoreVO);
//		
//		return likeStoreVO;
//	}
//	
//	public LikeStoreVO getOneLikeStore(Integer id) {
//		return dao.findByPrimaryKey(id);
//	}
//
//
//	
//	public List<LikeStoreVO> getAll(){
//		return dao.getAll();
//	}

}