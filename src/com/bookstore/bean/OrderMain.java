package com.bookstore.bean;
//订单主表

public class OrderMain {
	//属性
	private String orderNum;//订单编号
	private int customerId;//客户编号
	private String customerName;//收货人姓名
	private String tel;//收货人电话
	private String address;//收货地址
	private String status;//销售单状态（0-未处理，1-已处理，2-以发货，3-以收货）
	private int adminId;//处理人编号
	private String context;//备注
	private double sumprice;//订单总计价钱
	
	//方法
	public OrderMain() {
		// TODO Auto-generated constructor stub
	}

	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address, String status, int adminId,
			String context, int sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}

	@Override
	public String toString() {
		return "OrderMain [orderNum=" + orderNum + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", tel=" + tel
				+ ", address=" + address + ", status=" + status + ", adminId="
				+ adminId + ", context=" + context + ", sumprice=" + sumprice
				+ "]";
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public double getSumprice() {
		return sumprice;
	}

	public void setSumprice(double d) {
		this.sumprice = d;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + adminId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + customerId;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sumprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		OrderMain other = (OrderMain) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adminId != other.adminId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (orderNum == null) {
			if (other.orderNum != null)
				return false;
		} else if (!orderNum.equals(other.orderNum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(sumprice) != Double
				.doubleToLongBits(other.sumprice))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
}
