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
		
		//�������ﳵ
		Gouwuche gwc = null;
		//�õ�һ��session�����ӣ�
		HttpSession session = request.getSession();
		//�ж�session���Ƿ��й��ﳵ
		if(session.getAttribute("gwc") == null) {
			//session��û�й��ﳵ���½�һ�����ﳵ
			gwc = new Gouwuche();
		} else {
			//�õ����ﳵ
			gwc = (Gouwuche)session.getAttribute("gwc");
		}
		gwc.addItem(gwcItem);
		//�����ﳵ����session��
		session.setAttribute("gwc", gwc);
		//�ض���
		response.sendRedirect("gouwuche.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
