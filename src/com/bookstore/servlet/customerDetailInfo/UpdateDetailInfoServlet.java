package com.bookstore.servlet.customerDetailInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.CustomerDetailInfo;
import com.bookstore.dao.ICustomerDetailInfoDAO;
import com.bookstore.dao.impl.CustomerDetailInfoDAOImpl;

public class UpdateDetailInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDetailInfo info = new CustomerDetailInfo();
		int custId = Integer.parseInt(request.getParameter("custId"));
		info.setCustId(custId);
		info.setTel(request.getParameter("tel"));
		info.setAddress(request.getParameter("address"));
		info.setSex(Integer.parseInt(request.getParameter("sex")));
		info.setAge(Integer.parseInt(request.getParameter("age")));
		info.setCountMoney(Double.parseDouble(request.getParameter("countMoney")));
		info.setQq(request.getParameter("qq"));
		ICustomerDetailInfoDAO dao = new CustomerDetailInfoDAOImpl();
		String msg = "修改用户基本信息失败！";
		String returnPath = "/FindByCusDetailInfoServlet?id="+custId;
		if(dao.update(info)) {
			msg = "修改用户基本信息成功！";
			returnPath = "/FindAllCusDetailInfoServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

}
