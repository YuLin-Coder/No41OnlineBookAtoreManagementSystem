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

public class SaveCustomerInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerInfo info = new CustomerInfo();
		info.setCustName(request.getParameter("custName"));
		info.setPwd(request.getParameter("pwd"));
		info.setEmail(request.getParameter("email"));
		ICustomerInfoDAO infoDAO = new CustomerInfoDAOImpl();
		String msg = "新增用户基本信息失败！";
		String returnPath = "/background/saveCusInfo.jsp";
		if(infoDAO.save(info)) {
			msg = "新增用户基本信息成功！";
			returnPath = "/FindAllCustomerInfoServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
}
