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

		//�����������
		//request.setCharacterEncoding("gbk");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		ISysAdminDAO adminDAO = new SysAdminDAOImpl();
		//����findByNameAndPwd
		SysAdmin sysAdmin = adminDAO.findByNameAndPwd(name, pwd);
		//Ĭ�Ϻ�̨��½ʧ��
		String path = "login.jsp";
		//�ж��Ƿ��½�ɹ�
		if(sysAdmin != null) {
			//��½�ɹ�
			path = "index.jsp";
			//�ѵ�ǰ��½�û�����ϸ��Ϣ���뵽session
			HttpSession session = request.getSession();
			session.setAttribute("sysAdmin", sysAdmin);
		}
		//�ض���
		response.sendRedirect("background/" + path);
	}
}
