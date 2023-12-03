package com.bookstore.servlet.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.News;
import com.bookstore.dao.INewsDAO;
import com.bookstore.dao.impl.NewsDAOImpl;

public class FindByNewsIdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		INewsDAO newsDAO = new NewsDAOImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		News news = newsDAO.findById(id);
		request.setAttribute("news", news);
		RequestDispatcher rd = request.getRequestDispatcher("/background/updateNews.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
