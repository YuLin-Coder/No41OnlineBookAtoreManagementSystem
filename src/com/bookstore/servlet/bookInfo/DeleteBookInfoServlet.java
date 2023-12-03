package com.bookstore.servlet.bookInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;

public class DeleteBookInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		int id = Integer.parseInt((request.getParameter("id")));
		String msg = "删除图书基本信息失败！";
		if(bookInfoDAO.delete(id)) {
			msg = "删除图书基本信息成功！";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllBookInfoServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
