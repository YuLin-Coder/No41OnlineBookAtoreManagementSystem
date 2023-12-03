package com.bookstore.bean;
//订单明细表

public class OrderDetail {
	//属性
	private int detail;//明细编号
	private String orderNum;//主表ID
	private int bookId;//商品编号 
	private int num;//订购数量
	
	//方法
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int detail, String orderNum, int bookId, int num) {
		super();
		this.detail = detail;
		this.orderNum = orderNum;
		this.bookId = bookId;
		this.num = num;
	}

	public int getDetail() {
		return detail;
	}

	public void setDetail(int detail) {
		this.detail = detail;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "OrderDetail [detail=" + detail + ", orderNum=" + orderNum
				+ ", bookId=" + bookId + ", num=" + num + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + detail;
		result = prime * result + num;
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		if (bookId != other.bookId)
			return false;
		if (detail != other.detail)
			return false;
		if (num != other.num)
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		return true;
	}
}
