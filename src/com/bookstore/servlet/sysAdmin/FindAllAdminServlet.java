package com.bookstore.servlet.sysAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.SysAdmin;
import com.bookstore.common.Config;
import com.bookstore.dao.ISysAdminDAO;
import com.bookstore.dao.impl.SysAdminDAOImpl;

public class FindAllAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		ISysAdminDAO adminDAO = new SysAdminDAOImpl();
		List<SysAdmin> admins = adminDAO.getNowPage(nowPage, pageSize);
		int pageCount = adminDAO.getPageCount(pageSize);
		//把list集合放入在request范围内——界面上显示的三个数据
		request.setAttribute("admins", admins);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		//由servlet转跳到jsp中
		RequestDispatcher rd = request.getRequestDispatcher("/background/adminList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
