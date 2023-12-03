package com.bookstore.servlet.shoppingCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateGwcItemNumServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		Gouwuche gwc = (Gouwuche)session.getAttribute("gwc");
		if(num == 0) {
			gwc.deleteGwcItem(id);
		} else {
			gwc.updateItemNum(id, num);
		}
		//÷ÿ∂®œÚ
		response.sendRedirect("gouwuche.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
