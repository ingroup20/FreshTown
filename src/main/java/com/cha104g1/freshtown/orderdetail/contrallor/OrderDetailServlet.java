package com.cha104g1.freshtown.orderdetail.contrallor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha104g1.freshtown.orderdetail.model.OrderDetailService;
import com.cha104g1.freshtown.orderdetail.model.OrderDetailVO;



public class OrderDetailServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		
		if("getOne_For_Display".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs",errorMsgs);
			
			/******************1.接收請求參數，輸入格式錯誤處理****************************/
			String str = req.getParameter("orderDtlNo");
			if(str ==null || (str.trim()).length()==0) {
				errorMsgs.add("請輸入流水編號");
			}
			
			
			//似乎與50行重複
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req,res);
				return;
			}

			Integer orderDtlNo = null;
			
			try {
				orderDtlNo = Integer.valueOf(str);

				
			}catch(Exception e) {
				errorMsgs.add("流水編號格式不正確");
			}
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			
			/********2.開始查資料************************/
			OrderDetailService orderDetailSvc = new OrderDetailService();
			OrderDetailVO OrderDetailVO = orderDetailSvc.getOneOrderDetail(orderDtlNo);
			if(OrderDetailVO ==null) {
				errorMsgs.add("查無資料");
			}
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req,res);
				return;
			}
			
			/***************3.查詢完成，準備轉交******************/
			req.setAttribute("OrderDetailVO", OrderDetailVO);
			String url = "/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req,res);

		}
		
		
		//====================================================================
		
		if("getOne_For_Update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs",errorMsgs);
			
			/***************1.接收請求參數，檢查資料格式**************/
			Integer orderDtlNo = Integer.valueOf(req.getParameter("orderDtlNo"));
			
			/****************2.開始查詢資料****************************/
			OrderDetailService orderDetailSvc = new OrderDetailService();
			OrderDetailVO OrderDetailVO = orderDetailSvc.getOneOrderDetail(orderDtlNo);
			
			/**************3.查詢完成，準備轉交*************************/
			req.setAttribute("OrderDetailVO", OrderDetailVO);
			String url="/testSQL/update_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		
		}
		
		
		//=================================================================
		
		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			/************1.接收請求參數-輸入格式錯誤處理************************/
			Integer orderDtlNo = Integer.valueOf(req.getParameter("orderDtlNo"));
			Integer mealNo = Integer.valueOf(req.getParameter("mealNo"));
			Integer mealQty = Integer.valueOf(req.getParameter("mealQty"));
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			Integer priceBought = Integer.valueOf(req.getParameter("priceBought"));
			
			
			
			OrderDetailVO OrderDetailVO = new OrderDetailVO();
			OrderDetailVO.setOrderDtlNo(orderDtlNo);
			//OrderDetailVO.setMealNo(mealNo);
			OrderDetailVO.setMealQty(mealQty);
			//OrderDetailVO.setOrderId(orderId);
			OrderDetailVO.setPriceBought(priceBought);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("OrderDetailVO", OrderDetailVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req,res);
				return;
			}
			
			/*********************2.開始查資料****************************/
			OrderDetailService orderDetailSvc = new OrderDetailService();
			OrderDetailVO = orderDetailSvc.updateOrderDetail(orderDtlNo,mealNo,mealQty,orderId,priceBought);
			
			/**************3.查詢完成，準備轉交*************************/
			req.setAttribute("OrderDetailVO", OrderDetailVO);
			String url="/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		
		}
		
		//=================================================================
			
		if ("insert".equals(action)) {	
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer orderDtlNo = Integer.valueOf(req.getParameter("orderDtlNo"));
			Integer mealNo = Integer.valueOf(req.getParameter("mealNo"));
			Integer mealQty = Integer.valueOf(req.getParameter("mealQty"));
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			Integer priceBought = Integer.valueOf(req.getParameter("priceBought"));
			
			
			OrderDetailVO OrderDetailVO = new OrderDetailVO();
			
			OrderDetailVO.setOrderDtlNo(orderDtlNo);
			//OrderDetailVO.setMealNo(mealNo);
			OrderDetailVO.setMealQty(mealQty);
			//OrderDetailVO.setOrderId(orderId);
			OrderDetailVO.setPriceBought(priceBought);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("OrderDetailVO", OrderDetailVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req,res);
				return;
			}
			
			/*********************2.開始新增資料****************************/
			OrderDetailService orderDetailSvc = new OrderDetailService();
			OrderDetailVO = orderDetailSvc.addOrderDetail(orderDtlNo,mealNo,mealQty,orderId,priceBought);
			
			/***************************3.新增完成,準備轉交*******************/
			String url = "/testSQL/listAll.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);	
		}
				
		
	}

}
