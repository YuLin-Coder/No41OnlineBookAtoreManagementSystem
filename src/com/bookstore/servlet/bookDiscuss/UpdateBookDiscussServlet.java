package com.bookstore.servlet.bookDiscuss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookDiscuss;
import com.bookstore.dao.IBookDiscussDAO;
import com.bookstore.dao.impl.BookDiscussDAOImpl;

public class UpdateBookDiscussServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDiscuss discuss = new BookDiscuss();
		int disId = Integer.parseInt(request.getParameter("disId"));
		discuss.setDisId(disId);
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		discuss.setBookId(bookId);
		discuss.setCustId(Integer.parseInt(request.getParameter("custId")));
		discuss.setContext(request.getParameter("context"));
		discuss.setStates(Integer.parseInt(request.getParameter("states")));
		IBookDiscussDAO dao = new BookDiscussDAOImpl();
		String msg = "修改书评信息失败！";
		String returnPath = "/FindByBookDiscussIdServlet?id="+disId;
		if(dao.update(discuss)) {
			msg = "修改书评信息成功！";
			returnPath = "/FindAllBookDiscussServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);	
	}
}
