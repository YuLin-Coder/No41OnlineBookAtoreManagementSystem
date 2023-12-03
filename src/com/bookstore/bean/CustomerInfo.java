package com.bookstore.bean;
//用户基本信息表

public class CustomerInfo {
	//属性
	private int custId;//编号
	private String custName;//客户名称
	private String pwd;//用户密码
	private String email;//邮箱
	//方法
	public CustomerInfo() {
		// TODO Auto-generated constructor stub
	}
	public CustomerInfo(int custId, String custName, String pwd, String email) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.pwd = pwd;
		this.email = email;
	}
	@Override
	public String toString() {
		return "customerInfo [custId=" + custId + ", custName=" + custName
				+ ", pwd=" + pwd + ", email=" + email + "]";
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		CustomerInfo other = (CustomerInfo) obj;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
}
