package com.bookstore.servlet.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Employee;
import com.bookstore.common.Config;
import com.bookstore.dao.IEmployeeDAO;
import com.bookstore.dao.impl.EmployeeDAOImpl;

public class FindAllEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> emps = null;
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int pageCount = 0;
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		emps = employeeDAO.getNowPage(nowPage, pageSize);
		pageCount = employeeDAO.getPageCount(pageSize);
		//��list���Ϸ�����request��Χ�ڡ�����������ʾ����������
		request.setAttribute("emps", emps);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		//��servlet��ת��jsp��
		RequestDispatcher rd = request.getRequestDispatcher("/background/employeeList.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
