package com.bookstore.servlet.favorite;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Favorite;
import com.bookstore.common.Config;
import com.bookstore.dao.IFavoriteDAO;
import com.bookstore.dao.impl.FavoriteDAOImpl;

public class FindAllFavoriteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		IFavoriteDAO dao = new FavoriteDAOImpl();
		int pageCount = dao.getPageCount(pageSize);
		List<Favorite> favorites = dao.getNowPage(nowPage, pageSize);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("favorites", favorites);
		//ÇëÇó×ª·¢
		RequestDispatcher rd = request.getRequestDispatcher("/background/favoriteList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
