package com.cha104g1.freshtown.stores.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class StoresService {
	
	private StoresDAO_interface dao ;

	public StoresService() {
		dao = new StoresDAO();
	}
	
	public StoresVO addStores(

			String	storeAccount,
			String	storePw,
			String	storeName,
			String	storeGui,
			String	storeAddress,
			String	storePhone,
			Integer	storeState,
			Integer	storeLv,
			Date	createDate,
			Date	payDate,
			byte[]	photo,
			String	storeDesc,
			Integer	pushUp,
			String	ownerName,
			String	ownerMob,
			String	ownerId,
			String	ownerAddress,
			String	ownerEmail,
			Integer	scorePeople,
			Integer	totalScore	,
			BigDecimal	storeLat,
			BigDecimal	storeLag,
			String	openTime,
			String	restDay) 
	{
		StoresVO storesVO = new StoresVO();
		
		storesVO.setStoreAccount(storeAccount);
		storesVO.setStorePw(storePw);
		storesVO.setStoreLv (storeLv);
		storesVO.setCreateDate(createDate);
		storesVO.setPayDate(payDate);
		storesVO.setPhoto(photo);
		storesVO.setStoreDesc (storeDesc);
		storesVO.setPushUp (pushUp);
		storesVO.setOwnerName (ownerName);
		storesVO.setOwnerMob (ownerMob);	
		storesVO.setOwnerId (ownerId);
		storesVO.setOwnerAddress (ownerAddress);
		storesVO.setOwnerEmail (ownerEmail);
		storesVO.setStoreName (storeName);
		storesVO.setStoreAddress (storeAddress);
		storesVO.setStorePhone (storePhone);
		storesVO.setStoreState (storeState);
		storesVO.setScorePeople (scorePeople);
		storesVO.setTotalScore (totalScore);
		storesVO.setStoreLat(storeLat);
		storesVO.setStoreLag(storeLag);
		storesVO.setOpenTime (openTime);
		storesVO.setRestDay (restDay);
		storesVO.setStoreGui (storeGui);
		
		dao.insert(storesVO);

		return storesVO;
	}
	
	public StoresVO updateStores(

			String	storeAccount,
			String	storePw,
			String	storeName,
			String	storeGui,
			String	storeAddress,
			String	storePhone,
			Integer	storeState,
			Integer	storeLv,
			Date	createDate,
			Date	payDate,
			byte[]	photo,
			String	storeDesc,
			Integer	pushUp,
			String	ownerName,
			String	ownerMob,
			String	ownerId,
			String	ownerAddress,
			String	ownerEmail,
			Integer	scorePeople,
			Integer	totalScore	,
			BigDecimal	storeLat,
			BigDecimal	storeLag,
			String	openTime,
			String	restDay) 
	{
		StoresVO storesVO = new StoresVO();
		
		storesVO.setStoreAccount(storeAccount);
		storesVO.setStorePw(storePw);
		storesVO.setStoreLv (storeLv);
		storesVO.setCreateDate(createDate);
		storesVO.setPayDate(payDate);
		storesVO.setPhoto(photo);
		storesVO.setStoreDesc (storeDesc);
		storesVO.setPushUp (pushUp);
		storesVO.setOwnerName (ownerName);
		storesVO.setOwnerMob (ownerMob);	
		storesVO.setOwnerId (ownerId);
		storesVO.setOwnerAddress (ownerAddress);
		storesVO.setOwnerEmail (ownerEmail);
		storesVO.setStoreName (storeName);
		storesVO.setStoreAddress (storeAddress);
		storesVO.setStorePhone (storePhone);
		storesVO.setStoreState (storeState);
		storesVO.setScorePeople (scorePeople);
		storesVO.setTotalScore (totalScore);
		storesVO.setStoreLat(storeLat);
		storesVO.setStoreLag(storeLag);
		storesVO.setOpenTime (openTime);
		storesVO.setRestDay (restDay);
		storesVO.setStoreGui (storeGui);
		
		dao.update(storesVO);

		return storesVO;
	}
	
	public StoresVO getOneStores(Integer storeId) {
		return dao.findByPrimaryKey(storeId);
	}
	
	public List<StoresVO> getAll() {
		return dao.getAll();
	}
}
