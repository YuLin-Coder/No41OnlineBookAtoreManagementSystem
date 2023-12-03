package com.bookstore.servlet.favorite;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Favorite;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IFavoriteDAO;
import com.bookstore.dao.impl.FavoriteDAOImpl;

public class SaveFavServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Favorite favorite = new Favorite();
		favorite.setBookId(Integer.parseInt(request.getParameter("bookId")));
		favorite.setCustId(Integer.parseInt(request.getParameter("custId")));
		//将字符串转换为日期型
		String str = request.getParameter("date");
		Date date = DateConvert.convertToDate(str);
		favorite.setScdate(date);
		favorite.setContext(request.getParameter("context"));
		IFavoriteDAO dao = new FavoriteDAOImpl();
		String msg = "新增收藏夹信息失败！";
		String returnPath = "/background/saveFav.jsp";
		if(dao.save(favorite)) {
			msg = "新增收藏夹信息成功！";
			returnPath = "/FindAllFavoriteServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
}
