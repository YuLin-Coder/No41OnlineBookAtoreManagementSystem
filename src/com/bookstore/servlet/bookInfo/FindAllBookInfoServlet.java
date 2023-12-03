package com.bookstore.servlet.bookInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookInfo;
import com.bookstore.common.Config;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;

public class FindAllBookInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		List<BookInfo> bookInfos = bookInfoDAO.getNowPage(nowPage, pageSize);
		int pageCount = bookInfoDAO.getPageCount(pageSize);
		//将list集合放入在request范围内--界面上显示三个数据
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		//由servlet跳转到jsp中
		RequestDispatcher rd = request.getRequestDispatcher("/background/bookInfoList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
