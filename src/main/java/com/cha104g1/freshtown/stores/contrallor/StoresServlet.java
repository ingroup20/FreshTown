package com.cha104g1.freshtown.stores.contrallor;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cha104g1.freshtown.stores.model.StoresService;
import com.cha104g1.freshtown.stores.model.StoresVO;

@WebServlet("/stores/stores.do")
public class StoresServlet extends HttpServlet {

	private StoresService storesSvc;
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		/* ================= 單筆查詢 ============================== */
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/************* 1.接收請求參數，輸入格式錯誤處理 ********/
			String str = req.getParameter("storeId");
			// 前端js處理
			Integer storeId = null;
			try {
				storeId = Integer.valueOf(str);

			} catch (Exception e) {
				errorMsgs.add("流水編號格式不正確");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/************* 2.查詢永續層資料 ********/
			StoresService storesSvc = new StoresService();
			StoresVO storesVO = storesSvc.getOneStores(storeId);
			if (storesVO == null) {
				errorMsgs.add("查無資料");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failurView.forward(req, res);
				return;
			}

			/************* 3.查詢完，轉交內容 ********/

			req.setAttribute("storesVO", storesVO);
			String url = "/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* ================= 修改 ============================== */
		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/************* 1.接收請求參數，輸入格式錯誤處理 ********/
			Integer storeId = Integer.valueOf(req.getParameter("storeId"));
			/************* 2.查詢永續層資料 ********/
			StoresService storesSvc = new StoresService();
			StoresVO storesVO = storesSvc.getOneStores(storeId);

			/************* 3.查詢完，轉交內容 ********/
			req.setAttribute("storesVO", storesVO);
			String url = "/testSQL/update_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* ==================更新====================== */
		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/************ 1.接收請求參數-輸入格式錯誤處理 ************************/
			Integer storeId = Integer.valueOf(req.getParameter("storeId"));
			String storeAccount = req.getParameter("storeAccount");
			String storePw = req.getParameter("storePw");
			String storeName = req.getParameter("storeName");
			String storeGui = req.getParameter("storeGui");
			String storeAddress = req.getParameter("storeAddress");
			String storePhone = req.getParameter("storePhone");
			Integer storeState = Integer.valueOf(req.getParameter("storeId"));
			Integer storeLv = Integer.valueOf(req.getParameter("storeId"));
			Date createDate = Date.valueOf(req.getParameter("createDate"));
			Date payDate = Date.valueOf(req.getParameter("payDate"));

			Part photoPart = req.getPart("photo");
			InputStream photoIps = photoPart.getInputStream();
			byte[] photoBytes = photoIps.readAllBytes();

			String storeDesc = req.getParameter("storeDesc");
			Integer pushUp = Integer.valueOf(req.getParameter("pushUp"));
			String ownerName = req.getParameter("ownerName");
			String ownerMob = req.getParameter("ownerMob");
			String ownerId = req.getParameter("ownerId");
			String ownerAddress = req.getParameter("ownerAddress");
			String ownerEmail = req.getParameter("ownerEmail");
			Integer scorePeople = Integer.valueOf(req.getParameter("scorePeople"));
			Integer totalScore = Integer.valueOf(req.getParameter("totalScore"));

			BigDecimal storeLat = new BigDecimal(req.getParameter("storeLat"));
			BigDecimal storeLag = new BigDecimal(req.getParameter("storeLag"));

			String openTime = req.getParameter("openTime");
			String restDay = req.getParameter("restDay");

			// 放入VO物件
			StoresVO storesVO = new StoresVO();
			storesVO.setStoreAccount(storeAccount);
			storesVO.setStorePw(storePw);
			storesVO.setStoreLv (storeLv);
			storesVO.setCreateDate(createDate);
			storesVO.setPayDate(payDate);
			storesVO.setPhoto(photoBytes);
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

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("storesVO", storesVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req, res);
				return;
			}

			/********************* 2.開始查資料 ****************************/
			StoresService storesSvc = new StoresService();
			storesVO = storesSvc.updateStores(storeAccount, storePw, storeName, storeGui, storeAddress, storePhone,
					storeState, storeLv, createDate, payDate, photoBytes, storeDesc, pushUp, ownerName, ownerMob, ownerId,
					ownerAddress, ownerEmail, scorePeople, totalScore, storeLat, storeLag, openTime, restDay);
			/************** 3.查詢完成，準備轉交 *************************/
			String url ="/testSQL/listOne.jsp";
			
			
		}

		/* ================= 新增 ============================== */

		/************* 1.接收請求參數，輸入格式錯誤處理 ********/

		/************* 2.新增永續層資料 ********/

		/************* 3.新增完成，轉交內容 ********/

	}

}
