package com.bookstore.servlet.bookType;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookType;
import com.bookstore.common.Config;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.impl.BookTypeDAOImpl;

public class FindAllBookTypeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int pageCount = 0;
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		List<BookType> bookList = bookTypeDAO.getNowPage(nowPage, pageSize);
		pageCount = bookTypeDAO.getPageCount(pageSize);
		//��list���Ϸ�����request��Χ��--��������ʾ��������
		request.setAttribute("bookList", bookList);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		//��servlet��ת��jsp��
		RequestDispatcher rd = request.getRequestDispatcher("/background/bookTypeList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
