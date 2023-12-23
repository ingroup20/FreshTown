package com.cha104g1.freshtown.orders.contrallor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha104g1.freshtown.orders.model.OrdersService;
import com.cha104g1.freshtown.orders.model.OrdersVO;



public class OrdersServlet {
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
			String str = req.getParameter("orderId");
			if(str ==null || (str.trim()).length()==0) {
				errorMsgs.add("請輸入流水編號");
			}
			
			
			//似乎與50行重複
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req,res);
				return;
			}

			Integer orderId = null;
			
			try {
				orderId = Integer.valueOf(str);

				
			}catch(Exception e) {
				errorMsgs.add("流水編號格式不正確");
			}
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			
			/********2.開始查資料************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(orderId);
			if(ordersVO ==null) {
				errorMsgs.add("查無資料");
			}
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req,res);
				return;
			}
			
			/***************3.查詢完成，準備轉交******************/
			req.setAttribute("ordersVO", ordersVO);
			String url = "/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req,res);

		}
		
		
		//====================================================================
		
		if("getOne_For_Update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs",errorMsgs);
			
			/***************1.接收請求參數，檢查資料格式**************/
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			
			/****************2.開始查詢資料****************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO OrdersVO = ordersSvc.getOneOrders(orderId);
			
			/**************3.查詢完成，準備轉交*************************/
			req.setAttribute("OrdersVO", OrdersVO);
			String url="/testSQL/update_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		
		}
		
		
		//=================================================================
		
		if ("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);
			
			/************1.接收請求參數-輸入格式錯誤處理************************/
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			Integer orderState = Integer.valueOf(req.getParameter("orderState"));
			
			java.sql.Timestamp orderTime = null;
			try {
				orderTime = java.sql.Timestamp.valueOf(req.getParameter("orderTime").trim());
			} catch (IllegalArgumentException e) {
				orderTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			
			java.sql.Timestamp doneTime = null;
			try {
				doneTime = java.sql.Timestamp.valueOf(req.getParameter("doneTime").trim());
			} catch (IllegalArgumentException e) {
				doneTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp finishTime = null;
			try {
				finishTime = java.sql.Timestamp.valueOf(req.getParameter("finishTime").trim());
			} catch (IllegalArgumentException e) {
				finishTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp delayTime = null;
			try {
				delayTime = java.sql.Timestamp.valueOf(req.getParameter("delayTime").trim());
			} catch (IllegalArgumentException e) {
				delayTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			Integer customerId = Integer.valueOf(req.getParameter("customerId"));
			Integer totalPrice = Integer.valueOf(req.getParameter("totalPrice"));
			Integer storeId = Integer.valueOf(req.getParameter("storeId"));
			String delayDesc = req.getParameter("delayDesc");
			Integer comtVal = Integer.valueOf(req.getParameter("comtVal"));		
			String comtCont = req.getParameter("comtCont");
			
			java.sql.Timestamp comtTime = null;
			try {
				comtTime = java.sql.Timestamp.valueOf(req.getParameter("comtTime").trim());
			} catch (IllegalArgumentException e) {
				comtTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			
			java.sql.Timestamp remitDate = null;
			try {
				remitDate = java.sql.Timestamp.valueOf(req.getParameter("remitDate").trim());
			} catch (IllegalArgumentException e) {
				remitDate=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			String remitState = req.getParameter("remitState");
			
			java.sql.Timestamp payDate = null;
			try {
				payDate = java.sql.Timestamp.valueOf(req.getParameter("payDate").trim());
			} catch (IllegalArgumentException e) {
				payDate=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			Integer payMethod = Integer.valueOf(req.getParameter("payMethod"));
			Integer payState = Integer.valueOf(req.getParameter("payState"));
			
			
			
			
			OrdersVO OrdersVO = new OrdersVO();
			OrdersVO.setOrderId(orderId);
			OrdersVO.setOrderState(orderState);
			OrdersVO.setOrderTime(orderTime);
			OrdersVO.setDoneTime(doneTime);
			OrdersVO.setFinishTime(finishTime);
			OrdersVO.setDelayTime(delayTime);
			//OrdersVO.setCustomerId(orderId);
			OrdersVO.setTotalPrice(totalPrice);
			//OrdersVO.setStoreId(storeId);
			OrdersVO.setDelayDesc(delayDesc);
			OrdersVO.setComtVal(comtVal);
			OrdersVO.setComtCont(comtCont);
			OrdersVO.setComtTime(comtTime);
			OrdersVO.setRemitDate(remitDate);
			OrdersVO.setRemitState(remitState);
			OrdersVO.setPayDate(payDate);
			OrdersVO.setPayMethod(payMethod);
			OrdersVO.setPayState(payState);

			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("OrdersVO", OrdersVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req,res);
				return;
			}
			
			/*********************2.開始查資料****************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO = ordersSvc.updateOrders(orderId,orderState,orderTime,doneTime,finishTime,delayTime,customerId,totalPrice,storeId,delayDesc,comtVal,comtCont,comtTime,remitDate,remitState,payDate,payMethod,payState);
			
			/**************3.查詢完成，準備轉交*************************/
			req.setAttribute("OrdersVO", OrdersVO);
			String url="/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		
		}
		
		//=================================================================
			
		if ("insert".equals(action)) {	
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			Integer orderState = Integer.valueOf(req.getParameter("orderState"));
			
			java.sql.Timestamp orderTime = null;
			try {
				orderTime = java.sql.Timestamp.valueOf(req.getParameter("orderTime").trim());
			} catch (IllegalArgumentException e) {
				orderTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			
			java.sql.Timestamp doneTime = null;
			try {
				doneTime = java.sql.Timestamp.valueOf(req.getParameter("doneTime").trim());
			} catch (IllegalArgumentException e) {
				doneTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp finishTime = null;
			try {
				finishTime = java.sql.Timestamp.valueOf(req.getParameter("finishTime").trim());
			} catch (IllegalArgumentException e) {
				finishTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Timestamp delayTime = null;
			try {
				delayTime = java.sql.Timestamp.valueOf(req.getParameter("delayTime").trim());
			} catch (IllegalArgumentException e) {
				delayTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			Integer customerId = Integer.valueOf(req.getParameter("customerId"));
			Integer totalPrice = Integer.valueOf(req.getParameter("totalPrice"));
			Integer storeId = Integer.valueOf(req.getParameter("storeId"));
			String delayDesc = req.getParameter("delayDesc");
			Integer comtVal = Integer.valueOf(req.getParameter("comtVal"));		
			String comtCont = req.getParameter("comtCont");
			
			java.sql.Timestamp comtTime = null;
			try {
				comtTime = java.sql.Timestamp.valueOf(req.getParameter("comtTime").trim());
			} catch (IllegalArgumentException e) {
				comtTime=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			
			java.sql.Timestamp remitDate = null;
			try {
				remitDate = java.sql.Timestamp.valueOf(req.getParameter("remitDate").trim());
			} catch (IllegalArgumentException e) {
				remitDate=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			String remitState = req.getParameter("remitState");
			
			java.sql.Timestamp payDate = null;
			try {
				payDate = java.sql.Timestamp.valueOf(req.getParameter("payDate").trim());
			} catch (IllegalArgumentException e) {
				payDate=new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}


			Integer payMethod = Integer.valueOf(req.getParameter("payMethod"));
			Integer payState = Integer.valueOf(req.getParameter("payState"));
			
			
			OrdersVO OrdersVO = new OrdersVO();
			OrdersVO.setOrderId(orderId);
			OrdersVO.setOrderState(orderState);
			OrdersVO.setOrderTime(orderTime);
			OrdersVO.setDoneTime(doneTime);
			OrdersVO.setFinishTime(finishTime);
			OrdersVO.setDelayTime(delayTime);
			//OrdersVO.setCustomerId(orderId);
			OrdersVO.setTotalPrice(totalPrice);
			//OrdersVO.setStoreId(storeId);
			OrdersVO.setDelayDesc(delayDesc);
			OrdersVO.setComtVal(comtVal);
			OrdersVO.setComtCont(comtCont);
			OrdersVO.setComtTime(comtTime);
			OrdersVO.setRemitDate(remitDate);
			OrdersVO.setRemitState(remitState);
			OrdersVO.setPayDate(payDate);
			OrdersVO.setPayMethod(payMethod);
			OrdersVO.setPayState(payState);

			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("OrdersVO", OrdersVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req,res);
				return;
			}
			
			/*********************2.開始新增資料****************************/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO = ordersSvc.updateOrders(orderId,orderState,orderTime,doneTime,finishTime,delayTime,customerId,totalPrice,storeId,delayDesc,comtVal,comtCont,comtTime,remitDate,remitState,payDate,payMethod,payState);
			
			/***************************3.新增完成,準備轉交*******************/
			String url = "/testSQL/listAll.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);	
		}
				
		
	}

}
