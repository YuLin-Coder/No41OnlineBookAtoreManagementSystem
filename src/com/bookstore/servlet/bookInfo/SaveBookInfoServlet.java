package com.bookstore.servlet.bookInfo;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookInfo;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;

public class SaveBookInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookInfo info = new BookInfo();
		info.setBookName(request.getParameter("bookName"));
		info.setBooktypeId(Integer.parseInt(request.getParameter("bookTypeId")));
		info.setAuthor(request.getParameter("author"));
		info.setPbName(request.getParameter("pbName"));
		info.setContext(request.getParameter("context"));
		info.setSmallImg(request.getParameter("smallImg"));
		info.setBigImg(request.getParameter("bigImg"));
		info.setPrice(Double.parseDouble(request.getParameter("price")));
		//需要把字符串转换为日期
		Date date1 = DateConvert.convertToDate(request.getParameter("pbdate"));
		info.setPbdate(date1);
		info.setHyprice(Double.parseDouble(request.getParameter("hyprice")));
		info.setBookStates(Integer.parseInt(request.getParameter("bookStates")));
		//将字符串型转换成日期型
		Date date2 = DateConvert.convertToDate(request.getParameter("sjdate"));
		info.setSjdate(date2);
		info.setNum(Integer.parseInt(request.getParameter("num")));
		info.setSaleCount(Integer.parseInt(request.getParameter("saleCount")));
		
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		String msg = "新增图书基本信息失败！";
		String returnPath = "/background/saveBookInfo.jsp";
		if(bookInfoDAO.save(info)) {
			msg = "新增图书基本信息成功！";
			returnPath = "/FindAllBookInfoServlet?nowPage=1";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);	
	}

}
