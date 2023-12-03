package com.bookstore.servlet.customerInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.CustomerInfo;
import com.bookstore.dao.ICustomerInfoDAO;
import com.bookstore.dao.impl.CustomerInfoDAOImpl;

public class FindByCustomerInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerInfoDAO infoDAO = new CustomerInfoDAOImpl();
		CustomerInfo info = infoDAO.findById(id);
		request.setAttribute("info", info);
		RequestDispatcher rd = request.getRequestDispatcher("/background/updateCusInfo.jsp");
		rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
