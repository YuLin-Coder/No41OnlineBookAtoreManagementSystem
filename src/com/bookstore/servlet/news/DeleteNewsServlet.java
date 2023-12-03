package com.bookstore.servlet.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.INewsDAO;
import com.bookstore.dao.impl.NewsDAOImpl;

public class DeleteNewsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		INewsDAO newsDAO = new NewsDAOImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		//消息框显示内容
		String msg = "删除新闻失败！";
		if(newsDAO.delete(id)) {
			msg = "删除新闻成功！"; 
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllNewsServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
