package com.cha104g1.freshtown.refunds.contrallor;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cha104g1.freshtown.refunds.model.RefundsService;
import com.cha104g1.freshtown.refunds.model.RefundsVO;
import com.cha104g1.freshtown.stores.model.StoresService;
import com.cha104g1.freshtown.stores.model.StoresVO;

public class RefundsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");

		/* ================= 單筆查詢 ============================== */
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/************* 1.接收請求參數，輸入格式錯誤處理 ********/
			String str = req.getParameter("id");
			Integer id = null;

			try {
				id = Integer.valueOf(str);

			} catch (Exception e) {
				errorMsgs.add("流水編號格式不正確");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			/************* 2.查詢永續層資料 ********/
			RefundsService refundsSvc = new RefundsService();
			RefundsVO refundsVO = refundsSvc.getOneRefunds(id);
			if (refundsVO == null) {
				errorMsgs.add("查無資料");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/select_page.jsp");
				failurView.forward(req, res);
				return;
			}

			/************* 3.查詢完，轉交內容 ********/

			req.setAttribute("refundsVO", refundsVO);
			String url = "/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* ================= 修改 ============================== */
		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/************* 1.接收請求參數，輸入格式錯誤處理 ********/
			Integer id = Integer.valueOf(req.getParameter("id"));
			/************* 2.查詢永續層資料 ********/
			RefundsService refundsSvc = new RefundsService();
			RefundsVO refundsVO = refundsSvc.getOneRefunds(id);

			/************* 3.查詢完，轉交內容 ********/
			req.setAttribute("refundsVO", refundsVO);
			String url = "/testSQL/update_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* ==================更新====================== */
		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/************ 1.接收請求參數-輸入格式錯誤處理 ************************/

			Integer id = Integer.valueOf(req.getParameter("id"));
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			String refundState = req.getParameter("refundState");
			Integer refundDollar = Integer.valueOf(req.getParameter("refundDollar"));
			Date refundDate = Date.valueOf(req.getParameter("refundDate"));

			RefundsVO refundsVO = new RefundsVO();
			refundsVO.setId(id);
		//	refundsVO.setOrderId(orderId);
			refundsVO.setRefundState(refundState);
			refundsVO.setRefundDollar(refundDollar);
			refundsVO.setRefundDate(refundDate);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("refundsVO", refundsVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req, res);
				return;
			}

			/********************* 2.開始查資料 ****************************/
			RefundsService refundsSvc = new RefundsService();
			refundsVO = refundsSvc.updateRefunds(id, orderId, refundState, refundDollar, refundDate);

			/************** 3.查詢完成，準備轉交 *************************/
			req.setAttribute("refundsVO", refundsVO);
			String url = "/testSQL/listOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		/* ================= 新增 ============================== */

		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/************* 1.接收請求參數，輸入格式錯誤處理 ********/
			Integer orderId = Integer.valueOf(req.getParameter("orderId"));
			String refundState = req.getParameter("refundState");
			Integer refundDollar = Integer.valueOf(req.getParameter("refundDollar"));
			Date refundDate = Date.valueOf(req.getParameter("refundDate"));

			RefundsVO refundsVO =new RefundsVO();
		//	refundsVO.setOrderId(orderId);
			refundsVO.setRefundDate(refundDate);
			refundsVO.setRefundDollar(refundDollar);
			refundsVO.setRefundState(refundState);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("refundsVO", refundsVO);
				RequestDispatcher failurView = req.getRequestDispatcher("/testSQL/update_input.jsp");
				failurView.forward(req, res);
				return;
			}
			
			/************* 2.新增永續層資料 ********/
			RefundsService refundsSvc = new RefundsService();
			refundsSvc.addRefunds(orderId,refundState,refundDollar,refundDate);
			
			/************* 3.新增完成，轉交內容 ********/
			String url ="/testSQL/listAll.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;			
		}
	}
}
