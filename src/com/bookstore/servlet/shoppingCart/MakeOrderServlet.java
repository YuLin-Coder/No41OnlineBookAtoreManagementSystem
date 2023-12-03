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
		
		//1 向订单主表添加一条数据
		OrderMain orderMain = new OrderMain();
		//201508102038777
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//订单编号 
		String orderNum = df.format(now);
		orderMain.setOrderNum(orderNum);
		//客户姓名
		int customerId = customerInfo.getCustId();
		orderMain.setCustomerId(customerId);
		//收货人姓名
		String customerName = request.getParameter("customerName");
		orderMain.setCustomerName(customerName);
		//收货人电话
		String tel = request.getParameter("tel");
		orderMain.setTel(tel);
		//收货地址
		String address = request.getParameter("address");
		orderMain.setAddress(address);
		//销售单状态（0-未处理，1-已处理，2-以发货，3-已收货）
		orderMain.setStatus("0");
		//备注
		String context = request.getParameter("context");
		orderMain.setContext(context);
		//总价
		double sumprice = gwc.getHyPrices();
		orderMain.setSumprice(sumprice);
		
		//2 向订单明细表添加一条到多条数据
		List<OrderDetail> orderDetails = new Vector<OrderDetail>();
		Collection<GouwucheItem> items = gwc.getAllItems();
		for (GouwucheItem item : items) {
			OrderDetail orderDetail = new OrderDetail(); 
			//主表ID
			orderDetail.setOrderNum(orderNum);
			//商品编号
			orderDetail.setBookId(item.getBookId());
			//订购数量
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
			//输出编码格式
			response.setContentType("text/html; charset=gbk");
			PrintWriter out = response.getWriter();
			out.print("订单编号是:" + orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3 修改客户详细信息表的累积消费金额
		
	}
}
