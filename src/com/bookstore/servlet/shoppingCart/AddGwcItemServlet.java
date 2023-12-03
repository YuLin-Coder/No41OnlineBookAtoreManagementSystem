package com.bookstore.servlet.shoppingCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.BookInfo;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;

public class AddGwcItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInfoDAO bookInfoDAO = new  BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		
		GouwucheItem gwcItem = new GouwucheItem();
		gwcItem.setNum(1);
		gwcItem.setBookId(id);
		gwcItem.setBookName(bookInfo.getBookName());
		gwcItem.setPrice(bookInfo.getPrice());
		gwcItem.setHyprice(bookInfo.getHyprice());
		gwcItem.setSmallImg(bookInfo.getSmallImg());
		
		//声明购物车
		Gouwuche gwc = null;
		//得到一个session（箱子）
		HttpSession session = request.getSession();
		//判断session中是否有购物车
		if(session.getAttribute("gwc") == null) {
			//session中没有购物车，新建一个购物车
			gwc = new Gouwuche();
		} else {
			//得到购物车
			gwc = (Gouwuche)session.getAttribute("gwc");
		}
		gwc.addItem(gwcItem);
		//将购物车放在session中
		session.setAttribute("gwc", gwc);
		//重定向
		response.sendRedirect("gouwuche.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
