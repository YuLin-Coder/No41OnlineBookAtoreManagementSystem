package com.bookstore.servlet.customerDetailInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.CustomerDetailInfo;
import com.bookstore.common.Config;
import com.bookstore.dao.ICustomerDetailInfoDAO;
import com.bookstore.dao.impl.CustomerDetailInfoDAOImpl;

public class FindAllCusDetailInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CustomerDetailInfo> infos = null;
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int pageCount = 0;
		ICustomerDetailInfoDAO detailInfoDAO = new CustomerDetailInfoDAOImpl();
		pageCount = detailInfoDAO.getPageCount(pageSize);
		infos = detailInfoDAO.getNowPage(nowPage, pageSize);
		//把list集合放入在request范围内——界面上显示的三个数据
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("infos", infos);
		//请求转发--servlet-->jsp
		RequestDispatcher rd = request.getRequestDispatcher("/background/cusDetailInfoList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
