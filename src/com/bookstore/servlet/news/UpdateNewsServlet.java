package com.bookstore.servlet.news;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.News;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.INewsDAO;
import com.bookstore.dao.impl.NewsDAOImpl;

public class UpdateNewsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		News news = new News();
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		news.setNewsId(newsId);
		news.setNewTitle(request.getParameter("newTitle"));
		news.setContext(request.getParameter("context"));
		//将字符串转换为日期型
		Date time = DateConvert.convertToDate(request.getParameter("createTime"));
		news.setCreateTime(time);
		INewsDAO newsDAO = new NewsDAOImpl();
		//消息显示
		String msg = "修改新闻失败！";
		String returnPath = "/FindByNewsIdServlet?id="+newsId;
		if(newsDAO.update(news)) {
			msg = "修改新闻成功！";
			returnPath = "/FindAllNewsServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
}
