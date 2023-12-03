package com.bookstore.servlet.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.IEmployeeDAO;
import com.bookstore.dao.impl.EmployeeDAOImpl;

public class DeleteEmpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//��Ϣ����ʾ����
		String msg = "ɾ��Ա����Ϣʧ�ܣ�";
		if(employeeDAO.delete(id)) {
			msg = "ɾ��Ա����Ϣ�ɹ���";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllEmployeeServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
