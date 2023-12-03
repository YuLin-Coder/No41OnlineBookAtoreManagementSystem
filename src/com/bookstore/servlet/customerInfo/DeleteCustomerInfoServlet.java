package com.bookstore.servlet.customerInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.ICustomerInfoDAO;
import com.bookstore.dao.impl.CustomerInfoDAOImpl;

public class DeleteCustomerInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerInfoDAO infoDAO = new CustomerInfoDAOImpl();
		String msg = "ɾ���û�������Ϣʧ�ܣ�";
		if(infoDAO.delete(id)) {
			msg = "ɾ���û�������Ϣ�ɹ���";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllCustomerInfoServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
