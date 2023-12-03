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
		//��Ϣ����ʾ����
		String msg = "ɾ������ʧ�ܣ�";
		if(newsDAO.delete(id)) {
			msg = "ɾ�����ųɹ���"; 
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
