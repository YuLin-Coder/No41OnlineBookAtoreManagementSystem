package com.bookstore.servlet.customerDetailInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.ICustomerDetailInfoDAO;
import com.bookstore.dao.impl.CustomerDetailInfoDAOImpl;

public class DeleteCusDetailInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ICustomerDetailInfoDAO dao = new CustomerDetailInfoDAOImpl();
		String msg = "删除用户详细信息失败!";
		if(dao.delete(id)) {
			msg = "删除用户详细信息成功！";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllCusDetailInfoServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
