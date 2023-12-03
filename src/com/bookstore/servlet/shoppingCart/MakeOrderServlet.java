package com.bookstore.servlet.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.CustomerInfo;
import com.bookstore.bean.OrderDetail;
import com.bookstore.bean.OrderMain;
import com.bookstore.dao.IOrderDetailDAO;
import com.bookstore.dao.IOrderMainDAO;
import com.bookstore.dao.impl.OrderDetailDAOImpl;
import com.bookstore.dao.impl.OrderMainDAOImpl;

public class MakeOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
		//CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo");
		Gouwuche gwc = (Gouwuche)session.getAttribute("gwc");
		
		//1 �򶩵��������һ������
		OrderMain orderMain = new OrderMain();
		//201508102038777
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//������� 
		String orderNum = df.format(now);
		orderMain.setOrderNum(orderNum);
		//�ͻ�����
		int customerId = customerInfo.getCustId();
		orderMain.setCustomerId(customerId);
		//�ջ�������
		String customerName = request.getParameter("customerName");
		orderMain.setCustomerName(customerName);
		//�ջ��˵绰
		String tel = request.getParameter("tel");
		orderMain.setTel(tel);
		//�ջ���ַ
		String address = request.getParameter("address");
		orderMain.setAddress(address);
		//���۵�״̬��0-δ����1-�Ѵ���2-�Է�����3-���ջ���
		orderMain.setStatus("0");
		//��ע
		String context = request.getParameter("context");
		orderMain.setContext(context);
		//�ܼ�
		double sumprice = gwc.getHyPrices();
		orderMain.setSumprice(sumprice);
		
		//2 �򶩵���ϸ�����һ������������
		List<OrderDetail> orderDetails = new Vector<OrderDetail>();
		Collection<GouwucheItem> items = gwc.getAllItems();
		for (GouwucheItem item : items) {
			OrderDetail orderDetail = new OrderDetail(); 
			//����ID
			orderDetail.setOrderNum(orderNum);
			//��Ʒ���
			orderDetail.setBookId(item.getBookId());
			//��������
			orderDetail.setNum(item.getNum());
			orderDetails.add(orderDetail);
		}
		
		IOrderMainDAO orderMainDAO = new OrderMainDAOImpl();
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		try {
			orderMainDAO.save(orderMain);
			for (OrderDetail orderDetail : orderDetails) {
				orderDetailDAO.save(orderDetail);
			}	
			gwc.clear();
			//��������ʽ
			response.setContentType("text/html; charset=gbk");
			PrintWriter out = response.getWriter();
			out.print("���������:" + orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3 �޸Ŀͻ���ϸ��Ϣ����ۻ����ѽ��
		
	}
}
