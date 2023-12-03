package com.bookstore.servlet.shoppingCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.CustomerDetailInfo;
import com.bookstore.bean.CustomerInfo;
import com.bookstore.dao.ICustomerDetailInfoDAO;
import com.bookstore.dao.ICustomerInfoDAO;
import com.bookstore.dao.impl.CustomerDetailInfoDAOImpl;
import com.bookstore.dao.impl.CustomerInfoDAOImpl;

public class QtLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		//调用DAO，判断用户名和密码是否正确
		CustomerInfo customerInfo = customerInfoDAO.findByNameAndPwd(username, password);
		if(customerInfo == null) {
			//重定向到登陆界面
			response.sendRedirect("qtLogin.jsp");
		} else {
			//登陆成功
			ICustomerDetailInfoDAO customerDetailInfoDAO = new CustomerDetailInfoDAOImpl();
			CustomerDetailInfo customerDetailInfo = customerDetailInfoDAO.findById(customerInfo.getCustId());
			//得到session
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			session.setAttribute("customerDetailInfo", customerDetailInfo);
			//重定向到下订单界面
			response.sendRedirect("makeOrder.jsp");
		}
	}
}
