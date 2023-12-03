package com.bookstore.servlet.employee;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Employee;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IEmployeeDAO;
import com.bookstore.dao.impl.EmployeeDAOImpl;

public class SaveEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = new Employee();
		//employee.setEmpId(Integer.parseInt(request.getParameter("empId")));
		employee.setEmpName(request.getParameter("empName"));
		employee.setEmpAge(Integer.parseInt(request.getParameter("empAge")));
		//���ַ�����ת����������
		Date btd = DateConvert.convertToDate(request.getParameter("empBtd"));
		employee.setEmpBtd(btd);
		employee.setEmpSex(Integer.parseInt(request.getParameter("empSex")));
		employee.setIsDelete(1);
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//��Ϣ����ʾ����
		String msg = "����Ա����Ϣʧ��!!";
		String returnPath  = "/background/saveEmp.jsp";
		if (employeeDAO.save(employee)) {
			msg = "����Ա����Ϣ�ɹ�!!";
			returnPath  = "/FindAllEmployeeServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);		
	}
}
