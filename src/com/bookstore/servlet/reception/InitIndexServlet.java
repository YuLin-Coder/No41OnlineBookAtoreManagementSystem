package com.bookstore.servlet.reception;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookInfo;
import com.bookstore.bean.BookType;
import com.bookstore.bean.News;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.INewsDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;
import com.bookstore.dao.impl.BookTypeDAOImpl;
import com.bookstore.dao.impl.NewsDAOImpl;

public class InitIndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.��ȡ��������
		 * 2.�����ݷ���request patameter��Χ��
		 * 3.����ת����index.jsp
		 */
		INewsDAO newsDAO = new NewsDAOImpl();
		IBookInfoDAO infoDAO = new BookInfoDAOImpl();
		//1>.��ȡ�����б� top10
		List<News> news = newsDAO.findTopNine(10);
		//2>.��ȡ������Ʒ �����ϼ����ڵĽ������У���ȡtop5
		List<BookInfo> sjbooks = infoDAO.findBySjdate(5);
		//3>.��ȡ������Ʒ ����ͼ���������Ľ������У���ȡtop10
		List<BookInfo> rxbooks = infoDAO.findBySaleCount(10);
		//4>.��ȡ�Ƽ���Ʒ top12
		List<BookInfo> tjbooks = infoDAO.findTjbooks(12);
		//5>.��ȡͼ�����
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//�õ����еĸ���𣨶������
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//�õ�ÿ�����������������
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		request.setAttribute("news", news);
		request.setAttribute("sjbooks", sjbooks);
		request.setAttribute("rxbooks", rxbooks);
		request.setAttribute("tjbooks", tjbooks);
		request.setAttribute("bookTypes", bookTypes);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
