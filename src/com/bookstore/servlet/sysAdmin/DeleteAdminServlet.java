package com.bookstore.servlet.sysAdmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.ISysAdminDAO;
import com.bookstore.dao.impl.SysAdminDAOImpl;

public class DeleteAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ISysAdminDAO adminDAO = new SysAdminDAOImpl();
		//消息框显示内容
		String msg = "删除管理员失败！";
		if(adminDAO .delete(id)) {
			msg = "删除管理员成功！"; 
		}
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllAdminServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/message.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
