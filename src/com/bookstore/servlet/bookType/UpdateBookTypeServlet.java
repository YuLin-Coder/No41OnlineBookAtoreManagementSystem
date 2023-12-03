package com.bookstore.servlet.bookType;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookType;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.impl.BookTypeDAOImpl;

public class UpdateBookTypeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookType bookType = new  BookType();
		int bookTypeId = Integer.parseInt((request.getParameter("bookTypeId")));
		bookType.setBookTypeId(bookTypeId);
		bookType.setParentId(Integer.parseInt(request.getParameter("parentId")));
		bookType.setBookTypeName(request.getParameter("bookTypeName"));
		bookType.setContext(request.getParameter("context"));
		bookType.setIsDelete(Integer.parseInt(request.getParameter("isDelete")));
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		String msg = "修改图书类别信息失败！";
		String returnPath = "/FindByBookTypeIdServlet?id="+bookTypeId;
		if(bookTypeDAO.update(bookType)) {
			msg = "修改图书类别信息成功！";
			returnPath = "/FindAllBookTypeServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
}
