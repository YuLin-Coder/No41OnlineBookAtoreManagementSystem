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

public class SaveDetailInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDetailInfo info = new CustomerDetailInfo();
		info.setTel(request.getParameter("tel"));
		info.setAddress(request.getParameter("address"));
		info.setSex(Integer.parseInt(request.getParameter("sex")));
		info.setAge(Integer.parseInt(request.getParameter("age")));
		info.setCountMoney(Double.parseDouble(request.getParameter("countMoney")));
		info.setQq(request.getParameter("qq"));
		ICustomerDetailInfoDAO dao = new CustomerDetailInfoDAOImpl();
		//消息框显示内容
		String msg = "新增用户详细信息失败!!";
		String returnPath  = "/background/saveCusDetailInfo.jsp";
		if (dao.save(info)) {
			msg = "新增用户详细信息成功!!";
			returnPath  = "/FindAllCusDetailInfoServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

}
