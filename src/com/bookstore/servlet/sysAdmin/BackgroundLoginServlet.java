package com.bookstore.servlet.sysAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.SysAdmin;
import com.bookstore.dao.ISysAdminDAO;
import com.bookstore.dao.impl.SysAdminDAOImpl;

public class BackgroundLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决中文乱码
		//request.setCharacterEncoding("gbk");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		ISysAdminDAO adminDAO = new SysAdminDAOImpl();
		//调用findByNameAndPwd
		SysAdmin sysAdmin = adminDAO.findByNameAndPwd(name, pwd);
		//默认后台登陆失败
		String path = "login.jsp";
		//判断是否登陆成功
		if(sysAdmin != null) {
			//登陆成功
			path = "index.jsp";
			//把当前登陆用户的详细信息放入到session
			HttpSession session = request.getSession();
			session.setAttribute("sysAdmin", sysAdmin);
		}
		//重定向
		response.sendRedirect("background/" + path);
	}
}
