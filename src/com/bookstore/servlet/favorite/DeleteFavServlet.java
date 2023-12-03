package com.bookstore.servlet.favorite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.IFavoriteDAO;
import com.bookstore.dao.impl.FavoriteDAOImpl;

public class DeleteFavServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IFavoriteDAO dao = new FavoriteDAOImpl();
		String msg = "É¾³ýÊÕ²Ø¼ÐÐÅÏ¢Ê§°Ü£¡";
		if(dao.delete(id)) {
			msg = "É¾³ýÊÕ²Ø¼ÐÐÅÏ¢³É¹¦£¡";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllFavoriteServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
