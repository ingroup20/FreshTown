package com.cha104g1.freshtown.likestore.contralor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha104g1.freshtown.likestore.model.LikeStoreService;
import com.cha104g1.freshtown.likestore.model.LikeStoreVO;


public class LikeStoreServlet extends HttpServlet{
	
	private LikeStoreService likeStoreSvc;
	
	@Override
	public void init() throws ServletException {
		likeStoreSvc = new LikeStoreService();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		super.doGet(req, res);//可以存在嗎??
		doPost(req,res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath="";
		switch(action) {
			case "setAll":
				forwardPath=getAllLikeStore(req,res);
				break;
			case "compositeQuery":
				forwardPath=getCompositeLikeStoreQuery(req,res);
				break;
			default:
				forwardPath="index.jsp";
		}
		//新朋友
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req,res);	
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
//	
//		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//			doPost(req,res);
//		}
//		
//		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//			req.setCharacterEncoding("utf-8");
//			String action = req.getParameter("action");
//			
//			if("getOne_For_Display".equals(action)) {
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				
//				req.setAttribute("errorMsgs",errorMsgs);
//				
//				/******************1.接收請求參數，輸入格式錯誤處理****************************/
//				String str = req.getParameter("id");
//				if(str ==null || (str.trim()).length()==0) {
//					errorMsgs.add("請輸入流水編號");
//				}
//				
//				
//				//似乎與50行重複
//				if(!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
//					failureView.forward(req,res);
//					return;
//				}
//
//				Integer id = null;
//				
//				try {
//					id = Integer.valueOf(str);
//
//					
//				}catch(Exception e) {
//					errorMsgs.add("流水編號格式不正確");
//				}
//				
//				if(!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				
//				/********2.開始查資料************************/
//				LikeStoreService likeStoreSvc = new LikeStoreService();
//				LikeStoreVO likeStoreVO = likeStoreSvc.getOneLikeStore(id);
//				if(likeStoreVO ==null) {
//					errorMsgs.add("查無資料");
//				}
//				
//				if(!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
//					failureView.forward(req,res);
//					return;
//				}
//				
//				/***************3.查詢完成，準備轉交******************/
//				req.setAttribute("likeStoreVO", likeStoreVO);
//				String url = "/testSQL/listOne.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req,res);
//	
//			}
//			
//			
//			//====================================================================
//			
//			if("getOne_For_Update".equals(action)) {
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				
//				req.setAttribute("errorMsgs",errorMsgs);
//				
//				/***************1.接收請求參數，檢查資料格式**************/
//				Integer id = Integer.valueOf(req.getParameter("id"));
//				
//				/****************2.開始查詢資料****************************/
//				LikeStoreService likeStoreSvc = new LikeStoreService();
//				LikeStoreVO likeStoreVO = likeStoreSvc.getOneLikeStore(id);
//				
//				/**************3.查詢完成，準備轉交*************************/
//				req.setAttribute("likeStoreVO", likeStoreVO);
//				String url="/testSQL/update_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//			
//			}
//			
//			
//			//=================================================================
//			
//			if ("update".equals(action)) {
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				
//				req.setAttribute("errorMsgs", errorMsgs);
//				
//				/************1.接收請求參數-輸入格式錯誤處理************************/
//				Integer id = Integer.valueOf(req.getParameter("id"));
//				Integer customerId = Integer.valueOf(req.getParameter("customerId"));
//				Integer storeId = Integer.valueOf(req.getParameter("storeId"));
//				
//				String likeUnlike = req.getParameter("likeUnlike");
//				String likeUnlikeReg = "^[(uUlL)]$";
//				if(likeUnlike == null || likeUnlike.trim().length()==0) {
//					errorMsgs.add("請勿空白");
//				}else if(!likeUnlike.trim().matches(likeUnlikeReg)) {
//					errorMsgs.add("只能輸入英文代號，收藏L/黑名單U");
//				}
//				
//				LikeStoreVO likeStoreVO = new LikeStoreVO();
//				likeStoreVO.setId(id);
//				likeStoreVO.setCustomerId(customerId);
//				likeStoreVO.setStoreId(storeId);
//				likeStoreVO.setLikeUnlike(likeUnlike);
//				
//				if(!errorMsgs.isEmpty()) {
//					req.setAttribute("likeStoreVO", likeStoreVO);
//					RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
//					failurView.forward(req,res);
//					return;
//				}
//				
//				/*********************2.開始查資料****************************/
//				LikeStoreService likeStoreSvc = new LikeStoreService();
//				likeStoreVO = likeStoreSvc.updateLikeStore(id,customerId,storeId,likeUnlike);
//				
//				/**************3.查詢完成，準備轉交*************************/
//				req.setAttribute("likeStoreVO", likeStoreVO);
//				String url="/testSQL/listOne.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//			
//			}
//			
//			//=================================================================
//				
//			if ("insert".equals(action)) {	
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//			
//				Integer customerId = Integer.valueOf(req.getParameter("customerId"));
//				Integer storeId = Integer.valueOf(req.getParameter("storeId"));
//				
//				String likeUnlike = req.getParameter("likeUnlike");
//				String likeUnlikeReg = "^[(LUlu)]$";
//				if(likeUnlike == null || likeUnlike.trim().length()==0) {
//					errorMsgs.add("請勿空白");
//				}else if(!likeUnlike.trim().matches(likeUnlikeReg)) {
//					errorMsgs.add("只能輸入英文代號，收藏L/黑名單U");
//				}
//				
//				LikeStoreVO likeStoreVO = new LikeStoreVO();
//				
//				likeStoreVO.setCustomerId(customerId);
//				likeStoreVO.setStoreId(storeId);
//				likeStoreVO.setLikeUnlike(likeUnlike);
//				
//				if(!errorMsgs.isEmpty()) {
//					req.setAttribute("likeStoreVO", likeStoreVO);
//					RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
//					failurView.forward(req,res);
//					return;
//				}
//				
//				/*********************2.開始新增資料****************************/
//				LikeStoreService likeStoreSvc = new LikeStoreService();
//				likeStoreVO = likeStoreSvc.addLikeStore(customerId,storeId,likeUnlike);
//				
//				/***************************3.新增完成,準備轉交*******************/
//				String url = "/testSQL/listAll.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);	
//			}
//					
//			
//		}



	private String getAllLikeStore(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null)? 1:Integer.parseInt(page);
	
		List<LikeStoreVO> storeList =  likeStoreSvc.getAllLikeStore(currentPage);
		
		if(req.getSession().getAttribute("likeStorePageQty")==null) {
			int likeStorePageQty = likeStoreSvc.getPageTotal();
			req.getSession().setAttribute("likeStorePageQty",likeStorePageQty);
		}
		
		req.setAttribute("storeList", storeList);
		req.setAttribute("currentPage", currentPage);
		
		return "/testSQL/listAll.jsp";
	}


	private String getCompositeLikeStoreQuery(HttpServletRequest req,HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();
		
		if (map != null) {
			List<LikeStoreVO> storeList = likeStoreSvc.getLikeStoreByCompositeQuery(map);
			req.setAttribute("storeList", storeList);
		}else {
			return "/idex.jsp";
		}
	
		return "/testSQL/listCompositeQuery.jsp";
	}




}