package com.bookstore.servlet.reception;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookInfo;
import com.bookstore.bean.BookType;
import com.bookstore.common.Config;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;
import com.bookstore.dao.impl.BookTypeDAOImpl;

public class ShowBookListByTypeId extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		//�õ�ͼ�����
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//�õ����еĸ���𣨶������
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//�õ�ÿ�����������������
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		//�õ���������
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		List<BookInfo> rxbooks = bookInfoDAO.findBySaleCount(10);
		int pageSize = Config.PAGESIZE;
		List<BookInfo> bookInfos = bookInfoDAO.getNowPage(nowPage, pageSize);
		int pageCount = bookInfoDAO.getPageCount(pageSize);
		//��list���Ϸ�����request��Χ��--��������ʾ��������
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("rxbooks", rxbooks);
		request.setAttribute("typeId", typeId);
		//����ת��
		request.getRequestDispatcher("/bookInfoList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
