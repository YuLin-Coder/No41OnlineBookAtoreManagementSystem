package com.bookstore.servlet.bookDiscuss;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookDiscuss;
import com.bookstore.common.Config;
import com.bookstore.dao.IBookDiscussDAO;
import com.bookstore.dao.impl.BookDiscussDAOImpl;

public class FindAllBookDiscussServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		IBookDiscussDAO discussDAO = new BookDiscussDAOImpl();
		List<BookDiscuss> books = discussDAO.getNowPage(nowPage, pageSize);
		int pageCount = discussDAO.getPageCount(pageSize);
		//将list集合放入在request范围内--界面上显示三个数据
		request.setAttribute("books", books);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		//由servlet跳转到jsp中
		RequestDispatcher rd = request.getRequestDispatcher("/background/bookDiscussList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
