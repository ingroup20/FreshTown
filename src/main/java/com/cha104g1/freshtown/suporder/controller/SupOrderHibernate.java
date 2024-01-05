package com.cha104g1.freshtown.suporder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha104g1.freshtown.suporder.model.SupOrderH;
import com.cha104g1.freshtown.suporder.model.SupOrderServiceH;
import com.cha104g1.freshtown.suporder.model.SupOrderServiceImpl;

@WebServlet("/emp/emp.do")
public class SupOrderHibernate extends HttpServlet {
	
	private SupOrderServiceH supOrderServiceH;

	@Override
	public void init() throws ServletException {
		supOrderServiceH = new SupOrderServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
			case "getAll":
				forwardPath = getAllSupOrderH(req, res);
				break;
			default:
				forwardPath = "/index.jsp";
		}
		
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAllSupOrderH(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		
		List<SupOrderH> supOrderHList = supOrderServiceH.getAllSupOrder(currentPage);
		
		req.setAttribute("empList", supOrderHList);
		req.setAttribute("currentPage", currentPage);
		
		return "/emp/listAllEmps.jsp";
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
