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
		//�õ��û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		//����DAO���ж��û����������Ƿ���ȷ
		CustomerInfo customerInfo = customerInfoDAO.findByNameAndPwd(username, password);
		if(customerInfo == null) {
			//�ض��򵽵�½����
			response.sendRedirect("qtLogin.jsp");
		} else {
			//��½�ɹ�
			ICustomerDetailInfoDAO customerDetailInfoDAO = new CustomerDetailInfoDAOImpl();
			CustomerDetailInfo customerDetailInfo = customerDetailInfoDAO.findById(customerInfo.getCustId());
			//�õ�session
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			session.setAttribute("customerDetailInfo", customerDetailInfo);
			//�ض����¶�������
			response.sendRedirect("makeOrder.jsp");
		}
	}
}
